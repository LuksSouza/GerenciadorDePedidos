package com.algaworks.pedidovenda.enumeration;

public enum TipoCliente {
	
	FISICA("Pessoa Física"),
	JURIDICA("Pessoa Jurídica");
	
	private String descricao;

	private TipoCliente(String descricao) {
		this.descricao = descricao;		
	}

	public String getDescricao() {
		return descricao;
	}
	
}
