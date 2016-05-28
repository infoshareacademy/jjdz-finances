package com.infoshareacademy.finances.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infoshareacademy.finances.model.LstList;
import com.infoshareacademy.finances.service.AssetService;

@WebServlet("/inputForm")
public class MainFormInputServlet extends HttpServlet {

	@EJB
	AssetService assetService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<LstList> fundList = assetService.returnAllFunds();
		req.setAttribute("fundList", fundList);

		String assetCode = req.getParameter("selectAsset");
		if (assetCode != null){
			List<String> years = assetService.returnAvailableYears(assetCode);
			req.setAttribute("years",years);
		}
		String year = req.getParameter("selectYear");



		req.getRequestDispatcher("funds.jsp").forward(req, resp);
	}
}
