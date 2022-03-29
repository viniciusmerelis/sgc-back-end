package com.basis.sgc.service;

import com.basis.sgc.domain.Status;
import com.basis.sgc.exception.EntidadeNaoEncontradaException;
import com.basis.sgc.repository.StatusRepository;
import com.basis.sgc.service.dto.StatusDTO;
import com.basis.sgc.service.mapper.StatusMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StatusService {

    private static final String MSG_STATUS_NAO_ENCONTRADO = "Não existe um status com código ";

    private final StatusRepository statusRepository;
    private final StatusMapper statusMapper;

    public List<StatusDTO> listar() {
        return statusMapper.toDto(statusRepository.findAll());
    }

    public StatusDTO buscarPorId(Integer statusId) {
        return statusMapper.toDto(buscar(statusId));
    }

    public Status buscar(Integer statusId) {
        return statusRepository.findById(statusId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(MSG_STATUS_NAO_ENCONTRADO));
    }
}
