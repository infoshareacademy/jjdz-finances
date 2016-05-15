package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.service.users.UserSessionData;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("*.jsp")
public class AuthFilter implements Filter {

    @Inject
    UserSessionData sessionData;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (sessionData.getOAuthToken() != null) {
            chain.doFilter(request, response);
        }

        System.out.println("Not logged - redirecting");
        request.getRequestDispatcher("/login.jsp")
                .forward(request, response);
    }

    @Override
    public void destroy() {

    }
}
