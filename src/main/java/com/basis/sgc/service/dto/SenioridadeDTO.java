package com.basis.sgc.service.dto;

import com.basis.sgc.view.ColaboradorView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class SenioridadeDTO implements Serializable {
    @NotNull
    private Integer id;
    @JsonView(ColaboradorView.Listagem.class)
    private String nome;
}
