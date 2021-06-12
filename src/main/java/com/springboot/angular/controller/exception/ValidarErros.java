package com.springboot.angular.controller.exception;

import java.util.ArrayList;
import java.util.List;

import com.springboot.angular.controller.exception.handler.ErroPadrao;
import com.springboot.angular.service.exception.MensagensCampos;

public class ValidarErros extends ErroPadrao {
	
	private static final long serialVersionUID = 1L;
	
	private List<MensagensCampos> Lista = new ArrayList<>();
		
	public ValidarErros(Integer status, String msg, long timestamp) {
		super(status, msg, timestamp);
		
	}
	
	public List<MensagensCampos> getErros() {
		return Lista;
	}

	public void addErros(String campoNome, String mensagem) {
		Lista.add(new MensagensCampos(campoNome, mensagem));
	}

}
