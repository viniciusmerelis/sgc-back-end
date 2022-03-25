package com.basis.sgc.service.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class CompetenciaColaboradorDtoIdInput implements Serializable {
    @NotNull
    private Integer competenciaId;
    @NotNull
    private Integer colaboradorId;
}
