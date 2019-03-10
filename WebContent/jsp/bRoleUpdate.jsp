<%@page import="top.antifeudal.entity.Role"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Role role = (Role) request.getAttribute("role");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/common/bcommon.css">
<script type="text/javascript" src="<%=basePath%>/js/bRole.js"></script>
<link rel="stylesheet" href="<%=basePath %>/common/sweetalert/sweetalert.css" />
<script type="text/javascript" src="<%=basePath %>/common/sweetalert/sweetalert-dev.js"></script>
<title>角色修改</title>
</head>
<body>
<div class="add-area">
	<form action="<%=basePath %>RoleUpdate.rl?id=<%=role.getId() %>&ct=<%=role.getCreateTime() %>" 
		name="roleForm" method="post" onsubmit="return validate(this);">
		<div class="top-tt tt-update">Role Update</div>
		<input class="search-box" type="text" name="roleName" value="<%=role.getRoleName() %>" placeholder="Role Name *" />
		<textarea class="search-text-area" name="remark" placeholder="Remark"><%=role.getRemark() %></textarea><br/>
		<input class="btn btn-add-sv" type="submit" value="保存">
		<a href="<%=basePath %>/RolesGet.rl"><input class="btn btn-add-rt" type="button" value="返回"></a>
	</form>
</div>
</body>
</html>