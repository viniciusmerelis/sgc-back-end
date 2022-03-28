package com.basis.sgc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.basis.sgc.domain.CompetenciaColaborador;
import com.basis.sgc.domain.CompetenciaColaboradorId;
import com.basis.sgc.enums.Nivel;

@Repository
public interface CompetenciaColaboradorRepository extends JpaRepository<CompetenciaColaborador, CompetenciaColaboradorId> {

	@Query(value = "select case when count(cc) > 0 then true else false end from CompetenciaColaborador cc "
			+ "where cc.id.competenciaId = :competenciaId and cc.id.colaboradorId = :colaboradorId and cc.nivel = :nivel")
	boolean existeCompetenciaColaboradorComNivel(@Param("competenciaId") Integer competenciaId,
			@Param("colaboradorId") Integer colaboradorId, @Param("nivel") Nivel nivel);

}
