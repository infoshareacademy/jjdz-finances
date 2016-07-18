package com.infoshareacademy.finances.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infoshareacademy.finances.model.dto.MostSearchedAssetsDTO;
import com.infoshareacademy.finances.service.rest.ReportClient;

@WebServlet("/msaReport")
public class MostSearchedAssetsReportServlet extends HttpServlet {

	@EJB
	private ReportClient reportClient;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MostSearchedAssetsDTO> mostSearchedAssetsDTOs = reportClient.returnMostSearchedAssets();
		req.setAttribute("mostSearchedAssets",mostSearchedAssetsDTOs);
		req.getRequestDispatcher("mostSearchedAssetsReport.jsp").forward(req, resp);
	}
}
