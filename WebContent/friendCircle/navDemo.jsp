<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选项卡练习</title>
<script type="text/javascript"
	src="<c:url value='/jquery-1.9.1.min.js'/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
<script type="text/javascript" src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>	
</head>
<body>

	<div class="container-fluid">
	
	<table class="table table-bordered">
  <thead><tr><th>表头</th><tr></thead>
  <tbody><tr><td>fasdfas</td><tr></tbody>
</table>
	
		<div class="row-fluid">
			<div class="col-xs-12">
				<div class="tabbable" id="tabs-134499">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#panel-112380" data-toggle="tab">选项卡一</a>
						</li>
						<li><a href="#panel-990988" data-toggle="tab">选项卡二</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="panel-112380">
							<p>第一部分内容.</p>
						</div>
						<div class="tab-pane" id="panel-990988">
							<p>第二部分内容.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>