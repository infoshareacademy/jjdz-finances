package com.infoshareacademy.finances.reports.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.infoshareacademy.finances.reports.dto.MostSearchedAssetsDTO;
import com.infoshareacademy.finances.reports.entities.Report;
import com.infoshareacademy.finances.reports.entities.ReportName;
import com.infoshareacademy.finances.reports.repository.MainFormInputRepository;
import com.infoshareacademy.finances.reports.repository.ReportsRepository;

@Stateless
public class MostSearchedAssetsReportService {
	private final static Logger LOGGER = LoggerFactory.getLogger(MostSearchedAssetsReportService.class);
	public static final int NUMBER_OF_RETAINED_REPORTS = 10;

	@EJB
	private MainFormInputRepository mainFormInputRepository;

	@EJB
	private ReportsRepository reportsRepository;

	@Schedule(hour = "*", minute = "*/1")
	public void generateReport() {
		LOGGER.info("Generating MostSearchedAssets report.");
		List<MostSearchedAssetsDTO> mostSearchedAssets = mainFormInputRepository.findMostSearchedAssets();
		Gson gson = new Gson();
		Report report = new Report(ReportName.MOST_SEARCHED_ASSETS, gson.toJson(mostSearchedAssets));
		reportsRepository.save(report);
		LOGGER.info("MostSearchedAssets report generated.");
	}

	@Schedule(hour = "*", minute = "*/10")
	public void removeOldReports(){
		LOGGER.info("Removing old reports.");
		Long id = reportsRepository.returnReportMaxId(ReportName.MOST_SEARCHED_ASSETS);
		Long borderId = id - NUMBER_OF_RETAINED_REPORTS;

		int removed = reportsRepository.deleteOldReports(ReportName.MOST_SEARCHED_ASSETS, borderId);

		LOGGER.info("Removed {} reports.", removed);
	}

}
