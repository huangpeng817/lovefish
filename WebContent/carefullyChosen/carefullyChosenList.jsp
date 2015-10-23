<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱渔精选</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/style/list.css'/>">
<script type="text/javascript"
	src="<c:url value='/script/jquery-1.9.1.min.js'/>"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<br>
	<br>
	<div id="searchPanel">
		<form id="carefullyChosenForm"
			action="<c:url value='/CarefullyChosenServlet?method=findAll' />"
			method="post">
			<input type="submit" value="精选查询" />
		</form>
	</div>
	<br>
	
	<div id="carefullyChosenList">
	<ul>
	<c:forEach items="${Items }" var="cc" varStatus="status">
		<li>
			<div class="inner">
				<c:set var="photoesStr" value="${cc.imgURL }" />
				<c:forEach items="${fn:split(photoesStr,',')}" var="photo" begin="0" end="0" varStatus="stat">
				<a href="<c:url value='/CarefullyChosenServlet?method=getDetail&Id=${cc.id }'/>">
					<img alt="钓点图片" src="${photo }" border="0" width="100px" height="100px">
				</a>
				</c:forEach>
				<p>${cc.title }</p>
				<p>${cc.newsSource } ${cc.publishTime }</p>
			</div>
		</li>
	</c:forEach>
	</ul>
	</div>
	
	<div id="pagination">
		<c:choose>
			<c:when test="${pc eq 1 }">
				<a href="javascript:void(0)" disabled='true'>上一页</a>
			</c:when>
			<c:otherwise>
				<a href="<c:url value='/CarefullyChosenServlet?method=findAll&pc=${pc-1 }'/>">上一页</a>
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${HasElse eq false }">
				<a href="javascript:void(0)" disabled='true'>下一页</a>
			</c:when>
			<c:otherwise>
				<a href="<c:url value='/CarefullyChosenServlet?method=findAll&pc=${pc+1 }'/>">下一页</a>
			</c:otherwise>
		</c:choose>
	</div>
	
</body>
</html>