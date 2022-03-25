package com.basis.sgc.service.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class CompetenciaDtoInput implements Serializable {
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    private Integer categoriaId;
}
