package com.infoshareacademy.finances.reports.incommingEvents;

import com.infoshareacademy.finances.reports.entities.PlanCreationDtoLite;
import com.infoshareacademy.finances.reports.repository.PlansRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Stateless
@Path("/plan")
public class PlansEvent {

    @EJB
    PlansRepository plansRepository;

    @Context
    UriInfo uriInfo;

    @POST
    @Path("/create")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createPlan (PlanCreationDtoLite plan) {
        System.out.println("plan = " + plan);
        Long id = plansRepository.save(plan);
        return Response.created(uriInfo.getAbsolutePathBuilder().segment("{id}").build(id)
        ).build();
    }

    @GET
    @Path("/read/{id}")
    public PlanCreationDtoLite readPlan(@PathParam("id") String id) {
        return plansRepository.retrievePlanById(Long.valueOf(id));
    }

}
