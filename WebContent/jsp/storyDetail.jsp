<%@page import="top.antifeudal.util.DateUtil"%>
<%@page import="top.antifeudal.entity.BStory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	BStory story = (BStory) request.getAttribute("story");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=story.getArticleTitle() %></title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/storyDetail.css">
<link rel="shortcut icon" type="image/x-icon" href="<%=basePath %>image/icon/icon.ico" media="screen" />
<script src="<%=basePath %>common/jquery/jquery-3.3.1.min.js"></script>
</head>
<body>
	<div id="container" class="container">
		<div class="head-title"><a href="<%=basePath %>index.jsp">ANTI-FEUDAL</a></div>
		<div class="story-c">
			<h2 class="title"><%=story.getArticleTitle() %></h2>
			<div>
				<div class="author">作者：<%=story.getUserName() %></div>
				<p class="content">
					<%=story.getArticleContent() %>
				</p>
				<p class="time">编辑时间：<%=DateUtil.dateFormat(story.getUpdateTime()) %></p>
			</div>
			<div class="btn-area">
				<a href="<%=basePath %>FrontStories.sr"><button class="btn btn-flexd">返回</button></a>
			</div>
		</div>
		<footer class="cr">
			<div class="cr-footer-bottom">
				<small>© 2019 AntiFeudal All Rights Reserved. V2.3</small>
			</div>
		</footer>
		<div id="fiexd" class="back-flex">
			<div class="flex-area">
				<a><button class="btn-flexd btn">返回</button></a>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	window.onload = function() {flexFunction()}
	window.onscroll = function() {scrollFunction()};
	
	var contentH = document.body.scrollHeight;
	var viewH = window.screen.height;
	var oDiv = document.getElementById("fiexd");
	
	function scrollFunction() {
		var scrollTop = document.body.scrollTop;
		var documentH = document.documentElement.scrollTop;
		if (contentH - viewH - scrollTop <= 60 || contentH - viewH - documentH <= 60) {
		  document.getElementById("fiexd").style.height = "0";
		} else {
		  document.getElementById("fiexd").style.height = "60px";
		}
	}
	function flexFunction() {
		if (contentH < viewH) {
		  document.getElementById("fiexd").style.height = "0";
		} else {
		  document.getElementById("fiexd").style.height = "60px";
		}
	} 
	</script>
</body>
</html>