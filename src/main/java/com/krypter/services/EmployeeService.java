package com.krypter.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krypter.repository.EmployeeRepository;

@Path("/employee")
public class EmployeeService {

	@GET
	@Path("/{id}")
	@Produces({ MediaType.TEXT_HTML })
	public Response sayDude(@PathParam("id") final String id) {
		EmployeeRepository repo = EmployeeRepository.getInstance();
		return Response.status(200).entity(repo.getEmployee(id)).build();
	}

	@GET
	@Path("/")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getEmployees() {
		EmployeeRepository repo = EmployeeRepository.getInstance();
		System.out.println(repo.getEmployees());
		return Response.status(200).entity("Returning employees").build();
	}
}
