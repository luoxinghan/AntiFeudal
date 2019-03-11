<%@page import="top.antifeudal.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="top.antifeudal.entity.Story"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Story story = (Story) request.getAttribute("story");
	ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/common/bcommon.css">
<script type="text/javascript" src="<%=basePath%>/js/bStory.js"></script>
<link rel="stylesheet" href="<%=basePath %>/common/sweetalert/sweetalert.css" />
<script type="text/javascript" src="<%=basePath %>/common/sweetalert/sweetalert-dev.js"></script>
<title>文章修改</title>
</head>
<body>
<div class="add-area">
	<form action="<%=basePath %>StoryUpdate.sr?id=<%=story.getId() %>&ct=<%=story.getCreateTime() %>" 
		name="storyForm" method="post" onsubmit="return validate(this);">
		<div class="top-tt tt-update">Story Update</div>
		<select class="search-select" name="user">
			<%
			for(int i = 0; i < users.size(); i++) { 
				if(story.getUserId() == users.get(i).getId()){
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
		<input class="search-box" type="text" name="articleTitle" value="<%=story.getArticleTitle() %>" placeholder="Story Title *" />
		<textarea class="search-text-area story-text-area" rows="13" name="articleContent" placeholder="Story Content *"><%=story.getArticleContent() %></textarea>
		<input class="search-box" type="text" name="articleDes" value="<%=story.getArticleDes() %>" placeholder="Story Describe" /><br/>
		<input class="btn btn-add-sv" type="submit" value="保存">
		<a href="<%=basePath %>/StoriesGet.sr"><input class="btn btn-add-rt" type="button" value="返回"></a>
	</form>
</div>
</body>
</html>