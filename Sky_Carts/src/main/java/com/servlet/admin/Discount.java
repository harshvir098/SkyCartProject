package com.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProductDao;
import com.entity.Product;

@WebServlet("/admin/discount")
public class Discount extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		int discount = Integer.parseInt(req.getParameter("discount"));

		ProductDao dao = new ProductDao();
		HttpSession session = req.getSession();

		if (discount > 0 && discount <= 100) {

			Product p = dao.getProductByid(id);
			p.setDiscountBeforePrice(Double.parseDouble(p.getPrice()));

			Double discountPrice = (Double.parseDouble(p.getPrice())) * discount / 100;
			Double pr = Double.parseDouble(p.getPrice()) - discountPrice;
			p.setPrice(pr + "");
			p.setDiscount(discount);

			/*
			 * System.out.println(p.getPrice()); System.out.println(p.getDiscount());
			 * System.out.println(p.getDiscountBeforePrice());
			 */

			boolean f = dao.updateDiscountProduct(p);
			if (f) {
				session.setAttribute("succMsg", "update successfully");
				resp.sendRedirect("view_product.jsp");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
				resp.sendRedirect("discount.jsp");

			}

		} else {
			session.setAttribute("errorMsg", "invalid discount");
			resp.sendRedirect("discount.jsp?id=" + id);
		}

	}

}
