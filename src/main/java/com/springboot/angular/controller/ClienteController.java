package com.springboot.angular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.angular.domain.Cliente;
import com.springboot.angular.service.ClienteService;



@RestController
@RequestMapping(value="/cliente")
public class ClienteController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String Listar() {return "Rest Funcionando";}
	
	@Autowired
	private ClienteService clieserv;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> fin(@PathVariable Integer id) {
		Cliente obj = clieserv.Buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
