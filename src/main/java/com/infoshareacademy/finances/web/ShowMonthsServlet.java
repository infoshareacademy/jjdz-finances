package com.infoshareacademy.finances.web;

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

@WebServlet("/showMonths")
public class ShowMonthsServlet extends HttpServlet {

    @EJB
    AssetService assetService;

    @EJB
    AssetRepository assetRepository;

    @Inject
    MainFormInputData mainFormInputData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Long assetId = mainFormInputData.getAssetId();

        String year = req.getParameter("year");
        System.out.println("1" + year);
        mainFormInputData.setYear(year);

        System.out.println(year);

        List<String> months = assetService.returnAvailableMonths(assetId);

        req.setAttribute("selectAsset", mainFormInputData.getAssetCode());
        req.setAttribute("year", year);
        req.setAttribute("months", months);

        req.getRequestDispatcher("assetMonths.jsp").forward(req, resp);
    }
}


