package com.basis.sgc.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "turma_competencia_colaborador")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class TurmaCompetenciaColaborador implements Serializable {
    @EmbeddedId
    private TurmaCompetenciaColaboradorId id;

    @MapsId("turmaId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "turma_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TurmaFormacao turma;

    @MapsId("competenciaId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "competencia_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Competencia competencia;

    @MapsId("colaboradorId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "colaborador_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Colaborador colaborador;
}
