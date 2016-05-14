package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.service.PlanDaoBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PlanServlet", urlPatterns = "/planServlet")
public class PlanServlet extends HttpServlet {

    @EJB
    PlanDaoBean planDaoBean;

    @EJB
    WelcomeFinances assets;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
