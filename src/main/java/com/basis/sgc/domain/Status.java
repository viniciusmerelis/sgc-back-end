package com.basis.sgc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "status")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Status {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(nullable = false)
	private Integer id;
	
	@Column(nullable = false)
	private String nome;

}
