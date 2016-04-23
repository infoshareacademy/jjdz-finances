package com.infoshareacademy.finances.web;


import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.github.scribejava.core.oauth.OAuthService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/googleplus")
public class GooglePlusServlet extends HttpServlet {
    private static final String CLIENT_ID = "611628318839-i1eelkunlja4dq4js5mnplan1bs2j0qj.apps.googleusercontent.com";
    private static final String CLIENT_SECRET = "_EBNxwGtSvloQrZXJ0LSDqSm";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServiceBuilder builder = new ServiceBuilder();
        OAuth20Service service = builder
                .apiKey(CLIENT_ID)
                .apiSecret(CLIENT_SECRET)
                .callback("http://localhost:8080/AssetsAnalyzer-1.0-SNAPSHOT/oauth2callback")
                .scope("openid profile email " +
                        "https://www.googleapis.com/auth/plus.login " +
                        "https://www.googleapis.com/auth/plus.me")
                .build(GoogleApi20.instance()); //Now build the call

        HttpSession session = req.getSession();
        session.setAttribute("oauth2Service", service);


        resp.sendRedirect(service.getAuthorizationUrl());
    }
}
