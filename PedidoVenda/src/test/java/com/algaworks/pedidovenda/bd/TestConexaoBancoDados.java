package com.algaworks.pedidovenda.bd;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class TestConexaoBancoDados {

	@Test
	public void conexaoComSucesso() {
		EntityManagerFactory entityManagerFactory = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("PedidoPU");
			
			assertNotNull(entityManagerFactory);
			
			EntityManager entityManager = entityManagerFactory.createEntityManager();

			assertNotNull(entityManager);
			
			assertTrue(entityManager.isOpen());

		} catch (Exception e) {
			fail(e.getMessage());

		} finally {
			entityManagerFactory.close();
		}
	}

}
