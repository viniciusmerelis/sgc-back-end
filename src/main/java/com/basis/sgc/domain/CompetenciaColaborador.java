package com.basis.sgc.domain;

import com.basis.sgc.domain.enums.Nivel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
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

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "nivel")
    private Nivel nivel;
}
