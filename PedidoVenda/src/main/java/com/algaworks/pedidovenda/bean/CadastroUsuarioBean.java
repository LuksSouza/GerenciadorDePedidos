package com.algaworks.pedidovenda.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.algaworks.pedidovenda.enumeration.TipoPessoa;
import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.Endereco;
import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.service.NegocioException;

@ManagedBean
public class CadastroUsuarioBean {

    private Usuario usuario;

    @PostConstruct
    public void init() {
	this.usuario = new Usuario();
    }

    public void salvar() {}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
