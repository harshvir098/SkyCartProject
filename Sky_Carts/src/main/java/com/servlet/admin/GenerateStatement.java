package com.servlet.admin;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OrderDao;
import com.dao.ProductDao;
import com.entity.Product;
import com.entity.ProductOrder;

@WebServlet("/admin/generate")
public class GenerateStatement extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		LocalDate startDate = LocalDate.parse(req.getParameter("sdate"));
		LocalDate endDate = LocalDate.parse(req.getParameter("edate"));

		List<LocalDate> dateList = startDate.datesUntil(endDate).collect(Collectors.toList());

		/*
		 * long days = ChronoUnit.DAYS.between(startDate, endDate); List<LocalDate>
		 * dateList = Stream.iterate(startDate, localDate ->
		 * localDate.plusDays(1)).limit(days) .collect(Collectors.toList());
		 */

		OrderDao dao = new OrderDao();
		ProductDao pdao = new ProductDao();
		Double totalEarning = 0.0;

		List<ProductOrder> finalList = new ArrayList<>();

		for (LocalDate l : dateList) {
			List<ProductOrder> list = dao.getOrderByDateDtls(l.toString());
			for (ProductOrder p : list) {
				finalList.add(p);
			}
		}
		for (ProductOrder o : finalList) {
			Product p = pdao.getProductByid(o.getProductid());
			totalEarning += Double.parseDouble(p.getPrice()) * o.getQuantity();

		}
		if (finalList.size() > 0) {
			req.setAttribute("totalEarning", totalEarning);
			req.setAttribute("data", finalList);

		} else {
			req.setAttribute("st", "Product not sell");
		}

		req.getRequestDispatcher("generate.jsp").forward(req, resp);

	}

}
