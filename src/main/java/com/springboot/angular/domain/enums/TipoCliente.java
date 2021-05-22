package com.springboot.angular.domain.enums;

public enum TipoCliente {
	PESSOAFISICA(1,"Pessoa Fisíca"),
	PESSOAJURIDICA(2,"Pessoa Jurídica");
	
	private int code;
	private String descricao;
	//contrutor de enum e sempre privado
	private TipoCliente(int code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoCliente x: TipoCliente.values()) {
			if(cod.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
