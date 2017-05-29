package com.krypter.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krypter.domain.Employee;
import com.krypter.repository.EmployeeRepository;

@Path("/employee")
public class EmployeeService {

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getEmployee(@PathParam("id") final String id) {
		EmployeeRepository repo = EmployeeRepository.getInstance();
		return Response.status(200).entity(repo.getEmployee(id)).build();
	}

	@GET
	@Path("/")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getEmployees() {
		EmployeeRepository repo = EmployeeRepository.getInstance();
		return Response.status(200).entity(repo.getEmployees()).build();
	}

	@POST
	@Path("/add")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response createEmployee(Employee emp) {
		EmployeeRepository repo = EmployeeRepository.getInstance();
		String id = repo.createEmployee(emp.getName(), emp.getType(), emp.getSsn());
		return Response.status(200).entity(id).build();
	}
}
