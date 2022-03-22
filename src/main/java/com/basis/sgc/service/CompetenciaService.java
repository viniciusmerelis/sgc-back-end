package com.basis.sgc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.basis.sgc.domain.Categoria;
import com.basis.sgc.domain.Competencia;
import com.basis.sgc.exception.EntidadeEmUsoException;
import com.basis.sgc.exception.EntidadeNaoEncontradaException;
import com.basis.sgc.exception.RegraNegocioException;
import com.basis.sgc.repository.CategoriaRepository;
import com.basis.sgc.repository.CompetenciaRepository;
import com.basis.sgc.service.dto.ColaboradorResumoDto;
import com.basis.sgc.service.dto.CompetenciaColaboradorNivelMaximoDto;
import com.basis.sgc.service.dto.CompetenciaColaboradorNivelMaximoListDto;
import com.basis.sgc.service.dto.CompetenciaDto;
import com.basis.sgc.service.dto.CompetenciaResumoDto;
import com.basis.sgc.service.dto.input.CompetenciaDtoInput;
import com.basis.sgc.service.mapper.CompetenciaMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompetenciaService {

	private CompetenciaRepository competenciaRepository;
	private CompetenciaMapper competenciaMapper;
	private CategoriaRepository categoriaRepository;

	@Transactional
	public List<CompetenciaDto> listarTodas() {
		return competenciaMapper.toDto(competenciaRepository.findAll());
	}

	@Transactional
	public CompetenciaDto buscarPeloId(Integer competenciaId) {
		return competenciaMapper.toDto(
				competenciaRepository.findById(competenciaId).orElseThrow(() -> new RegraNegocioException("Não existe competencia com código " + competenciaId)));
	}

	@Transactional
	public CompetenciaDto salvar(CompetenciaDtoInput competenciaDtoInput) {
		Competencia competencia = competenciaMapper.toEntity(competenciaDtoInput);
		Integer categoriaId = competencia.getCategoria().getId();
		Categoria categoria = categoriaRepository.findById(categoriaId)
				.orElseThrow(() -> new RegraNegocioException("Não existe categoria com código " + categoriaId));
		competencia.setCategoria(categoria);
		return competenciaMapper.toDto(competenciaRepository.save(competencia));
	}

	@Transactional
	public CompetenciaDto atualizar(Integer competenciaId, CompetenciaDtoInput competenciaDtoInput) {
		Competencia competencia = competenciaMapper.toEntity(competenciaDtoInput);
		competencia.setId(competenciaId);
		Integer categoriaId = competencia.getCategoria().getId();
		Categoria categoria = categoriaRepository.findById(categoriaId)
				.orElseThrow(() -> new RegraNegocioException("Não existe categoria com código " + categoriaId));
		competencia.setCategoria(categoria);
		return competenciaMapper.toDto(competenciaRepository.save(competencia));
	}

	@Transactional
	public void excluir(Integer competenciaId) {
		try {
			competenciaRepository.deleteById(competenciaId);
			competenciaRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException("Não existe uma competencia com código " + competenciaId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException("A competencia de código " + competenciaId + " está em uso");
		}
	}

	public List<CompetenciaColaboradorNivelMaximoDto> buscarColaboradoresNivelMaximo() {
		List<CompetenciaColaboradorNivelMaximoListDto> resultQuery = competenciaRepository.buscarCompetenciasEColaboradoresNivelMaximo();
		Map<Integer, CompetenciaColaboradorNivelMaximoDto> map = new HashMap<>();

		for(CompetenciaColaboradorNivelMaximoListDto itemResult : resultQuery) {
			CompetenciaColaboradorNivelMaximoDto competenciaKey = map.computeIfAbsent(itemResult.getCompetenciaId(), (k) -> {
				CompetenciaColaboradorNivelMaximoDto competencia = new CompetenciaColaboradorNivelMaximoDto();
				competencia.setCompetencia(new CompetenciaResumoDto());
				competencia.getCompetencia().setId(itemResult.getCompetenciaId());
				competencia.getCompetencia().setNome(itemResult.getCompetenciaNome());
				return competencia;
			});
			ColaboradorResumoDto colaborador = new ColaboradorResumoDto();
			colaborador.setId(itemResult.getColaboradorId());
			colaborador.setNome(itemResult.getColaboradorNome());
			colaborador.setSobrenome(itemResult.getColaboradorSobrenome());
			competenciaKey.getColaboradores().add(colaborador);
		}
		return new ArrayList<>(map.values());
	}
}
