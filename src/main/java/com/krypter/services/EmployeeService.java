package com.krypter.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employee")
public class EmployeeService {
	@GET
	@Path("/{id}")
	@Produces({ MediaType.TEXT_HTML })
	public Response sayDude(@PathParam("id") final String id) {
		return Response.status(200).entity("You sent " + id).build();
	}

	@GET
	@Path("/")
	@Produces({ MediaType.TEXT_HTML })
	public Response sayHello() {
		return Response.status(200).entity("This is just a string").build();
	}
}
