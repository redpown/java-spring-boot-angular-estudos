package com.springboot.angular.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.angular.domain.Pedido;
import com.springboot.angular.repository.PedidoRepository;
import com.springboot.angular.service.exception.IdNaoEncontrado;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository catbanco;

	public Pedido Buscar(Integer id) {
		
		Optional<Pedido> obj = catbanco.findById(id);
		
		return  obj.orElseThrow(()->new IdNaoEncontrado("Objeto não encontrado id:" + id + " Tipo:" + Pedido.class.getName()));
	}
}


