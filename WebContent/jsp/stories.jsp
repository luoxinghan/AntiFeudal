<%@page import="top.antifeudal.entity.BStory"%>
<%@page import="top.antifeudal.util.StringUtil"%>
<%@page import="top.antifeudal.util.DateUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	ArrayList<BStory> stories = (ArrayList<BStory>) request.getAttribute("stories");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stories</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/stories.css">
<link rel="shortcut icon" type="image/x-icon" href="<%=basePath %>image/icon/icon.ico" media="screen" />
</head>
<body>
	<jsp:include page="../common/slidebar.jsp"></jsp:include>
	<div class="container">
		<div class="top-title">
			<img src="<%=basePath %>image/bltn.png" alt="Snow" style="width:100%;">
			<div class="top-title-text">Better Late Than Never</div>
		</div>
		<%for(int i = 0; i < stories.size(); i++) { %>
		<div class="mid-story">
			<div class="st">
				<h2><%=stories.get(i).getArticleTitle() %></h2>
				<div class="st-ct">
					<span><%=stories.get(i).getUserName() %>：</span>
					<%=stories.get(i).getArticleContent() %>
				</div>
				<p class="st-time"><%=DateUtil.dateFormat(stories.get(i).getUpdateTime()) %></p>
				<a href="<%=basePath %>StoryDetailGet.sr?id=<%=stories.get(i).getId()%>"><button class="btn">全文阅读</button></a>
			</div>
		</div>
		<%} %>
		<footer class="cr">
			<div class="cr-footer-bottom">
				<small>© 2019 AntiFeudal All Rights Reserved. V2.3</small>
			</div>
		</footer>
	</div>
	<script type="text/javascript">
	$('.btn-slider').on("click", function(){
		$('.container').toggleClass('menu-open');
		$("body").toggleClass("hide-scroll");
	});
	</script>
</body>
</html>