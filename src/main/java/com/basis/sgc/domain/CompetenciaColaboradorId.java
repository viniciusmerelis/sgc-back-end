package com.basis.sgc.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@Embeddable
public class CompetenciaColaboradorId {

	@Column(name = "competencia_id", nullable = false)
	private Integer competenciaId;
	
	@Column(name = "colaborador_id", nullable = false)
	private Integer colaboradorId;
}
