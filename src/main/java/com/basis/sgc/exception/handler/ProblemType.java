package com.basis.sgc.exception.handler;

import lombok.Getter;

@Getter
public enum ProblemType {
    ERRO_NEGOCIO("/erro-negocio", "Erro de negócio"),
    ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada", "Entidade não encontrada"),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entidade não encontrada"),
    DADOS_INVALIDOS("/dados-invalidos", "Dados invalidos");

    private String uri;
    private String title;

    ProblemType(String uri, String title) {
        this.uri = "http://basis.com" + uri;
        this.title = title;
    }
}
