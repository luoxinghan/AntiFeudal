<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/common/bcommon.css">
<script type="text/javascript" src="<%=basePath%>/js/bStory.js"></script>
<link rel="stylesheet" href="<%=basePath %>/common/sweetalert/sweetalert.css" />
<script type="text/javascript" src="<%=basePath %>/common/sweetalert/sweetalert-dev.js"></script>
<title>故事新增</title>
</head>
<body>
<div class="add-area">
	<form action="<%=basePath %>StoryAdd.sr" name="StoryForm" method="post" onsubmit="return validate(this);">
		<div class="top-tt tt-add">Story Add</div>
		<input class="search-box" type="text" name="articleTitle" placeholder="Story Title *" />
		<textarea class="search-text-area story-text-area" rows="13" name="articleContent" placeholder="Story Content *"></textarea>
		<input class="search-box" type="text" name="articleDes" placeholder="Story Describe" /><br/>
		<input class="btn btn-add-sv" type="submit" value="保存">
		<a href="<%=basePath %>/StoriesGet.sr"><input class="btn btn-add-rt" type="button" value="返回"></a>
	</form>
</div>
</body>
</html>