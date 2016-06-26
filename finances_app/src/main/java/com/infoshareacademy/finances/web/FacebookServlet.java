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

import com.github.scribejava.apis.FacebookApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.infoshareacademy.finances.service.UserSessionData;

@WebServlet("/facebook")
public class FacebookServlet extends HttpServlet{
	private static final long serialVersionUID = 1886798665295894101L;
	private static Logger logger = LoggerFactory.getLogger(FacebookServlet.class);
	private static final String CLIENT_ID = "248633892194297";
	private static final String CLIENT_SECRET = "35ec858d19e982e2c2ce69eb86c365a4";

	@Inject
	UserSessionData sessionData;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		logger.info("Making a service for OAuth.");
		OAuth20Service service = new ServiceBuilder()
				.apiKey(CLIENT_ID)
				.apiSecret(CLIENT_SECRET)
				.callback("http://localhost:8080/oauth2callback")
				.scope("email")
				.build(FacebookApi.instance());

		sessionData.setService(service);
		sessionData.setAuthType("f");


		logger.info("Redirecting to facebook for authorization.");
		resp.sendRedirect(service.getAuthorizationUrl());
	}
}
