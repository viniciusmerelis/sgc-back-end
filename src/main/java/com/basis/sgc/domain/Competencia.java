package com.basis.sgc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "competencia")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Competencia implements Serializable {

	@Id
	@SequenceGenerator(name = "seq_id_competencia", sequenceName = "seq_id_competencia", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_competencia")
	@Column(nullable = false)
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categoria;
}
