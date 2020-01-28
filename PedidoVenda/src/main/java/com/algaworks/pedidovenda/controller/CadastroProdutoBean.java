package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.Categorias;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 8108185350428411119L;

	@Inject
	private Categorias categoriasRepository;

	private Produto produto;
	private List<Categoria> categorias;
	private Categoria categoriaPai;

	@PostConstruct
	public void init() {
		this.produto = new Produto();
	}

	public void carregaObjetosDaTela(ComponentSystemEvent event) {
		System.out.println("Inicializando...");
		this.categorias = categoriasRepository.raizes();
	}

	public void salvar() {
		System.out.println("Recebendo categoria pai: "+this.categoriaPai.getDescricao());
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

	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

}