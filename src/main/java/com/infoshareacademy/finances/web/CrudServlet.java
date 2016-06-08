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

@WebServlet(name = "CrudServlet", urlPatterns = "/crud")
public class CrudServlet extends HttpServlet {

    @Inject
    private PlanDaoService planDaoService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String asset = request.getParameter("asset");
        String date = request.getParameter("date");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
