package com.krypter.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
public class CustomerService {
	@GET
	@Path("/{id}")
	@Produces({ MediaType.TEXT_HTML })
	public Response getCustomer(@PathParam("id") String id) {
		return Response.status(200).entity("You asked is customer " + id).build();
	}

	@GET
	@Path("/")
	@Produces({ MediaType.TEXT_HTML })
	public Response getCustomers() {
		return Response.status(200).entity("This is all customers list").build();
	}
}
