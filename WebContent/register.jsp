<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Register</title>
<%@include file="/common/head.jsp"%>
<link href="<c:url value="/css/root/register.css"/>" type="text/css" rel="stylesheet" />
</head>
<body>
	<div align="center">
		<div class="register-title">
			<h2>Welcome to use Share</h2>
		</div>
		<div class="form-content" style="width: 300px">
			<form action="register" method="post">
				<input type="text" name="name" placeholder="Name" />
				<br />
				<input type="password" name="password" placeholder="Password" />
				<br />
				<input type="password" placeholder="Confirm password" />
				<br />
				<input type="text" name="email" placeholder="E-mail" />
				<br />
				<input type="submit" value="Register" />
			</form>
		</div>
	</div>
</body>
</html>