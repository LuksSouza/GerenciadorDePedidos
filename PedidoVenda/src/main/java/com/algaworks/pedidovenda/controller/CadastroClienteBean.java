package com.algaworks.pedidovenda.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.Endereco;
import com.algaworks.pedidovenda.model.enumeration.TipoPessoa;
import com.algaworks.pedidovenda.service.NegocioException;

@ManagedBean
public class CadastroClienteBean {

	private Cliente cliente;
	private Endereco endereco;

	@PostConstruct
	public void init() {
		this.endereco = new Endereco(1l, "Logradouro de teste", 999l, "Complemento teste", "12322430", "Sao Paulo",
				"Sao Paulo");
		this.cliente = new Cliente(1l, "Teste 1", "teste@teste.com", "3904879685799999", TipoPessoa.FISICA);
		this.cliente.addEndereco(endereco);
	}

	public void salvar() {
		throw new NegocioException("Método salvar ainda não foi implementado!");
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
