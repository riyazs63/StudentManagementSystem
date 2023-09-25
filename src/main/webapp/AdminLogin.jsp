<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STUDENT MANAGEMENT SYSTEM</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">

</head>
<body>

	<form action="validate" method="post">

		<div class="container" align="center" style="padding-top: 100px">
			<div class="card" style="width: 25rem">
				<div>
					<h1>
						<i>HELLO ADMIN</i>
					</h1>
				</div>
				<div class="mb-3 container ">
					<label for="username" class="form-label">UserName</label> <input
						type="text" class="form-control" id="username"
						placeholder="enter your username" name="username"
						style="width: 300px">
				</div>
				<div class="mb-3 container">
					<label for="password" class="form-label">PASSWORD</label> <input
						type="PASSWORD" class="form-control" id="password"
						placeholder="enter your password" name="password"
						style="width: 300px">
				</div>
				<div class="mb-3 container">
					<input class="btn btn-success" type="submit" value="Login"
						style="width: 100px">
				</div>
			</div>
		</div>
	</form>
</body>
</html>