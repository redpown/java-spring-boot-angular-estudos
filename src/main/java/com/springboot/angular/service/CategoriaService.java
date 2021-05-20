package com.springboot.angular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.angular.domain.Categoria;
import com.springboot.angular.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository catbanco;

	public Categoria Buscar(Integer id) {
		Object obj = catbanco.findById(id);
		return (Categoria) obj;
	}
}
