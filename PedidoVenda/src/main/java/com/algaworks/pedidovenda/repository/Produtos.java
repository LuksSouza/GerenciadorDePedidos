package com.algaworks.pedidovenda.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.filter.ProdutoFilter;

public class Produtos {

	@Inject
	private EntityManager manager;

	public Produto guardar(Produto produto) {
		return manager.merge(produto);
	}

	public Produto porSKU(String sku) {

		try {
			return manager.createQuery("from Produto where sku = :sku", Produto.class)
					.setParameter("sku", sku)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Produto> filtrados(ProdutoFilter filtro) {
		
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Produto.class);
		
		if (true) {
			criteria.add(Restrictions.eq("sku", filtro.getSku()));
		}
		
		if (true) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome()));
		}
		
		return criteria.list();
	}

}