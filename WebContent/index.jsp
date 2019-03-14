<%@page import="top.antifeudal.entity.FrontContent"%>
<%@page import="top.antifeudal.impl.FrontContentImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	FrontContentImpl fci = new FrontContentImpl();
	FrontContent frontContent = fci.getByJspAndDivName("index.jsp", "div2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AntiFeudal</title>
<link rel="shortcut icon" type="image/x-icon" href="<%=basePath %>image/icon/icon.ico" media="screen" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/index.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>/common/common.css" />
</head>
<body>
	<jsp:include page="./jsp/loading.jsp"></jsp:include>
	<jsp:include page="./common/slidebar.jsp"></jsp:include>
	<div class="div0">
		<h1>ANTIFEUDAL</h1>
	</div>
	<div class="div1">
		<div class="div1-area">
		    <div class="area-card">
		      <a href="<%=basePath %>PhotosShow" class="option">
		      	<img src="<%=basePath %>/image/group1.jpg" alt="LuoXinghan" />
		      </a>
		    </div> 
			 
			<div class="area-intro">
				<div class="intro-container">
					<h2>Luo Xinghan</h2>
					<p class="intro-title">Student</p>
					<p>CQUT and GRSU University students. Major: Software Engineering.</p>
					<p>生活是苦难的，我又滑着我的断桨出发了。</p>
					<p>xinghanluo@gmail.com</p>
					<p><a href="<%=basePath %>/jsp/contact.jsp"><button class="btn">Contact</button></a></p>
				</div>
			</div>
		</div>
	</div>
	<div class="div2">
		<div class="div2-know-content">
			<h2>写在最后</h2>
			<div class="div2-know-text">
				<%=frontContent != null ? frontContent.getContent() : "" %>
			</div>
			<a href="<%=basePath %>FrontStories.sr"><button class="btn div2-btn">read more</button></a>
		</div>
		<img alt="div2-background-image" src="<%=basePath %>image/div2-bg.png" />
	</div>
	<footer class="div4">
		<div class="div4-footer-top">
			<ul>
				<li><a href="<%=basePath%>index.jsp">Home</a></li>
				<li><a href="#">About AntiFeudal</a></li>
				<li><a href="<%=basePath %>/jsp/contact.jsp">Contact Me</a></li>
			</ul>
		</div>
		<div class="div4-footer-bottom">
			<small>© 2019 AntiFeudal All Rights Reserved. V2.3</small>
		</div>
	</footer>
	
<script type="text/javascript">
	$('.btn-slider').on("click", function(){
		$('.div0').toggleClass('menu-open');
		$('.div1').toggleClass('menu-open');
		$('.div2').toggleClass('menu-open');
		$('.div3').toggleClass('menu-open');
		$('.div4').toggleClass('menu-open');
		$("body").toggleClass("hide-scroll");
	});
</script>
</body>
</html>