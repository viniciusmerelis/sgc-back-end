package com.basis.sgc.exception.handler;

import lombok.Getter;

@Getter
public enum ProblemType {
	ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio"),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
	PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido"),
	ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"),
	DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos");

	private String title;
    private String uri;

    ProblemType(String uri, String title) {
        this.uri = "http://basis.com.br" + uri;
        this.title = title;
    }
}
