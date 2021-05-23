package com.springboot.angular.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.angular.domain.Categoria;
import com.springboot.angular.service.CategoriaService;



@RestController
@RequestMapping(value="/categoria")
public class CategoriaController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String Listar() {return "Rest Funcionando";}
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		Categoria obj = service.Buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
		
		obj = service.Inserir(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
											 .path("/{id}")
											 .buildAndExpand(obj.getId())
											 .toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value ="/{id}",  method = RequestMethod.PUT)
	public ResponseEntity<Void> Atualizar(@RequestBody Categoria obj , @PathVariable Integer id) {
		obj.setId(id);
		obj = service.Atualizar(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value ="/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<Void> Deletar(@PathVariable Integer id) {

		service.Deletar(id);
		return ResponseEntity.noContent().build();
		
		}
	
}

