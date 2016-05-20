package com.infoshareacademy.finances.web;
import com.infoshareacademy.finances.service.users.UserInfoService;
import com.infoshareacademy.finances.service.users.UserSessionData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(urlPatterns = "/oauth2callback")
public class OAuth2CallbackServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(OAuth2CallbackServlet.class);
    @Inject
    UserSessionData sessionData;
    @EJB
    UserInfoService service;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        logger.info("Checking if user consented");
        String error = req.getParameter("error");
        if ((null != error) && ("access_denied".equals(error.trim()))) {
            HttpSession session = req.getSession();
            session.invalidate();
            resp.sendRedirect(req.getContextPath());
            return;
        }
        logger.info("OK the user have consented so lets find out about the user");
        sessionData.createOAuthToken(req.getParameter("code"));
        service.getUserDetails();
        resp.sendRedirect("/index.jsp");
    }
}