<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test页面</title>
<script type="text/javascript"
	src="<c:url value='/jquery-1.9.1.min.js'/>"></script>
<script type="text/javascript">
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
			}
			
		});
	});
</script>
</head>
<body>

	<br>
	<br>
	<div id="searchPanel">
		<form id="myForm"
			action="<c:url value='/TestServlet?method=findAll' />" method="post">

		<input id="Lat" type="hidden" name="Lat" value="">
		<input id="Lng" type="hidden" name="Lng" value="">
		<input id="Region" type="hidden" name="Region" value="">
		
			<select name="condition">
				<option <c:if test="${condition eq '默认'}">selected</c:if>>默认</option>
				<option <c:if test="${condition eq '人气'}">selected</c:if>>人气</option>
				<option <c:if test="${condition eq '距离'}">selected</c:if>>距离</option>
			</select> &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="查询" />
		</form>
	</div>
	<br>

	<table align="center" border="1" width="70%" cellpadding="0"
		cellspacing="0">
		<thead>
			<tr>
				<th>序号</th>
				<th>钓点名称</th>
				<th>钓点位置</th>
				<th>距离</th>
			<tr>
		</thead>
		<tbody>
			<c:forEach items="${Items }" var="fp" varStatus="status">
				<tr>
					<td>${status.index + 1 }</td>
					<td>${fp.name }</td>
					<td>${fp.localAdd }</td>
					<td>${fp.distance }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<center>
		<c:choose>
			<c:when test="${pc eq 1 }">
				<a href="javascript:void(0)" disabled='true'>上一页</a>
			</c:when>
			<c:otherwise>
				<a href="<c:url value='/TestServlet?method=findAll&Lat=${Lat }&Lng=${Lng }&Region=${Region }&RegionID=${RegionID }&condition=${condition }&Sort=${Sort }&pc=${pc-1 }'/>">上一页</a>
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${HasElse eq false }">
				<a href="javascript:void(0)" disabled='true'>下一页</a>
			</c:when>
			<c:otherwise>
				<a href="<c:url value='/TestServlet?method=findAll&Lat=${Lat }&Lng=${Lng }&Region=${Region }&RegionID=${RegionID }&condition=${condition }&Sort=${Sort }&pc=${pc+1 }'/>">下一页</a>
			</c:otherwise>
		</c:choose>
	</center>

</body>
</html>