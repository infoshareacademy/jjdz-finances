package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.model.PlanCreationDto;
import com.infoshareacademy.finances.model.UserInfo;
import com.infoshareacademy.finances.repository.PlansRepository;
import com.infoshareacademy.finances.repository.UserInfoRepository;
import com.infoshareacademy.finances.service.PlanDaoService;
import com.infoshareacademy.finances.service.users.UserSessionData;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "PlansListServlet", urlPatterns = "/plansList")
public class PlansListServlet extends HttpServlet {

    @EJB
    PlansRepository plansRepository;

    @EJB
    UserInfoRepository userInfoRepository;

    @Inject
    UserSessionData userSessionData;

    @Inject
    PlanDaoService planDaoService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfo userInfo = userSessionData.getUserInfo();
        Long userId=userInfoRepository.findUserId(userInfo.getMail());
        List<PlanCreationDto> allPlans = plansRepository.findAllPlans(userId);


        request.setAttribute("plans", allPlans);
        request.getRequestDispatcher("plan.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("del");
        if(action.equalsIgnoreCase("del")) {
                planDaoService.delete(Long.valueOf(request.getParameter("id")));

        }

        response.sendRedirect("plan.jsp");

//                getRequestDispatcher("plan.jsp").forward(request, response);

//        switch (action) {
//            case "delete":
//
//                break;
//            case  "edit":
//                planDaoService.
        }
    }

