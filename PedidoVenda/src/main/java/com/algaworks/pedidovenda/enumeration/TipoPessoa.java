package com.algaworks.pedidovenda.enumeration;

public enum TipoPessoa {
	
	FISICA("Pessoa Física"),
	JURIDICA("Pessoa Jurídica");
	
	private String descricao;

	private TipoPessoa(String descricao) {
		this.descricao = descricao;		
	}

	public String getDescricao() {
		return descricao;
	}
	
}
