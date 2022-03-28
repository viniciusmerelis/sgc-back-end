package com.basis.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ColaboradorResumoDTO implements Serializable {
    private Integer id;
    private String nome;
    private String sobrenome;
}
