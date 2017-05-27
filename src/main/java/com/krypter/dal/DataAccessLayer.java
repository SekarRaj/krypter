package com.krypter.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataAccessLayer {

	private static EntityManager em;

	public static EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("krypter-jpa");
		em = emf.createEntityManager();
		return em;
	}

}	
