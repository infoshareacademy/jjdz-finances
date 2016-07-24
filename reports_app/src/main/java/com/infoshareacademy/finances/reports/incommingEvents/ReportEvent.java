package com.infoshareacademy.finances.reports.incommingEvents;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infoshareacademy.finances.reports.entities.Report;
import com.infoshareacademy.finances.reports.entities.ReportName;
import com.infoshareacademy.finances.reports.repository.ReportsRepository;

@Stateless
@Path("/report")
public class ReportEvent {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportEvent.class);

	@EJB
	ReportsRepository reportsRepository;

	@GET
	@Path("/retrieve/{report}")
	public Response retrieveReport(@PathParam("report") ReportName reportName){
		LOGGER.info("Retrieving report: {}", reportName);
		Long reportId = reportsRepository.returnReportMaxId(reportName);
		LOGGER.debug("Report Max Id: {}", reportId);
		Report report = reportsRepository.returnReport(reportId);

		LOGGER.info("Returning requested report: {}", reportName);
		return Response.ok(report.getReport(), MediaType.TEXT_PLAIN).build();
	}
}
