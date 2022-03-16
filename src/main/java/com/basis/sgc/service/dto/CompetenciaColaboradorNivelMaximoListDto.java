package com.basis.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompetenciaColaboradorNivelMaximoListDto {
	private Integer competenciaId;
	private String competenciaNome;
	private Integer colaboradorId;
	private String colaboradorNome;
	private String colaboradorSobrenome;
}
