package com.algaworks.pedidovenda.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.algaworks.pedidovenda.model.Cliente;

@ManagedBean
public class DialogBean {

	private List<Cliente> clientes;
	private Cliente clienteAdicionado;
	
	@PostConstruct
	public void init() {
		this.clienteAdicionado = new Cliente();
		this.clientes = new ArrayList<Cliente>();
		
		this.clientes.add(new Cliente("Teste 1", null, "390487968-57", null));
	}

	public void adicionar() {
		this.clientes.add(this.clienteAdicionado);
		this.clienteAdicionado = new Cliente();
	}
	
	public void excluirCliente() {
		return;
	}
	
	public Cliente getClienteAdicionado() {
		return clienteAdicionado;
	}

	public void setClienteAdicionado(Cliente clienteAdicionado) {
		this.clienteAdicionado = clienteAdicionado;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}
}