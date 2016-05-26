package com.infoshareacademy.finances.web.filters;

import com.infoshareacademy.finances.service.users.UserSessionData;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthFilter.class);

    @Inject
    UserSessionData sessionData;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (sessionData.getOAuthToken() == null) {
            LOGGER.info("Not logged - redirecting");
            request.getRequestDispatcher("/login.jsp")
                    .forward(request, response);
            return;
        }
        LOGGER.info("sessionData = " + sessionData.getUserInfo());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
