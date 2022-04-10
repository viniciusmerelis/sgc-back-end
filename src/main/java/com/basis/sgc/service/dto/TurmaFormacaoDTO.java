package com.basis.sgc.service.dto;

import com.basis.sgc.view.TurmaFormacaoView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class TurmaFormacaoDTO implements Serializable {
    @JsonView(TurmaFormacaoView.Listagem.class)
    private Integer id;
    @JsonView(TurmaFormacaoView.Listagem.class)
    private String nome;
    @JsonView(TurmaFormacaoView.Listagem.class)
    private String descricao;
    @JsonView(TurmaFormacaoView.Listagem.class)
    private LocalDateTime dataInicio;
    @JsonView(TurmaFormacaoView.Listagem.class)
    private LocalDateTime dataTermino;
    @JsonView(TurmaFormacaoView.Listagem.class)
    private StatusDTO status;
    private Set<CompetenciaEColaboradorDTO> competenciasEColaboradores = new HashSet<>();
}
