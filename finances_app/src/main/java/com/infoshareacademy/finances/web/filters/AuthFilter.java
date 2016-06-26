package com.infoshareacademy.finances.web.filters;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infoshareacademy.finances.service.UserSessionData;

public class AuthFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthFilter.class);

    @Inject
    UserSessionData sessionData;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (sessionData.getAuthToken() == null) {
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
