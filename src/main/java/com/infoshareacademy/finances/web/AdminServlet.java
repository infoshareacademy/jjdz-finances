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

import com.infoshareacademy.finances.entity.Privileges;
import com.infoshareacademy.finances.model.UserInfo;
import com.infoshareacademy.finances.model.UserInfoEntity;
import com.infoshareacademy.finances.model.UserInfoModel;
import com.infoshareacademy.finances.repository.UserPrivilegesRepository;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

	@EJB
	UserPrivilegesRepository userPrivilegesRepository;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserInfoEntity> users = userPrivilegesRepository.loadUsersWithPrivileges(Privileges.ADMIN);
		List<UserInfoModel> admins = new ArrayList<>();
		users.stream()
				.forEach(a -> admins.add(new UserInfoModel(a.getUserInfo().getName(), a.getUserInfo().getMail())));
		req.setAttribute("admins", admins);
		resp.sendRedirect("admin.jsp");
	}
}
