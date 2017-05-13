package com.krypter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Employee.getAllEmployees", query = "Select e from Employee e") })
@Table(name = "TBL_EMP_MST")
public class Employee {
	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "dept")
	private String department;

	public Employee() {
	}

	public Employee(String id, String firstName, String lastName, String department) {
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setDepartment(department);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return this.getId() + ", " + this.getFirstName() + ", " + this.getLastName() + ", " + this.getDepartment();
	}
}
