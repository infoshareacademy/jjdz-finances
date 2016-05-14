package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.model.LstList;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@WebServlet(urlPatterns = "/main")
public class mainFinacesServlet extends HttpServlet {

@EJB
mainFinances Funds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println("main.jsp: " + action);

        if (action != null) {
            System.out.println("main.jsp: " + action);
            switch (action) {
                case "forwardFundsMain":
                    forwardFundsMain(req, resp);
                    break;
                case "fundsSelected":
                    fundsSelected(req, resp);
                    break;
                case "currenciesSelected":
                    currenciesSelected(req, resp);
                    break;
                case "adminSelected":
                    adminSelected(req, resp);
                    break;
                case "loginSelected":
                    loginSelected(req, resp);
                    break;
            }
        } else {
            forwardMain(req, resp);
        }
    }

    private void forwardMain(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nextJSP = "/jsp/main.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

    private void forwardFundsMain(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<LstList> fundList = Funds.getAllFunds();

        String nextJSP = "/jsp/funds.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("fundList", fundList);
        dispatcher.forward(req, resp);
    }

    private void fundsSelected(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("action", "fundsSelected");
        req.setAttribute("fund", "AGI001");
        String nextJSP = "/jsp/funds.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

    private void currenciesSelected(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("action", "currenciesSelected");
        req.setAttribute("currencies", "EUR");
        String nextJSP = "/jsp/currencies.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

    private void adminSelected(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nextJSP = "/jsp/admin.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

    private void loginSelected(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nextJSP = "/jsp/login.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }
}
