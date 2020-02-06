package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.Categorias;
import com.algaworks.pedidovenda.service.CadastroProdutoService;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

    private static final long serialVersionUID = 8108185350428411119L;

    @Inject
    private Categorias categoriasRepository;

    @Inject
    private CadastroProdutoService cadastroProdutoService;

    private Produto produto;
    private List<Categoria> categorias;
    private Categoria categoriaPai;
    private List<Categoria> subcategorias;

    public CadastroProdutoBean() {
	limpar();
    }

    public void carregaObjetosDaTela(ComponentSystemEvent event) {
	if (FacesUtil.isNotPostback()) {
	    this.categorias = categoriasRepository.raizes();

	    this.carregarSubcategorias();
	}
    }

    public void carregarSubcategorias() {
	this.subcategorias = categoriasRepository.subcategoriasDe(this.categoriaPai);
    }

    public void salvar() {
	cadastroProdutoService.salvar(this.produto);
	limpar();

	FacesUtil.addInfoMessage("Produto salvo com sucesso.");
    }

    private void limpar() {
	this.produto = new Produto();
	this.categoriaPai = null;
	this.subcategorias = new ArrayList<Categoria>();
    }

    public Produto getProduto() {
	return produto;
    }

    public void setProduto(Produto produto) {
	this.produto = produto;

	if (produto != null) {
	    this.categoriaPai = produto.getCategoria().getCategoriaPai();
	}
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

    public List<Categoria> getSubcategorias() {
	return subcategorias;
    }
    
    public boolean isEditando() {
	return this.produto.getId() != null;
    }

}
