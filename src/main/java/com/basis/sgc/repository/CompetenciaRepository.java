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
            "cc.id.competenciaId, c.nome, cc.id.colaboradorId, colab.nome," +
            "colab.sobrenome) from CompetenciaColaborador cc " +
            "join Competencia c on c.id = cc.id.competenciaId " +
            "join Colaborador colab on colab.id = cc.id.colaboradorId " +
            "where cc.nivel=2")
    List<CompetenciaColaboradorNivelMaximoListDTO> buscarCompetenciasEColaboradoresNivelMaximo();
}
