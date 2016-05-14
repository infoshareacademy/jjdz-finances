package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.service.PlanDaoBean;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
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
    mainFinances assets;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "fundsSelected":
                    fundsSelected(request, response);
                    break;
                case "currenciesSelected":
                    currenciesSelected(request, response);
                    break;
            }
        } else {
            refresh(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    private void refresh(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("plan.jsp");
        dispatcher.forward(request, response);
    }



    private void fundsSelected(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

//        req.setAttribute("action", "fundsSelected");
//        req.setAttribute("fund", "AGI001");
//        String nextJSP = "/jsp/funds.jsp";
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
//        dispatcher.forward(req, resp);
    }

    private void currenciesSelected(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

//        req.setAttribute("action", "currenciesSelected");
//        req.setAttribute("currencies", "EUR");
//        String nextJSP = "/jsp/currencies.jsp";
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
//        dispatcher.forward(req, resp);
    }
}