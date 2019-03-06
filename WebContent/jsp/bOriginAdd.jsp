<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/common/bcommon.css">
<script type="text/javascript" src="<%=basePath%>/js/bOrigin.js"></script>
<link rel="stylesheet" href="<%=basePath %>/common/sweetalert/sweetalert.css" />
<script type="text/javascript" src="<%=basePath %>/common/sweetalert/sweetalert-dev.js"></script>
<title>添加分享地址</title>
</head>
<body>
<div class="add-area">
	<form action="<%=basePath %>OriginAdd" name="originForm" method="post" onsubmit="return validate(this);">
		<div class="top-tt tt-add">Origin Add</div>
		<input class="search-box" type="text" name="country" placeholder="Country *" />
		<input class="search-box" type="text" name="state" placeholder="State"/>
		<input class="search-box" type="text" name="city" placeholder="City" />
		<input class="search-box" type="text" name="street" placeholder="Street"/>
		<input class="search-box" type="text" name="priority" placeholder="Priority *" />
		<textarea class="search-text-area" name="remark" placeholder="Remark"></textarea><br/>
		<input class="btn btn-add-sv" type="submit" value="保存">
		<a href="<%=basePath %>/OriginManagement"><input class="btn btn-add-rt" type="button" value="返回"></a>
	</form>
</div>
</body>
</html>