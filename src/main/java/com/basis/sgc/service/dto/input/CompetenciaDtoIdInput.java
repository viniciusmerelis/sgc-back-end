package com.basis.sgc.service.dto.input;

import javax.validation.constraints.NotNull;

import com.basis.sgc.service.dto.NivelDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompetenciaDtoIdInput {
	@NotNull
	private Integer id;
	@NotNull
	private NivelDto nivel;
}
