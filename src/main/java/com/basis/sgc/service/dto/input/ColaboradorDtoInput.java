package com.basis.sgc.service.dto.input;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColaboradorDtoInput {
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	private String cpf;
	@NotBlank
	@Email
	private String email;
	@NotNull
	private LocalDateTime dataNascimento;
	@NotNull
	private LocalDateTime dataAdmissao;
	@NotNull
	private Integer senioridadeId;
	@Valid
	@NotEmpty(message = "É necessário informar ao menos uma compentecia")
	private Set<CompetenciaNivelDtoIdInput> competencias = new HashSet<>();
}
