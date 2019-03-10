<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/common/bcommon.css">
<script type="text/javascript" src="<%=basePath%>/js/bRole.js"></script>
<link rel="stylesheet" href="<%=basePath %>/common/sweetalert/sweetalert.css" />
<script type="text/javascript" src="<%=basePath %>/common/sweetalert/sweetalert-dev.js"></script>
<meta charset="UTF-8">
<title>添加角色</title>
</head>
<body>
<div class="add-area">
	<form action="<%=basePath %>RoleAdd.rl" name="roleForm" method="post" onsubmit="return validate(this);">
		<div class="top-tt tt-add">Role Add</div>
		<input class="search-box" type="text" name="roleName" placeholder="Role Name *" />
		<textarea class="search-text-area" name="remark" placeholder="Remark"></textarea><br/>
		<input class="btn btn-add-sv" type="submit" value="保存">
		<a href="<%=basePath %>/RolesGet.rl"><input class="btn btn-add-rt" type="button" value="返回"></a>
	</form>
</div>
</body>
</html>