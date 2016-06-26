package com.infoshareacademy.finances.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infoshareacademy.finances.service.UserInfoService;
import com.infoshareacademy.finances.service.UserSessionData;

@WebServlet(urlPatterns = "/oauth2callback")
public class OAuth2CallbackServlet extends HttpServlet {
	private static final long serialVersionUID = -7218554815331667516L;
	private static Logger LOGGER = LoggerFactory.getLogger(OAuth2CallbackServlet.class);

	@Inject
	UserSessionData sessionData;

	@EJB
	UserInfoService service;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		LOGGER.info("Checking if user consented");
		String error = req.getParameter("error");
		if (null != error && "access_denied".equals(error.trim())) {
			HttpSession session = req.getSession();
			session.invalidate();
			resp.sendRedirect(req.getContextPath());
			return;
		}
		LOGGER.info("OK the user have consented so lets find out about the user");
		sessionData.createAuthToken(req.getParameter("code"));
		service.getUserDetails();

		resp.sendRedirect("/index.jsp");
	}
}