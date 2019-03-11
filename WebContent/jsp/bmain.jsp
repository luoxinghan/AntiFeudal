<%@page import="top.antifeudal.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	User user = (User)request.getSession().getAttribute("buser");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bmain.css" />
<link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>image/icon/icon.ico" media="screen" />
<title>BackManagement</title>
</head>
<body>
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a href="<%=basePath%>UserManagement" target="innerFrame">Users</a>
		<a href="<%=basePath%>RolesGet.rl" target="innerFrame">Roles</a> 
		<a href="<%=basePath%>StoriesGet.sr" target="innerFrame">Stories</a> 
		<a href="<%=basePath%>PhotoManagement" target="innerFrame">Photos</a> 
		<a href="<%=basePath%>OriginManagement" target="innerFrame">Origins</a>
	</div>

	<div id="topInfo" class="topInfo">
		<span style="font-size: 30px; cursor: pointer" onclick="openNav()">&#9776;</span>
		<a class="userInfo">欢迎 <%=user.getUserName() %>. </a>
	</div>

	<div id="main">
		<iframe src="<%=basePath%>common/jsp/welcome.jsp" class="innerFrame"
			name="innerFrame" frameborder="0" scrolling="auto"></iframe>
	</div>

	<div id="bottomInfo" class="bottomInfo">
		<small>© 2019 AntiFeudal All Rights Reserved. V2.3</small>
	</div>
	<script>
		function openNav() {
			document.getElementById("mySidenav").style.width = "200px";
			document.getElementById("main").style.marginLeft = "200px";
			document.getElementById("topInfo").style.marginLeft = "200px";
			document.getElementById("bottomInfo").style.marginLeft = "200px";
		}

		function closeNav() {
			document.getElementById("mySidenav").style.width = "0";
			document.getElementById("main").style.marginLeft = "0";
			document.getElementById("topInfo").style.marginLeft = "0";
			document.getElementById("bottomInfo").style.marginLeft = "0";
		}
	</script>
</body>
</html>