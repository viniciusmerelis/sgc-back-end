package com.basis.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class TurmaFormacaoDTO implements Serializable {
    private Integer id;
    private String nome;
    private String descricao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;
    private StatusDTO status;
//    private Set<CompetenciaColaboradorDTO> competenciasColaboradores = new HashSet<>();
}
