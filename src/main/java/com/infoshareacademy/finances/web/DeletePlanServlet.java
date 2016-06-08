package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.service.PlanDaoService;

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

    @Inject
    private PlanDaoService planDaoService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        planDaoService.delete(id);
        response.sendRedirect("plan.jsp");
//        response.sendRedirect(request.getContextPath());
//        request.getRequestDispatcher("plan.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
