package com.basis.sgc.service.dto;

import com.basis.sgc.view.TurmaFormacaoView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StatusDTO implements Serializable {
    private Integer id;
    @JsonView(TurmaFormacaoView.Listagem.class)
    private String nome;
}
