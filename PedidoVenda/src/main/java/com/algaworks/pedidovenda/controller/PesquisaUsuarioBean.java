package com.algaworks.pedidovenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.model.enumeration.GrupoUsuario;

@ManagedBean
public class PesquisaUsuarioBean {

    private List<Usuario> usuarios;
    private List<GrupoUsuario> grupos;

    @PostConstruct
    public void init() {
	this.usuarios = new ArrayList<Usuario>();
	this.grupos = GrupoUsuario.getGrupos();

	Usuario usuario = new Usuario("Teste", "testeUsuario@teste.com.br", "123456");

	for (int i = 0; i < 20; i++) {
	    usuarios.add(usuario);
	}
    }

    public List<Usuario> getUsuarios() {
	return usuarios;
    }

    public List<GrupoUsuario> getGrupos() {
	return grupos;
    }

    public List<GrupoUsuario> getGrupoUsuarioDescricao() {
	return GrupoUsuario.getGrupos();
    }

}
