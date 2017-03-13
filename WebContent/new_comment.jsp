<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%@include file="/common/head.jsp"%>
<link href="<c:url value="/css/root/new_comment.css"/>" type="text/css" rel="stylesheet" />
</head>
<body>
	<%@include file="/common/top.jsp"%>
	<div>
		<form>
			<input id="comment" type="text" />
			<input id="open" type="button" value="Open" />
			<input id="file" type="file" accept="image/*" style="display: none" multiple="multiple"/>
		</form>
	</div>
</body>
<%@include file="/common/jsInclude.jsp"%>
<script type="text/javascript">
	$('#open').on('click', function() {
		$('#file').trigger('click');
	});

	function toRegister() {
		window.location.href = "register.jsp";
	}

	function login() {
		$.ajax({
			'url' : 'login',
			'type' : 'get',
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