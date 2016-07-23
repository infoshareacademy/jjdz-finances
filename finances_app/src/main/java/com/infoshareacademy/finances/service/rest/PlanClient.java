package com.infoshareacademy.finances.service.rest;

import javax.ejb.Stateless;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.infoshareacademy.finances.service.HostnameDetector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infoshareacademy.finances.model.rest.PlanCreationDtoLite;

@Stateless
public class PlanClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(PlanClient.class);

	public void createRemotePlan(PlanCreationDtoLite plan){

		String reportServerURL = new HostnameDetector().getReportServerURL();
		System.out.println("ReportsServerURL: " + reportServerURL);

		LOGGER.info("Creating remote plan: {}", plan);

		Response resp = ClientBuilder.newClient()
				.register(new EntityLoggingFilter())
				.target(reportServerURL + "/api/plan/create")
				.request()
				.post(Entity.entity(plan, MediaType.APPLICATION_JSON_TYPE));

		LOGGER.info("Status of the remote plan creating: {}", resp.getStatus());
	}
}
