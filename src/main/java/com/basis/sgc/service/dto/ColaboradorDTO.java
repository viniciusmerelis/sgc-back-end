package com.basis.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ColaboradorDTO implements Serializable {
    private Integer id;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String cpf;
    @Email
    @NotBlank
    private String email;
    @NotNull
    private LocalDateTime dataNascimento;
    @NotNull
    private LocalDateTime dataAdmissao;
    @Valid
    @NotNull
    private SenioridadeDTO senioridade;
    private Set<CompetenciaDoColaboradorDTO> competencias = new HashSet<>();
}
