package com.basis.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class TurmaFormacaoDto implements Serializable {
    private Integer id;
    private String nome;
    private String descricao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;
    private StatusDto status;
    private Set<CompetenciaColaboradorDto> competenciasColaboradores = new HashSet<>();
}
