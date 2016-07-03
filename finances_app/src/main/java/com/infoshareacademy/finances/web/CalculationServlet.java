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
import com.infoshareacademy.finances.service.MainFormInputService;
import com.infoshareacademy.finances.service.UserSessionData;
import com.infoshareacademy.finances.service.rest.MainFormInputClient;

@WebServlet("/calculation")
public class CalculationServlet extends HttpServlet {
	private static final long serialVersionUID = -2240869130026946160L;
	private static final Logger LOGGER = LoggerFactory.getLogger(CalculationServlet.class);

	@EJB
	MainFormInputService mainFormInputService;

	@EJB
	MainFormInputClient mainFormInputClient;

	@Inject
	UserSessionData userSessionData;

	@Inject
	MainFormInputData mainFormInputData;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		mainFormInputData.setMonth(req.getParameter("selectMonth"));

		String assetName = mainFormInputData.getAssetName();
		String year = mainFormInputData.getYear();
		String month = mainFormInputData.getMonth();
		String assetCode = mainFormInputData.getAssetCode();
		Long userId = userSessionData.getUserId();
		MainFormInput mainFormInput = new MainFormInput(assetCode, assetName, userId, month, year);

		LOGGER.info("Saving MainFormInput to DB");
		mainFormInputService.logToDB(mainFormInput);
		mainFormInputClient.createRemoteClient(mainFormInput);

		req.setAttribute("asset", assetName);
		req.setAttribute("year", year);
		req.setAttribute("month", month);

		req.getRequestDispatcher("result.jsp").forward(req, resp);
	}
}
