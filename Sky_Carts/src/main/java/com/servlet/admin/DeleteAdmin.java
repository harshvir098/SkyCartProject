package com.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDao;
import com.dao.CategoryDao;
import com.util.DBConnect;

@WebServlet("/admin/deleteAdmin")
public class DeleteAdmin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		AdminDao dao = new AdminDao(DBConnect.getConnection());

		HttpSession session = req.getSession();

		if (dao.deleteAdmin(id)) {

			session.setAttribute("succMsg", "Delete sucesfully");
			resp.sendRedirect("admin.jsp");

		} else {
			session.setAttribute("errorMsg", "something wrong on server");
			resp.sendRedirect("admin.jsp");
		}

	}
}
