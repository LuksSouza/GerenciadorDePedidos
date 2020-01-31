package com.algaworks.pedidovenda.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import com.algaworks.pedidovenda.model.Produto;

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

}