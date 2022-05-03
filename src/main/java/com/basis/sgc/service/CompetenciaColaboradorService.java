package com.basis.sgc.service;

import com.basis.sgc.domain.CompetenciaColaborador;
import com.basis.sgc.repository.CompetenciaColaboradorRepository;
import com.basis.sgc.service.dto.ColaboradorResumoDTO;
import com.basis.sgc.service.dto.CompetenciaDoColaboradorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class CompetenciaColaboradorService {

    private final CompetenciaColaboradorRepository competenciaColaboradorRepository;

    public Set<CompetenciaDoColaboradorDTO> buscarCompetenciasDoColaborador(Integer colaboradorId) {
        return competenciaColaboradorRepository.buscarCompetenciasDoColaborador(colaboradorId);
    }

    public List<CompetenciaColaborador> salvar(List<CompetenciaColaborador> competencias) {
        return competenciaColaboradorRepository.saveAll(competencias);
    }

    public void excluir(Integer colaboradorId) {
        competenciaColaboradorRepository.excluirCompetenciasDoColaborador(colaboradorId);
    }

    public List<ColaboradorResumoDTO> buscarColaboradoresComCompetenciaNivelMaximo(Integer competenciaId) {
        return competenciaColaboradorRepository.buscarColaboradoresComNivelMaximoNaCompetencia(competenciaId);
    }
}
