<%@page import="top.antifeudal.entity.PageBean"%>
<%@page import="top.antifeudal.entity.BOrigin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	PageBean<BOrigin> pg = (PageBean<BOrigin>) request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/common/bcommon.css">
<script type="text/javascript" src="<%=basePath%>/js/bOrigin.js"></script>
<link rel="stylesheet" href="<%=basePath %>/common/sweetalert/sweetalert.css" />
<script type="text/javascript" src="<%=basePath %>/common/sweetalert/sweetalert-dev.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="top-search-area">
		<form action="OriginManagement" method="post">
			<span class="sh-txt">用户名:</span> <input name="userName" class="sh" type="text"/>
			<span class="sh-txt">国家:</span> <input name="country" class="sh" type="text"/>
			<input class="btn btn-sh" type="submit" value="查询">
		</form>
		<a href="<%=basePath %>/jsp/bOriginAdd.jsp"><button class="btn btn-add">Add</button></a>
	</div>
	<div class="mid-table-area">
		<table class="show-table">
            <tr>
                <th>ID</th>
                <th>用户名</th>
                <th>国家</th>
                <th>州/省/市</th>
                <th>区</th>
                <th>街道</th>
                <th>优先级</th>
                <th>是否删除</th>
                <th>操作</th>
            </tr>
          	<% for(int i = 0; i < pg.getList().size(); i++) { %>
            <tr>
                <td><%=pg.getList().get(i).getId() %></td>
                <td><%=pg.getList().get(i).getUserName() %></td>
                <td><%=pg.getList().get(i).getCountry() %></td>
                <td><%=pg.getList().get(i).getState() %></td>
                <td><%=pg.getList().get(i).getCity() %></td>
                <td><%=pg.getList().get(i).getStreet() %></td>
                <td><%=pg.getList().get(i).getDisplayPriority() %></td>
                <td><%=pg.getList().get(i).getIsDelete() == 1 ? "已删除" : "未删除"%></td>
                <td>
                	<%if(pg.getList().get(i).getIsDelete() == 1){ %>
                		<a onclick="recoverOrigin(<%=pg.getList().get(i).getId() %>)" class="a-rv">恢复</a>
                	<%} else { %>
                		<a href="OriginUpdateCheck?id=<%=pg.getList().get(i).getId() %>" class="a-ud">修改</a> |
                		<a onclick="deleteOrigin(<%=pg.getList().get(i).getId() %>)" class="a-dl">删除</a>
                	<%}%>
                </td>
            </tr>
			<% }%>
        </table>
	</div>
	<div class="btm-page-area">
		<div class="pagination">
			<a style="display: <%=pg.getCurPage()==1 ? "none":"block" %>;" href="OriginManagement?p=<%=(pg.getCurPage() - 1)%>">&laquo;</a>
			<%for(int i = 0; i < pg.getTotalPage(); i++){ 
				if(pg.getCurPage() == (i + 1)){
			%>
				<a class="active" href="OriginManagement?p=<%=(i+1) %>"><%=(i+1) %></a>
			<%  } else {%>
				<a href="OriginManagement?p=<%=(i+1) %>"><%=(i+1) %></a>
			<% 
				}
			  }
			%>
			<a style="display: <%=pg.getCurPage()==pg.getTotalPage() ? "none":"block" %>;" href="OriginManagement?p=<%=(pg.getCurPage() + 1)%>">&raquo;</a>
		</div>
	</div>
</body>
</html>