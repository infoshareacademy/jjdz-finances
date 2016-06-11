package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.service.PlanDaoService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeletePlanServlet", urlPatterns = "/delete")
public class DeletePlanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private PlanDaoService planDaoService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("btnaction");
        if (action.equalsIgnoreCase("edit")) {

            response.sendRedirect("/createEdit");

        } else {
            Long id = Long.parseLong(request.getParameter("btnaction"));


            planDaoService.delete(id);
            response.sendRedirect("/plansList");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
