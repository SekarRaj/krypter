package com.krypter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employee")
public class EmployeeCrudService {
	@GET
	@Path("/{name}")
	@Produces({ MediaType.TEXT_HTML })
	public Response sayDude(@PathParam("name") final String name) {
		return Response.status(200).entity("You sent " + name).build();
	}

	@GET
	@Path("/")
	@Produces({ MediaType.TEXT_HTML })
	public Response sayHello() {
		return Response.status(200).entity("This is just a string").build();
	}
}
