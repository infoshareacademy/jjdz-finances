package com.infoshareacademy.finances.web;

import java.io.IOException;
import java.util.Enumeration;
import com.infoshareacademy.finances.entity.AssetType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/main")
class MainFinacesServlet extends HttpServlet {

    private static final long serialVersionUID = 5375886917868065269L;

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
			case "logoutSelected":
                logoutSelected(req, resp);
                break;
            case "plansSelected":
                plansSelected(req, resp);
                break;
			case "reportsSelected":
				reportsSelected(req, resp);
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

        String nextJSP = "/showAssets";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("assetType", AssetType.FUND);
        dispatcher.forward(req, resp);
    }

    private void fundSelected(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("action", "fundSelected");
        req.setAttribute("value", "AGI001");
        String nextJSP = "assets.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

    private void currenciesSelected(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nextJSP = "/showAssets";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("assetType", AssetType.CURRENCY);
        dispatcher.forward(req, resp);
    }

    private void adminSelected(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nextJSP = "/admin";
        resp.sendRedirect("/admin");
    }

    private void loginSelected(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nextJSP = "/login.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

	private void logoutSelected(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		req.getSession().invalidate();
        String nextJSP = "/login.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

    private void plansSelected(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nextJSP = "/plansList";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

	private void reportsSelected(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String nextJSP = "/reports.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(req, resp);
	}
}
