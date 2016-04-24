package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.model.LstList;
import com.infoshareacademy.finances.service.LstLoad;
import com.sun.org.apache.xpath.internal.functions.FuncDoclocation;
import javafx.util.Pair;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@WebServlet(urlPatterns = "/")
public class WelcomeFinancesServlet extends HttpServlet {

@EJB
WelcomeFinances Funds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "fundSelected":
                    fundSelected(req, resp);
                    break;
                case "currencieSelected":
                    currencieSelected(req, resp);
                    break;
            }
        } else {
            List<LstList> FundList = Funds.getAllFunds();
       /*     for(int i=0;i<FundList.size();i++){
                System.out.println(FundList.get(i));
            }*/
            forwardListFunds(req, resp, FundList);
        }
    }

    private void forwardListFunds(HttpServletRequest req, HttpServletResponse resp, List fundList)
            throws ServletException, IOException {
        String nextJSP = "/jsp/main.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("fundList", fundList);
        dispatcher.forward(req, resp);
    }

    private void fundSelected(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("action", "fundSelect");
        req.setAttribute("fund", "AGI001");
        String nextJSP = "/jsp/funds.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

    private void currencieSelected(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("action", "currencies");
        req.setAttribute("currencies", "EUR");
        String nextJSP = "/jsp/currencies.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

}
