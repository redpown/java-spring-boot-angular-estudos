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
	private CategoriaRepository service;

	public Categoria Buscar(Integer id) {
		
		Optional<Categoria> obj = service.findById(id);
		
		return  obj.orElseThrow(()->new ObjectNotFound("Objeto não encontrado id:" + id + " Tipo:" + Categoria.class.getName()));
	}
	
	public Categoria Inserir(Categoria obj) {
		 obj.setId(null);
		 return obj = service.save(obj);
	}
	
	public Categoria Atualizar(Categoria obj) {
		///O METODO SAVE tb faz a atualização
		///se o id for diferente de null
		 Buscar(obj.getId());
		 
		 return obj = service.save(obj);
	}
}


