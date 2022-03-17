package com.basis.sgc.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "colaborador")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Colaborador implements Serializable {

	@Id
	@SequenceGenerator(name = "seq_id_colaborador", sequenceName = "seq_id_colaborador", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_colaborador")
	@Column(nullable = false)
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String sobrenome;
	
	@Column(nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private String email;
	
	@Column(name = "data_nasc", nullable = false)
	private LocalDateTime dataNascimento;
	
	@Column(name = "data_admi", nullable = false)
	private LocalDateTime dataAdmissao;
	
	@ManyToOne
	@JoinColumn(name = "senioridade_id", nullable = false)
	private Senioridade senioridade;
	
	@OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CompetenciaColaborador> competencias = new HashSet<>();
}
