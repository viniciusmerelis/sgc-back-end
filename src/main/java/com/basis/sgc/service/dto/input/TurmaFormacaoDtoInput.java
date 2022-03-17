package com.basis.sgc.service.dto.input;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurmaFormacaoDtoInput {
	@NotBlank
	private String nome;
	@NotBlank
	private String descricao;
	@NotNull
	private LocalDateTime dataInicio;
	@NotNull
	private LocalDateTime dataTermino;
	@NotNull
	private Integer statusId;
	@Valid
	@NotEmpty(message = "Deve ser informado ao menos uma competencia e um colaborador")
	private Set<CompetenciaColaboradorDtoIdInput> competenciasColaboradores = new HashSet<>();
}
