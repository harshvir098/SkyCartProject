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
						</div>
					</form>

					<hr>
					<table class="table mt-3">
						<thead>
							<tr>
								<th class="text-center">Order Date</th>
								<th class="text-center">Order ID</th>
								<th>Delivery Address</th>
								<th>Product Details</th>
								<th>Payment Type</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>





						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>