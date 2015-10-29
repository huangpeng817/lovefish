<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模态框练习</title>
<script type="text/javascript"
	src="<c:url value='/script/jquery-1.9.1.min.js'/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
<script type="text/javascript" src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#model_save").click(function() {
			$("#submitInput").click();
		});
	});
</script>
</head>
<body>

<!-- 按钮触发模态框 -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  运行模态框实例
</button>

<!-- 模态框 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-describedby="描述信息">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">模态框标题</h4>
      </div>
      <div class="modal-body">
        	<!-- 填写的内容 -->
        	<form action="">
        		用户名：<input type="text" name="username"><br><br>
        		密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password">
        		<input id="submitInput" type="submit" value="提交" style="display: none;">
        	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="model_save">保存</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>