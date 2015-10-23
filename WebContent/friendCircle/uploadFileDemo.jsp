<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件</title>
</head>
<body>
	<center>
		<form action="<c:url value='/FriendCircleServlet'/>" method="post">
			<input type="hidden" name="method" value="addDynamic">
			<table>
				<tr>
					<td>上传图片：</td>
					<td><input type="file" name="upload"></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="完成"></td>
					<td></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>