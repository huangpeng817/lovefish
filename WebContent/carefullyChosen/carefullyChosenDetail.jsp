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
	src="<c:url value='/script/jquery-1.9.1.min.js'/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
<script type="text/javascript" src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		$("#model_save").click(function() {
			$("#submitInput").click();
		});
		
		$("#commnetP").click(function() {
			//alert("commnetP元素被点击了");
			$("#getCommentListForm").submit();
		});
		
		$("#zanP").click(function() {
			alert("zanP元素被点击了");
			//$("#getPrasieListForm").submit();
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
		
		$("#collectBtn").click(function() {
			$.ajax({
				url: "http://120.24.159.207:8081/CMS/Collection/CreateCollection",
				data : {Token: "4h83vlv63o216q8gum9j91qhrn", DeviceNo: "DeviceNo",  Type: "1", Id: newsId},
				type : "POST",
				dataType : "json",
				asyn : false,
				cache : false,
				error : function(XMLResponse) {
					alert("进入error函数");
				},
				success : function(result) {
					if (result.Message == "收藏成功") {
						alert("收藏成功");
						return;
					}
					if (result.Message == "取消成功") {
						alert("取消成功");
						return;
					}
					alert("原来的赞数为：" + zanCount);
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
	
	<form id="getPrasieListForm" action="<c:url value='/CarefullyChosenServlet'/>">
		<input type="hidden" name="method" value="getPrasieList">
		<input type="hidden" name="Id" value="${cc.id }">
	</form>
	
	<div>
	<button id="zanBtn"><img width="100px" height="100px" border="0" alt="点赞图标" src="<c:url value='/style/images/zan.png'/>"></button>
	
	<!-- 按钮触发模态框 -->
	<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">
 		<img width="100px" height="100px" border="0" alt="评论图标" src="<c:url value='/style/images/comment.png'/>">
	</button>
	<!-- 模态框 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-describedby="描述信息">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">添加评论</h4>
	      </div>
	      <div class="modal-body">
	        	<!-- 填写的内容 -->
	        	<form action="<c:url value='/CarefullyChosenServlet'/>" method="post">
					<input type="hidden" name="method" value="addComment">
					<input type="hidden" name="Id" value="${cc.id }">
					<textarea rows="" cols="" name="Content"></textarea>
					<input id="submitInput" type="submit" value="发送" style="display: none;"> 
				</form>
	      </div>
	      <div class="modal-footer">
	        <!-- <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> -->
	        <button type="button" class="btn btn-primary" id="model_save">发送</button>
	      </div>
	    </div>
	  </div>
	</div>
	<%-- <a id="commentA" href="<c:url value='/CarefullyChosenServlet?method=addCommentUI&NewsID=${cc.id }'/>">
		<img width="100px" height="100px" border="0" alt="评论图标" src="<c:url value='/style/images/comment.png'/>">
	</a> --%>
	
	
	<button id="collectBtn"><img width="100px" height="100px" border="0" alt="收藏图标" src="<c:url value='/style/images/collect.jpg'/>"></button>
	</div>
</body>
</html>