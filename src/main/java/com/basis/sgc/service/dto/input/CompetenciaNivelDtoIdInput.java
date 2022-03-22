package com.basis.sgc.service.dto.input;

import javax.validation.constraints.NotNull;

import com.basis.sgc.domain.Nivel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompetenciaNivelDtoIdInput {
	@NotNull
	private Integer id;
	@NotNull
	private Nivel nivel;
}
