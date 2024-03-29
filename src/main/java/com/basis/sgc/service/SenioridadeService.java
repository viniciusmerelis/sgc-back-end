package com.basis.sgc.service;

import com.basis.sgc.domain.Senioridade;
import com.basis.sgc.exception.EntidadeNaoEncontradaException;
import com.basis.sgc.repository.SenioridadeRepository;
import com.basis.sgc.service.dto.SenioridadeDTO;
import com.basis.sgc.service.mapper.SenioridadeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SenioridadeService {

	private static final String MSG_SENIORIDADE_NAO_ENCONTRADA = "Não existe um cadastro dessa senioridade no sistema.";

	private final SenioridadeRepository senioridadeRepository;
	private final SenioridadeMapper senioridadeMapper;

	public List<SenioridadeDTO> listar() {
		return senioridadeMapper.toDto(senioridadeRepository.findAll());
	}

	public SenioridadeDTO buscarPorId(Integer senioridadeId) {
		return senioridadeMapper.toDto(buscar(senioridadeId));
	}

	public Senioridade buscar(Integer senioridadeId) {
		return senioridadeRepository.findById(senioridadeId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(MSG_SENIORIDADE_NAO_ENCONTRADA));
	}
}
