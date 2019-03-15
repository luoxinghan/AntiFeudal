<%@page import="top.antifeudal.entity.BUser"%>
<%@page import="top.antifeudal.entity.PageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	PageBean<BUser> pg = (PageBean<BUser>) request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/common/bcommon.css">
<script type="text/javascript" src="<%=basePath%>/js/bUser.js"></script>
<link rel="stylesheet" href="<%=basePath %>/common/sweetalert/sweetalert.css" />
<script type="text/javascript" src="<%=basePath %>/common/sweetalert/sweetalert-dev.js"></script>
<title>用户</title>
</head>
<body>
<div>
	<div class="top-search-area">
		<form action="UserManagement" method="post">
			<span class="sh-txt">用户名:</span> <input name="userName" class="sh" type="text"/>
			<span class="sh-txt">电话号码:</span> <input name="telephone" class="sh" type="text"/>
			<input class="btn btn-sh" type="submit" value="查询">
		</form>
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
          	<% for(int i = 0; i < pg.getList().size(); i++) { %>
            <tr>
             	
                <td><%=pg.getList().get(i).getId() %></td>
                <td><%=pg.getList().get(i).getRoleName() %></td>
                <td><%=pg.getList().get(i).getAccount() %></td>
                <td><%=pg.getList().get(i).getUserName() %></td>
                <td><%=pg.getList().get(i).getPhoneNumber() %></td>
                <td><%=pg.getList().get(i).getIsLock() == 1 ? "锁定" : "可用" %></td>
                <td><%=pg.getList().get(i).getCreateTime() %></td>
                <td><%=pg.getList().get(i).getIsDelete() == 1 ? "已删除" : "未删除"%></td>
                <td>
                	<%if(pg.getList().get(i).getIsLock() == 1){ %>
                		<a onclick="recoverUser(<%=pg.getList().get(i).getId() %>)" class="a-rv">恢复</a>
                	<%} else { %>
                		<a href="UserUpdateCheck?id=<%=pg.getList().get(i).getId() %>" class="a-ud">修改</a> |
                		<a onclick="deleteUser(<%=pg.getList().get(i).getId() %>)" class="a-lk">锁定</a>
                	<%}%>
                </td>
                
            </tr>
			<% }%>
        </table>
	</div>
	<div class="btm-page-area">
		<div class="pagination">
			<a style="display: <%=pg.getCurPage()==1 ? "none":"block" %>;" href="UserManagement?p=<%=(pg.getCurPage() - 1)%>">&laquo;</a>
			<%for(int i = 0; i < pg.getTotalPage(); i++){ 
				if(pg.getCurPage() == (i + 1)){
			%>
				<a class="active" href="UserManagement?p=<%=(i+1) %>"><%=(i+1) %></a>
			<%  } else {%>
				<a href="UserManagement?p=<%=(i+1) %>"><%=(i+1) %></a>
			<% 
				}
			  }
			%>
			<a style="display: <%=pg.getCurPage()==pg.getTotalPage() ? "none":"block" %>;" href="UserManagement?p=<%=(pg.getCurPage() + 1)%>">&raquo;</a>
		</div>
	</div>
</div>
</body>
</html>