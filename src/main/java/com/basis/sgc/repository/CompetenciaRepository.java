package com.basis.sgc.repository;

import com.basis.sgc.domain.Competencia;
import com.basis.sgc.service.dto.CompetenciaColaboradorNivelMaximoListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Integer> {

    @Query(value = "select new com.basis.sgc.service.dto.CompetenciaColaboradorNivelMaximoListDTO(" +
            "cc.id.competenciaId, cc.competencia.nome, cc.id.colaboradorId, cc.colaborador.nome," +
            "cc.colaborador.sobrenome) from CompetenciaColaborador cc where cc.nivel=2")
    List<CompetenciaColaboradorNivelMaximoListDTO> buscarCompetenciasEColaboradoresNivelMaximo();
}
