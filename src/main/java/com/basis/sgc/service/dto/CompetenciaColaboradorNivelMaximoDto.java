package com.basis.sgc.service.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompetenciaColaboradorNivelMaximoDto {
	private CompetenciaResumoDto competencia;
	private List<ColaboradorResumoDto> colaboradores;
}
