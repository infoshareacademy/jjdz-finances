package com.infoshareacademy.finances.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infoshareacademy.finances.model.DailyValueEntity;
import com.infoshareacademy.finances.repository.DailyValuesRepository;

@WebServlet("/calculation")
public class CalculationServlet extends HttpServlet {
	private static final long serialVersionUID = -2240869130026946160L;
	private static final Logger LOGGER = LoggerFactory.getLogger(CalculationServlet.class);

	@EJB
	DailyValuesRepository dailyValuesRepository;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LocalDate dateFrom = LocalDate.now().withMonth(5).withYear(2014).withDayOfMonth(1);
		int interval = dateFrom.lengthOfMonth();
		LocalDate dateTo = dateFrom.withDayOfMonth(interval);

		String assetCode = req.getParameter("selectAsset");
		LOGGER.info("Selecting daily values for assetCode: {}", assetCode);

		List<DailyValueEntity> dailyValuesByRange = dailyValuesRepository
				.findDailyValuesByRange(assetCode, dateFrom, dateTo);

		dailyValuesByRange.forEach(f -> LOGGER.info(String.valueOf(f)));

		req.getRequestDispatcher("funds.jsp").forward(req, resp);
	}
}
