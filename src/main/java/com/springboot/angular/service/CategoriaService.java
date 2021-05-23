package com.springboot.angular.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.angular.domain.Categoria;
import com.springboot.angular.repository.CategoriaRepository;
import com.springboot.angular.service.exception.ObjectNotFound;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository catbanco;

	public Categoria Buscar(Integer id) {
		
		Optional<Categoria> obj = catbanco.findById(id);
		
		return  obj.orElseThrow(()->new ObjectNotFound("Objeto não encontrado id:" + id + " Tipo:" + Categoria.class.getName()));
	}
}


