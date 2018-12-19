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
	<jsp:include page="./loading.jsp"></jsp:include>
	<div class="mid">
		<div class="registerform">
			<h2>马上注册 也没啥用</h2>
			<form action="<%=basePath%>Register" method="post">
				<input id="username" class="inputText" type="text" placeholder="用户名"  name="username" />
				<input id="phonenumber" class="inputText" type="text" placeholder="手机号" name="phonenumber" />
				<input id="password" class="inputText" type="password" placeholder="密码" name="password" />
				<input id="repassword" class='inputText' type='password' placeholder="密码确认" />
				<p>我同意</p><a href="#">条款和条件。</a>
				<input type="submit" class="btn_login" onClick="conformInfo();" value="Register">
				<div class="backinfo">
					<a href="<%=basePath%>jsp/login.jsp">Already have an account?</a><br/>
					<a href="<%=basePath%>index.jsp">Back to Homepage</a>
				</div>
			</form>
			
		</div>
	</div>
</body>
</html>