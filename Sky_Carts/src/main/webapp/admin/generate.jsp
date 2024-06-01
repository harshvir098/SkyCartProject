<%@page import="com.entity.Product"%>
<%@page import="com.dao.ProductDao"%>
<%@page import="com.entity.User"%>
<%@page import="com.util.DBConnect"%>
<%@page import="com.dao.UserDAO"%>
<%@page import="com.entity.ProductOrder"%>
<%@page import="com.dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/css.jsp"%>
</head>
<body>
	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-5 mt-3">
			<div class="card card-sh">
				<div class="card-header">
					<h3 class="text-center">Statement</h3>
				</div>




				<div class="card-body">
					<form action="generate">
						<div class="row">
							<div class="col">
								<input type="date" class=" form-control" name="sdate">
							</div>

							<div class="col">
								<input type="date" class=" form-control" name="edate">
							</div>
							<div class="col">
								<button class="btn btn-primary">Search</button>
							</div>

							<div class="col">
								<button class="btn btn-success">Total Earning :
									&#8364;${totalEarning}</button>
							</div>
						</div>
					</form>

					<hr>
					<table class="table mt-3">
						<thead>
							<tr>
								<th class="text-center">Order Date</th>
								<th class="text-center">Order ID</th>
								<th>Product Details</th>
								<th>Payment Type</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>

							<%
							List<ProductOrder> list = (List<ProductOrder>) request.getAttribute("data");

							String st = (String) request.getAttribute("st");

							ProductDao pdao = new ProductDao();
							if (list != null) {
								for (ProductOrder o : list) {
									Product p = pdao.getProductByid(o.getProductid());
							%>

							<tr>
								<th><%=o.getOrderDate()%></th>
								<th scope="row"><%=o.getOrderId()%></th>

								<td><%=p.getTitle()%> <br>Quantity : <%=o.getQuantity()%>
									<br> <%
 Double tprice = Double.parseDouble(p.getPrice()) * o.getQuantity();
 %> &#8364;<%=tprice%></td>



								<td><%=o.getPaymentType()%></td>
								<td><%=o.getOrderStatus()%></td>

							</tr>
							<%
							}
							} else {
							%>

							<h4 class="text-center text-danger"><%=st%></h4>
							<%
							}
							%>




						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>