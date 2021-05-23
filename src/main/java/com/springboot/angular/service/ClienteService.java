package com.springboot.angular.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.angular.domain.Cliente;
import com.springboot.angular.repository.ClienteRepository;
import com.springboot.angular.service.exception.IdNaoEncontrado;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository cliebanco;

	public Cliente Buscar(Integer id) {
		
		Optional<Cliente> obj = cliebanco.findById(id);
		
		return  obj.orElseThrow(()->new IdNaoEncontrado("Objeto não encontrado id:" + id + " Tipo:" + Cliente.class.getName()));
	}
}


