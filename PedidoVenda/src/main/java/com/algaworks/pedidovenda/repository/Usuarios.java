package com.algaworks.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.service.NegocioException;
import com.algaworks.pedidovenda.util.jpa.Transactional;

public class Usuarios implements Serializable {

    private static final long serialVersionUID = -8083220090054738364L;
    
    @Inject
    private EntityManager manager;

    @Transactional
    public void guardar(Usuario usuario) throws EntityExistsException, IllegalArgumentException, TransactionRequiredException {
	this.manager.merge(usuario);
    }

    public List<Usuario> comNomeLike(String nomeBuscado) {
	StringBuilder param = new StringBuilder();
	param.append("%");
	param.append(nomeBuscado);
	param.append("%");
	
	return this.manager.createQuery("from Usuario u where u.nome like :nome", Usuario.class)
		.setParameter("nome", param.toString())
		.getResultList();
    }

    @Transactional
    public void remover(Usuario usuarioSelecionado) {
	try {
	    usuarioSelecionado = this.porId(usuarioSelecionado.getId()); 
	    manager.remove(usuarioSelecionado);
	    manager.flush();
	} catch(PersistenceException e) {
	    throw new NegocioException("Usuario não pode ser excluído.");
	}
    }

    public Usuario porId(Long id) {
	return this.manager.find(Usuario.class, id);
    }

    public String buscarSenha(Long id) {
	return this.porId(id).getSenha();
    }

    public Usuario porEmail(String email) {
	try {
	    return this.manager.createQuery("from Usuario where email = :email", Usuario.class)
		    .setParameter("email", email)
		    .getSingleResult();
	} catch (NoResultException e) {
	    return null;
	}
    }    

}