package com.basis.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ColaboradorDTO implements Serializable {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private LocalDateTime dataNascimento;
    private LocalDateTime dataAdmissao;
    private SenioridadeDTO senioridade;
    private Set<CompetenciaNivelDTO> competencias = new HashSet<>();
}
