<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" type="image/x-icon"
	href="../image/icon/icon.ico" media="screen" />
<link rel="stylesheet" href="../css/register.css">
<script src="../common/sweetalert/sweetalert-dev.js"></script>
<link rel="stylesheet" href="../common/sweetalert/sweetalert.css" />
<script type="text/javascript" src="../js/register.js"></script>
<title>注册</title>
</head>
<body>
	<div class="left"
		onclick="javascript:window.location.href='<%=basePath%>jsp/login.jsp'"><p>LOGIN</p></div>
	<div class="mid">
		<div class="reg">
			<form class="regForm" name="registerForm" action="<%=basePath%>Register"
				onsubmit="return validate(this);" method="get">
				<h2>注册</h2>
				<table class="regInfoTable">
					<tr>
						<td class="leftTd">*用户名</td>
						<td>:</td>
						<td><input id="username" class="inputText" type="text" name="username" /></td>
					</tr>
					<tr>
						<td class="leftTd">*密码</td>
						<td>:</td>
						<td><input id="password" class="inputText" type="text" name="password" /></td>
					</tr>
					<tr>
						<td class="leftTd">*手机号</td>
						<td>:</td>
						<td><input id="phonenumber" class="inputText" type="text" name="phonenumber" /></td>
					</tr>
				</table>
				<div style="width: 100%; text-align: center;">
					<input type="submit" class="btn_login" onClick="conformInfo();" value="Register">
				</div>
			</form>
			
		</div>
	</div>
</body>
</html>