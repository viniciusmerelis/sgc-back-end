package com.basis.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class SenioridadeDTO implements Serializable {
    @NotNull
    private Integer id;
    private String nome;
}
