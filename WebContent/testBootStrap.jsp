<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/head.jsp"%>
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<form class="form-search">
				<input class="input-medium search-query" type="text" /> <button type="submit" class="btn">查找</button>
			</form>
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						<a class="btn btn-navbar" data-target=".navbar-responsive-collapse" data-toggle="collapse"></a> <a class="brand" href="#">share</a>
						<div class="nav-collapse collapse navbar-responsive-collapse">
							<ul class="nav">
								<li class="active">
									<a href="#">主页</a>
								</li>
								<li>
									<a href="#">链接</a>
								</li>
								<li>
									<a href="#">链接</a>
								</li>
								<li class="dropdown">
									<a class="dropdown-toggle" data-toggle="dropdown" href="#">下拉菜单</a>
									<ul class="dropdown-menu">
										<li>
											<a href="#">下拉导航1</a>
										</li>
										<li>
											<a href="#">下拉导航2</a>
										</li>
										<li>
											<a href="#">其他</a>
										</li>
										<li class="divider">
										</li>
										<li class="nav-header">
											标签
										</li>
										<li>
											<a href="#">链接1</a>
										</li>
										<li>
											<a href="#">链接2</a>
										</li>
									</ul>
								</li>
							</ul>
							<ul class="nav pull-right">
								<li>
									<a href="#">右边链接</a>
								</li>
								<li class="divider-vertical">
								</li>
								<li class="dropdown">
									<a class="dropdown-toggle" data-toggle="dropdown" href="#">下拉菜单</a>
									<ul class="dropdown-menu">
										<li>
											<a href="#">下拉导航1</a>
										</li>
										<li>
											<a href="#">下拉导航2</a>
										</li>
										<li>
											<a href="#">其他</a>
										</li>
										<li class="divider">
										</li>
										<li>
											<a href="#">链接3</a>
										</li>
									</ul>
								</li>
							</ul>
						</div>
						
					</div>
				</div>
				
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							产品
						</th>
						<th>
							交付时间
						</th>
						<th>
							状态
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Default
						</td>
					</tr>
					<tr class="success">
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Approved
						</td>
					</tr>
					<tr class="error">
						<td>
							2
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							02/04/2012
						</td>
						<td>
							Declined
						</td>
					</tr>
					<tr class="warning">
						<td>
							3
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							03/04/2012
						</td>
						<td>
							Pending
						</td>
					</tr>
					<tr class="info">
						<td>
							4
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							04/04/2012
						</td>
						<td>
							Call in to confirm
						</td>
					</tr>
				</tbody>
			</table>
			<div class="pagination">
				<ul>
					<li>
						<a href="#">上一页</a>
					</li>
					<li>
						<a href="#">1</a>
					</li>
					<li>
						<a href="#">2</a>
					</li>
					<li>
						<a href="#">3</a>
					</li>
					<li>
						<a href="#">4</a>
					</li>
					<li>
						<a href="#">5</a>
					</li>
					<li>
						<a href="#">下一页</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
</body>
</html>