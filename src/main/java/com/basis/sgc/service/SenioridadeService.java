package com.basis.sgc.service;

import com.basis.sgc.domain.Senioridade;
import com.basis.sgc.exception.EntidadeNaoEncontradaException;
import com.basis.sgc.repository.SenioridadeRepository;
import com.basis.sgc.service.dto.SenioridadeDto;
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

	public List<SenioridadeDto> listar() {
		return senioridadeMapper.toDto(senioridadeRepository.findAll());
	}

	public SenioridadeDto buscarPorId(Integer senioridadeId) {
		return senioridadeMapper.toDto(buscarOuFalhar(senioridadeId));
	}

	public Senioridade buscarOuFalhar(Integer senioridadeId) {
		return senioridadeRepository.findById(senioridadeId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(MSG_SENIORIDADE_NAO_ENCONTRADA));
	}
}
