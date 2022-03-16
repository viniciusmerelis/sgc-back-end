package com.basis.sgc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.basis.sgc.domain.Senioridade;
import com.basis.sgc.exception.EntidadeNaoEncontradaException;
import com.basis.sgc.repository.SenioridadeRepository;
import com.basis.sgc.service.dto.SenioridadeDto;
import com.basis.sgc.service.mapper.SenioridadeMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SenioridadeService {

	private SenioridadeRepository senioridadeRepository;
	private SenioridadeMapper senioridadeMapper;
	
	@Transactional
	public List<SenioridadeDto> listarTodas() {
		return senioridadeMapper.toDto(senioridadeRepository.findAll());
	}
	
	@Transactional
	public SenioridadeDto buscarPeloId(Integer senioridadeId) {
		return senioridadeMapper.toDto(buscarOuFalhar(senioridadeId));
	}
	
	@Transactional
	public Senioridade buscarOuFalhar(Integer senioridadeId) {
		return senioridadeRepository.findById(senioridadeId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Não existe uma senioridade com código " + senioridadeId));
	}
}
