package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.repository.Usuarios;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaUsuarioBean implements Serializable {

    private static final long serialVersionUID = -9078125601681006120L;
    
    private String nomeBuscado;
    private Usuario usuarioSelecionado;
    private List<Usuario> usuarioList;
    
    @Inject
    private Usuarios usuarios;

    public PesquisaUsuarioBean() {
	this.usuarioList = new ArrayList<Usuario>();
	this.nomeBuscado = "";
    }
    
    public void pesquisar() {
	this.usuarioList = this.usuarios.comNomeLike(this.nomeBuscado);
    }
    
    public void excluir() {
	try {
	    this.usuarios.remover(this.usuarioSelecionado);
	} catch (Exception e) {
	    FacesUtil.addErrorMessage(e.getMessage());
	    return;
	}
	
	this.usuarioList.remove(this.usuarioSelecionado);
	this.usuarioSelecionado = null;
    }
    
    public String getNomeBuscado() {
        return nomeBuscado;
    }

    public void setNomeBuscado(String nomeBuscado) {
        this.nomeBuscado = nomeBuscado;
    }

    public List<Usuario> getUsuarioList() {
	return this.usuarioList;
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }

}