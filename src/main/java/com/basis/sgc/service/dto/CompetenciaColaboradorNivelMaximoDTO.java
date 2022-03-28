package com.basis.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CompetenciaColaboradorNivelMaximoDTO implements Serializable {
    private CompetenciaResumoDTO competencia;
    private List<ColaboradorResumoDTO> colaboradores = new ArrayList<>();
}
