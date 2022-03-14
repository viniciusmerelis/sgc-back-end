package com.basis.sgc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.basis.sgc.repository.StatusRepository;
import com.basis.sgc.service.dto.StatusDto;
import com.basis.sgc.service.mapper.StatusMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatusService {

	private StatusRepository statusRepository;
	private StatusMapper statusMapper;
	
	@Transactional
	public List<StatusDto> listarTodas() {
		return statusMapper.toDto(statusRepository.findAll());
	}
	
	@Transactional
	public StatusDto buscarPeloId(Integer statusId) {
		return statusMapper.toDto(statusRepository.findById(statusId)
				.orElseThrow(() -> new RuntimeException("Deu ruim")));
	}
}
