package com.basis.sgc.repository;

import com.basis.sgc.service.dto.CompetenciaDoColaboradorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.basis.sgc.domain.CompetenciaColaborador;
import com.basis.sgc.domain.CompetenciaColaboradorId;
import com.basis.sgc.domain.enums.Nivel;

import java.util.List;
import java.util.Set;

@Repository
public interface CompetenciaColaboradorRepository extends JpaRepository<CompetenciaColaborador, CompetenciaColaboradorId> {

    @Query(value =
            "select case when count(cc) > 0 then true else false end from CompetenciaColaborador cc " +
                    "where cc.id.competenciaId = :competenciaId and cc.id.colaboradorId = :colaboradorId and cc.nivel = :nivel")
    boolean existeCompetenciaColaboradorComNivel(@Param("competenciaId") Integer competenciaId,
                                                 @Param("colaboradorId") Integer colaboradorId, @Param("nivel") Nivel nivel);

    @Query(value =
            "select new com.basis.sgc.service.dto.CompetenciaDoColaboradorDTO(cc.id.competenciaId, c.nome, cc.nivel) " +
                    "from CompetenciaColaborador cc " +
                    "join Competencia c on c.id = cc.id.competenciaId " +
                    "where cc.id.colaboradorId = :colaboradorId")
    Set<CompetenciaDoColaboradorDTO> buscarCompetenciasDoColaborador(@Param("colaboradorId") Integer colaboradorId);

    @Query(value =
            "select new com.basis.sgc.service.dto.CompetenciaDoColaboradorDTO(cc.id.competenciaId, c.nome, cc.nivel) " +
                    "from CompetenciaColaborador cc " +
                    "join Competencia c on c.id = cc.id.competenciaId " +
                    "where cc.id.colaboradorId in (:colaboradoresIds)")
    Set<CompetenciaDoColaboradorDTO> buscarCompetenciasDosColaboradores(@Param("colaboradoresIds") List<Integer> colaboradoresIds);

    @Modifying
    @Query(value = "delete from CompetenciaColaborador cc where cc.id.colaboradorId = :colaboradorId")
    void excluirCompetenciasDoColaborador(@Param("colaboradorId") Integer colaboradorId);
}
