package com.basis.sgc.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CompetenciaColaboradorId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "competencia_id", nullable = false)
    private Integer competenciaId;

    @Column(name = "colaborador_id", nullable = false)
    private Integer colaboradorId;
}
