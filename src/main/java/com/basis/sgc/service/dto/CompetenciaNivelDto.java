package com.basis.sgc.service.dto;

import com.basis.sgc.domain.Nivel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompetenciaNivelDto {
    private Integer id;
    private String nome;
    private Nivel nivel;
}
