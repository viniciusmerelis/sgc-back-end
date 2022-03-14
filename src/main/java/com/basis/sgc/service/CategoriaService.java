package com.basis.sgc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.basis.sgc.domain.Categoria;
import com.basis.sgc.exception.EntidadeNaoEncontradaException;
import com.basis.sgc.repository.CategoriaRepository;
import com.basis.sgc.service.dto.CategoriaDto;
import com.basis.sgc.service.mapper.CategoriaMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriaService {

	private CategoriaRepository categoriaRepository;
	private CategoriaMapper categoriaMapper;
	
	@Transactional
	public List<CategoriaDto> listarTodas() {
		return categoriaMapper.toDto(categoriaRepository.findAll());
	}
	
	@Transactional
	public CategoriaDto buscarPeloId(Integer categoriaId) {
		return categoriaMapper.toDto(buscarOuFalhar(categoriaId));
	}
	
	public Categoria buscarOuFalhar(Integer categoriaId) {
		return categoriaRepository.findById(categoriaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Categoria de código %d não encontrada", categoriaId)));
	}
}
