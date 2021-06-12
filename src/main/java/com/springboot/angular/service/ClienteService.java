package com.springboot.angular.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.springboot.angular.DTO.ClienteDTO;
import com.springboot.angular.domain.Cliente;
import com.springboot.angular.repository.ClienteRepository;
import com.springboot.angular.service.exception.IdNaoEncontrado;
import com.springboot.angular.service.exception.NaoPodeDeletarId;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository service;

	public Cliente Buscar(Integer id) {
		
		Optional<Cliente> obj = service.findById(id);
		
		return  obj.orElseThrow(()->new IdNaoEncontrado("Objeto não encontrado id:" + id + " Tipo:" + Cliente.class.getName()));
	}
	
	public Cliente Inserir(Cliente obj) {
		 obj.setId(null);
		 return obj = service.save(obj);
	}
	
	public Cliente Atualizar(Cliente velhoObj) {
		///O METODO SAVE tb faz a atualização
		///se o id for diferente de null
		Cliente novoObj = Buscar(velhoObj.getId());
		atualizarDados(novoObj,velhoObj);
        return  service.save(novoObj);
	}
	
	public List<Cliente> Todos() {
			return (List<Cliente>) service.findAll();
	}
	
	public void Deletar(Integer id) {
		Buscar(id);
		try {
		service.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new NaoPodeDeletarId("Não é possivel excluir um Cliente que possui produtos");
		}
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return service.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO obj) {
		return new Cliente(obj.getId(),obj.getNome(),obj.getEmail(),null,null);
	}
	
	private void atualizarDados(Cliente novoObj,Cliente velhoObj) {
		novoObj.setNome(velhoObj.getNome());
		novoObj.setEmail(velhoObj.getEmail());
	}
}


