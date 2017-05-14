package com.krypter.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class DataAccessLayer {

	@PersistenceContext
	private static EntityManager em;

	public static EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("krypter-jpa");
		em = emf.createEntityManager();
		return em;
	}

}	
