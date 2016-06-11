package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.model.FundStatsDTO;
import com.infoshareacademy.finances.model.UserInfo;
import com.infoshareacademy.finances.repository.StatisticsRepository;
import com.infoshareacademy.finances.repository.UserInfoRepository;
import com.infoshareacademy.finances.service.users.UserSessionData;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/showStatistics")
public class StatisticsServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsServlet.class);
    private static final long serialVersionUID = 1L;

    @EJB
    StatisticsRepository statisticsRepository;

    @EJB
    UserInfoRepository userInfoRepository;

    @Inject
    UserSessionData userSessionData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Servlet /showStatistics started. ");
        //user
        UserInfo userInfo = userSessionData.getUserInfo();
        Long userId=userInfoRepository.findUserId(userInfo.getMail());


        List<FundStatsDTO> buyMax = statisticsRepository.findMaxPurchasingFunds();
        LOGGER.info("Size of buyMax list: {}.", buyMax.size());
        buyMax.stream().forEach(s -> LOGGER.info(String.valueOf(s)));
        req.setAttribute("buyMax", buyMax);

        List<FundStatsDTO> sellMax = statisticsRepository.findMaxSellingFunds();
        LOGGER.info("Size of sellMax list: {}.", sellMax.size());
        sellMax.stream().forEach(s -> LOGGER.info(String.valueOf(s)));
        req.setAttribute("sellMax", sellMax);

        LOGGER.info("Servlet /showStatistics ended. ");
        req.getRequestDispatcher("statistics.jsp").forward(req, resp);
    }
}