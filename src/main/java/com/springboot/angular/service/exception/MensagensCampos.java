package com.springboot.angular.service.exception;

import java.io.Serializable;

public class MensagensCampos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String CampoNome;
	
	private String Mensagem;
	
	public MensagensCampos() {
		
	}
	
	public MensagensCampos(String campoNome, String mensagem) {
		super();
		CampoNome = campoNome;
		Mensagem = mensagem;
	}

	public String getCampoNome() {
		return CampoNome;
	}

	public void setCampoNome(String campoNome) {
		CampoNome = campoNome;
	}

	public String getMensagem() {
		return Mensagem;
	}

	public void setMensagem(String mensagem) {
		Mensagem = mensagem;
	}
	
}
