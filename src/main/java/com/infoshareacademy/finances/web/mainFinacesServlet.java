package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.model.LstList;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

import java.io.IOException;
import java.util.*;


@WebServlet(urlPatterns = "/main")
public class MainFinacesServlet extends HttpServlet {

    @EJB
    CacheAll cache;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println("(" + req.getRequestURL() + ") main.jsp: " + action);
        if (action == null) {
            forwardMain(req, resp);
            return;
        }

        switch (action) {
            case "forwardFundsMain":
                forwardFundsMain(req, resp);
                break;
            case "fundSelected":
                fundSelected(req, resp);
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
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println("main.jsp: " + action);

        Enumeration<String> parameterNames = req.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            System.out.print("param: " + paramName);
            String[] paramValues = req.getParameterValues(paramName);

            for (int i = 0; i < paramValues.length; i++) {
                String paramValue = paramValues[i];
                System.out.println(" value: " + paramValue);
            }
        }

        if (action != null) {
            System.out.println("main.jsp: POST :" + action);
            switch (action) {
                case "fundSelected":
                    fundSelected(req, resp);
                    break;
            }
        } else {
            forwardMain(req, resp);
        }
    }

    private void forwardMain(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nextJSP = "/main.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

    private void forwardFundsMain(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<LstList> fundList = cache.returnAllFunds();

        String nextJSP = "/funds.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("fundList", fundList);
        dispatcher.forward(req, resp);
    }

    private void fundSelected(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("action", "fundSelected");
        req.setAttribute("value", "AGI001");
        String nextJSP = "funds.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

    private void currenciesSelected(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("action", "currenciesSelected");
        req.setAttribute("currencies", "EUR");
        String nextJSP = "/currencies.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

    private void adminSelected(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nextJSP = "/admin";
		resp.sendRedirect(nextJSP);
    }

    private void loginSelected(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nextJSP = "/login.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }
}
