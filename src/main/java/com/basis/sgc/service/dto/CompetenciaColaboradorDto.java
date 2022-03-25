package com.basis.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CompetenciaColaboradorDto implements Serializable {
    private CompetenciaResumoDto competencia;
    private ColaboradorResumoDto colaborador;
}
