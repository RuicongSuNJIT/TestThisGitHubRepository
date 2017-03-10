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
		<div class="top-content individual">
			<div class="brand  left">Share</div>
			<div class="login-signup  right">
				<div class="left">
					<form action="login" method="get">
						<input name="name" type="text" placeholder="Username" />
						<input name="pass" type="password" placeholder="Password">
						<input type="submit" value="Log In" />
					</form>
				</div>
				<div class="right">
					<button onclick="toRegister()">Sign Up</button>
				</div>
			</div>
		</div>
	</div>
	<div class="main">
		<div class="main-content individual">
			<div class="intro left">
				<div class="intro-content">
					<img class="avatar" src="<c:url value="/resource/Avatar.jpg"/>" />
				</div>
			</div>
			<div class="comment left">
				<div class="comment-content">
					<h2 class="comment-title">Your comment</h2>
					<ul class="comment-list no-mark">
						<li class="comment-item" id="1">
							abc<br /> def<br />
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function toRegister() {
		window.location.href = "register.jsp";
	}
</script>
</html>