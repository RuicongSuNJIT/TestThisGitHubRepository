<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="/common/head.jsp"%>
<link href="<c:url value="/css/root/index.css"/>" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="top">
		<div class="brand inline left">Share</div>
		<div class="top-login-signup inline right">
			<form style="display: inline" action="login" method="get">
				<input name="name" type="text" placeholder="Username" />
				<input name="pass" type="password" placeholder="Password">
				<input type="submit" value="Log In" />
			</form>
			<button onclick="toRegister()">Sign Up</button>
		</div>
	</div>
</body>
<script type="text/javascript">
	function toRegister() {
		window.location.href = "register.jsp";
	}
</script>
</html>