package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Grupo;
import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.service.CadastroUsuarioService;
import com.algaworks.pedidovenda.service.PesquisaGrupoService;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

    private static final long serialVersionUID = -4804413680699631774L;

    @Inject
    private PesquisaGrupoService pesquisaGrupoService;

    @Inject
    private CadastroUsuarioService cadastroUsuarioService;

    private Usuario usuario;
    private Grupo grupoSelecionado;
    private Grupo grupoSelecionadoExcluir;
    private List<Grupo> gruposList;

    public CadastroUsuarioBean() {
	this.usuario = new Usuario();
    }

    public void carregaObjetosDaTela() {
	if (FacesUtil.isNotPostback()) {
	    this.gruposList = this.pesquisaGrupoService.buscarTodos();
	}
    }

    public void adicionaGrupo() {
	this.usuario.adicionaGrupo(grupoSelecionado);
    }

    public void salvar() {
	if (this.usuario.getGrupos().isEmpty()) {
	    FacesUtil.addErrorMessage("Usuario sem grupo selecionado.");
	    return;
	}

	this.cadastroUsuarioService.salvar(this.usuario);

	limpar();

	FacesUtil.addInfoMessage("Usuario salvo com sucesso.");
    }

    public void excluirGrupo() {
	boolean foiExcluido = this.usuario.removerGrupo(this.grupoSelecionadoExcluir);

	if (foiExcluido) {
	    FacesUtil.addErrorMessage("Não foi possível excluir o grupo selecionado.");
	}

	FacesUtil.addInfoMessage("Usuario salvo com sucesso.");
    }

    private void limpar() {
	this.usuario = new Usuario();
	this.grupoSelecionado = null;
    }
    
    public boolean isEditando() {
	return this.usuario != null && this.usuario.getId() != null;
    }

    public Usuario getUsuario() {
	return usuario;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    public List<Grupo> getGrupos() {
	return gruposList;
    }

    public Grupo getGrupoSelecionado() {
	return grupoSelecionado;
    }

    public void setGrupoSelecionado(Grupo grupoSelecionado) {
	this.grupoSelecionado = grupoSelecionado;
    }

    public Grupo getGrupoSelecionadoExcluir() {
	return grupoSelecionadoExcluir;
    }

    public void setGrupoSelecionadoExcluir(Grupo grupoSelecionadoExcluir) {
	this.grupoSelecionadoExcluir = grupoSelecionadoExcluir;
    }

}
