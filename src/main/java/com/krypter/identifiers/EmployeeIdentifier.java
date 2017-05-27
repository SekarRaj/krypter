package com.krypter.identifiers;

import java.util.Random;

public class EmployeeIdentifier implements IdGenerator{

	public String generateId() {
		return "E" + Math.abs(100000 + new Random().nextInt(900000));
	}

}
