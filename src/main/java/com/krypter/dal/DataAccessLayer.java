package com.krypter.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataAccessLayer {

	private static EntityManager em = null;

	private static Object lock = new Object();

	public static EntityManager getEntityManager() {
		if (null == em) {
			synchronized (lock) {
				if (null == em) {
					EntityManagerFactory emf = Persistence.createEntityManagerFactory("krypter-jpa");
					em = emf.createEntityManager();
				}
			}
		}
		return em;
	}

}
