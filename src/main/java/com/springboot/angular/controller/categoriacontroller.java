package com.springboot.angular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.angular.domain.Categoria;
import com.springboot.angular.service.CategoriaService;



@RestController
@RequestMapping(value="/helloworld")
public class categoriacontroller {
	
	@RequestMapping(method = RequestMethod.GET)
	public String Listar() {return "Rest Funcionando";}
	
	@Autowired
	private CategoriaService catserv;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> fin(@PathVariable Integer id) {
		Categoria obj = catserv.Buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
