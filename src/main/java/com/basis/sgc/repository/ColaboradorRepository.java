package com.basis.sgc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.service.dto.CompetenciaColaboradorNivelMaximoListDto;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

	@Query(value = "select new com.basis.sgc.service.dto.CompetenciaColaboradorNivelMaximoListDto(cc.id.competenciaId, cc.competencia.nome, cc.id.colaboradorId, cc.colaborador.nome, cc.colaborador.sobrenome) from CompetenciaColaborador cc where cc.nivel=2")
	List<CompetenciaColaboradorNivelMaximoListDto> buscarColaboradorCompetenciaNivelMaximo();
}
