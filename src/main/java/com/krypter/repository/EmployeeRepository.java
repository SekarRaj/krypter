package com.krypter.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.krypter.dal.DataAccessLayer;
import com.krypter.domain.Employee;
import com.krypter.identifiers.EmployeeIdentifier;
import com.krypter.identifiers.IdentifierGenerator;

public class EmployeeRepository {
	private static volatile EmployeeRepository INSTANCE;
	private static Object lock = new Object();

	// @Inject
	private IdentifierGenerator idGenerator;

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

	public String createEmployee(String firstName, String lastName, String dob) {
		em.getTransaction().begin();
		String id = idGenerator.generateId();
		Employee emp = new Employee(id, firstName, lastName, dob);
		em.persist(emp);
		em.getTransaction().commit();
		return emp.getId();
	}

	public boolean editEmployee(Employee emp) {
		em.getTransaction().begin();
		Employee employee = em.find(Employee.class, emp.getId());
		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		employee.setDepartment(emp.getDepartment());
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
//		return em.createQuery("Employee.getAllEmployees", Employee.class).getResultList();
		return em.createQuery("from Employee").getResultList();
	}
}
