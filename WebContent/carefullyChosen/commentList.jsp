<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论列表</title>
</head>
<body>

	<div id="commentList">
	<ul>
	<c:forEach items="${Items }" var="c" varStatus="status">
		<li>
			<div class="inner">
				<c:set var="photoesStr" value="${c.currentHead }" />
				<c:forEach items="${fn:split(photoesStr,',')}" var="photo" begin="0" end="0" varStatus="stat">
				<%-- <a href="<c:url value='/CarefullyChosenServlet?method=getDetail&Id=${c.id }'/>"> --%>
					<img alt="头像图片" src="${photo }" border="0" width="100px" height="100px">
				<!-- </a> -->
				</c:forEach>
				<div>
					<p>昵称：${c.nickName } &nbsp;&nbsp;&nbsp;&nbsp;发布时间：${c.publishTime }</p>
					<p>评论内容： ${c.content }</p>
				
				</div>
			</div>
		</li>
	</c:forEach>
	</ul>
	</div>
	
	<!-- 分页 -->
	<div id="pagination">
		<c:choose>
			<c:when test="${pc eq 1 }">
				<a href="javascript:void(0)" disabled='true'>上一页</a>
			</c:when>
			<c:otherwise>
				<a href="<c:url value='/CarefullyChosenServlet?method=getCommentList&Id=${Id }&pc=${pc-1 }'/>">上一页</a>
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${HasElse eq false }">
				<a href="javascript:void(0)" disabled='true'>下一页</a>
			</c:when>
			<c:otherwise>
				<a href="<c:url value='/CarefullyChosenServlet?method=getCommentList&Id=${Id }&pc=${pc+1 }'/>">下一页</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>