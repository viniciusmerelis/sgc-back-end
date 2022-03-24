package com.basis.sgc.service;

import java.util.List;

import javax.transaction.Transactional;

import com.basis.sgc.domain.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.basis.sgc.exception.EntidadeNaoEncontradaException;
import com.basis.sgc.exception.RegraNegocioException;
import com.basis.sgc.repository.ColaboradorRepository;
import com.basis.sgc.repository.CompetenciaRepository;
import com.basis.sgc.repository.StatusRepository;
import com.basis.sgc.repository.TurmaFormacaoRepository;
import com.basis.sgc.service.dto.TurmaFormacaoDto;
import com.basis.sgc.service.dto.input.TurmaFormacaoDtoInput;
import com.basis.sgc.service.mapper.TurmaFormacaoMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TurmaFormacaoService {

    private static final String MSG_TURMA_NAO_ENCONTRADA = "Não existe um cadastro de turma formação com código ";
    private static final String MSG_ERRO_EXCLUIR_TURMA_INICIADA = "Esta turma não pode ser excluida pois está em andamento.";
    private static final String MSG_STATUS_NAO_ENCONTRADO = "Não existe um status com código ";
    private static final String MSG_COMPETENCIA_NAO_ENCONTRADA = "Não existe uma competencia com código ";
    private static final String MSG_COLABORADOR_NAO_ENCONTRADO = "Não existe um colaborador com código ";

    private TurmaFormacaoRepository turmaFormacaoRepository;
    private TurmaFormacaoMapper turmaFormacaoMapper;
    private StatusRepository statusRepository;
    private CompetenciaRepository competenciaRepository;
    private ColaboradorRepository colaboradorRepository;

    @Transactional
    public List<TurmaFormacaoDto> listarTodas() {
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.findAll());
    }

    @Transactional
    public TurmaFormacaoDto buscarPeloId(Integer turmaId) {
        return turmaFormacaoMapper.toDto(buscarOuFalhar(turmaId));
    }

    @Transactional
    public TurmaFormacaoDto salvar(TurmaFormacaoDtoInput turmaFormacaoDtoInput) {
        TurmaFormacao turma = turmaFormacaoMapper.toEntity(turmaFormacaoDtoInput);
        Integer statusId = turma.getStatus().getId();
        Status status = statusRepository.findById(statusId)
                .orElseThrow(() -> new RegraNegocioException(MSG_STATUS_NAO_ENCONTRADO + statusId));
        turma.setStatus(status);
        turma.getCompetenciasColaboradores().forEach(item -> {
            Competencia competencia = competenciaRepository.findById(item.getId().getCompetenciaId())
                    .orElseThrow(() -> new RegraNegocioException(MSG_COMPETENCIA_NAO_ENCONTRADA + item.getId().getCompetenciaId()));
            Colaborador colaborador = colaboradorRepository.findById(item.getId().getColaboradorId())
                    .orElseThrow(() -> new RegraNegocioException(MSG_COLABORADOR_NAO_ENCONTRADO + item.getId().getColaboradorId()));
            item.setTurma(turma);
            item.setCompetencia(competencia);
            item.setColaborador(colaborador);
        });
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.save(turma));
    }

    @Transactional
    public TurmaFormacaoDto atualizar(Integer turmaId, TurmaFormacaoDtoInput turmaFormacaoDtoInput) {
        TurmaFormacao turma = turmaFormacaoMapper.toEntity(turmaFormacaoDtoInput);
        turma.setId(turmaId);
        Integer statusId = turma.getStatus().getId();
        Status status = statusRepository.findById(statusId)
                .orElseThrow(() -> new RegraNegocioException(MSG_STATUS_NAO_ENCONTRADO + statusId));
        turma.setStatus(status);
        turma.getCompetenciasColaboradores().forEach(item -> {
            Competencia competencia = competenciaRepository.findById(item.getId().getCompetenciaId())
                    .orElseThrow(() -> new RegraNegocioException(MSG_COMPETENCIA_NAO_ENCONTRADA + item.getId().getCompetenciaId()));
            Colaborador colaborador = colaboradorRepository.findById(item.getId().getColaboradorId())
                    .orElseThrow(() -> new RegraNegocioException(MSG_COLABORADOR_NAO_ENCONTRADO + item.getId().getColaboradorId()));
            item.getId().setTurmaId(turma.getId());
            item.setTurma(turma);
            item.setCompetencia(competencia);
            item.setColaborador(colaborador);
        });
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.save(turma));
    }

    @Transactional
    public void excluir(Integer turmaId) {
        TurmaFormacao turma = buscarOuFalhar(turmaId);
        if (turma.getStatus().getNome().equals("Iniciada")) {
            throw new RegraNegocioException(MSG_ERRO_EXCLUIR_TURMA_INICIADA);
        }
        turmaFormacaoRepository.deleteById(turmaId);
    }

    @Transactional
    public TurmaFormacao buscarOuFalhar(Integer turmaId) {
        return turmaFormacaoRepository.findById(turmaId).orElseThrow(() -> new EntidadeNaoEncontradaException(
                MSG_TURMA_NAO_ENCONTRADA + turmaId));
    }
}