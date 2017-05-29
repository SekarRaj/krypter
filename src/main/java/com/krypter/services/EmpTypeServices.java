package com.krypter.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krypter.repository.EmpTypeRepository;

@Path("/emptype")
public class EmpTypeServices {

	@GET
	@Path("/")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getEmpTypes() {
		EmpTypeRepository repo = EmpTypeRepository.getInstance();
		// return Response.status(200).entity("Okay i am
		// working").header("Access-Control-Allow-Origin", "*").build();
		return Response.status(200).entity(repo.getEmpTypes()).header("Access-Control-Allow-Origin", "*").build();
	}

}
