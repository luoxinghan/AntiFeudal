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
<link rel="stylesheet" href="<%=basePath %>common/font-awesome-5.7.2/css/all.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/slidebar.css">
<script src="<%=basePath %>common/jquery/jquery-3.3.1.min.js"></script>
<title></title>
</head>
<body>
<div class="sidebar">
	<ul>
		<li><a class="fa fa-circle-o" href="<%=basePath%>index.jsp"><span> Home</span></a></li>
		<li><a class="fa fa-circle-o" href="<%=basePath%>FrontStories.sr"><span> Story</span></a></li>
		<li><a class="fa fa-circle-o" href="<%=basePath%>PhotosShow"><span> Photo</span></a></li>
		<li><a class="fa fa-circle-o" href="<%=basePath%>jsp/contact.jsp"><span> Contact</span></a></li>
		<li><a class="fa fa-circle-o" href="#"><span> More+</span></a></li>
	</ul>
</div>
<div class="menu">
	<div class="con conb"><a href="<%=basePath%>index.jsp"></a></div>
	<a class="btn-slider btnb">MENU<i class="icn fas fa-chevron-right"></i></i></a>
</div>
<script type="text/javascript">
	$('.btn-slider').on("click", function(){
		$('.icn').toggleClass('fa-chevron-right');
		$('.icn').toggleClass('fa-chevron-left');
		$(".btn-slider").toggleClass("btnb");
		$(".btn-slider").toggleClass("btnc");
		$(".con").toggleClass("conb");
		$(".con").toggleClass("conc");
		$('.sidebar').toggleClass('side');
	});
</script>
</body>
</html>