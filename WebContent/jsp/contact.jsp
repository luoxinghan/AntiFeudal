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
<title>Contact Me</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/contact.css">
<link rel="shortcut icon" type="image/x-icon" href="<%=basePath %>image/icon/icon.ico" media="screen" />
</head>
<body>
	<jsp:include page="../common/slidebar.jsp"></jsp:include>
	<div class="mid-contact-way">
		<div class="contact-bg">
			<h1>反馈和建议</h1>
		</div>
		<div>
			<h2>Quick feedback</h2>
			<div class="border-line"></div>
			<div class="other-way">
				<p>Email: xinghanluo@gmail.com</p>
				<p>WeChat: luoxinhan</p>
			</div>
		</div>
		<div>
			<h2>Social Account</h2>
			<div class="border-line"></div>
			<div class="middle">
				<a class="btn" href="https://music.163.com/#/user/home?id=134247678">
					<i class="fas fa-music"></i>
				</a>
				<a class="btn" href="https://www.weibo.com/2913010611">
					<i class="fab fa-weibo"></i>
				</a>
				<a class="btn" href="https://www.zhihu.com/people/antiFeudal">
					<i class="fab fa-zhihu"></i>
				</a>
				<a class="btn" href="https://github.com/luoxinghan">
					<i class="fab fa-github"></i>
				</a>
				<a class="btn" href="https://www.instagram.com/luo_xing_han">
					<i class="fab fa-instagram"></i>
				</a>
			</div>
		</div>
		<footer class="cr">
			<div class="cr-footer-bottom">
				<small>© 2019 AntiFeudal All Rights Reserved. V2.3</small>
			</div>
		</footer>
	</div>
	<script type="text/javascript">
	$('.btn-slider').on("click", function(){
		$('.mid-contact-way').toggleClass('menu-open');
		$("body").toggleClass("hide-scroll");
	});
</script>
</body>
</html>