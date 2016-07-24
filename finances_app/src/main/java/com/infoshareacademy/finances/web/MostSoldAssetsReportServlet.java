package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.model.dto.AssetsSumDTO;
import com.infoshareacademy.finances.service.rest.ReportMaxSellClient;
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

@WebServlet("/maxSoldReport")
public class MostSoldAssetsReportServlet extends HttpServlet{
    private static final Logger LOGGER = LoggerFactory.getLogger(MostSoldAssetsReportServlet.class);

    @EJB
    private ReportMaxSellClient reportMaxSellClient;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        LOGGER.info("Servlet /maxSoldReport started.");


        List<AssetsSumDTO> mostSoldAssetsDTOs = reportMaxSellClient.returnMostOftenSoldAssets();
        mostSoldAssetsDTOs.stream().forEach(s -> LOGGER.info(String.valueOf(s)));

        req.setAttribute("mostSoldAssets",mostSoldAssetsDTOs);
        LOGGER.info("Servlet /maxSoldReport is over. ");
        req.getRequestDispatcher("mostSoldAssetsReport.jsp").forward(req, resp);
    }



}
