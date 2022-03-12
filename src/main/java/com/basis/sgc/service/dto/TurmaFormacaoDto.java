package com.basis.sgc.service.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurmaFormacaoDto {

	private Integer id;
	private String nome;
	private String descricao;
	private LocalDateTime dataInicio;
	private LocalDateTime dataTermino;
	private StatusDto status;
}
