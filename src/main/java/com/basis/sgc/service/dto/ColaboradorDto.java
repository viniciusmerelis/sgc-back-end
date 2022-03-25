package com.basis.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ColaboradorDto implements Serializable {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private LocalDateTime dataNascimento;
    private LocalDateTime dataAdmissao;
    private SenioridadeDto senioridade;
    private Set<CompetenciaNivelDto> competencias = new HashSet<>();
}
