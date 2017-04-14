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
					<a href="new_momment.jsp">
						<img class="new" src="<c:url value="/resource/New.png"/>" />
					</a>
					<ul class="comment-list no-mark">
					</ul>
					<button id="loadmore" onclick="loadMore()">Load More...</button>
				</div>
			</div>
		</div>
	</div>
</body>
<%@include file="/common/js_include.jsp"%>
<script src="<c:url value="/js/template.js"/>"></script>
<script type="text/javascript">
	var page = 0;
	$(function() {
		$('#loadmore').removeAttr('disabled');
		loadMore();
	});

	function loadMore() {
		$.ajax({
			'type' : 'post',
			'url' : 'showMoment',
			'data' : {
				'page' : page
			},
			'dataType' : 'json',
			'success' : function(result) {
				var length = result.length;
				var li;
				var ul = $('ul');
				for (var i = 0; i < length; ++i) {
					li = Template.getMomentLi(result[i]);
					ul.append(li);
				}
				++page;
				if (length < 10) {
					$('#loadmore').attr('disabled', 'disabled');
				}
			}
		});
	}
</script>
</html>