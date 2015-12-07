<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>百度地图API获取城市名页面</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/style/list.css'/>">
<script type="text/javascript"
	src="<c:url value='/script/jquery-1.9.1.min.js'/>"></script>
<script type="text/javascript">

	
</script>

<script type="text/javascript">

	var cityName = "";
	
	$(document).ready(function() {
			$.ajax({
			url: "http://api.map.baidu.com/location/ip?ak=c36mRDe5Ts3v6zst94lIfxyh&coor=bd09ll",
			//data : {ak: "c36mRDe5Ts3v6zst94lIfxyh", coor: "bd09ll"},
			type : "POST",
			dataType : "jsonp",
			//crossDomain: true, 
			asyn : false,
			cache : false,
			error : function(XMLResponse) {
				alert("进入error函数");
			},
			success : function(result) {
				$("#Lat").val(result.content.point.y);
				$("#Lng").val(result.content.point.x);
				$("#Region").val(result.content.address_detail.city);
				//alert(result.content.address_detail.city);
				cityName = result.content.address_detail.city;
				alert(cityName);
			}
			
		});
	});

	alert("另一个script片段获取的cityName为： " + cityName);
</script>
</head>
<body>
	
</body>
</html>