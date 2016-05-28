package com.infoshareacademy.finances.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infoshareacademy.finances.entity.Privileges;
import com.infoshareacademy.finances.entity.UserPrivileges;
import com.infoshareacademy.finances.model.UserInfo;
import com.infoshareacademy.finances.model.UserInfoEntity;
import com.infoshareacademy.finances.model.UserInfoModel;
import com.infoshareacademy.finances.repository.UserInfoRepository;
import com.infoshareacademy.finances.repository.UserPrivilegesRepository;

@WebServlet(urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminServlet.class);
	private static final long serialVersionUID = -1098883883988907023L;

	@EJB
	UserInfoRepository userInfoRepository;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOGGER.info("/admin servlet - start");

		List<UserInfoEntity> users = userInfoRepository.loadUsersWithPrivileges(Privileges.ADMIN);
		LOGGER.info("Found {} users with ADMIN privileges", users.size());
		List<UserInfoModel> admins = new ArrayList<>();
		users.forEach(a -> admins.add(new UserInfoModel(a.getUserInfo().getName(), a.getUserInfo().getMail())));
		req.setAttribute("admins", admins);

		users = userInfoRepository.loadUsersWithPrivileges(Privileges.MORTAL);
		LOGGER.info("Found {} users with MORTAL privileges", users.size());
		List<UserInfoModel> mortals = new ArrayList<>();
		users.forEach(a -> mortals.add(new UserInfoModel(a.getUserInfo().getName(), a.getUserInfo().getMail())));
		req.setAttribute("mortals", mortals);

		LOGGER.info("/admin servlet - end");
		req.getRequestDispatcher("/admin.jsp").forward(req, resp);
	}
}
