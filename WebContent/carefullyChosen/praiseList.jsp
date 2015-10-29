<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>点赞列表</title>
</head>
<body>

	<div id="praiseList">
	<ul>
	<c:forEach items="${Items }" var="p" varStatus="status">
		<li>
			<div class="inner">
				<img alt="头像图片" src="${p.headUrl }" border="0" width="100px" height="100px">
				&nbsp;&nbsp;${p.nickName }&nbsp;&nbsp;${p.rank }级
				
<%-- 				<img alt="头像图片" src="${p.headUrl }" border="0" width="100px" height="100px">
				<div>
					<p>昵称：${p.nickName } &nbsp;&nbsp;&nbsp;&nbsp;${p.rank }级</p>
				
				</div> --%>
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
				<a href="<c:url value='/CarefullyChosenServlet?method=getPrasieList&Id=${Id }&pc=${pc-1 }'/>">上一页</a>
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${HasElse eq false }">
				<a href="javascript:void(0)" disabled='true'>下一页</a>
			</c:when>
			<c:otherwise>
				<a href="<c:url value='/CarefullyChosenServlet?method=getPrasieList&Id=${Id }&pc=${pc+1 }'/>">下一页</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>