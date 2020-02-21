package com.algaworks.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.repository.Usuarios;

public class CadastroUsuarioService implements Serializable {

    private static final long serialVersionUID = -3993969104346051565L;

    @Inject
    private Usuarios usuarios;

    public void salvar(Usuario usuario) {
	
	if (usuario.getId() == null && this.usuarios.porEmail(usuario.getEmail()) != null) {
	    throw new NegocioException("E-mail já cadastrado!");
	}
	
	if (usuario.getId() != null) {
	    usuario.setSenha(this.usuarios.buscarSenha(usuario.getId()));
	}
	
	this.usuarios.guardar(usuario);
    }   
    
}
