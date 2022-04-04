package com.basis.sgc.service.dto;

import com.basis.sgc.domain.enums.Nivel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetenciaDoColaboradorDTO implements Serializable {
    private Integer id;
    private String nome;
    private Nivel nivel;
}
