package com.basis.sgc.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "turma_competencia_colaborador")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class TurmaCompetenciaColaborador {

	@EmbeddedId
	private TurmaCompetenciaColaboradorId id;
	
	@MapsId("turmaId")
	@ManyToOne(optional = false)
	@JoinColumn(name = "turma_id", referencedColumnName = "id", insertable = false, updatable = false)
	private TurmaFormacao turma;
	
	@MapsId("competenciaId")
	@ManyToOne(optional = false)
	@JoinColumn(name = "competencia_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Competencia competencia;
	
	@MapsId("colaboradorId")
	@ManyToOne(optional = false)
	@JoinColumn(name = "colaborador_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Colaborador colaborador;
}