package com.basis.sgc.service.dto.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompetenciaColaboradorDtoIdInput {
	@NotNull
	private Integer competenciaId;
	@NotNull
	private Integer colaboradorId;
}
