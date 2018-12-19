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
</head>
<body>
	<jsp:include page="../common/slidebar.jsp"></jsp:include>
	<div class="div0">
		<h1>ANTIFEUDAL</h1>
		<p>Text Background Image From:<a href="https://www.weibo.com/p/1005052856850754/home">@偷懒的头发V</a></p>
	</div>
	<div class="div1">
		123
	</div>
	<div class="div2">
		<div class="div2-know-content">
			<h2>寫在中間</h2>
			<div class="div2-know-text">
				<%=frontContent != null ? frontContent.getContent() : "" %>
			</div>
			<button class="div2-know-btn">
				<span></span>
			</button>
		</div>
		<img alt="div2-background-image" src="<%=basePath %>image/div2-bg.png" />
	</div>
	<div class="div3">
		123
	</div>
	<footer class="div4">
		<div class="div4-footer-top">
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="#">About AntiFeudal</a></li>
				<li><a href="#">Contact Me</a></li>
			</ul>
		</div>
		<div class="div4-footer-bottom">
			<small>© 2019 AntiFeudal All Rights Reserved. V 2.3</small>
		</div>
	</footer>
	
<script type="text/javascript">
	$('.btn').on("click", function(){
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