<%@page import="top.antifeudal.entity.BImageFile"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	ArrayList<BImageFile>  blist = (ArrayList<BImageFile>) request.getAttribute("blist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/common/bcommon.css">
<title>图片</title>
</head>
<body>
<div class="top-search-area">
		<form action="PhotosManagement" method="post">
			<span class="sh-txt">文件名:</span> <input name="fileName" class="sh" type="text"/>
			<span class="sh-txt">用户名:</span> <input name="userName" class="sh" type="text"/>
			<input class="btn btn-sh" type="submit" value="查询">
		</form>
		<button class="btn btn-add">Upload</button>
	</div>
	<div class="mid-table-area">
		<table class="show-table">
            <tr>
                <th>ID</th>
                <th>文件名</th>
                <th>国家</th>
                <th>用户名</th>
                <th>后缀类型</th>
                <th>文件大小</th>
                <th>是否展示</th>
                <th>操作</th>
            </tr>
          	<% for(int i = 0; i < blist.size(); i++) { %>
            <tr>
             	
                <td><%=blist.get(i).getId() %></td>
                <td><%=blist.get(i).getFileName() %></td>
                <td><%=blist.get(i).getCountry() %></td>
                <td><%=blist.get(i).getUserName() %></td>
                <td><%=blist.get(i).getFileExt() %></td>
                <td><%=blist.get(i).getFileSize() %></td>
                <td><%=blist.get(i).getIsShow() == 1 ? "展示" : "隐藏" %></td>
                <td>
                	<a class="a-ud">修改</a> |
                	<a class="a-dl">删除</a> |
                	<a class="a-lk">隐藏</a>
                </td>
                
            </tr>
			<% }%>
        </table>
	</div>
	<div></div>
</body>
</html>