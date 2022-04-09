package com.basis.sgc.repository;

import com.basis.sgc.service.dto.CompetenciaDoColaboradorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.basis.sgc.domain.CompetenciaColaborador;
import com.basis.sgc.domain.CompetenciaColaboradorId;

import java.util.Set;

@Repository
public interface CompetenciaColaboradorRepository extends JpaRepository<CompetenciaColaborador, CompetenciaColaboradorId> {

    @Query(value =
            "select new com.basis.sgc.service.dto.CompetenciaDoColaboradorDTO(cc.id.competenciaId, c.nome, cc.nivel) " +
                    "from CompetenciaColaborador cc " +
                    "join Competencia c on c.id = cc.id.competenciaId " +
                    "where cc.id.colaboradorId = :colaboradorId")
    Set<CompetenciaDoColaboradorDTO> buscarCompetenciasDoColaborador(@Param("colaboradorId") Integer colaboradorId);

    @Modifying
    @Query(value = "delete from CompetenciaColaborador cc where cc.id.colaboradorId = :colaboradorId")
    void excluirCompetenciasDoColaborador(@Param("colaboradorId") Integer colaboradorId);

    @Query(value =
            "select case when count(cc) > 0 then true else false end from CompetenciaColaborador cc " +
                    "where cc.id.colaboradorId = :colaboradorId")
    boolean isColaboradorComCompetencia(@Param("colaboradorId") Integer colaboradorId);
}
