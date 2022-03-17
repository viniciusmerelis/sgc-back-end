package com.basis.sgc.service.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.basis.sgc.service.dto.view.TurmaFormacaoView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurmaFormacaoDto {
	@JsonView(TurmaFormacaoView.ResumoListagem.class)
	private Integer id;
	@JsonView(TurmaFormacaoView.ResumoListagem.class)
	private String nome;
	@JsonView(TurmaFormacaoView.ResumoListagem.class)
	private String descricao;
	@JsonView(TurmaFormacaoView.ResumoListagem.class)
	private LocalDateTime dataInicio;
	@JsonView(TurmaFormacaoView.ResumoListagem.class)
	private LocalDateTime dataTermino;
	@JsonView(TurmaFormacaoView.ResumoListagem.class)
	private StatusDto status;
	private Set<CompetenciaColaboradorDto> competenciasColaboradores = new HashSet<>();
}
