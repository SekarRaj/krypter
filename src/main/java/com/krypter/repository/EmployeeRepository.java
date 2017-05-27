package com.krypter.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.krypter.dal.DataAccessLayer;
import com.krypter.domain.Employee;
import com.krypter.identifiers.EmployeeIdentifier;
import com.krypter.identifiers.IdGenerator;

public class EmployeeRepository {
	private static volatile EmployeeRepository INSTANCE;
	private static Object lock = new Object();

	private IdGenerator idGenerator;

	@PersistenceContext
	private EntityManager em;
	
	private EmployeeRepository() {
		idGenerator = new EmployeeIdentifier();
		em = DataAccessLayer.getEntityManager();
	}

	public static EmployeeRepository getInstance() {
		if (INSTANCE == null) {
			synchronized (lock) {
				if (INSTANCE == null)
					INSTANCE = new EmployeeRepository();
			}
		}
		return INSTANCE;
	}

	public String createEmployee(String name, String type, String ssn) {
		em.getTransaction().begin();
		String id = idGenerator.generateId();
		System.out.println(id + " generted with length " + id.length());
		
		Employee emp = new Employee(id, name, type, ssn);
		em.persist(emp);
		em.getTransaction().commit();
		return emp.getId();
	}

	public boolean editEmployee(Employee emp) {
		em.getTransaction().begin();
		Employee employee = em.find(Employee.class, emp.getId());
		employee.setName(emp.getName());
		employee.setType(emp.getType());
		employee.setType(emp.getType());
		em.getTransaction().commit();
		return true;
	}

	public boolean deleteEmployee(String empId) {
		em.getTransaction().begin();
		Employee employee = em.find(Employee.class, empId);
		em.remove(employee);
		em.getTransaction().commit();
		return true;
	}

	public Employee getEmployee(String empId) {
		Employee emp = em.find(Employee.class, empId);
		return emp;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees() {
		return em.createQuery("from Employee").getResultList();
	}
}
