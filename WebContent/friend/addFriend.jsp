<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加好友</title>
</head>
<body>
	<hr>
	<div align="center">
		<form action="<c:url value='/FriendServlet'/>" method="post">
			<input type="hidden" name="method" value="GetUserListByKey">
			<input type="text" name="keyStr" value="${keyStr }" placeholder="输入昵称或手机号">
			<input type="submit" value="查询">
		</form>
	</div>
	
	<br>
	<hr>
	<h2>${msg }</h2>
	<div id="userListByKey">
		<ul>
			<c:forEach items="${Items }" var="user" varStatus="status">
				<li>
					<div class="inner">
						<p>
							<%-- <a href="<c:url value='/FriendCircleServlet?method=getFriendCircleListByUserID&UserID=${user.HXAccount }'/>"> --%>
							<img src="${user.head }" width="30px"
								height="30px">
							<!-- </a> -->	
							${user.nickName }
							
							<a href="<c:url value='/FriendServlet?method=addFriend&ApplyID=${user.HXAccount }'/>">加好友</a>
							${user.HXAccount }
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
					href="<c:url value='/FriendServlet?method=GetUserListByKey&pc=${pc-1 }&keyStr=${keyStr }'/>">上一页</a>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${HasElse eq false }">
				<a href="javascript:void(0)" disabled='true'>下一页</a>
			</c:when>
			<c:otherwise>
				<a
					href="<c:url value='/FriendServlet?method=GetUserListByKey&pc=${pc+1 }&keyStr=${keyStr }'/>">下一页</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>