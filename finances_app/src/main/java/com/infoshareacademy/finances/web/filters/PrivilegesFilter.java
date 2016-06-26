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

import com.infoshareacademy.finances.entity.Privileges;
import com.infoshareacademy.finances.service.UserSessionData;

public class PrivilegesFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(PrivilegesFilter.class);

	@Inject
	UserSessionData userSessionData;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (userSessionData.getPrivileges() != Privileges.ADMIN) {
			LOGGER.info("User with MORTAR or UNKNOWN privileges [{}] wanted to access admin panel.",
					userSessionData.getUserInfo().getName());
			request.getRequestDispatcher("/main").forward(request, response);
			return;
		}
		LOGGER.info("User with ADMIN privileges [{}] accessing admin panel.",
				userSessionData.getUserInfo().getName());

		chain.doFilter(request,response);
	}

	@Override
	public void destroy() {

	}
}
