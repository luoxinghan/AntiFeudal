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
<link rel="shortcut icon" type="image/x-icon" href="<%=basePath %>/image/icon/icon.ico" media="screen" />
<title>Sorry!</title>
</head>
<style>
body{
	margin: 0;
	padding: 0;
	background-color: #333333;
}
.div0{
	position: absolute;
	width: 100%;
	height: 100%;
	z-index: 20000;
}
.div0 h1 {
	font-size: 100px;
	text-transform: uppercase;
	font-weight: 900;
	color: white;
	letter-spacing: 15px;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	margin: 0;
}
</style>
<body>
<div class="div0">
	<a href="<%=basePath%>index.jsp"><h1>404</h1></a>
</div>
</body>
</html>