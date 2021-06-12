package com.springboot.angular.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.springboot.angular.domain.Cliente;
import com.springboot.angular.domain.enums.TipoCliente;

public class ClienteDTO  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message ="Preenchimento Obrigatório")
	@Length(min = 5, max = 120,message="O nome deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@Email(message ="E-mail inválido")
	private String email;
	
    private String cpfcnpj;
	
	private TipoCliente tipo;
	
	public ClienteDTO() {}

	public ClienteDTO(Cliente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.cpfcnpj = obj.getCpfcnpj();
		this.tipo = obj.getTipo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}
	

}
