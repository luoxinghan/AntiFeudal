<%@page import="top.antifeudal.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="top.antifeudal.entity.Role"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	User user = (User) request.getAttribute("user");
	ArrayList<Role> roles = (ArrayList<Role>) request.getAttribute("roles");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/common/bcommon.css">
<script type="text/javascript" src="<%=basePath%>/js/bUser.js"></script>
<link rel="stylesheet" href="<%=basePath %>/common/sweetalert/sweetalert.css" />
<script type="text/javascript" src="<%=basePath %>/common/sweetalert/sweetalert-dev.js"></script>
<title>用户信息修改</title>
</head>
<body>
<div class="add-area">
	<form action="<%=basePath %>UserUpdate?id=<%=user.getId() %>&ct=<%=user.getCreateTime() %>" 
		name="userForm" method="post" onsubmit="return validate(this);">
		<div class="top-tt tt-update">User Update</div>
		<select class="search-select" name="role">
			<%
			for(int i = 0; i < roles.size(); i++) { 
				if(user.getRoleId() == roles.get(i).getId()){
			%>
			<option selected="selected" value="<%=roles.get(i).getId() %>"><%=roles.get(i).getRoleName() %></option>
			<%
				} else {
			%>
			<option value="<%=roles.get(i).getId() %>"><%=roles.get(i).getRoleName() %></option>
			<%
				}
			}
			%>
		</select>
		<input class="search-box" type="text" name="account" value="<%=user.getAccount() %>" readonly="readonly" placeholder="Account *" />
		<input class="search-box" type="text" name="username" value="<%=user.getUserName() %>" placeholder="User Name *"/>
		<input class="search-box" type="password" name="password" value="<%=user.getPassword() %>" readonly="readonly"/>
		<input class="search-box" type="text" name="phone" value="<%=user.getPhoneNumber() %>" placeholder="Phone Number *"/>
		<textarea class="search-text-area" name="remark" placeholder="Remark"><%=user.getRemark() %></textarea><br/>
		<input class="btn btn-add-sv" type="submit" value="保存">
		<a href="<%=basePath %>/UserManagement"><input class="btn btn-add-rt" type="button" value="返回"></a>
	</form>
</div>
</body>
</html>