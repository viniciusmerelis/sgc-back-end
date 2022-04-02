package com.basis.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

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
}
