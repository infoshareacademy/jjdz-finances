package com.infoshareacademy.finances.reports.incommingEvents;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.infoshareacademy.finances.reports.entities.MainFormInput;
import com.infoshareacademy.finances.reports.repository.MainFormInputRepository;

@Stateless
@Path("/mainForm")
public class MainFormInputEvent {

	@EJB
	MainFormInputRepository mainFormInputRepository;

	@Context
	UriInfo uriInfo;

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createMainFormInput(MainFormInput formInput) {
		Long id = mainFormInputRepository.save(formInput);

		return Response
				.created(uriInfo.getAbsolutePathBuilder().segment("{id}").build(id))
				.build();
	}

}
