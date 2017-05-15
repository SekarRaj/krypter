package com.krypter.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("ap")
public class AccountsPayableService {
	@GET
	@Path("/{id}")
	@Produces({ MediaType.TEXT_HTML })
	public Response getReceivable(@PathParam("id") final String id) {
		return Response.status(200).entity("Listing payable id " + id).build();
	}

	@GET
	@Path("/")
	@Produces({ MediaType.TEXT_HTML })
	public Response getReceivables() {
		return Response.status(200).entity("Listing all payables.").build();
	}
}