package com.infoshareacademy.finances.web;

import com.infoshareacademy.finances.service.Google2Api;
import org.scribe.builder.ServiceBuilder;
import org.scribe.oauth.OAuthService;

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
        OAuthService service = builder.provider(Google2Api.class)
                .apiKey(CLIENT_ID)
                .apiSecret(CLIENT_SECRET)
                .callback("http://localhost:8080/FoundsAnalyzer-1.0-SNAPSHOT/welcome.jsp")
                        .scope("openid profile email " +
                                        "https://www.googleapis.com/auth/plus.login " +
                                "https://www.googleapis.com/auth/plus.me")
                .build(); //Now build the call

        HttpSession session = req.getSession();
        session.setAttribute("oauth2Service", service);

        resp.sendRedirect(service.getAuthorizationUrl(null));
    }
}
