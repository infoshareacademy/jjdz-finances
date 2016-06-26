package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.entity.AssetEntity;
import com.infoshareacademy.finances.repository.AssetRepository;
import com.infoshareacademy.finances.service.AssetService;
import com.infoshareacademy.finances.service.MainFormInputData;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/showYears")
public class ShowYearsServlet extends HttpServlet {

    @EJB
    AssetService assetService;

    @EJB
    AssetRepository assetRepository;

    @Inject
    MainFormInputData mainFormInputData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String assetCode = req.getParameter("selectAsset");
		mainFormInputData.setAssetCode(assetCode);

		AssetEntity assetEntity = assetRepository.findAssetByCode(assetCode);

		mainFormInputData.setAssetId(assetEntity.getId());
		String assetName = assetEntity.getAsset().getName();
		mainFormInputData.setAssetName(assetName);

        if (assetCode != null) {
            List<String> years = assetService.returnAvailableYears(assetCode);
            req.setAttribute("years", years);
            req.setAttribute("selectAsset", assetName);
        }

        req.getRequestDispatcher("assetYears.jsp").forward(req, resp);
    }
}
