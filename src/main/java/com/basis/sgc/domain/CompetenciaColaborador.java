package com.basis.sgc.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "competencia_colaborador")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class CompetenciaColaborador {

	@EmbeddedId
	private CompetenciaColaboradorId id;
	
	@MapsId("competenciaId")
	@ManyToOne(optional = false)
	@JoinColumn(name = "competencia_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Competencia competencia;
	
	@MapsId("colaboradorId")
	@ManyToOne(optional = false)
	@JoinColumn(name = "colaborador_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Colaborador colaborador;

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "nivel")
	private Nivel nivel;
}
