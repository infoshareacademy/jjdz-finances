package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.repository.PlansRepository;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PlansListServlet", urlPatterns = "/plansList")
public class PlansListServlet extends HttpServlet {

    @EJB
    PlansRepository plansRepository;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("plans", plansRepository.findAllPlans());
        getServletContext().getRequestDispatcher("plan.jsp").forward(request, response);
    }
}
