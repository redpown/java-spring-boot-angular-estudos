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
import com.springboot.angular.DTO.NovoClienteDTO;
import com.springboot.angular.domain.Cidade;
import com.springboot.angular.domain.Cliente;
import com.springboot.angular.domain.Endereco;
import com.springboot.angular.domain.enums.TipoCliente;
import com.springboot.angular.repository.ClienteRepository;
import com.springboot.angular.repository.EnderecoRepository;
import com.springboot.angular.service.exception.IdNaoEncontrado;
import com.springboot.angular.service.exception.NaoPodeDeletarId;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository service;
	
	@Autowired
	private EnderecoRepository serviceEnd;

	public Cliente Buscar(Integer id) {
		
		Optional<Cliente> obj = service.findById(id);
		
		return  obj.orElseThrow(()->new IdNaoEncontrado("Objeto não encontrado id:" + id + " Tipo:" + Cliente.class.getName()));
	}
	
	public Cliente Inserir(Cliente obj) {
		 obj.setId(null);
		 obj = service.save(obj);
		 serviceEnd.saveAll(obj.getEnderecos());
		 return obj;
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
	
	public Cliente fromDTO(NovoClienteDTO obj) {
		Cliente clie = new Cliente(null,obj.getNome(),obj.getEmail(),obj.getCpfcnpj(),TipoCliente.toEnum(obj.getTipo()));
		Cidade ciddade = new Cidade(obj.getCidadeId(), null, null);
		Endereco end = new Endereco(
				null,obj.getLogradouro(),obj.getNumero(),obj.getComplemento(),obj.getBairro(),obj.getCep(),clie,ciddade
				);
		clie.getEnderecos().add(end);
		clie.getTelefone().add(obj.getTelefone1());
		if (obj.getTelefone2()!=null) {
			clie.getTelefone().add(obj.getTelefone2());
		}
		if (obj.getTelefone3()!=null) {
			clie.getTelefone().add(obj.getTelefone3());
		}
		return clie;
	}
	
	private void atualizarDados(Cliente novoObj,Cliente velhoObj) {
		novoObj.setNome(velhoObj.getNome());
		novoObj.setEmail(velhoObj.getEmail());
	}
}


