package com.infoshareacademy.finances.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infoshareacademy.finances.entity.AssetType;
import com.infoshareacademy.finances.model.dto.LstList;
import com.infoshareacademy.finances.service.AssetService;

@WebServlet("/showAssets")
public class ShowAssetsServlet extends HttpServlet {

	@EJB
	AssetService assetService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AssetType assetType = (AssetType)req.getAttribute("assetType");
		List<LstList> assetList ;

		if (AssetType.FUND.equals(assetType)) {
			assetList = assetService.returnAllFunds();

		} else {
			assetList = assetService.returnAllCurrency();
		}

		req.setAttribute("assetList", assetList);

		req.getRequestDispatcher("assets.jsp").forward(req, resp);
	}
}
