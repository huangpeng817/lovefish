<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>钓友列表</title>
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
	<div id="searchPanel">
		<form id="friendForm"
			action="<c:url value='/FriendServlet?method=getFriendList' />"
			method="post">
			<input type="submit" value="朋友列表查询" />
		</form> <br>
		<form id="nearbyFriendForm"
			action="<c:url value='/FriendServlet?method=getNearbyFriendList' />"
			method="post">
			<input type="submit" value="附近朋友列表查询" />
		</form>
		<div align="right">
		<a href="<c:url value='/friend/addFriend.jsp'/>">
			<%-- <img width="100px" height="100px" src="<c:url value='/style/images/sendDynamic.jpg'/>"> --%>
			添加好友
		</a>
		</div>
	</div>
	<br>

	<div id="friendList">
		<ul>
			<c:forEach items="${Items }" var="f" varStatus="status">
				<li>
					<div class="inner">
						<p>
							<a href="<c:url value='/FriendCircleServlet?method=getFriendCircleListByUserID&UserID=${f.HXAccount }'/>">
							<img src="${f.head }" width="30px"
								height="30px">
							</a>	
							${f.nickName }
							<a href="<c:url value='/FriendServlet?method=deleteFriend&FriendID=${f.HXAccount }'/>">
								删除好友
							</a>
						</p>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>