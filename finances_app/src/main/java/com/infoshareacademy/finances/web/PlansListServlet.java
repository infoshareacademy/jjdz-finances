package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.model.dto.LstList;
import com.infoshareacademy.finances.entity.PlanCreationDto;
import com.infoshareacademy.finances.entity.UserInfo;
import com.infoshareacademy.finances.repository.PlansRepository;
import com.infoshareacademy.finances.repository.UserInfoRepository;
import com.infoshareacademy.finances.service.AssetService;
import com.infoshareacademy.finances.service.PlanDaoService;
import com.infoshareacademy.finances.service.UserSessionData;
import com.infoshareacademy.finances.service.calculation.DateCompare;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@WebServlet(name = "PlansListServlet", urlPatterns = "/plansList")
public class PlansListServlet extends HttpServlet {

    @EJB
    PlansRepository plansRepository;

    @EJB
    UserInfoRepository userInfoRepository;

    @Inject
    UserSessionData userSessionData;

    @EJB
    PlanDaoService planDaoService;

    @EJB
    AssetService assetService;

    @EJB
    DateCompare dateCompare;

    private static final Logger LOGGER = LoggerFactory.getLogger(PlansListServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserInfo userInfo = userSessionData.getUserInfo();
        Long userId=userInfoRepository.findUserId(userInfo.getMail());

        List<PlanCreationDto> allPlans = plansRepository.findAllPlans(userId);
        List<LstList> fundList = assetService.returnAllFunds();

        List<String> expiredPlans = allPlans.stream()
                .filter(plan -> dateCompare.timeOut(plan.getActionTime()) == -1)
                .map(PlanCreationDto::getId)
                .map(id -> id.toString())
                .collect(Collectors.toList());

        LOGGER.info("###### Expired Plans ids: {}", expiredPlans);

        String token = UUID.randomUUID().toString().toUpperCase();
        userSessionData.setCsrf(token);

        request.setAttribute("token", token);
        request.setAttribute("fundList", fundList);
        request.setAttribute("expiredPlans", expiredPlans);
        request.setAttribute("plans", allPlans);

        request.getRequestDispatcher("plan.jsp").forward(request, response);
    }

}


