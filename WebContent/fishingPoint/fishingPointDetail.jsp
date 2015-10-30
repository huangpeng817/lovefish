<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>钓点详情页面</title>
</head>
<body>
	----钓点详情页面----
	<br>
	<br>
	<c:set var="photoesStr" value="${fp.photoes }" />
	<c:forEach items="${fn:split(photoesStr,',')}" var="photo"
		varStatus="stat">
		<img alt="钓点图片" src="${photo }" border="0" width="200px"
			height="200px">
	</c:forEach>

	<p>${fp.name } <span style="color: blue; font-size: xx-large;">${fp.pointType }</span></p>
	<p>联系人：${fp.linkName }</p>
	<p>地址：${fp.localAdd }</p>
	<p>鱼种：${fp.fishType }</p>
	<p>${fp.cashType }</p>
	<p>简介：${fp.content }</p>
	<p>${fp.praiseCount }赞</p>
	<p>${fp.commentCount }评论</p>
</body>
</html>