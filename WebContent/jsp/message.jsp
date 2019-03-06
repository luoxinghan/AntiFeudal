<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Integer state = (Integer) request.getAttribute("state");
	String message = (String) request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件上传结果</title>
</head>
<style>
body{
	margin: 0;
	padding: 0;
}
.div0{
	position: absolute;
	width: 100%;
	height: 100%;
	z-index: 20000;
}
.div0 h1 {
	font-size: 60px;
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

.btn{
	border-radius: 5px;
	font-family: "montserrat", sans-serif;
	font-size: 12px;
	color: #ffffff;
	text-transform: uppercase;
	margin: 10px 0px 0px 10px;
	padding: 5px 20px;
	min-width: 60px;
	cursor: pointer;
	/* transition: color 0.4s linear; */
	transition: 0.4s;
}

.btn:hover{
	background-color: #ffffff;
	color: #000000;
}

.btn-add-sv{
	border: 2px solid #ffa502;
	background: rgba(255, 165, 2, 0.8);
}

.btn-add-rt{
	border: 2px solid #ced6e0;
	background: rgba(206, 214, 224, 0.8);
}
</style>
<%if(state == 1) { %>
<body style="background-color: #70a1ff;">
<%} else { %>
<body style="background-color: #ff4757;">
<%} %>
<div class="div0">
	<h1><%=message %></h1>
	<a href="<%=basePath %>/jsp/bPhotoUpload.jsp"><input class="btn btn-add-sv" type="button" value="继续上传"></a>
	<a href="<%=basePath %>PhotoManagement"><input class="btn btn-add-rt" type="button" value="不上传了"></a>
</div>
</body>
</html>