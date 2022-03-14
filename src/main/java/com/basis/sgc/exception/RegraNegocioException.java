package com.basis.sgc.exception;

public class RegraNegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RegraNegocioException(String mensagem) {
		super(mensagem);
	}

	public RegraNegocioException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
