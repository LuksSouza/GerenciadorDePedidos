package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.model.Produto;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 8108185350428411119L;

	@Inject
	private EntityManager entityManager;
	
	private Produto produto;
	private List<Categoria> categorias;
	
	@PostConstruct
	public void init() {
		this.produto = new Produto();
	}
	
	public void carregaObjetosDaTela(ComponentSystemEvent event) {
		System.out.println("Inicializando...");
		this.categorias = entityManager.createQuery("from Categoria", Categoria.class).getResultList();
	}
	
	public void salvar() {
		System.out.println("Salvando...");
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

}
