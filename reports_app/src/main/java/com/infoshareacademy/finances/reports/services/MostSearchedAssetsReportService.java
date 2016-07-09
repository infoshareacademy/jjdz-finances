package com.infoshareacademy.finances.reports.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.json.Json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.infoshareacademy.finances.reports.dto.MostSearchedAssetsDTO;
import com.infoshareacademy.finances.reports.repository.MainFormInputRepository;

@Stateless
public class MostSearchedAssetsReportService {
	private final static Logger LOGGER = LoggerFactory.getLogger(MostSearchedAssetsReportService.class);

	@EJB
	private MainFormInputRepository mainFormInputRepository;

	@Schedule(hour = "*", minute = "*/15")
	public String generateReport(){
		List<MostSearchedAssetsDTO> mostSearchedAssets = mainFormInputRepository.findMostSearchedAssets();
		Gson gson = new Gson();
		System.out.println(gson.toJson(mostSearchedAssets));
		return null;
	}

}
