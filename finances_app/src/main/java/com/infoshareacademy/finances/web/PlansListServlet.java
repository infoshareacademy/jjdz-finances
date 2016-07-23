package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.model.dto.LstList;
import com.infoshareacademy.finances.entity.PlanCreationDto;
import com.infoshareacademy.finances.entity.UserInfo;
import com.infoshareacademy.finances.repository.PlansRepository;
import com.infoshareacademy.finances.repository.UserInfoRepository;
import com.infoshareacademy.finances.service.AssetService;
import com.infoshareacademy.finances.service.PlanDaoService;
import com.infoshareacademy.finances.service.UserSessionData;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserInfo userInfo = userSessionData.getUserInfo();
        Long userId=userInfoRepository.findUserId(userInfo.getMail());

        List<PlanCreationDto> allPlans = plansRepository.findAllPlans(userId);
        List<LstList> fundList = assetService.returnAllFunds();

        String token = UUID.randomUUID().toString().toUpperCase();
        userSessionData.setCsrf(token);

        request.setAttribute("token", token);
        request.setAttribute("fundList", fundList);
        request.setAttribute("plans", allPlans);

        request.getRequestDispatcher("plan.jsp").forward(request, response);
    }

}


