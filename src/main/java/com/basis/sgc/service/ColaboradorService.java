package com.basis.sgc.service;

import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.domain.CompetenciaColaborador;
import com.basis.sgc.domain.CompetenciaColaboradorId;
import com.basis.sgc.exception.EntidadeEmUsoException;
import com.basis.sgc.exception.EntidadeNaoEncontradaException;
import com.basis.sgc.repository.ColaboradorRepository;
import com.basis.sgc.service.dto.ColaboradorDTO;
import com.basis.sgc.service.dto.CompetenciaDoColaboradorDTO;
import com.basis.sgc.service.mapper.ColaboradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ColaboradorService {

    private static final String MSG_COLABORADOR_NAO_ENCONTRADO = "Não existe um cadastro desse colaborador no sistema.";
    private static final String MSG_COLABORADOR_EM_USO = "Este colaborador está em uso";

    private final ColaboradorRepository colaboradorRepository;
    private final ColaboradorMapper colaboradorMapper;
    private final CompetenciaColaboradorService competenciaColaboradorService;

    public List<ColaboradorDTO> listar(Pageable pageable) {
        Page<Colaborador> colaboradoresPages = colaboradorRepository.findAll(pageable);
        List<ColaboradorDTO> colaboradoresDTO = colaboradorMapper.toDto(colaboradoresPages.getContent());
        return colaboradoresDTO;
    }

    public ColaboradorDTO buscarPorId(Integer colaboradorId) {
        ColaboradorDTO colaboradorDTO = colaboradorMapper.toDto(buscar(colaboradorId));
        colaboradorDTO.setCompetencias(competenciaColaboradorService.buscarCompetenciasDoColaborador(colaboradorId));
        return colaboradorDTO;
    }

    public ColaboradorDTO salvar(ColaboradorDTO colaboradorDTO) {
        Colaborador colaborador = colaboradorMapper.toEntity(colaboradorDTO);
        if(isColaboradorIdNull(colaborador)) {
            competenciaColaboradorService.excluir(colaboradorDTO.getId());
        }
        colaborador = colaboradorRepository.save(colaborador);
        Set<CompetenciaDoColaboradorDTO> competenciasDTO = colaboradorDTO.getCompetencias();
        adicionarCompetenciasEColaboradores(competenciasDTO, colaborador);
        colaboradorDTO = colaboradorMapper.toDto(colaborador);
        colaboradorDTO.setCompetencias(competenciasDTO);
        return colaboradorDTO;
    }

    public void excluir(Integer colaboradorId) {
        try {
            competenciaColaboradorService.excluir(colaboradorId);
            colaboradorRepository.deleteById(colaboradorId);
            colaboradorRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(MSG_COLABORADOR_NAO_ENCONTRADO);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(MSG_COLABORADOR_EM_USO);
        }
    }

    public Colaborador buscar(Integer colaboradorId) {
        return colaboradorRepository.findById(colaboradorId).orElseThrow(() -> new EntidadeNaoEncontradaException(
                MSG_COLABORADOR_NAO_ENCONTRADO));
    }

    private List<CompetenciaColaborador> adicionarCompetenciasEColaboradores(Set<CompetenciaDoColaboradorDTO> competenciasDTO,Colaborador colaborador) {
        List<CompetenciaColaborador> competencias = competenciasDTO.stream().map(competencia -> new CompetenciaColaborador(
                        new CompetenciaColaboradorId(competencia.getId(), colaborador.getId()), competencia.getNivel()))
                .collect(Collectors.toList());
        return competenciaColaboradorService.salvar(competencias);
    }

    private boolean isColaboradorIdNull(Colaborador colaborador) {
        return Objects.isNull(colaborador.getId());
    }
}
