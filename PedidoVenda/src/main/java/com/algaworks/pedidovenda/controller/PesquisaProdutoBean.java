package com.algaworks.pedidovenda.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.Produtos;
import com.algaworks.pedidovenda.repository.filter.ProdutoFilter;

@ManagedBean
public class PesquisaProdutoBean {

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
