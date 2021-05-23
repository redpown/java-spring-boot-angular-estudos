package com.springboot.angular.service.exception;

public class IdNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public IdNaoEncontrado(String msg) {
		super(msg);
	}
	public IdNaoEncontrado(String msg, Throwable cause) {
		super(msg,cause);
	}
}


