package com.algaworks.pedidovenda.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import com.algaworks.pedidovenda.model.Grupo;
import com.algaworks.pedidovenda.repository.Grupos;

public class PesquisaGrupoService implements Serializable {

    private static final long serialVersionUID = -3598840362829796308L;
    
    @Inject
    private Grupos grupos;
    
    public List<Grupo> buscarTodos() {
	try {
	    return grupos.buscarTodos();
	} catch (NoResultException e) {
	    return null;
	}
    }

    public Grupo porId(long id) {
	return grupos.porId(id);
    }

}
