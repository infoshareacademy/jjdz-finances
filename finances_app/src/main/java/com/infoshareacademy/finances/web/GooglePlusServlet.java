package com.infoshareacademy.finances.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.infoshareacademy.finances.service.UserSessionData;

@WebServlet("/googleplus")
public class GooglePlusServlet extends HttpServlet {
	private static final long serialVersionUID = 4330454933129667121L;
	private static final Logger LOGGER = LoggerFactory.getLogger(GooglePlusServlet.class);
    private static final String CLIENT_ID = "611628318839-i1eelkunlja4dq4js5mnplan1bs2j0qj.apps.googleusercontent.com";
    private static final String CLIENT_SECRET = "_EBNxwGtSvloQrZXJ0LSDqSm";

    @Inject
    UserSessionData sessionData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOGGER.info("Making a service for OAuth.");
        OAuth20Service service = new ServiceBuilder()
                .apiKey(CLIENT_ID)
                .apiSecret(CLIENT_SECRET)
                .callback("http://localhost:8080/oauth2callback")
                .scope("openid profile email " +
                        "https://www.googleapis.com/auth/plus.login " +
                        "https://www.googleapis.com/auth/plus.me")
                .build(GoogleApi20.instance());

        sessionData.setService(service);
		sessionData.setAuthType("g");

        LOGGER.info("Redirecting to google for authorization.");
        resp.sendRedirect(service.getAuthorizationUrl());
    }
}
