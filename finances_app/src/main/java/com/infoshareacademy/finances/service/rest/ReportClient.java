package com.infoshareacademy.finances.service.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import com.infoshareacademy.finances.service.HostnameDetector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.infoshareacademy.finances.model.dto.MostSearchedAssetsDTO;

@Stateless
public class ReportClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportClient.class);

	public List<MostSearchedAssetsDTO> returnMostSearchedAssets() {
		String reportServerURL = new HostnameDetector().getReportServerURL();
		System.out.println("ReportsServerURL: " + reportServerURL);

		Response response = ClientBuilder.newClient()
				.target(reportServerURL + "/api/report/retrieve/" + ReportName.MOST_SEARCHED_ASSETS).request().get();
		String jsonEntity = response.readEntity(String.class);
		LOGGER.info("{}", jsonEntity);

		Gson gson = new Gson();
		List<MostSearchedAssetsDTO> report = gson.fromJson(jsonEntity, new TypeToken<List<MostSearchedAssetsDTO>>() {
		}.getType());

		return report;
	}
}

