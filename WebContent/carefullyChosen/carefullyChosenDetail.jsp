<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱渔精选详情页面</title>
<script type="text/javascript"
	src="<c:url value='/jquery-1.9.1.min.js'/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		$("#commnetP").click(function() {
			//alert("commnetP元素被点击了");
			$("#getCommentListForm").submit();
		});
		
		var newsId = "${cc.id }";
		$("#zanBtn").click(function() {
			$.ajax({
				url: "http://120.24.159.207:8081/CMS/News/NewsPraise",
				data : {Token: "4h83vlv63o216q8gum9j91qhrn", DeviceNo: "DeviceNo", PraiseOrCancel: "1", NewsID: newsId},
				type : "POST",
				dataType : "json",
				asyn : false,
				cache : false,
				error : function(XMLResponse) {
					alert("进入error函数");
				},
				success : function(result) {
					if (result.Message == "今天已点赞") {
						alert("今天已点赞");
						return;
					}
					var zanCount = parseInt($("#zan").text());
					//alert("原来的赞数为：" + zanCount);
					$("#zan").text(zanCount + 1);
				}
				
			});
		});
	});
</script>
</head>
<body>
	----爱渔精选详情页面----
	<br>
	<br>
	<!-- 循环展示所有的图片 -->
	<%-- <c:set var="photoesStr" value="${cc.imgURL }" />
	<c:forEach items="${fn:split(photoesStr,',')}" var="photo"
		varStatus="stat">
		<img alt="钓点图片" src="${photo }" border="0" width="200px"
			height="200px">
	</c:forEach> --%>

	<p>资讯标题：<strong>${cc.title }</strong></p>
	<p>文章属于的分类：${cc.categoryTop }</p>
	<p>发布时间：${cc.publishTime }</p>
	<p id="zanP" align="right"><span id="zan">${cc.praiseCount }</span>&nbsp;赞</p>
	<p id="commnetP" align="right">${cc.commentCount }&nbsp;评论</p>
	<p><strong>内容：</strong>${cc.content }</p>
	<p>文章来源: ${cc.newSource }</p>
	
	<form id="getCommentListForm" action="<c:url value='/CarefullyChosenServlet'/>">
		<input type="hidden" name="method" value="getCommentList">
		<input type="hidden" name="Id" value="${cc.id }">
	</form>
	
	<div>
	<button id="zanBtn"><img width="100px" height="100px" border="0" alt="点赞图标" src="<c:url value='/style/images/zan.png'/>"></button>
	<a id="commentA" href="<c:url value='/CarefullyChosenServlet?method=addCommentUI&NewsID=${cc.id }'/>"><img width="100px" height="100px" border="0" alt="评论图标" src="<c:url value='/style/images/comment.png'/>"></a>
<%-- 	<button id="commentBtn"><img width="100px" height="100px" border="0" alt="评论图标" src="<c:url value='/style/images/comment.png'/>"></button> --%>
	</div>
</body>
</html>