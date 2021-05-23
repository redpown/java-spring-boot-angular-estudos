package com.springboot.angular.service.exception;

public class NaoPodeDeletarId extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public NaoPodeDeletarId(String msg) {
		super(msg);
	}
	public NaoPodeDeletarId(String msg, Throwable cause) {
		super(msg,cause);
	}
}


