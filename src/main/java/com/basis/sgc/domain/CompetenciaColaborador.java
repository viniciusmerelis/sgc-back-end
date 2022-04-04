package com.basis.sgc.domain;

import com.basis.sgc.domain.enums.Nivel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "competencia_colaborador")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetenciaColaborador implements Serializable {
    @EmbeddedId
    private CompetenciaColaboradorId id;

//    @MapsId("competenciaId")
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "competencia_id", referencedColumnName = "id", insertable = false, updatable = false)
//    private Competencia competencia;
//
//    @MapsId("colaboradorId")
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "colaborador_id", referencedColumnName = "id", insertable = false, updatable = false)
//    private Colaborador colaborador;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "nivel")
    private Nivel nivel;
}
