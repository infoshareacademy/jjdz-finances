package com.infoshareacademy.finances.web;

import java.io.IOException;
import java.time.LocalDate;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infoshareacademy.finances.repository.DailyValuesRepository;
import com.infoshareacademy.finances.service.MainFormInputData;

@WebServlet("/calculation")
public class CalculationServlet extends HttpServlet {
	private static final long serialVersionUID = -2240869130026946160L;
	private static final Logger LOGGER = LoggerFactory.getLogger(CalculationServlet.class);

	@EJB
	DailyValuesRepository dailyValuesRepository;

	@Inject
	MainFormInputData mainFormInputData;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		mainFormInputData.setMonth(req.getParameter("selectMonth"));

		req.getRequestDispatcher("result.jsp").forward(req, resp);
	}
}
