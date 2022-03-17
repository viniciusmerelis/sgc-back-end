package com.basis.sgc.service.dto;

import com.basis.sgc.service.dto.view.TurmaFormacaoView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusDto {
	@JsonView(TurmaFormacaoView.ResumoListagem.class)
	private Integer id;
	@JsonView(TurmaFormacaoView.ResumoListagem.class)
	private String nome;
}
