package com.basis.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CompetenciaColaboradorNivelMaximoDto implements Serializable {
    private CompetenciaResumoDto competencia;
    private List<ColaboradorResumoDto> colaboradores = new ArrayList<>();
}
