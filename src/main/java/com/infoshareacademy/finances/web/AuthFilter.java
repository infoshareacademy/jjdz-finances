package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.service.users.UserSessionData;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/main")
public class AuthFilter implements Filter {

    @Inject
    UserSessionData sessionData;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (sessionData.getOAuthToken() == null) {
            System.out.println("Not logged - redirecting");
            request.getRequestDispatcher("/login.jsp")
                    .forward(request, response);
            return;
        }
        request.setAttribute("userinfo", sessionData.getUserInfo());
        System.out.println("sessionData = " + sessionData.getUserInfo());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
