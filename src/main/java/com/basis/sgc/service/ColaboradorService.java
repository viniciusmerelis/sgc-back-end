package com.basis.sgc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.domain.Competencia;
import com.basis.sgc.domain.Senioridade;
import com.basis.sgc.exception.EntidadeEmUsoException;
import com.basis.sgc.exception.EntidadeNaoEncontradaException;
import com.basis.sgc.exception.RegraNegocioException;
import com.basis.sgc.repository.ColaboradorRepository;
import com.basis.sgc.repository.CompetenciaRepository;
import com.basis.sgc.repository.SenioridadeRepository;
import com.basis.sgc.service.dto.ColaboradorDto;
import com.basis.sgc.service.dto.input.ColaboradorDtoInput;
import com.basis.sgc.service.mapper.ColaboradorMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ColaboradorService {

	private ColaboradorRepository colaboradorRepository;
	private ColaboradorMapper colaboradorMapper;
	private SenioridadeRepository senioridadeRepository;
	private CompetenciaRepository competenciaRepository;

	@Transactional
	public List<ColaboradorDto> listarTodos() {
		return colaboradorMapper.toDto(colaboradorRepository.findAll());
	}

	@Transactional
	public ColaboradorDto buscarPeloId(Integer colaboradorId) {
		return colaboradorMapper.toDto(buscarOuFalhar(colaboradorId));
	}

	@Transactional
	public ColaboradorDto salvar(ColaboradorDtoInput colaboradorDtoInput) {
		Colaborador colaborador = colaboradorMapper.toEntity(colaboradorDtoInput);
		Integer senioridadeId = colaborador.getSenioridade().getId();
		Senioridade senioridade = senioridadeRepository.findById(senioridadeId)
				.orElseThrow(() -> new RegraNegocioException("Não existe uma senioridade com código " + senioridadeId));
		colaborador.setSenioridade(senioridade);
		colaborador.getCompetencias().forEach(item -> {
			Competencia competencia = competenciaRepository.findById(item.getId().getCompetenciaId())
					.orElseThrow(() -> new RegraNegocioException(
							"Não existe um cadastro de competencia com código " + item.getId().getCompetenciaId()));
			item.setCompetencia(competencia);
			item.setColaborador(colaborador);
		});
		return colaboradorMapper.toDto(colaboradorRepository.save(colaborador));
	}

	@Transactional
	public ColaboradorDto atualizar(Integer colaboradorId, ColaboradorDtoInput colaboradorDtoInput) {
		Colaborador colaborador = colaboradorMapper.toEntity(colaboradorDtoInput);
		colaborador.setId(colaboradorId);
		Integer senioridadeId = colaborador.getSenioridade().getId();
		Senioridade senioridade = senioridadeRepository.findById(senioridadeId)
				.orElseThrow(() -> new RegraNegocioException("Não existe uma senioridade com código " + senioridadeId));
		colaborador.setSenioridade(senioridade);
		colaborador.getCompetencias().forEach(item -> {
			Competencia competencia = competenciaRepository.findById(item.getId().getCompetenciaId())
					.orElseThrow(() -> new RegraNegocioException(
							"Não existe um cadastro de competencia com código " + item.getId().getCompetenciaId()));
			item.getId().setColaboradorId(colaborador.getId());
			item.setColaborador(colaborador);
			item.setCompetencia(competencia);
		});
		return colaboradorMapper.toDto(colaboradorRepository.save(colaborador));
	}

	@Transactional
	public void excluir(Integer colaboradorId) {
		try {
			colaboradorRepository.deleteById(colaboradorId);
			colaboradorRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					"Não existe um cadastro de colaborador com código " + colaboradorId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException("O colaborador de código " + colaboradorId + " está em uso");
		}
	}

	@Transactional
	public Colaborador buscarOuFalhar(Integer colaboradorId) {
		return colaboradorRepository.findById(colaboradorId).orElseThrow(() -> new EntidadeNaoEncontradaException(
				"Não existe um cadastro de colaborador com código " + colaboradorId));
	}
}
