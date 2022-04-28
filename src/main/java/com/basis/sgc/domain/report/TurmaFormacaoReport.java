package com.basis.sgc.domain.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class TurmaFormacaoReport {
    private String nome;
    private String descricao;
    private Date dataInicio;
    private Date dataTermino;
}
