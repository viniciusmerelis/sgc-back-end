package com.basis.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompetenciaNivelDto {
    private Integer id;
    private String nome;
    private NivelDto nivel;
}
