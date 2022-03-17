package com.basis.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompetenciaDto {
	private Integer id;
	private String nome;
	private String descricao;
	private CategoriaDto categoria;
}
