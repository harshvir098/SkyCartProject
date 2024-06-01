<%@page import="com.util.DBConnect"%>
<%@page import="com.dao.AdminDao"%>
<%@page import="com.entity.Admin"%>
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
			<div class="col-md-4 offset-md-4">
				<div class="card card-sh">
					<div class="card-header">
						<p class="fs-4 text-center">Edit Admin</p>
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
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						AdminDao dao = new AdminDao(DBConnect.getConnection());
						Admin a = dao.getUser(id);
						%>
						<form action="updateAdmin" method="post" id="userRegister">
							<div class="row">
								<div class="col">
									<label class="form-label">Full Name</label> <input required
										name="fullname" type="text" value="<%=a.getFullName()%>"
										class="form-control form-control-sm">
								</div>

								<div class="col">
									<label class="form-label">Mobile Number</label> <input required
										name="mobno" type="number" value="<%=a.getMobNo()%>"
										class="form-control form-control-sm">
								</div>
							</div>


							<div class="mt-2">
								<label class="form-label">Email</label> <input required
									value="<%=a.getEmail()%>" name="email" type="email"
									class="form-control form-control-sm">
							</div>

							<div class="row mt-3">
								<div class="col">
									<label class="form-label">Password</label> <input required
										value="<%=a.getPassword()%>" name="password" type="text"
										id="pass" class="form-control form-control-sm">
								</div>
							</div>
							<input type="hidden" name="id" value="<%=a.getId()%>">
							<button type="submit"
								class="btn bg-primary text-white col-md-12 mt-3">Update</button>
						</form>

					</div>
				</div>
			</div>


		</div>
	</div>


</body>
</html>