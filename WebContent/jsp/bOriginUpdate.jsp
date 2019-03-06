<%@page import="top.antifeudal.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="top.antifeudal.entity.Origin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Origin origin = (Origin) request.getAttribute("origin");
	ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/common/bcommon.css">
<script type="text/javascript" src="<%=basePath%>/js/bOrigin.js"></script>
<link rel="stylesheet" href="<%=basePath %>/common/sweetalert/sweetalert.css" />
<script type="text/javascript" src="<%=basePath %>/common/sweetalert/sweetalert-dev.js"></script>
<title>修改分享地址</title>
</head>
<body>
<div class="add-area">
	<form action="<%=basePath %>OriginUpdate?id=<%=origin.getId() %>&ct=<%=origin.getCreateTime() %>" 
		name="originForm" method="post" onsubmit="return validate(this);">
		<div class="top-tt tt-update">Origin Update</div>
		<select class="search-select" name="user">
			<%
			for(int i = 0; i < users.size(); i++) { 
				if(origin.getUserId() == users.get(i).getId()){
			%>
			<option selected="selected" value="<%=users.get(i).getId() %>"><%=users.get(i).getUserName() %></option>
			<%
				} else {
			%>
			<option value="<%=users.get(i).getId() %>"><%=users.get(i).getUserName() %></option>
			<%
				}
			}
			%>
		</select>
		<input class="search-box" type="text" name="country" value="<%=origin.getCountry() %>" placeholder="Country *" />
		<input class="search-box" type="text" name="state" value="<%=origin.getState() %>" placeholder="State"/>
		<input class="search-box" type="text" name="city" value="<%=origin.getCity() %>" placeholder="City" />
		<input class="search-box" type="text" name="street" value="<%=origin.getStreet() %>" placeholder="Street"/>
		<input class="search-box" type="text" name="priority" value="<%=origin.getDisplayPriority() %>" placeholder="Priority *" />
		<textarea class="search-text-area" name="remark"><%=origin.getRemark() %></textarea><br/>
		<input class="btn btn-add-sv" type="submit" value="保存">
		<a href="<%=basePath %>/OriginManagement"><input class="btn btn-add-rt" type="button" value="返回"></a>
	</form>
</div>
</body>
</html>