package com.basis.sgc.service.dto;

import com.basis.sgc.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StatusDTO implements Serializable {
    private Integer id;
    @JsonView(Views.Listagem.class)
    private String nome;
}
