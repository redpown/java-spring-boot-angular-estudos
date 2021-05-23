package com.springboot.angular.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.springboot.angular.domain.Categoria;
import com.springboot.angular.repository.CategoriaRepository;
import com.springboot.angular.service.exception.IdNaoEncontrado;
import com.springboot.angular.service.exception.NaoPodeDeletarId;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository service;

	public Categoria Buscar(Integer id) {
		
		Optional<Categoria> obj = service.findById(id);
		
		return  obj.orElseThrow(()->new IdNaoEncontrado("Objeto não encontrado id:" + id + " Tipo:" + Categoria.class.getName()));
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
	
	public List<Categoria> Todos() {
			return service.findAll();
	}
	
	public void Deletar(Integer id) {
		Buscar(id);
		try {
		service.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new NaoPodeDeletarId("Não é possivel excluir uma categoria que possui produtos");
		}
	}
}


