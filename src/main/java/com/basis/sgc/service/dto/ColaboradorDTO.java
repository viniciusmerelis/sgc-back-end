package com.basis.sgc.service.dto;

import com.basis.sgc.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonView(Views.Listagem.class)
    private Integer id;

    @JsonView(Views.Listagem.class)
    @NotBlank
    private String nome;

    @JsonView(Views.Listagem.class)
    @NotBlank
    private String sobrenome;

    @NotBlank
    private String cpf;

    @JsonView(Views.Listagem.class)
    @Email
    @NotBlank
    private String email;

    @JsonView(Views.Listagem.class)
    @NotNull
    private LocalDateTime dataNascimento;

    @NotNull
    private LocalDateTime dataAdmissao;

    @JsonView(Views.Listagem.class)
    @Valid
    @NotNull
    private SenioridadeDTO senioridade;

    private Set<CompetenciaDoColaboradorDTO> competencias = new HashSet<>();
}
