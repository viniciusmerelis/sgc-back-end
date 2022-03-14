package com.basis.sgc.service.dto.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompetenciaDtoInput {

	@NotBlank
	private String nome;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private Integer categoriaId;
}
