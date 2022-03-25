package com.basis.sgc.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "status")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Status implements Serializable {
    @EqualsAndHashCode.Include
    @Id
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String nome;
}
