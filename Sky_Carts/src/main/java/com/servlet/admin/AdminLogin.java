package com.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDao;
import com.entity.Admin;
import com.util.DBConnect;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String em = req.getParameter("email");
			String ps = req.getParameter("password");

			AdminDao dao = new AdminDao(DBConnect.getConnection());
			HttpSession session = req.getSession();

			Admin user = dao.login(em, ps);
			if (user != null) {
				session.setAttribute("adminObj", user);
				resp.sendRedirect("admin/index.jsp");
			} else {
				session.setAttribute("errorMsg", "invalid email and password");
				resp.sendRedirect("admin_login.jsp");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
