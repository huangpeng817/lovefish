<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布钓友圈</title>
<script type="text/javascript"
	src="<c:url value='/script/jquery-1.9.1.min.js'/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
 		$.ajax({
			url: "http://api.map.baidu.com/location/ip?ak=c36mRDe5Ts3v6zst94lIfxyh&coor=bd09ll",
			type : "POST",
			dataType : "jsonp",
			asyn : false,
			cache : false,
			error : function(XMLResponse) {
				alert("进入error函数");
			},
			success : function(result) {
				$("#Lat").val(result.content.point.y);
				$("#Lng").val(result.content.point.x);
			}
			
		});
	});
</script>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<center>
		<form action="<c:url value='/SendDynamicServlet'/>" method="post" enctype="multipart/form-data">
			<input id="Lat" type="hidden" name="Lat" value="">
			<input id="Lng" type="hidden" name="Lng" value="">
			<table>
				<tr>
					<td>图片：</td>
					<td><input id="photo" type="file" name="photo"></td>
				</tr>
				<tr>
					<td>位置：</td>
					<td><input id="localAdd" type="text" name="localAdd"></td>
				</tr>
				<tr>
					<td>是否上传足迹：</td>
					<td>
						<input type="radio" name="IsAdv" value="1">是
						<input type="radio" name="IsAdv" value="0" checked="checked">否
					</td>
				</tr>
				<tr>
					<td>内容：</td>
					<td>
						<textarea rows="4" cols="21" name="content"></textarea>
					</td>
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