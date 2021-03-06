<%@page import="top.antifeudal.entity.BImageFile"%>
<%@page import="top.antifeudal.entity.PageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	PageBean<BImageFile> pg = (PageBean<BImageFile>) request.getAttribute("page");
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
		<form action="PhotoManagement" method="post">
			<span class="sh-txt">文件名:</span> <input name="fileName" class="sh" type="text"/>
			<span class="sh-txt">用户名:</span> <input name="userName" class="sh" type="text"/>
			<input class="btn btn-sh" type="submit" value="查询">
		</form>
		<a href="<%=basePath %>/jsp/bPhotoUpload.jsp"><button class="btn btn-add">Upload</button></a>
	</div>
	<div class="mid-table-area">
		<table class="show-table">
            <tr>
                <th class="td-id">ID</th>
                <th class="td-file-name">文件名</th>
                <th class="td-file-des">描述</th>
                <th>国家</th>
                <th>省/市/州</th>
                <th>区/县</th>
                <th>大小</th>
                <th>是否展示</th>
                <th>操作</th>
            </tr>
          	<% for(int i = 0; i < pg.getList().size(); i++) { %>
            <tr>
             	
                <td><%=pg.getList().get(i).getId() %></td>
                <td title="<%=pg.getList().get(i).getFileName() %>"><%=pg.getList().get(i).getFileName() %></td>
                <td title="<%=pg.getList().get(i).getFileDes() %>"><%=pg.getList().get(i).getFileDes() %></td>
                <td><%=pg.getList().get(i).getCountry() %></td>
                <td><%=pg.getList().get(i).getState() %></td>
                <td><%=pg.getList().get(i).getCity() %></td>
                <td><%=pg.getList().get(i).getFileSize() %>kb</td>
                <td><%=pg.getList().get(i).getIsShow() == 1 ? "展示" : "隐藏" %></td>
                <td>
                	<%if(pg.getList().get(i).getIsShow() == 1){ %>
                		<a href="PhotoDelete?id=<%=pg.getList().get(i).getId() %>&s=0" class="a-lk">隐藏</a>
                	<%} else { %>
                		<a href="PhotoDelete?id=<%=pg.getList().get(i).getId() %>&s=1" class="a-rv">显示</a>
                	<%}%>
                </td>
                
            </tr>
			<% }%>
        </table>
	</div>
	<div class="btm-page-area">
		<div class="pagination">
			<a style="display: <%=pg.getCurPage()<=1 ? "none":"block" %>;" href="PhotoManagement?p=<%=(pg.getCurPage() - 1)%>">&laquo;</a>
			<%for(int i = 0; i < pg.getTotalPage(); i++){ 
				if(pg.getCurPage() == (i + 1)){
			%>
				<a class="active" href="PhotoManagement?p=<%=(i+1) %>"><%=(i+1) %></a>
			<%  } else {%>
				<a href="PhotoManagement?p=<%=(i+1) %>"><%=(i+1) %></a>
			<% 
				}
			  }
			%>
			<a style="display: <%=pg.getCurPage()>=pg.getTotalPage() ? "none":"block" %>;" href="PhotoManagement?p=<%=(pg.getCurPage() + 1)%>">&raquo;</a>
		</div>
	</div>
</body>
</html>