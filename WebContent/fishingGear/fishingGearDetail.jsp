<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>渔具店详情页面</title>
<style type="text/css">
	body, html, #showMap {width: 80%;height: 80%;overflow: hidden;margin:0;font-family:"微软雅黑";}
</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=c36mRDe5Ts3v6zst94lIfxyh"></script>
<script type="text/javascript"
	src="<c:url value='/script/jquery-1.9.1.min.js'/>"></script>
</head>
<body>
	----渔具店详情页面----
	<br>
	<br>
	<c:choose>
	<c:when test="${fg.photoes ne '' }">
	<c:set var="photoesStr" value="${fg.photoes }" />
	<c:forEach items="${fn:split(photoesStr,',')}" var="photo"
		varStatus="stat">
		<img alt="渔具店图片" src="${photo }" border="0" width="200px"
			height="200px">
	</c:forEach>
	</c:when>
	<c:otherwise>
		<div id="showMap"></div>
	</c:otherwise>
	</c:choose>
<div style="float: right;">
	<p>${fg.FGName } <span style="color: blue; font-size: xx-large;">距离 ${fg.distance }km</span></p>
	<p>地址：${fg.FGAddress }</p>
	<p>简介：${fg.content }</p>
	<p>电话：${fg.FGTel }</p>
	<p>${fg.praise }赞</p>
	<p>${fg.commentCount }评论</p>
</div>
</body>
</html>
<script type="text/javascript">
	var lat = "${fg.lat}";
	var lng = "${fg.lng}";
	var localAdd = "${fg.FGAddress}";
	//alert(localAdd);
	// 百度地图API功能
	var map = new BMap.Map("showMap");
	var point = new BMap.Point(lng,lat);
	map.centerAndZoom(point,12);
	// 创建地址解析器实例
	var myGeo = new BMap.Geocoder();
	// 将地址解析结果显示在地图上,并调整地图视野 
 	myGeo.getPoint(localAdd, function(point){
		if (point) {
			map.centerAndZoom(point, 16);
			map.addOverlay(new BMap.Marker(point));
		}else{
			alert("您选择地址没有解析到结果!");
		}
	}, "宁波市");
</script>