<%@page import="com.entity.Admin"%>
<%@page import="com.util.DBConnect"%>
<%@page import="com.dao.AdminDao"%>
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

	<div class="container-fluid " style="margin-top: 100px;">
		<div class="row">
			<div class="col-md-4">
				<div class="card card-sh">
					<div class="card-header">
						<p class="fs-4 text-center">Add Admin</p>
					</div>
					<div class="card-body">

						<c:if test="${not empty errorMsg}">
							<p class="fs-4 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<p class=" fs-4 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form action="addAdmin" method="post">
							<div class="row">
								<div class="col">
									<label class="form-label">Full Name</label> <input required
										name="fullname" type="text"
										class="form-control form-control-sm">
								</div>

								<div class="col">
									<label class="form-label">Mobile Number</label> <input required
										name="mobno" type="number"
										class="form-control form-control-sm">
								</div>
							</div>


							<div class="mt-2">
								<label class="form-label">Email</label> <input required
									name="email" type="email" class="form-control form-control-sm">
							</div>

							<div class="row mt-3">
								<div class="col">
									<label class="form-label">Password</label> <input required
										name="password" type="password" id="pass"
										class="form-control form-control-sm">
								</div>
							</div>
							<button type="submit"
								class="btn bg-primary text-white col-md-12 mt-3">Register</button>
						</form>

					</div>
				</div>
			</div>

			<div class="col-md-8">
				<div class="card card-sh">
					<div class="card-header">
						<p class="fs-4 text-center">Admin Details</p>
					</div>
					<div class="card-body">

						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Mob No</th>
									<th scope="col">Email</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								AdminDao dao = new AdminDao(DBConnect.getConnection());
								List<Admin> list = dao.getAllAdmin();
								for (Admin ad : list) {
								%>
								<tr>
									<td><%=ad.getFullName()%></td>
									<td><%=ad.getMobNo()%></td>
									<td><%=ad.getEmail()%></td>
									<td><a href="edit_admin.jsp?id=<%=ad.getId()%>"
										class="btn btn-sm btn-primary">Edit</a> <a
										href="deleteAdmin?id=<%=ad.getId()%>"
										class="btn btn-sm btn-danger">Delete</a></td>
								</tr>
								<%
								}
								%>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>