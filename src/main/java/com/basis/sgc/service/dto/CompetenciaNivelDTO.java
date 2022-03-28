package com.basis.sgc.service.dto;

import com.basis.sgc.domain.enums.Nivel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CompetenciaNivelDTO implements Serializable {
    private Integer id;
    private String nome;
    private Nivel nivel;
}
