package com.basis.sgc.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
@Embeddable
public class TurmaCompetenciaColaboradorId implements Serializable {
    @Column(name = "turma_id", nullable = false)
    private Integer turmaId;

    @Column(name = "competencia_id", nullable = false)
    private Integer competenciaId;

    @Column(name = "colaborador_id", nullable = false)
    private Integer colaboradorId;
}
