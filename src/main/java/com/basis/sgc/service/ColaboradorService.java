package com.basis.sgc.service;

import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.domain.Competencia;
import com.basis.sgc.domain.CompetenciaColaborador;
import com.basis.sgc.domain.Senioridade;
import com.basis.sgc.exception.EntidadeEmUsoException;
import com.basis.sgc.exception.EntidadeNaoEncontradaException;
import com.basis.sgc.repository.ColaboradorRepository;
import com.basis.sgc.service.dto.ColaboradorDto;
import com.basis.sgc.service.dto.input.ColaboradorDtoInput;
import com.basis.sgc.service.mapper.ColaboradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class ColaboradorService {

    private static final String MSG_COLABORADOR_NAO_ENCONTRADO = "Não existe um cadastro desse colaborador no sistema.";
    private static final String MSG_COLABORADOR_EM_USO = "Este colaborador está em uso";

    private final ColaboradorRepository colaboradorRepository;
    private final ColaboradorMapper colaboradorMapper;
    private final SenioridadeService senioridadeService;
    private final CompetenciaService competenciaService;

    public List<ColaboradorDto> listar() {
        return colaboradorMapper.toDto(colaboradorRepository.findAll());
    }

    public ColaboradorDto buscarPorId(Integer colaboradorId) {
        return colaboradorMapper.toDto(buscarOuFalhar(colaboradorId));
    }

    public ColaboradorDto salvar(ColaboradorDtoInput colaboradorDtoInput) {
        Colaborador colaborador = colaboradorMapper.toEntity(colaboradorDtoInput);
        Integer senioridadeId = colaborador.getSenioridade().getId();
        Senioridade senioridade = senioridadeService.buscarOuFalhar(senioridadeId);
        colaborador.setSenioridade(senioridade);
        colaborador.setCompetencias(adicionarCompetencias(colaborador));
        return colaboradorMapper.toDto(colaboradorRepository.save(colaborador));
    }

    public ColaboradorDto atualizar(Integer colaboradorId, ColaboradorDtoInput colaboradorDtoInput) {
        Colaborador colaborador = colaboradorMapper.toEntity(colaboradorDtoInput);
        colaborador.setId(colaboradorId);
        Integer senioridadeId = colaborador.getSenioridade().getId();
        Senioridade senioridade = senioridadeService.buscarOuFalhar(senioridadeId);
        colaborador.setSenioridade(senioridade);
        colaborador.setCompetencias(adicionarCompetencias(colaborador));
        return colaboradorMapper.toDto(colaboradorRepository.save(colaborador));
    }

    public void excluir(Integer colaboradorId) {
        try {
            colaboradorRepository.deleteById(colaboradorId);
            colaboradorRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(MSG_COLABORADOR_NAO_ENCONTRADO);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(MSG_COLABORADOR_EM_USO);
        }
    }

    public Colaborador buscarOuFalhar(Integer colaboradorId) {
        return colaboradorRepository.findById(colaboradorId).orElseThrow(() -> new EntidadeNaoEncontradaException(
                MSG_COLABORADOR_NAO_ENCONTRADO));
    }

    private Set<CompetenciaColaborador> adicionarCompetencias(Colaborador colaborador) {
        colaborador.getCompetencias().forEach(item -> {
            Competencia competencia = competenciaService.buscarOuFalhar(item.getId().getCompetenciaId());
            if (colaborador.getId() != null) {
                item.getId().setColaboradorId(colaborador.getId());
            }
            item.setColaborador(colaborador);
            item.setCompetencia(competencia);
        });
        return colaborador.getCompetencias();
    }
}
