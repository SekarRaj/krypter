package com.krypter.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("ar")
public class AccountsReceivableService {
	@GET
	@Path("/{id}")
	@Produces({ MediaType.TEXT_HTML })
	public Response getPayable(@PathParam("id") final String id) {
		return Response.status(200).entity("Listing receivable id " + id).build();
	}

	@GET
	@Path("/")
	@Produces({ MediaType.TEXT_HTML })
	public Response getPayables() {
		return Response.status(200).entity("Listing all receivables").build();
	}
}
