<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>装备评测</title>
<script type="text/javascript"
	src="<c:url value='/script/jquery-1.9.1.min.js'/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
<script type="text/javascript" src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
<script type="text/javascript">
	
</script>
<style type="text/css">
	#list1 li, #list2 li, #list3 li {
		/* border: 1px solid red; */
		float: left;
		list-style: none;
		width: 250px;
		height: 250px;
	}
	
	#tabs li {
		width: 33%;
	}
</style>
</head>
<body>
	<ul id="list2">
		<c:forEach items="${Items }" var="cc" varStatus="status">
			<li>
				<div class="inner">
					<c:set var="photoesStr" value="${cc.imgURL }" />
					<c:forEach items="${fn:split(photoesStr,',')}" var="photo"
						begin="0" end="0" varStatus="stat">
						<a
							href="<c:url value='/CarefullyChosenServlet?method=getDetail&Id=${cc.id }'/>">
							<img alt="钓点图片" src="${photo }" border="0" width="100px"
							height="100px">
						</a>
					</c:forEach>
					<p>${cc.title }</p>
					<p>爱渔社区 ${cc.publishTime }</p>
					<p>${cc.praiseCount }赞${cc.commentCount }评论</p>
				</div>
			</li>
		</c:forEach>
	</ul>
</body>
</html>