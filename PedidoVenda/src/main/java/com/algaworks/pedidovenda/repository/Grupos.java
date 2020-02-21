package com.algaworks.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.algaworks.pedidovenda.model.Grupo;
import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.filter.ProdutoFilter;
import com.algaworks.pedidovenda.service.NegocioException;
import com.algaworks.pedidovenda.util.jpa.Transactional;

public class Grupos implements Serializable {

    private static final long serialVersionUID = -2870936497678662129L;

    @Inject
    private EntityManager manager;

    public List<Grupo> buscarTodos() {
	try {
	    return manager.createQuery("from Grupo", Grupo.class).getResultList();
	} catch (NoResultException e) {
	    return null;
	}
    }

    public Grupo porId(long id) {
	return manager.find(Grupo.class, id);
    }

}