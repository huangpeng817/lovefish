<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱渔动态</title>
<script type="text/javascript"
	src="<c:url value='/script/jquery-1.9.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/script/jquery.cookie.js'/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
<script type="text/javascript" src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
<script type="text/javascript">
	
</script>
<style type="text/css">
	#list1 li, #list2 li, #list3 li, #list4 li {
		float: left;
		list-style: none;
		width: 250px;
		height: 250px;
	}
	
	#tabs li {
		width: 25%;
	}
</style>
</head>
<body>
	<br>
	<br>
	<div id="searchPanel">
		<form id="searchForm" action="<c:url value='/LoveFishDynamicServlet?method=initLoad'/>" method="post">
			<input type="button" value="国际新闻查询" onclick="getList(1)">
			<input id="tabId" type="hidden" name="tabIndex" value="1">
		</form>
	</div>
	<br>
	
	<!-- 选项卡 -->
	<div class="tabbable" id="tabs-134499">
			<ul class="nav nav-tabs" id="tabs">
				<li id="gjxwLi" class="active"><a href="#panel-112380" data-toggle="tab"  onclick="getList(1)">国际新闻</a>
				</li>
				<li id="gnxwLi"><a href="#panel-990988" data-toggle="tab" onclick="getList(2)">国内新闻</a></li>
				<li id="gjssLi"><a href="#panel-777777" data-toggle="tab" onclick="getList(3)">国际赛事</a></li>
				<li id="gnssLi"><a href="#panel-666666" data-toggle="tab" onclick="getList(4)">国内赛事</a></li>
			</ul>
			<div class="tab-content">
				<!-- 国际新闻 -->
				<div class="tab-pane active" id="panel-112380">
					<ul id="list1">
					<c:forEach items="${Items }" var="cc" varStatus="status">
						<li>
							<div class="inner">
								<c:set var="photoesStr" value="${cc.imgURL }" />
								<c:forEach items="${fn:split(photoesStr,',')}" var="photo" begin="0" end="0" varStatus="stat">
								<a href="<c:url value='/CarefullyChosenServlet?method=getDetail&Id=${cc.id }'/>">
									<img alt="钓点图片" src="${photo }" border="0" width="100px" height="100px">
								</a>
								</c:forEach>
								<p>${cc.title }</p>
								<p>爱渔社区 ${cc.publishTime }</p>
								<p>${cc.praiseCount }赞 ${cc.commentCount }评论</p>
							</div>
						</li>
					</c:forEach>
					</ul>
				</div>
				<!-- 国内新闻 -->
				<div class="tab-pane" id="panel-990988">
					<ul id="list2">
					<c:forEach items="${Items }" var="cc" varStatus="status">
						<li>
							<div class="inner">
								<c:set var="photoesStr" value="${cc.imgURL }" />
								<c:forEach items="${fn:split(photoesStr,',')}" var="photo" begin="0" end="0" varStatus="stat">
								<a href="<c:url value='/CarefullyChosenServlet?method=getDetail&Id=${cc.id }'/>">
									<img alt="钓点图片" src="${photo }" border="0" width="100px" height="100px">
								</a>
								</c:forEach>
								<p>${cc.title }</p>
								<p>爱渔社区 ${cc.publishTime }</p>
								<p>${cc.praiseCount }赞 ${cc.commentCount }评论</p>
							</div>
						</li>
					</c:forEach>
					</ul>
					
				</div>
				<!-- 国际赛事 -->
				<div class="tab-pane" id="panel-777777">
					<ul id="list3">
					<c:forEach items="${Items }" var="cc" varStatus="status">
						<li>
							<div class="inner">
								<c:set var="photoesStr" value="${cc.imgURL }" />
								<c:forEach items="${fn:split(photoesStr,',')}" var="photo" begin="0" end="0" varStatus="stat">
								<a href="<c:url value='/CarefullyChosenServlet?method=getDetail&Id=${cc.id }'/>">
									<img alt="钓点图片" src="${photo }" border="0" width="100px" height="100px">
								</a>
								</c:forEach>
								<p>${cc.title }</p>
								<p>爱渔社区 ${cc.publishTime }</p>
								<p>${cc.praiseCount }赞 ${cc.commentCount }评论</p>
							</div>
						</li>
					</c:forEach>
					</ul>
				</div>
				<!-- 国内赛事 -->
				<div class="tab-pane" id="panel-666666">
					<ul id="list4">
					<c:forEach items="${Items }" var="cc" varStatus="status">
						<li>
							<div class="inner">
								<c:set var="photoesStr" value="${cc.imgURL }" />
								<c:forEach items="${fn:split(photoesStr,',')}" var="photo" begin="0" end="0" varStatus="stat">
								<a href="<c:url value='/CarefullyChosenServlet?method=getDetail&Id=${cc.id }'/>">
									<img alt="钓点图片" src="${photo }" border="0" width="100px" height="100px">
								</a>
								</c:forEach>
								<p>${cc.title }</p>
								<p>爱渔社区 ${cc.publishTime }</p>
								<p>${cc.praiseCount }赞 ${cc.commentCount }评论</p>
							</div>
						</li>
					</c:forEach>
					</ul>
				</div>
			</div>
	</div>	
	
	<!-- 分页 -->
	<div id="pagination">
		<p>
		<c:choose>
			<c:when test="${pc eq 1 }">
				<a href="javascript:void(0)" disabled='true'>上一页</a>
			</c:when>
			<c:otherwise>
				<a id="prePage" href="<c:url value='/LoveFishDynamicServlet?method=initLoad&pc=${pc-1 }&tabIndex=${tabIndex }'/>">上一页</a>
			</c:otherwise>
		</c:choose>
		</p>
		
		<p>
		<c:choose>
			<c:when test="${HasElse eq false }">
				<a href="javascript:void(0)" disabled='true'>下一页</a>
			</c:when>
			<c:otherwise>
				<a id="nextPage" href="<c:url value='/LoveFishDynamicServlet?method=initLoad&pc=${pc+1 }&tabIndex=${tabIndex }'/>">下一页</a>
			</c:otherwise>
		</c:choose>
		</p>
	</div>
	
</body>
<script type="text/javascript">
	function getList(index) {
		$("#tabId").val(index);
		$("#searchForm").submit();
		$.cookie('tabIndex', index);
	}
	$(function(){
		var index = $.cookie('tabIndex');
		if (index == "1") {
			$("#gjxwLi").attr("class","active");
			$("#gnxwLi").attr("class","");
			$("#gjssLi").attr("class","");
			$("#gnssLi").attr("class","");
		}
		if (index == "2") {
			$("#gjxwLi").attr("class","");
			$("#gnxwLi").attr("class","active");
			$("#gjssLi").attr("class","");
			$("#gnssLi").attr("class","");
		}
		if (index == "3") {
			$("#gjxwLi").attr("class","");
			$("#gnxwLi").attr("class","");
			$("#gjssLi").attr("class","active");
			$("#gnssLi").attr("class","");
		}
		if (index == "4") {
			$("#gjxwLi").attr("class","");
			$("#gnxwLi").attr("class","");
			$("#gjssLi").attr("class","");
			$("#gnssLi").attr("class","active");
		}
	});
	
</script>
</html>