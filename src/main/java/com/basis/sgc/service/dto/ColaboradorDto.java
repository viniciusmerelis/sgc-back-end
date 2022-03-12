package com.basis.sgc.service.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColaboradorDto {

	private Integer id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String email;
	private LocalDateTime dataNascimento;
	private LocalDateTime dataAdmissao;
	private SenioridadeDto senioridade;
}
