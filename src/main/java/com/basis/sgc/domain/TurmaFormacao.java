package com.basis.sgc.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "turma_formacao")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class TurmaFormacao implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_id_turma_formacao", sequenceName = "seq_id_turma_formacao", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_turma_formacao")
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "data_inicio", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "data_termino", nullable = false)
    private LocalDateTime dataTermino;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TurmaCompetenciaColaborador> competenciasColaboradores = new HashSet<>();
}
