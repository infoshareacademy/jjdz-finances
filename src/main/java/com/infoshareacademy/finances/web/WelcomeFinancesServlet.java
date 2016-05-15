package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.service.users.UserSessionData;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/")
public class WelcomeFinancesServlet extends HttpServlet {

    @EJB
    WelcomeFinances main;

    @Inject
    UserSessionData sessionData;

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("sessionData.userInfo = " + sessionData.getUserInfo());

//
//        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
//        dispatcher.forward(req, resp);

        PrintWriter writer = resp.getWriter();
        writer.print("<h1>");
        writer.print(main.welcome());
        writer.print("</h1>");
        writer.flush();
    }
}
