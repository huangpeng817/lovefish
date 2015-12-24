<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>附近的人</title>
</head>
<%-- <link rel="stylesheet" type="text/css"
	href="<c:url value='/style/list.css'/>"> --%>
<script type="text/javascript"
	src="<c:url value='/script/jquery-1.9.1.min.js'/>"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<br>
	<br>
	<div id="nearbyFriendList">
		<ul>
			<c:forEach items="${Items }" var="user" varStatus="status">
				<li>
					<div class="inner">
						<p>
							<a href="<c:url value='/FriendCircleServlet?method=getFriendCircleListByUserID&UserID=${user.HXAccount }'/>">
							<img src="${user.head }" width="30px"
								height="30px">
							</a>	
							${user.nickName }
							${user.dinstince }km
						</p>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	<br><br><br>
	<div id="pagination" align="center">
		<c:choose>
			<c:when test="${pc eq 1 }">
				<a href="javascript:void(0)" disabled='true'>上一页</a>
			</c:when>
			<c:otherwise>
				<a
					href="<c:url value='/FriendServlet?method=getNearbyFriendList&pc=${pc-1 }'/>">上一页</a>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${HasElse eq false }">
				<a href="javascript:void(0)" disabled='true'>下一页</a>
			</c:when>
			<c:otherwise>
				<a
					href="<c:url value='/FriendServlet?method=getNearbyFriendList&pc=${pc+1 }'/>">下一页</a>
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>
