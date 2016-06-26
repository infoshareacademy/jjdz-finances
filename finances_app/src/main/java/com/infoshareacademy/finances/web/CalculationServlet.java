package com.infoshareacademy.finances.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infoshareacademy.finances.entity.MainFormInput;
import com.infoshareacademy.finances.service.MainFormInputData;
import com.infoshareacademy.finances.service.MainFormInputLogService;
import com.infoshareacademy.finances.service.UserSessionData;

@WebServlet("/calculation")
public class CalculationServlet extends HttpServlet {
	private static final long serialVersionUID = -2240869130026946160L;
	private static final Logger LOGGER = LoggerFactory.getLogger(CalculationServlet.class);

	@EJB
	MainFormInputLogService mainFormInputLogService;

	@Inject
	UserSessionData userSessionData;

	@Inject
	MainFormInputData mainFormInputData;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		mainFormInputData.setMonth(req.getParameter("selectMonth"));

		LOGGER.info("Saving MainFormInput to DB");
		MainFormInput mainFormInput = new MainFormInput(mainFormInputData.getAssetCode(), userSessionData.getUserId(),
				mainFormInputData.getMonth(), mainFormInputData.getYear());
		mainFormInputLogService.logToDB(mainFormInput);

		req.setAttribute("asset", mainFormInputData.getAssetName());
		req.setAttribute("year", mainFormInputData.getYear());
		req.setAttribute("month", mainFormInputData.getMonth());

		req.getRequestDispatcher("result.jsp").forward(req, resp);
	}
}
