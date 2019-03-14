<%@page import="top.antifeudal.entity.User"%>
<%@page import="top.antifeudal.util.StringUtil"%>
<%@page import="top.antifeudal.util.DateUtil"%>
<%@page import="top.antifeudal.entity.ImageFile"%>
<%@page import="top.antifeudal.entity.BStory"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	ArrayList<BStory> stories = (ArrayList<BStory>) request.getAttribute("stories");
	ImageFile photo = (ImageFile) request.getAttribute("photo");
	String filePath = StringUtil.changeTheUrl(photo.getFilePath() + '\\' + photo.getFileName());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/bwelcome.css">
<link rel="stylesheet" href="<%=basePath %>/common/sweetalert/sweetalert.css" />
<script type="text/javascript" src="<%=basePath %>/common/sweetalert/sweetalert-dev.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/bWelcome.js"></script>
<title>欢迎界面</title>
</head>
<body>
<div class="top-text">
	<div style="background: url(../photos<%=filePath %>) no-repeat 0% 50%;background-size:100% auto;" class="container">
	  	<div class="centered">无论是什么样的一天，都是崭新且从未发生过的。</div>
	  	<div class="bottom-right">每一次打开，背景都会随机从本地中获取</div>
	</div>
</div>
<div class="mid-content">
	<div class="ct-left">
		<h2>看最近写的吧</h2>
		<%for(int i = 0; i < stories.size(); i++) { %>
		<div class="left-story">
			<p class="title"><%=stories.get(i).getArticleTitle() %></p>
			<p class="author"><%=stories.get(i).getUserName() + "-"+ DateUtil.dateFormat(stories.get(i).getUpdateTime()) %></p>
		</div>
		<%} %>
		<a href="<%=basePath %>StoriesGet.sr">· · · · · ·</a>
	</div>
	<div class="ct-mid">
		<h2>或者听听歌</h2>
		<iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width=280 height=280 src="//music.163.com/outchain/player?type=0&id=2705297777&auto=0&height=430"></iframe>
	</div>
	<div class="ct-right">
		<a href="<%=basePath%>jsp/bPhotoUpload.jsp"><button class="btn">上传照片</button></a>
		<h2>投诉建议</h2>
		<form name="suggestForm" action="<%=basePath %>Suggestions.wc" 
			 method="post" onsubmit="return validate(this);">
			<input name="title" class="search-box" type="text" placeholder="Title"/>
			<textarea class="suggestion-text-area" rows="6" name="suggestion" placeholder="Suggestion"></textarea>
			<input class="btn" type="submit" value="发送">
		</form>
	</div>
</div>
</body>
</html>