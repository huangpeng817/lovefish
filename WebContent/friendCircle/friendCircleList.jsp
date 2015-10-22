<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>朋友圈列表</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/style/list.css'/>">
<script type="text/javascript"
	src="<c:url value='/script/jquery-1.9.1.min.js'/>"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<br>
	<br>
	<div id="searchPanel">
		<form id="friendCircleForm"
			action="<c:url value='/FriendCircleServlet?method=getFriendCircleList' />"
			method="post">
			<input type="submit" value="朋友圈查询" />
		</form> <br>
		<form id="myfriendCircleForm"
			action="<c:url value='/FriendCircleServlet?method=getMyFriendCircleList' />"
			method="post">
			<input type="submit" value="钓友动态查询" />
		</form>
	</div>
	<br>

	<div id="friendCircleList">
		<ul>
			<c:forEach items="${Items }" var="fc" varStatus="status">
				<li>
					<div class="inner">
						<p>
							<img alt="朋友圈头像" src="${fc.currentHead }" width="30px"
								height="30px">
							${fc.rank }级
							${fc.nickName }
							${fc.publishTime }
							${fc.praiseCount }赞
							${fc.commentCount }评论
						</p>
						<c:set var="photoesStr" value="${fc.photoes }" />
						<c:forEach items="${fn:split(photoesStr,',')}" var="photo"
							begin="0" end="0" varStatus="stat">
							<a
								href="<c:url value='/FriendCircleServlet?method=getDetail&RepGUID=${fc.repGUID }'/>">
								<img alt="朋友圈图片" src="${photo }" border="0" width="192px"
								height="140px">
							</a>
						</c:forEach>
						<p>${fc.content }</p>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	<br><br><br>
	<div id="pagination" align="right">
		<c:choose>
			<c:when test="${pc eq 1 }">
				<a href="javascript:void(0)" disabled='true'>上一页</a>
			</c:when>
			<c:otherwise>
				<a
					href="<c:url value='/FriendCircleServlet?method=getFriendCircleList&pc=${pc-1 }'/>">上一页</a>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${HasElse eq false }">
				<a href="javascript:void(0)" disabled='true'>下一页</a>
			</c:when>
			<c:otherwise>
				<a
					href="<c:url value='/FriendCircleServlet?method=getFriendCircleList&pc=${pc+1 }'/>">下一页</a>
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>