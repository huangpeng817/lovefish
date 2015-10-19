<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>钓点列表</title>
<script type="text/javascript"
	src="<c:url value='/jquery-1.9.1.min.js'/>"></script>
<script type="text/javascript">
	  $(document).ready(function() {
		  
		$.ajax({
			url : "http://app.ifishing.com.cn:8081/CMS/News/GetFishingPointList?Count=1000&Lat=29.81513065850262&Lng=121.5629947456772&PageIndex=1&RegionID=115&Sort=2",
			/* data: {Token: "4h83vlv63o216q8gum9j91qhrn", DeviceNo: "DeviceNo"}, */
			data: {Token: "1pqfosdk9e4p6qb0433qq8bi9a", DeviceNo: "DeviceNo"},
			type : "POST",
			dataType : "json",
			asyn : false,
			cache : false,
			error : function(XMLResponse) {
				alert("进入error函数");
				alert(arguments[1]);
				
				alert(XMLResponse.responseText);
			},
			success : function(result) {
				alert("成功");
				var jsonStr = JSON.stringify(result.Data); 
				
				alert(jsonStr);
				/*$("#jsonStr").val(jsonStr);
				$("#formId").submit(); */
				
				/* $.ajax({
					url : "/lovefish/TestServlet",
					data: {method: "init", jsonStr: jsonStr},
					type : "POST",
					dataType : "json",
					asyn : false,
					cache : false,	
				}); */
				
				//var jsonObj = JSON.parse(jsonStr);
				
				//alert(jsonObj.Code);
				
				//$("#listTab").append("<tr>");
				
				//myImg  myPlace  myDistance  myStar  myComment
				
				/* $("#myImg").attr("src", result.Data.Items[0].Photoes[0]);
				$("#myPlace").text(result.Data.Items[0].LocalAdd);
				$("#myDistance").text(result.Data.Items[0].Distance);
				$("#myStar").text(result.Data.Items[0].Level);
				$("#myComment").text(result.Data.Items[0].CommentCount);
				
				$("#myImg1").attr("src", result.Data.Items[1].Photoes[0]);
				$("#myPlace1").text(result.Data.Items[1].LocalAdd);
				$("#myDistance1").text(result.Data.Items[1].Distance);
				$("#myStar1").text(result.Data.Items[1].Level);
				$("#myComment1").text(result.Data.Items[1].CommentCount); */
				
				
				//for (var i = 1; i <= result.Data.Count; i++) {
					/* document.write("第"+(i+1)+"条数据：&nbsp;&nbsp;&nbsp;&nbsp;");
					document.write(result.Data.Items[i].Name+"&nbsp;&nbsp;&nbsp;&nbsp;");
					document.write(result.Data.Items[i].Photoes[0]+"&nbsp;&nbsp;&nbsp;&nbsp;");
					document.write(result.Data.Items[i].LocalAdd+"<br>"); */
					
					/* if(i % 4 == 0) {
						$("#listTab").append("</tr><tr>");
					}
					$("#listTab").append("<td>"+ i +"</td>"); */
					
					//alert($("#listTab").html());
				//}
			}
		});
	});

</script>

</head>
<body>

<%-- <form id="formId" action="<c:url value='/TestServlet?method=init' />" method="post">
	<!-- <input type="submit"/ value="提交" style="">			 -->
	<input id="jsonStr" type="hidden" name="jsonStr"/>
</form> --%>


	钓点列表页面1111<br><br>
	<table align="center" border="1" width="100%" cellpadding="0" cellspacing="0">
		<thead><tr><th>钓点名称</th><th>钓点位置</th></tr></thead>
		<tbody>
			<tr><td>名称1</td><td>位置1</td></tr>
	
			<c:forEach items="${data.Items }" var="fp">
			<tr>
				<td>${fp.name }</td>
				<td>${fp.localAdd }</td>
			</tr>
			</c:forEach>
	
		</tbody>
	</table>
	
	<%-- 用户名：${username } --%>
	
	
	<div id="myDiv">
		<table border="1" style="border-collapse: collapse;">
			<tr><td rowspan="3"><img id="myImg" alt="钓点图片" src="" width="150px" height="120px"/></td><td id="myPlace">孵化园钓点</td><td></td></tr>
			<tr><td id="myDistance">距离你10km</td><td></td></tr>
			<tr><td id="myStar">四个星</td><td id="myComment">0评论</td></tr>
		</table>
		<table border="1" style="border-collapse: collapse;">
			<tr><td rowspan="3"><img id="myImg1" alt="钓点图片" src="" width="150px" height="120px"/></td><td id="myPlace1">孵化园钓点</td><td></td></tr>
			<tr><td id="myDistance1">距离你10km</td><td></td></tr>
			<tr><td id="myStar1">四个星</td><td id="myComment1">0评论</td></tr>
		</table>
	</div>
	
	
	<table id="listTab" border="1" style="border-collapse: collapse;">
		<!-- <tr><td></td></tr> -->
	</table>
	
	<!-- 
				PageIndex 分页 Int32 
                Count 数量 Int32 
                Lng 经度 Double 
                Lat 纬度 Double 
                RegionID 城市ID Int64 默认值：0
                Sort 默认 = 0,人气 = 1, 距离 = 2,等级 = 3, Int32 默认值：0
     -->
	<!-- <form action="http://120.24.159.207:8081/CMS/News/GetFishingPointList" method="post">
		<input type="hidden" name="PageIndex" value="1" /> 
		<input type="hidden" name="Count" value="1000" />
		<input type="hidden" name="Lng" value="121.5629947456772" />
		<input type="hidden" name="Lat" value="29.81513065850262" /> 
		<input type="hidden" name="RegionID" value="115" />
		<input type="hidden" name="Sort" value="2" />
		<input type="hidden" name="Token" value="4h83vlv63o216q8gum9j91qhrn" />
		<input type="hidden" name="DeviceNo" value="DeviceNo" />
		
		
		<input type="submit" value="POST查询">
		
	</form> -->

</body>
</html>