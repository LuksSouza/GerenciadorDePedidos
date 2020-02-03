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
	
	//@Test
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
	
	@Test
	public void populaTabelaCategoriaComSubCategoria() {
	    
	    this.produceEntityManager();
	    
	    this.em.getTransaction().begin();
	    
	    //limpa tabelas
	    this.em.createNativeQuery("delete from categoria where categoria_pai_id is not null").executeUpdate();
	    this.em.createNativeQuery("delete from categoria").executeUpdate();
	    
	    //reinicia index da tabela
	    this.em.createNativeQuery("alter table categoria auto_increment = 1").executeUpdate();
	    
	    //insere categorias
	    this.em.createNativeQuery("insert into categoria (descricao) values ('Informática')").executeUpdate();
	    this.em.createNativeQuery("insert into categoria (descricao) values ('Eletrodomésticos')").executeUpdate();
	    this.em.createNativeQuery("insert into categoria (descricao) values ('Móveis')").executeUpdate();
	    
	    //insere subcategorias
	    this.em.createNativeQuery("insert into categoria (descricao, categoria_pai_id) values ('Computadores', 1)").executeUpdate();
	    this.em.createNativeQuery("insert into categoria (descricao, categoria_pai_id) values ('Notebooks', 1)").executeUpdate();
	    this.em.createNativeQuery("insert into categoria (descricao, categoria_pai_id) values ('Tablets', 1)").executeUpdate();
	    this.em.createNativeQuery("insert into categoria (descricao, categoria_pai_id) values ('Monitores', 1)").executeUpdate();
	    this.em.createNativeQuery("insert into categoria (descricao, categoria_pai_id) values ('Impressoras', 1)").executeUpdate();
	    this.em.createNativeQuery("insert into categoria (descricao, categoria_pai_id) values ('Acessórios', 1)").executeUpdate();
	    
	    this.em.createNativeQuery("insert into categoria (descricao, categoria_pai_id) values ('Ar condicionados', 2)").executeUpdate();
	    this.em.createNativeQuery("insert into categoria (descricao, categoria_pai_id) values ('Fogões', 2)").executeUpdate();
	    this.em.createNativeQuery("insert into categoria (descricao, categoria_pai_id) values ('Fornos elétricos', 2)").executeUpdate();
	    this.em.createNativeQuery("insert into categoria (descricao, categoria_pai_id) values ('Microondas', 2)").executeUpdate();
	    this.em.createNativeQuery("insert into categoria (descricao, categoria_pai_id) values ('Refrigeradores', 2)").executeUpdate();
	    
	    this.em.createNativeQuery("insert into categoria (descricao, categoria_pai_id) values ('Cadeiras', 3)").executeUpdate();
	    this.em.createNativeQuery("insert into categoria (descricao, categoria_pai_id) values ('Mesas', 3)").executeUpdate();
	    this.em.createNativeQuery("insert into categoria (descricao, categoria_pai_id) values ('Racks', 3)").executeUpdate();
	    this.em.createNativeQuery("insert into categoria (descricao, categoria_pai_id) values ('Sofás', 3)").executeUpdate();
	    
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
