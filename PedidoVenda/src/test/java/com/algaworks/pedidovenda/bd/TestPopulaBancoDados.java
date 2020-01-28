package com.algaworks.pedidovenda.bd;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class TestPopulaBancoDados {
	
	private EntityManager em;
	
	@Test
	public void populaTabelaCategoria() {
		
		this.produceEntityManager();
		
		this.em.getTransaction().begin();
		
		this.em.createNativeQuery("insert into categoria (descricao) values('Computadores')").executeUpdate();
		this.em.createNativeQuery("insert into categoria (descricao) values('Notebooks')").executeUpdate();
		this.em.createNativeQuery("insert into categoria (descricao) values('Tablets')").executeUpdate();
		this.em.createNativeQuery("insert into categoria (descricao) values('Monitores')").executeUpdate();
		this.em.createNativeQuery("insert into categoria (descricao) values('Impressoras')").executeUpdate();
		this.em.createNativeQuery("insert into categoria (descricao) values('Acessorios')").executeUpdate();
		
		this.em.getTransaction().commit();
		
		this.em.close();
	}
	
	private void produceEntityManager() {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;

		if (this.em != null) return;
		
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("PedidoPU");

			assertNotNull(entityManagerFactory);

			entityManager = entityManagerFactory.createEntityManager();

			assertNotNull(entityManager);

			assertTrue(entityManager.isOpen());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		this.em = entityManager;
	}

}
