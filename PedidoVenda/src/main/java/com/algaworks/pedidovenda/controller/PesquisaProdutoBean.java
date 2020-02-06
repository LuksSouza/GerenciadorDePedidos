package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.Produtos;
import com.algaworks.pedidovenda.repository.filter.ProdutoFilter;

@Named
@ViewScoped
public class PesquisaProdutoBean implements Serializable {

	private static final long serialVersionUID = 2721925547903851056L;

	@Inject
	private Produtos produtos;

	private ProdutoFilter filtro;
	private List<Produto> produtosFiltrados;
	private Produto produtoSelecionado;

	public PesquisaProdutoBean() {
		this.filtro = new ProdutoFilter();
	}

	public void pesquisar() {
		this.produtosFiltrados = this.produtos.filtrados(filtro);
	}

	public void excluir() {
		this.produtosFiltrados.remove(this.produtoSelecionado);
		this.produtoSelecionado = null;
	}

	public List<Produto> getProdutosFiltrados() {
		return this.produtosFiltrados;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public ProdutoFilter getFiltro() {
		return filtro;
	}

}
