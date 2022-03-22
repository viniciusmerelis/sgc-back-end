package com.basis.sgc.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompetenciaColaboradorNivelMaximoListDto {
	private Integer competenciaId;
	private String competenciaNome;
	private Integer colaboradorId;
	private String colaboradorNome;
	private String colaboradorSobrenome;
}
