package com.basis.sgc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.domain.Competencia;
import com.basis.sgc.domain.Status;
import com.basis.sgc.domain.TurmaFormacao;
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
				.orElseThrow(() -> new RegraNegocioException("Não existe um status com código " + statusId));
		turma.setStatus(status);
		turma.getCompetenciasColaboradores().forEach(item -> {
			Competencia competencia = competenciaRepository.findById(item.getId().getCompetenciaId())
					.orElseThrow(() -> new RegraNegocioException("Não existe uma competencia com código " + item.getId().getCompetenciaId()));
			Colaborador colaborador = colaboradorRepository.findById(item.getId().getColaboradorId())
					.orElseThrow(() -> new RegraNegocioException("Não existe um colaborador com código " + item.getId().getColaboradorId()));
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
				.orElseThrow(() -> new RegraNegocioException("Não existe um status com código " + statusId));
		turma.setStatus(status);
		turma.getCompetenciasColaboradores().forEach(item -> {
			Competencia competencia = competenciaRepository.findById(item.getId().getCompetenciaId())
					.orElseThrow(() -> new RegraNegocioException("Não existe uma competencia com código " + item.getId().getCompetenciaId()));
			Colaborador colaborador = colaboradorRepository.findById(item.getId().getColaboradorId())
					.orElseThrow(() -> new RegraNegocioException("Não existe um colaborador com código " + item.getId().getColaboradorId()));
			item.setTurma(turma);
			item.setCompetencia(competencia);
			item.setColaborador(colaborador);
		});
		return turmaFormacaoMapper.toDto(turmaFormacaoRepository.save(turma));
	}
	
	@Transactional
	public void excluir(Integer turmaId) {
		try {
			turmaFormacaoRepository.deleteById(turmaId);
			turmaFormacaoRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException("Não existe um cadastro de turma formação com código " + turmaId);
		}
	}
	
	

	@Transactional
	public TurmaFormacao buscarOuFalhar(Integer turmaId) {
		return turmaFormacaoRepository.findById(turmaId).orElseThrow(() -> new EntidadeNaoEncontradaException(
				"Não existe um cadastro de turma formação com código" + turmaId));
	}
}
