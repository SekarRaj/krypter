package com.krypter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/employee")
public class EmployeeCrudService {
	@GET
	@Produces({ MediaType.TEXT_HTML })
	public String sayHello() {
		return "Hello world!!!";
	}
}
