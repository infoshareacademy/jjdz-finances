package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.service.PlanDaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteEditPlan", urlPatterns = "/deleteEdit")
public class DeleteEditPlanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private PlanDaoService planDaoService;
    private Logger logger = LoggerFactory.getLogger(DeleteEditPlanServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("btnaction");
        String[] actions = action.split("-");
        if ("edit".equals(actions[1])) {

            request.setAttribute("PlanId", actions[0]);
            logger.info("############### plan id from jsp:{}", actions[0]);
            logger.info("############### plan id glued tp request:{}", request.getAttribute("PlanId"));
            request.getRequestDispatcher("/createEdit").forward(request, response);

        } else if ("delete".equals(actions[1])) {
            Long id = Long.parseLong(actions[0]);
            planDaoService.delete(id);
            response.sendRedirect("/plansList");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
