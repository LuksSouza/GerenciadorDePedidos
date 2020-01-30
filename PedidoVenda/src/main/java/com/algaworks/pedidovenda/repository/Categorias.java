package com.algaworks.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.pedidovenda.model.Categoria;

public class Categorias implements Serializable {

	private static final long serialVersionUID = -4817098794262396443L;

	@Inject
	private EntityManager entityManager;

	public List<Categoria> raizes() {
		return entityManager.createQuery("from Categoria where categoriaPai is null", Categoria.class).getResultList();
	}

	public Categoria porId(long id) {
		return entityManager.find(Categoria.class, id);
	}

	public List<Categoria> subcategoriasDe(Categoria categoriaPai) {
		return entityManager.createQuery("from Categoria where categoriaPai is :raiz", Categoria.class)
				.setParameter("raiz", categoriaPai)
				.getResultList();
	}

}