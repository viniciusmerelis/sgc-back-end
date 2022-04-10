package com.basis.sgc.service;

import com.basis.sgc.domain.Competencia;
import com.basis.sgc.exception.EntidadeEmUsoException;
import com.basis.sgc.exception.EntidadeNaoEncontradaException;
import com.basis.sgc.repository.CompetenciaRepository;
import com.basis.sgc.service.dto.CompetenciaDTO;
import com.basis.sgc.service.dto.DropdownDTO;
import com.basis.sgc.service.mapper.CompetenciaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CompetenciaService {

    private static final String MSG_COMPETENCIA_NAO_ENCONTRADA = "Não existe um cadastro dessa competencia no sistema.";
    private static final String MSG_COMPETENCIA_EM_USO = "Essa competência está em uso";

    private final CompetenciaRepository competenciaRepository;
    private final CompetenciaMapper competenciaMapper;
    private final CompetenciaColaboradorService competenciaColaboradorService;

    public List<CompetenciaDTO> listar() {
        return competenciaMapper.toDto(competenciaRepository.findAll());
    }

    public CompetenciaDTO buscarPorId(Integer competenciaId) {
        return competenciaMapper.toDto(buscar(competenciaId));
    }

    public void salvar(CompetenciaDTO competenciaDTO) {
        Competencia competencia = competenciaMapper.toEntity(competenciaDTO);
        competenciaMapper.toDto(competenciaRepository.save(competencia));
    }

    public void excluir(Integer competenciaId) {
        try {
            competenciaRepository.deleteById(competenciaId);
            competenciaRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(MSG_COMPETENCIA_NAO_ENCONTRADA);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(MSG_COMPETENCIA_EM_USO);
        }
    }

    public Competencia buscar(Integer competenciaId) {
        return competenciaRepository.findById(competenciaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(MSG_COMPETENCIA_NAO_ENCONTRADA));
    }

    public List<DropdownDTO> buscarColaboradoresComCompetenciaNivelMaximo(Integer competenciaId) {
        return competenciaColaboradorService.buscarColaboradoresComCompetenciaNivelMaximo(competenciaId);
    }
}
