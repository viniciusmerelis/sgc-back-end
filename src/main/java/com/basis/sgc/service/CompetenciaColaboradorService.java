package com.basis.sgc.service;

import com.basis.sgc.domain.CompetenciaColaborador;
import com.basis.sgc.repository.CompetenciaColaboradorRepository;
import com.basis.sgc.service.dto.CompetenciaColaboradorDTO;
import com.basis.sgc.service.mapper.CompetenciaColaboradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CompetenciaColaboradorService {

    private final CompetenciaColaboradorRepository competenciaColaboradorRepository;
    private final CompetenciaColaboradorMapper competenciaColaboradorMapper;

    public List<CompetenciaColaboradorDTO> listar() {
        return competenciaColaboradorMapper.toDto(competenciaColaboradorRepository.findAll());
    }

    public void salvar(List<CompetenciaColaboradorDTO> competenciaColaboradorDTO) {
        List<CompetenciaColaborador> competenciasColaboradores = competenciaColaboradorMapper.toEntity(competenciaColaboradorDTO);
//        TODO: fazer validação
    }

    public void excluir(CompetenciaColaboradorDTO competenciasColaboradoresDTO) {

    }
}
