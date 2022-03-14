package com.basis.sgc.service;

import java.util.List;

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
import com.basis.sgc.service.dto.CompetenciaDto;
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
				competenciaRepository.findById(competenciaId).orElseThrow(() -> new RuntimeException("Deu ruim")));
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
}
