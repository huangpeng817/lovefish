<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册(手机号)页面</title>
<script type="text/javascript"
	src="<c:url value='/script/jquery-1.9.1.min.js'/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		$("#vCodeBtn").click(function(){
			var MobilePhone = $("#MobilePhone").val();
			//alert("获取到的手机号为： " + MobilePhone);
			$.ajax({
				url: "http://120.24.159.207:8081/UMS/UM/CreateVCodeByMobile",
				data : {MobilePhone: MobilePhone, validateType: "1"},
				type : "POST",
				dataType : "json",
				asyn : false,
				cache : false,
				error : function(XMLResponse) {
					alert("进入error函数");
				},
				success : function(result) {
					// 通用的提示
					alert("接口返回数据提示： " + result.Message);
					// 获取验证码成功的情况
					/* if (result.Message == null) {
						alert("请接收手机验证码并填写");
					} */
				}
			});
		
		});
	});
</script>
</head>
<body><br><br><br><br>
	<center>
		<form action="<c:url value='/UserServlet'/>" method="post">
			<input type="hidden" name="method" value="reigsterByMobile">
			<table>
				<tr>
					<td>手机号： </td>
					<td><input id="MobilePhone" type="text" name="MobilePhone"></td>
				</tr>
				<tr>
					<td>密码： </td>
					<td><input type="password" name="Password">
					<!-- (需使用MD5加密) --></td>
				</tr>
				<tr>
					<td>验证码： </td>
					<td><input type="text" name="VCode"></td>
					<td><input id="vCodeBtn" type="button" value="获取验证码"></td>
				</tr>
				
				<tr>
					<td></td>
					<td><input type="submit" value="注册"></td>
					<td></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>