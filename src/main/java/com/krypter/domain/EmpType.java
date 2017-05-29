package com.krypter.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FPPET")
public class EmpType {
	@Id
	@Column(name = "S2ID")
	@Basic(optional = false, fetch = FetchType.EAGER)
	private int id;

	@Column(name = "S2EMTY")
	@Basic(optional = false, fetch = FetchType.EAGER)
	private String type;

	@Column(name = "S2BRAT")
	@Basic(optional = false, fetch = FetchType.EAGER)
	private double rate;

	@Column(name = "S2STAT")
	@Basic(optional = false, fetch = FetchType.EAGER)
	private char status;

	public EmpType() {
	}

	public EmpType(String type, double rate, char status) {
		this.type = type;
		this.rate = rate;
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return this.getId() + ", " + this.getType() + ", " + this.getRate() + ", " + this.getStatus();
	}
}
