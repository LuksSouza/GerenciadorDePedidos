package com.algaworks.pedidovenda.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.algaworks.pedidovenda.model.Produto;

@ManagedBean
public class PesquisaProdutoBean {

    private List<Produto> produtos;
    private Produto produtoSelecionado;

    @PostConstruct
    private void init() {
	produtos = new ArrayList<Produto>();

	for (int i = 0; i < 20; i++) {
	    this.produtos.add(new Produto(123, "Bala de morango" + i, "Doces", new BigDecimal(1.50), 98));
	}
    }

    public void excluir() {
	this.produtos.remove(this.produtoSelecionado);
	this.produtoSelecionado = null;
    }

    public List<Produto> getProdutos() {
	return produtos;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
	this.produtoSelecionado = produtoSelecionado;
	System.out.println(this.produtoSelecionado.getNome());
    }

}
