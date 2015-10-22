<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>朋友圈详情页面</title>
<script type="text/javascript"
	src="<c:url value='/script/jquery-1.9.1.min.js'/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
<script type="text/javascript" src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
<script type="text/javascript">

</script>
</head>
<body>
----朋友圈详情页面----
	<br>
	<br>
	<p>
	<img alt="朋友圈头像" src="${fc.currentHead }" width="30px" height="30px">
	${fc.rank }级
	${fc.nickName }
	${fc.publishTime }
	</p>

	<!-- 循环展示所有的图片 -->
	<div>
	<c:set var="photoesStr" value="${fc.photoes }" />
	<c:forEach items="${fn:split(photoesStr,',')}" var="photo"
		varStatus="stat">
		<img alt="钓点图片" src="${photo }" border="0" width="200px"
			height="200px">
	</c:forEach>
	<p>${fc.content }</p>
	</div>
	
	<%-- <p id="zanP" align="right"><span id="zan">${cc.praiseCount }</span>&nbsp;赞</p>
	<p id="commnetP" align="right">${cc.commentCount }&nbsp;评论</p> --%>
	
	<%-- <div>
	<c:forEach items="${fc.commClass }" var="cc">
		<p>
		<img alt="头像" src="${cc.headUrl }" width="100px" height="100px">
		</p>
		<p>${cc.nickName } ${cc.rank }级</p>
		<p>${cc.commTime }</p>
		<p>${cc.content }</p>
	</c:forEach>
	</div> --%>
	
	
	<div class="tabbable" id="tabs-134499">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#panel-112380" data-toggle="tab">评价${fc.commentCount }</a>
						</li>
						<li><a href="#panel-990988" data-toggle="tab">点赞${fc.praiseCount }</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="panel-112380">
							<p>
								<c:forEach items="${fc.commClass }" var="cc">
								<p>
									<img alt="头像" src="${cc.headUrl }" width="100px" height="100px">
								</p>
								<p>${cc.nickName } ${cc.rank }级</p>
								<p>${cc.commTime }</p>
								<p>${cc.content }</p>
								</c:forEach>
							</p>
						</div>
						<div class="tab-pane" id="panel-990988">
							<p>
								<c:forEach items="${fc.praiseClass }" var="pc">
								<p>
									<img alt="头像" src="${pc.headUrl }" width="100px" height="100px">
									${pc.nickName } ${pc.rank }级
								</p>
								<%-- <p>${pc.nickName } ${pc.rank }级</p> --%>
								</c:forEach>
							</p>
						</div>
					</div>
	</div>
	
	
	<div align="right">
	<button id="zanBtn"><img width="100px" height="100px" border="0" alt="点赞图标" src="<c:url value='/style/images/zan.png'/>"></button>
	<a id="commentA" href="<c:url value='/CarefullyChosenServlet?method=addCommentUI&NewsID=${cc.id }'/>"><img width="100px" height="100px" border="0" alt="评论图标" src="<c:url value='/style/images/comment.png'/>"></a>
<%-- 	<button id="commentBtn"><img width="100px" height="100px" border="0" alt="评论图标" src="<c:url value='/style/images/comment.png'/>"></button> --%>
	</div>
</body>
</html>