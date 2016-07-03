package com.infoshareacademy.finances.service.rest;

import javax.ejb.Stateless;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infoshareacademy.finances.entity.MainFormInput;
@Stateless
public class MainFormInputClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(MainFormInputClient.class);

	public void createRemoteClient(MainFormInput formInput) {
		LOGGER.info("Creating remote MainFormInput: {}", formInput);

		Response resp = ClientBuilder.newClient()
				.target("http://localhost:8082/api/mainForm/create")
				.request()
				.post(Entity.entity(formInput, MediaType.APPLICATION_JSON_TYPE));

		LOGGER.info("Status of the remote MainFormInput creating: {}", resp.getStatus());
	}
}
