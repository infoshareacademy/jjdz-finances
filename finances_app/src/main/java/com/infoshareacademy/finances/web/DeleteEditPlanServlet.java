package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.entity.PlanCreationDto;
import com.infoshareacademy.finances.service.PlanDaoService;
import com.infoshareacademy.finances.service.UserSessionData;
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

@WebServlet(name = "DeleteEditPlan", urlPatterns = "/deleteEdit")
public class DeleteEditPlanServlet extends HttpServlet {

    @EJB
    private PlanDaoService planDaoService;

    @Inject
    UserSessionData userSessionData;

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteEditPlanServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean validToken = request.getParameter("token").equals(userSessionData.getCsrf());
        String action = request.getParameter("btnaction");
        String[] actions = action.split("-");
        LOGGER.info("^^^^^^^^^^^^^^^^^^^^^^^^   token in Session: {}", userSessionData.getCsrf());
        LOGGER.info("^^^^^^^^^^^^^^^^^^^^^^^^   token from form: {}", request.getParameter("token"));
        if ("edit".equals(actions[1])) {

            request.setAttribute("PlanId", actions[0]);
            LOGGER.info("############### plan id from jsp:{}", actions[0]);
            LOGGER.info("############### plan id glued tp request:{}", request.getAttribute("PlanId"));
            PlanCreationDto planCreationDto = planDaoService.find(Long.parseLong(actions[0]));

            request.setAttribute("planCreationDto", planCreationDto);
            request.setAttribute("planId", planCreationDto.getId());
            request.setAttribute("name", planCreationDto.getAssetEntity().getAsset().getName());
            request.setAttribute("code", planCreationDto.getAssetEntity().getAsset().getCode());
            request.setAttribute("actionType", planCreationDto.getPlanActionType().toString());
            LOGGER.info("@@@@@@@@@@@@@ Action type: {}", request.getAttribute("actionType"));
            request.setAttribute("date", planCreationDto.getActionTime());
            LOGGER.info("@@@@@@@@@@@@@ Date looks like this: {}", request.getAttribute("date"));
            request.getRequestDispatcher("/crudServlet").forward(request, response);

        } else if ("delete".equals(actions[1]) && validToken) {
            Long id = Long.parseLong(actions[0]);
            planDaoService.delete(id);
            response.sendRedirect("/plansList");
        } else if (!validToken) {
//            String message = "CSRF attack recognized!";
//            request.getSession().setAttribute("message", message);
            response.sendRedirect("/plansList");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
