<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.um.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STUDENT MANAGEMENT SYSTEM</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>

	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">STUDENT MANAGEMENT SYSTEM</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<%=request.getContextPath()%>/list">Users</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<c:if test="${list==null}">
		<form action="insert" method="post">
	</c:if>
	<c:if test="${list!=null}">
		<form action="update" method="post">
	</c:if>



	<div class="container" align="center" style="padding-top: 80px">
		<div class="card" style="width: 25rem">
			<h2 align="center">
				<c:if test="${list==null}">
 ADD STUDENT</c:if>
				<c:if test="${list!=null}">
 EDIT STUDENT</c:if>
			</h2>
			<div class="mb-3 container">
				<input type="hidden" class="form-control" value="${list.id}"
					placeholder="enter your name" name="id" style="width: 300px">
			</div>

			<div class="mb-3 container">
				<label for="name" class="form-label">NAME</label> <input type="text"
					class="form-control" id="name" value="${list.name}"
					placeholder="enter your name" name="name" style="width: 300px">
			</div>

			<div class="mb-3 container">
				<label for="email" class="form-label">EMAIL</label> <input
					type="EMAIL" class="form-control" id="email" value="${list.email}"
					placeholder="enter your email" name="email" style="width: 300px">
			</div>
			<div class="mb-3 container">
				<label for="city" class="form-label">CITY</label> <input type="city"
					class="form-control" id="city" value="${list.city}"
					placeholder="enter your city" name="city" style="width: 300px">
			</div>
			<div class="mb-3 container">
				<input type="submit" value="save" class="btn btn-success"
					style="width: 150px">
			</div>
		</div>
	</div>
	</form>
</body>
</html>