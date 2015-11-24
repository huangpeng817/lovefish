<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱渔百科</title>
<%-- <link rel="stylesheet" type="text/css" href="<c:url value='/style/list.css'/>"> --%>
<script type="text/javascript"
	src="<c:url value='/script/jquery-1.9.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/script/jquery.cookie.js'/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
<script type="text/javascript" src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
<script type="text/javascript">
	
</script>
<style type="text/css">
	#list1 li, #list2 li, #list3 li {
		/* border: 1px solid red; */
		float: left;
		list-style: none;
		width: 250px;
		height: 250px;
	}
	
	#tabs li {
		width: 33%;
	}
</style>
</head>
<body>
	<br>
	<br>
	<div id="searchPanel">
		<form id="jcjyForm" action="<c:url value='/EncyclopediaServlet?method=initLoad'/>" method="post">
			<input type="button" value="教程经验查询" onclick="getJCJYList()">
			<input type="hidden" name="tabIndex" value="1">
		</form>
		<form id="zbpcForm" action="<c:url value='/EncyclopediaServlet?method=getZBPCList'/>" method="post">
			<input type="hidden" name="tabIndex" value="2">
		</form>
		<form id="syhForm" action="<c:url value='/EncyclopediaServlet?method=getSYHList'/>" method="post">
			<input type="hidden" name="tabIndex" value="3">
		</form>
	</div>
	<br>
	
	<!-- 选项卡 -->
	<div class="tabbable" id="tabs-134499">
			<ul class="nav nav-tabs" id="tabs">
				<li id="jcjyLi" class="active"><a href="#panel-112380" data-toggle="tab"  onclick="getJCJYList()">教程经验</a>
				</li>
				<li id="zbpcLi"><a href="#panel-990988" data-toggle="tab" onclick="getZBPCList()">装备评测</a></li>
				<li id="syhLi"><a href="#panel-777777" data-toggle="tab" onclick="getSYHList()">食渔汇</a></li>
			</ul>
			<div class="tab-content">
				<!-- 教程经验。。。 -->
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
				<!-- 装备评测。。。 -->
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
				<!-- 食渔汇。。。 -->
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
				<a href="<c:url value='/EncyclopediaServlet?method=initLoad&pc=${pc-1 }'/>">上一页</a>
			</c:otherwise>
		</c:choose>
		</p>
		
		<p>
		<c:choose>
			<c:when test="${HasElse eq false }">
				<a href="javascript:void(0)" disabled='true'>下一页</a>
			</c:when>
			<c:otherwise>
				<a href="<c:url value='/EncyclopediaServlet?method=initLoad&pc=${pc+1 }'/>">下一页</a>
			</c:otherwise>
		</c:choose>
		</p>
	</div>
	
</body>
<script type="text/javascript">
	function getJCJYList() {
		$.cookie('tabIndex', null);
		$.cookie('tabIndex', '1');
		$("#jcjyForm").submit();
		//alert("选项卡1： " + $.cookie('tabIndex'));
	}
	function getZBPCList() {
		$.cookie('tabIndex', null);
		$.cookie('tabIndex', '2');
		$("#zbpcForm").submit();
		//alert("选项卡2： " + $.cookie('tabIndex'));
	}
	function getSYHList() {
		$.cookie('tabIndex', null);
		$.cookie('tabIndex', '3');
		$("#syhForm").submit();
		//alert("选项卡3： " + $.cookie('tabIndex'));
	}
	
	$(function(){
		
		var index = $.cookie('tabIndex');
		if (index == "1") {
			$("#jcjyLi").attr("class","active");
			$("#zbpcLi").attr("class","");
			$("#syhLi").attr("class","");
		}
		if (index == "2") {
			$("#jcjyLi").attr("class","");
			$("#zbpcLi").attr("class","active");
			$("#syhLi").attr("class","");
		}
		if (index == "3") {
			$("#jcjyLi").attr("class","");
			$("#zbpcLi").attr("class","");
			$("#syhLi").attr("class","active");
		}
		//alert("页面加载的值：" + index);
		$.cookie('tabIndex', null);
	});
	
</script>
</html>