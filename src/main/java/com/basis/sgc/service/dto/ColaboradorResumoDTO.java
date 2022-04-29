package com.basis.sgc.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ColaboradorResumoDTO implements Serializable {
    private Integer id;
    private String nome;
    private String sobrenome;
}
