<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/bootstrap/css/bootstrap.css'/>"
	rel="stylesheet" />
<script type="text/javascript"
	src="<c:url value='/jquery-1.4.4.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/jquery.jqprint-0.3.js'/>"></script>
<script type="text/javascript">
	function a() {
		//alert("你点击了我，还一笑而过");
		$("#ddd").jqprint();
	}
</script>
<title>打印测试3</title>
</head>
<body>
	<div id="ddd">
		<table class="table" id="myTable">
			<caption>我是表头</caption>
			<thead>
				<tr>
					<th>姓名</th>
					<th>年龄</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>张三</td>
					<td>11</td>
				</tr>
				<tr>
					<td>李四</td>
					<td>22</td>
				</tr>
			</tbody>
		</table>

	</div>

	<input type="button" onclick=" a()" value="打印" />
</body>
</html>