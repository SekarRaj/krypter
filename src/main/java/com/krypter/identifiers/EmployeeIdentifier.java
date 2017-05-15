package com.krypter.identifiers;

import java.util.Random;

public class EmployeeIdentifier implements IdentifierGenerator{

	@Override
	public String generateId() {
		return "E" + Math.abs(new Random().nextInt());
	}

}
