package com.krypter.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
//@NamedQueries({ @NamedQuery(name = "Employee.getAllEmployees", query = "Select e from Employee e") })
@Table(name = "FPPEM")
public class Employee {
	@Id
	@Basic(optional = false, fetch = FetchType.EAGER)
	@Column(name = "S1EMNO")
	private String id;

	@Column(name = "S1EMNM")
	@Basic(optional = false, fetch = FetchType.EAGER)
	private String name;

	@Column(name = "S1EMTY")
	@Basic(optional = false, fetch = FetchType.EAGER)
	private String type;

	@Column(name = "S1ESSN")
	@Basic(optional = false, fetch = FetchType.EAGER)
	private String ssn;

	public Employee() {
	}

	public Employee(String id, String name, String type, String ssn) {
		this.setId(id);
		this.setName(name);
		this.setType(type);
		this.setSsn(ssn);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return this.getId() + ", " + this.getName() + ", " + this.getType() + ", " + this.getSsn();
	}
}
