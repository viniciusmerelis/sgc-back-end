package com.basis.sgc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categoria")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Categoria {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(nullable = false)
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
}
