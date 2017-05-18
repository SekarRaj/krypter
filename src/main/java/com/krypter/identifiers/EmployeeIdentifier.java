package com.krypter.identifiers;

import java.util.Random;

public class EmployeeIdentifier implements IdentifierGenerator{

	public String generateId() {
		return "E" + Math.abs(new Random().nextInt());
	}

}
