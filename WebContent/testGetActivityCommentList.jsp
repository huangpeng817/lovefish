<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>活动评价列表</title>
<script type="text/javascript"
	src="<c:url value='/jquery-1.9.1.min.js'/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({
			url : "http://120.24.159.207:8081/CMS/News/ActivityCommentList?Id=1&PageIndex=1&Count=1",
			//data: {Id: "1", PageIndex: "1", Count: "1"},
			type : "POST",
			dataType : "json",
			asyn : false,
			cache : false,
			success : function(result) {
				document.write(result.Data.Items[0].CurrentHead);
				//alert(result.Data.Items[0].CurrentHead);
				$("#headImg").attr("src", result.Data.Items[0].CurrentHead);
				//alert($("#headImg").attr("src"));
			},
			error : function(XMLResponse) {
				alert("进入error函数");
				alert(arguments[1]);
				
				alert(XMLResponse.responseText);
			}
		});
	});

</script>

</head>
<body>
	活动评价列表页面<br><br>
	下面是头像：<br>
	
	<img id="headImg" alt="头像" src="">
	

	<!-- 
				PageIndex 分页 Int32 
                Count 数量 Int32 
                Lng 经度 Double 
                Lat 纬度 Double 
                RegionID 城市ID Int64 默认值：0
                Sort 默认 = 0,人气 = 1, 距离 = 2,等级 = 3, Int32 默认值：0
     -->
	<form action="http://120.24.159.207:8081/CMS/News/GetFishingPointList"
		method="get">
		<input type="hidden" name="PageIndex" value="1" /> <input
			type="hidden" name="Count" value="20" /> <input type="hidden"
			name="Lng" value="121.556652" /> <input type="hidden" name="Lat"
			value="29.8088" /> <input type="hidden" name="RegionID" value="0" />
		<input type="hidden" name="Sort" value="0" />
		<!-- <input type="submit" value="查询"> -->
	</form>

</body>
</html>