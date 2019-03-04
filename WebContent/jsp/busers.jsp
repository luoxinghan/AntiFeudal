<%@page import="top.antifeudal.entity.BUser"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	ArrayList<BUser>  blist = (ArrayList<BUser>) request.getAttribute("blist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/common/bcommon.css">
<title>用户</title>
</head>
<body>
<div>
	<div class="top-search-area">
		<form action="UsersManagement" method="post">
			<span class="sh-txt">用户名:</span> <input name="userName" class="sh" type="text"/>
			<span class="sh-txt">电话号码:</span> <input name="telephone" class="sh" type="text"/>
			<input class="btn btn-sh" type="submit" value="查询">
		</form>
		<button class="btn btn-add">Add</button>
	</div>
	<div class="mid-table-area">
		<table class="show-table">
            <tr>
                <th>ID</th>
                <th>角色名</th>
                <th>账户</th>
                <th>用户名</th>
                <th>电话</th>
                <th>锁定</th>
                <th>创建时间</th>
                <th>删除</th>
                <th>操作</th>
            </tr>
          	<% for(int i = 0; i < blist.size(); i++) { %>
            <tr>
             	
                <td><%=blist.get(i).getId() %></td>
                <td><%=blist.get(i).getRoleName() %></td>
                <td><%=blist.get(i).getAccount() %></td>
                <td><%=blist.get(i).getUserName() %></td>
                <td><%=blist.get(i).getPhoneNumber() %></td>
                <td><%=blist.get(i).getIsLock() == 1 ? "锁定" : "可用" %></td>
                <td><%=blist.get(i).getCreateTime() %></td>
                <td><%=blist.get(i).getIsDelete() == 1 ? "已删除" : "未删除"%></td>
                <td>
                	<a class="a-ud">修改</a> |
                	<a class="a-dl">删除</a> |
                	<a class="a-lk">锁定</a>
                </td>
                
            </tr>
			<% }%>
        </table>
	</div>
	<div></div>
</div>
</body>
</html>