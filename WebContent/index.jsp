<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%@include file="/common/head.jsp"%>
<link href="<c:url value="/css/root/index.css"/>" type="text/css" rel="stylesheet" />
</head>
<body>
	<%@include file="/common/top.jsp"%>
	<div class="main">
		<div class="main-content individual">
			<div class="intro left">
				<div class="intro-content">
					<img class="avatar" src="${user.avatar}" />
				</div>
			</div>
			<div class="comment left">
				<div class="comment-content">
					<h2 class="comment-title">Your comment</h2>
					<a href="">
						<img class="new" src="<c:url value="/resource/New.png"/>" />
					</a>
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
<%@include file="/common/js_include.jsp"%>
<script type="text/javascript">
	function toRegister() {
		window.location.href = "register.jsp";
	}

	function login() {
		$.ajax({
			'url' : 'login',
			'type' : 'post',
			'data' : {
				'name' : $("#name")[0].value,
				'pass' : $("#pass")[0].value
			},
			'dataType' : 'json',
			'success' : function(returnData) {
				alert(returnData['status']);
			}
		});
	}
</script>
</html>