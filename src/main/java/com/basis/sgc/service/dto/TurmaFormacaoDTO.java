package com.basis.sgc.service.dto;

import com.basis.sgc.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class TurmaFormacaoDTO implements Serializable {
    @JsonView(Views.Listagem.class)
    private Integer id;

    @JsonView(Views.Listagem.class)
    @NotBlank
    private String nome;

    @JsonView(Views.Listagem.class)
    @NotBlank
    private String descricao;

    @JsonView(Views.Listagem.class)
    @NotNull
    private LocalDateTime dataInicio;

    @JsonView(Views.Listagem.class)
    @NotNull
    private LocalDateTime dataTermino;

    @JsonView(Views.Listagem.class)
    @NotNull
    private StatusDTO status;
    private Set<CompetenciaEColaboradorDTO> competenciasEColaboradores = new HashSet<>();
}
