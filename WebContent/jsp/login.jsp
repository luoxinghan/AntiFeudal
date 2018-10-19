<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String hint = "";
	if((String)request.getAttribute("hint") != null){
		hint = (String)request.getAttribute("hint");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="shortcut icon" type="image/x-icon"
	href="<%=basePath %>/image/icon/icon.ico" media="screen" />
<link rel="stylesheet" href="<%=basePath %>/css/login.css">
<link rel="stylesheet" href="<%=basePath %>/common/font-awesome-4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="<%=basePath %>/js/login.js"></script>
<link rel="stylesheet" href="<%=basePath %>/common/sweetalert/sweetalert.css" />
<script type="text/javascript" src="<%=basePath %>/common/sweetalert/sweetalert-dev.js"></script>
</head>
<body>
	<div class="comp_center">
		<button class="login_bt" id="login_bt" onclick="login()" >
			<span>Login</span>
		</button>
		<form class="loginForm" name="loginForm" action="<%=basePath %>Login" onsubmit="return validate(this);" method="post">
			<div class="cont_form_login" id="cont_form_login">
				<a href="#" onclick="back()"><span class='fa fa-undo fa-lg'></span></a>
				<h2>登录</h2>
				<input type="text" placeholder="手机号/账号/用户名" name="userName" /> 
				<input type="password" placeholder="密码" name="password" />
				<button class="btn_login" onClick="cambiar_login()">LOGIN</button>
			</div>
		</form>
	</div>
	<%
	if(hint.equals("noUser")) {
	%>
	<script>swal("未找到该用户,请注册后再登录。");</script>
	<%
	} 
	if(hint.equals("wrongPass")){
	%>
	<script>swal("用户密码错误！");</script>
	<%
	}
	%>
</body>
</html>