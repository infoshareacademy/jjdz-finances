package com.infoshareacademy.finances.web;


import com.infoshareacademy.finances.model.dto.AssetsSumDTO;
import com.infoshareacademy.finances.service.rest.ReportMaxBuyClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/maxBuyReport")
public class MostPurchasedAssetsReportServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(MostPurchasedAssetsReportServlet.class);

    @EJB
    private ReportMaxBuyClient reportMaxBuyClient;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        LOGGER.info("Servlet /maxBuyReport started.");


        List<AssetsSumDTO> mostPurchasedAssetsDTOs = reportMaxBuyClient.returnMostOftenPurchasedAssets();
        mostPurchasedAssetsDTOs.stream().forEach(s -> LOGGER.info(String.valueOf(s)));

        req.setAttribute("mostPurchasedAssets",mostPurchasedAssetsDTOs);
        LOGGER.info("Servlet /maxBuyReport is over. ");
        req.getRequestDispatcher("mostPurchasedAssetsReport.jsp").forward(req, resp);
    }


}
