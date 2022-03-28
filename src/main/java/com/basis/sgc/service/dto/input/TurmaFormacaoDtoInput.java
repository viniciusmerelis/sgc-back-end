package com.basis.sgc.service.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class TurmaFormacaoDtoInput implements Serializable {
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
    @NotEmpty
    private Set<CompetenciaColaboradorDtoIdInput> competenciasColaboradores = new HashSet<>();
}
