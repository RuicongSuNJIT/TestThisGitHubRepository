<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%@include file="/common/head.jsp"%>
<link href="<c:url value="/css/root/new_comment.css"/>" type="text/css"
	rel="stylesheet" />
</head>
<body>
	<%@include file="/common/top.jsp"%>
	<div style="margin-left: 10px; margin-top: 10px;">
		<form>
			<textarea id="moment"
				style="width: 900px; height: 400px; resize: none;"></textarea>
			<br />
			<input type="button" value="Submit" onclick="newMoment()" />
			<input id="open" type="button" value="Open" />
			<input id="file" type="file" accept="image/*" style="display: none"
				multiple="multiple" />
		</form>
	</div>
	<div id="imageContainer" style="margin-top: 10px;"></div>
</body>
<%@include file="/common/js_include.jsp"%>
<script src="<c:url value="/js/template.js"/>"></script>
<script type="text/javascript">
	$(function() {
		Template.basePath = '<c:url value="/SavingFolder"/>';
		$('#open').on('click', function() {
			$('#file').trigger('click');
		});

		$('#file').fileupload({
			'url' : 'uploadFile', // this is the mapped name of the servlet writing into 
			// the annotation
			'type' : 'POST',
			'dataType' : 'json',
			'singleFileUploads' : false,
			'done' : function(e, data) {
				var container = $("#imageContainer");
				var files = data.result
				var div;
				for ( var i in files) {
					div = getDeletable(files[i].name, files[i].url);
					$("#imageContainer").append(div);
				}
			}
		});
	});

	function getDeletable(name, url) {
		var div = Template.getImageDiv(true);
		var image = Template.getImageImg(url);
		var del = Template.getImageDel('<c:url value="/resource/Delete.png"/>',
				name, deleteImage);
		div.append(image);
		div.append(del);
		return div;
	}

	function deleteImage() {
		$(this).parent().remove();
		/*
		$.ajax({
			'url' : 'cancelUpload',
			'type' : 'POST',
			'data' : {
				'name' : $(this).attr('del')
			},
			'dataType' : 'json',
			'success' : function(data) {
				alert(data.status);
			}
		});
		*/
	}

	function newComment() {
		var comment = $("#comment")[0].value;
		if (comment == "") {
			alert("You must have some to say, don't be so shy.");
			return;
		}

		$.ajax({
			'url' : 'newMoment',
			'type' : 'POST',
			'data' : {
				'comment' : comment
			},
			'dataType' : 'json',
			'success' : function(data) {
				alert(data.status);
			}
		});
	}

	function toRegister() {
		window.location.href = 'register.jsp';
	}

	function login() {
		$.ajax({
			'url' : 'login',
			'type' : 'get',
			'data' : {
				"name" : $('#name')[0].value,
				"pass" : $('#pass')[0].value
			},
			'dataType' : 'json',
			'success' : function(returnData) {
				alert(returnData['status']);
			}
		});
	}
</script>
</html>