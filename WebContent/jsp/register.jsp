<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="../image/icon/icon.ico" media="screen" />
<link rel="stylesheet" href="../css/register.css">
<link rel="stylesheet" href="../common/font-awesome-4.7.0/css/font-awesome.min.css" />
<script src="../common/sweetalert/sweetalert-dev.js"></script>
<link rel="stylesheet" href="../common/sweetalert/sweetalert.css" />
<script type="text/javascript" src="../js/register.js"></script>
<title>注册</title>
</head>
<body>
<div class="mid">
	<table class="regTable">
		<tr>
			<td class="regTdLeft">
				<div class="midLeft">
					<img class="reg" alt="注册背景" src="<%=basePath %>image/reg.jpg" />
					<p class="chineseFont">幸临本站 不妨少休<br/></p>
					<table class="contactWay">
						<tr>
							<td class="td1">Name</td>
							<td class="td2">:</td>
							<td class="td3">ThirtyCost</td>
						</tr>
						<tr>
							<td class="td1">Email</td>
							<td class="td2">:</td>
							<td class="td3">xinghan@antifeudal.top</td>
						</tr>
						<tr>
							<td class="td1">WeiBo</td>
							<td class="td2">:</td>
							<td class="td3"><a>Mr_curiosit_y</a></td>
						</tr>
						<tr>
							<td class="td1">NECloud</td>
							<td class="td2">:</td>
							<td class="td3"><a>Mr_curiosit_y</a></td>
						</tr>
					</table>
				</div>
			</td>
			<td class="regTdRight">
				 <form name="registerForm" action="<%=basePath %>Register" onsubmit="return validate(this);" method="get">
					<table class="regInfoTable">
						<tr>
							<td class="leftTd">*用户名</td>
							<td>:</td>
							<td><input class="inputText" type="text" name="userName" /></td>
						</tr>
						<tr>
							<td class="leftTd">*密码</td>
							<td>:</td>
							<td><input class="inputText" type="text" name="userName" /></td>
						</tr>
						<tr>
							<td class="leftTd">*手机号</td>
							<td>:</td>
							<td><input class="inputText" type="text" name="userName" /></td>
						</tr>
					</table>
				</form>
				<div>
					<div>
						<button class="btn_login" onClick="swal('jkjkj')">LOGIN</button>
					</div>
				</div>
				<div>
					<div>
						<button class="btn_login" onClick="cambiar_login()">LOGIN</button>
					</div>
				</div>
			</td>
		</tr>
	</table>
</div>
</body>
</html>