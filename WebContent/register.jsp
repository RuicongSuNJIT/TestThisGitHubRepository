<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Register</title>
<%@include file="/common/head.jsp"%>
<link href="<c:url value="/css/root/register.css"/>" type="text/css"
	rel="stylesheet" />
</head>
<body>
	<div align="center">
		<div class="register-title">
			<h2>Welcome to use Share</h2>
		</div>
		<div class="form-content" style="width: 300px">
			<form>
				<input type="text" id="name" placeholder="Name" />
				<br />
				<input type="password" id="pass" placeholder="Password" />
				<br />
				<input type="password" id="conf" placeholder="Confirm password" />
				<br />
				<input type="text" id="nick" placeholder="Nick name" />
				<br />
				<input type="text" id="email" placeholder="E-mail" />
				<br />
				<input type="button" value="Register" onclick="register()" />
				<input type="reset" value="Reset" />
			</form>
		</div>
	</div>
</body>
<%@include file="/common/js_include.jsp"%>
<script type="text/javascript">
	function register() {
		var pass = $("#pass")[0].value;
		var conf = $("#conf")[0].value;
		
		if(pass != conf){
			alert("Password and Confirm are not equal!");
			return;
		} 
		
		$.ajax({
			'url' : 'register',
			'type' : 'post',
			'data' : {
				'name' : $("#name")[0].value,
				'pass' : pass,
				'nick' : $("#nick")[0].value,
				'email' : $("#email")[0].value
			},
			'dataType' : 'json',
			'success' : function(returnData) {
				alert(returnData['status']);
			}
		});
	}
</script>
</html>