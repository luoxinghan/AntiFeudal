<%@page import="top.antifeudal.util.DateUtil"%>
<%@page import="top.antifeudal.entity.BStory"%>
<%@page import="top.antifeudal.entity.PageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	PageBean<BStory> pg = (PageBean<BStory>) request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/common/bcommon.css">
<script type="text/javascript" src="<%=basePath%>/js/bStory.js"></script>
<link rel="stylesheet" href="<%=basePath %>/common/sweetalert/sweetalert.css" />
<script type="text/javascript" src="<%=basePath %>/common/sweetalert/sweetalert-dev.js"></script>
<title>故事</title>
</head>
<body>
	<div class="top-search-area">
		<form action="StoriesGet.sr" method="post">
			<span class="sh-txt">用户名:</span> <input name="userName" class="sh" type="text"/>
			<span class="sh-txt">文章标题:</span> <input name="articleTitle" class="sh" type="text"/>
			<input class="btn btn-sh" type="submit" value="查询">
		</form>
		<a href="<%=basePath %>/jsp/bStoryAdd.jsp"><button class="btn btn-add">Add</button></a>
	</div>
	<div class="mid-table-area">
		<table class="show-table">
            <tr>
                <th>ID</th>
                <th>作者</th>
                <th>文章标题</th>
                <th>文章描述</th>
                <th>创建时间</th>
                <th>修改时间</th>
                <th>是否删除</th>
                <th>操作</th>
            </tr>
          	<% for(int i = 0; i < pg.getList().size(); i++) { %>
            <tr>
                <td><%=pg.getList().get(i).getId() %></td>
                <td><%=pg.getList().get(i).getUserName() %></td>
                <td><%=pg.getList().get(i).getArticleTitle() %></td>
                <td><%=pg.getList().get(i).getArticleDes() %></td>
                <td><%=DateUtil.dateFormat(pg.getList().get(i).getCreateTime()) %></td>
                <td><%=DateUtil.dateFormat(pg.getList().get(i).getUpdateTime()) %></td>
                <td><%=pg.getList().get(i).getIsDelete() == 1 ? "已删除" : "未删除"%></td>
                <td>
                	<%if(pg.getList().get(i).getIsDelete() == 1){ %>
                		<a onclick="recoverStory(<%=pg.getList().get(i).getId() %>)" class="a-rv">恢复</a>
                	<%} else { %>
                		<a href="StoryUpdateGet.sr?id=<%=pg.getList().get(i).getId() %>" class="a-ud">重写</a> |
                		<a onclick="deleteStory(<%=pg.getList().get(i).getId() %>)" class="a-dl">删除</a>
                	<%}%>
                </td>
            </tr>
			<% }%>
        </table>
	</div>
	<div class="btm-page-area">
		<div class="pagination">
			<a style="display: <%=pg.getCurPage()==1 ? "none":"block" %>;" href="StoriesGet.sr?p=<%=(pg.getCurPage() - 1)%>">&laquo;</a>
			<%for(int i = 0; i < pg.getTotalPage(); i++){ 
				if(pg.getCurPage() == (i + 1)){
			%>
				<a class="active" href="StoriesGet.sr?p=<%=(i+1) %>"><%=(i+1) %></a>
			<%  } else {%>
				<a href="StoriesGet.sr?p=<%=(i+1) %>"><%=(i+1) %></a>
			<% 
				}
			  }
			%>
			<a style="display: <%=pg.getCurPage()==pg.getTotalPage() ? "none":"block" %>;" href="StoriesGet.sr?p=<%=(pg.getCurPage() + 1)%>">&raquo;</a>
		</div>
	</div>
</body>
</html>