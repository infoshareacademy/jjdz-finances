package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.service.PlanDaoService;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("btnaction");
        String[] actions = action.split("-");
        if ("edit".equals(actions[1])) {

            response.sendRedirect("/createEdit");

        } else if ("delete".equals(actions[1])) {
            Long id = Long.parseLong(actions[0]);
            planDaoService.delete(id);
            response.sendRedirect("/plansList");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
