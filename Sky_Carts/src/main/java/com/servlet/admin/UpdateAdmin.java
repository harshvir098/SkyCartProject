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

@WebServlet("/admin/updateAdmin")
public class UpdateAdmin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String fn = req.getParameter("fullname");
			String em = req.getParameter("email");
			String mb = req.getParameter("mobno");
			String ps = req.getParameter("password");
			int id = Integer.parseInt(req.getParameter("id"));

			Admin admin = new Admin(fn, em, mb, ps);
			admin.setId(id);

			AdminDao dao = new AdminDao(DBConnect.getConnection());
			HttpSession session = req.getSession();

			if (dao.updateUser(admin)) {

				session.setAttribute("succMsg", "update successfully");
				resp.sendRedirect("admin.jsp");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
				resp.sendRedirect("admin.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
