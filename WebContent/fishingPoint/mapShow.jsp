<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		/* body, html,#allmap {width: 300px;height: 300px;overflow: hidden;margin:0;font-family:"微软雅黑";} */
 		body, html,#allmap {width: 80%;height: 80%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=c36mRDe5Ts3v6zst94lIfxyh"></script>
	<title>地址解析</title>
</head>
<body>
	<div id="allmap"></div>
</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	var point = new BMap.Point(121.569661,29.793664);
	map.centerAndZoom(point,12);
	// 创建地址解析器实例
	var myGeo = new BMap.Geocoder();
	
	var localAddr = "";
	// 根据坐标得到地址描述
	myGeo.getLocation(new BMap.Point(121.569661, 29.793664), function(result){
		if (result){
			alert(result.address);
			localAddr = result.address;
		}
	});
	//alert(localAddr);
	// 将地址解析结果显示在地图上,并调整地图视野
	myGeo.getPoint("宁波市鄞州区傅家村高速立交桥下", function(point){
/* 	myGeo.getPoint("浙江省宁波市鄞州区S1(甬台温高速公路)", function(point){ */
/* 	myGeo.getPoint("宁波市鄞州区傅家村高速立交桥下", function(point){ */
		if (point) {
			map.centerAndZoom(point, 16);
			map.addOverlay(new BMap.Marker(point));
		}else{
			alert("您选择地址没有解析到结果!");
		}
	}, "宁波市");
</script>
