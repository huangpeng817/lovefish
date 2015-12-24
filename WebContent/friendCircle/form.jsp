<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'form.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    
    <form method="post" enctype="multipart/form-data" 
    	action="http://120.24.159.207:8081/FCS/FriendCircle/SendFriendCircle">
    	<!-- http://120.24.159.207:8081/FCS/FriendCircle/SendFriendCircle
    	?content=test_1
    	&localAdd=place_1
    	&lon=121.5825
    	&lat=29.8022
    	&IsAdv=0
    	&Token=1pqfosdk9e4p6qb0433qq8bi9a
    	&DeviceNo=DeviceNo -->
    	<input type="hidden" name="content" value="test_2">
    	<input type="hidden" name="localAdd" value="place_2">
    	<input type="hidden" name="lon" value="121.5825">
    	<input type="hidden" name="lat" value="29.8022">
    	<input type="hidden" name="IsAdv" value="0">
    	<input type="hidden" name="Token" value="1pqfosdk9e4p6qb0433qq8bi9a">
    	<input type="hidden" name="DeviceNo" value="DeviceNo">
    	<input type="file" name="photoes">
    	<input type="submit" value="提交">
    </form>
    
  </body>
</html>
