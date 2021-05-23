package com.springboot.angular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.angular.domain.Pedido;
import com.springboot.angular.service.PedidoService;



@RestController
@RequestMapping(value="/pedido")
public class PedidoController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String Listar() {return "Rest Funcionando";}
	
	@Autowired
	private PedidoService serv;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> fin(@PathVariable Integer id) {
		Pedido obj = serv.Buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
}

