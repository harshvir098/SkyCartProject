
<%@page import="com.entity.Product"%>
<%@page import="com.dao.ProductDao"%>
<%@page import="com.entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.CategoryDao"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin | Category</title>
<%@include file="../component/css.jsp"%>
</head>
<body>
	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>

	<div class="container-fluid " style="margin-top: 100px;">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card card-sh">
					<div class="card-body">
						<p class="fs-4 text-center">Add Discount</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-4 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<p class=" fs-4 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						ProductDao dao2 = new ProductDao();
						Product p = dao2.getProductByid(id);
						%>
						<form action="discount" method="post">
							<div class="mb-3">
								<label class="form-label">Product Name</label> <input
									name="name" required type="text" class="form-control"
									value="<%=p.getTitle()%>" readonly>
							</div>
							<div class="mb-3">
								<label class="form-label">Price</label> <input type="text"
									required name="price" class="form-control"
									value="<%=p.getPrice()%>" readonly>
							</div>

							<div class="mb-3">
								<label class="form-label">Discount (%)</label> <input
									type="text" required name="discount" class="form-control">
							</div>
							<input type="hidden" name="id" value="<%=p.getId()%>">

							<button type="submit" class="btn bg-primary text-white col-md-12">Add</button>
						</form>

					</div>
				</div>
			</div>

		</div>
	</div>
	</div>


</body>
</html>