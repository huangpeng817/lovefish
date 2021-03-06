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
$(document).ready(function () {
	$.ajax({
		url: "<c:url value='/FriendCircleServlet'/>",
		data: {method: "getCurrentUser"},
		type : "POST",
		dataType : "json",
		asyn : false,
		cache : false,
		error : function(XMLResponse) {
			alert("进入error函数");
		},
		success : function(result) {
			$("#WallPaper").attr("src", result.WallPaper);
			$("#Head").attr("src", result.Head);
			$("#NickName").text("昵称: " + result.NickName);
			$("#Friends").text("好友数: " + result.Friends);
			$("#Gender").text("性别: " + result.Gender);
			$("#Rank").text("等级: " + result.Rank);
		}    
		     
	});       
});
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
			action="<c:url value='/FriendCircleServlet?method=getMyFriendDynamicList' />"
			method="post">
			<input type="submit" value="钓友动态查询" />
		</form>
		<div align="right">
		<a href="<c:url value='/FriendCircleServlet?method=addDynamicUI'/>">
			<img width="100px" height="100px" alt="发布钓友圈" src="<c:url value='/style/images/sendDynamic.jpg'/>">
		</a>
		</div>
	</div>
	<br>
	
	<div id="getCurrentUser" style="width: 1000px">
		<div>
			<img style="float: left;" id="WallPaper" src="">
		</div>
		<div style="position: relative; top: 50px; left: -300px"><!-- absolute -->
			<div><img id="Head" src=""></div>
			<p id="NickName">昵称</p>
			<p id="Friends">好友数</p>
			<p id="Gender">性别</p>
			<p id="Rank">等级</p>
		</div>
	</div>

	<div id="friendCircleList">
		<ul>
			<c:forEach items="${Items }" var="fc" varStatus="status">
				<li>
					<div class="inner">
						<p>
							<a href="<c:url value='/FriendCircleServlet?method=getFriendCircleListByUserID&UserID=${fc.HXAccount }'/>">
							<img alt="朋友圈头像" src="${fc.currentHead }" width="30px"
								height="30px">
							</a>	
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