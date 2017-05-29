package com.krypter.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.krypter.dal.DataAccessLayer;
import com.krypter.domain.EmpType;

public class EmpTypeRepository {
	private static volatile EmpTypeRepository INSTANCE = null;
	private static Object lock = new Object();

	private EntityManager em;

	private static EmpTypeRepository createInstance() {
		return new EmpTypeRepository();
	}

	private EmpTypeRepository() {
		em = DataAccessLayer.getEntityManager();
	}

	public static EmpTypeRepository getInstance() {
		if (INSTANCE == null) {
			synchronized (lock) {
				if (INSTANCE == null) {
					INSTANCE = createInstance();
				}
			}
		}
		System.out.println("Instance has null value " + (INSTANCE == null));
		return INSTANCE;
	}

	@SuppressWarnings("unchecked")
	public List<EmpType> getEmpTypes() {
		return em.createQuery("from EmpType").getResultList();
	}
}
