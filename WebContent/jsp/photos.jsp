<%@page import="top.antifeudal.util.StringUtil"%>
<%@page import="top.antifeudal.entity.ImageFile"%>
<%@page import="top.antifeudal.entity.OriginPhotos"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	ArrayList<OriginPhotos> oList = (ArrayList<OriginPhotos>) request.getAttribute("oList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AntiFeudal-Photos</title>
<link rel="shortcut icon" type="image/x-icon" href="<%=basePath %>image/icon/icon.ico" media="screen" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/photos.css" />
</head>
<body>
	<jsp:include page="./loading.jsp"></jsp:include>
	<jsp:include page="../common/slidebar.jsp"></jsp:include>
	<%for(int i = 0; i < oList.size(); i++) { 
		ArrayList<ImageFile> imageFiles = oList.get(i).getImageFiles();
		String p = "";
		String country = oList.get(i).getbOrigin().getCountry();
		String state = oList.get(i).getbOrigin().getState();
		String city = oList.get(i).getbOrigin().getCity();
		String street = oList.get(i).getbOrigin().getStreet();
		if(!StringUtil.isEmpty(country)){
			p = p + "" + country;
			if(!StringUtil.isEmpty(state)){
				p = p + " " + state;
				if(!StringUtil.isEmpty(city)){
					p = p + " " + city;
					if(!StringUtil.isEmpty(street)) {
						p = p + " " + street;
					}
				}
			}
		}
	%>
	<div class="origin">
		<h2 class="place"><%=p %> <span class="username"><%=oList.get(i).getbOrigin().getUserName() %></span></h2>	
	</div>
	<header>
		<%
			int count = imageFiles.size();
			for(int j = 0; j < count; j++) {
				String filePath = imageFiles.get(j).getFilePath() + '/' + imageFiles.get(j).getFileName();
		%>
		<div class="img-div"><img src="../photos<%=filePath %>" alt="<%=imageFiles.get(j).getFileDescribe() %>"></div>
		<% }%>
	</header>
	<%}%>
	<footer class="cr">
		<div class="cr-footer-bottom">
			<small>© 2019 AntiFeudal All Rights Reserved. V2.3</small>
		</div>
	</footer>
	
	<!-- The Modal -->
	<div id="myModal" class="modal">
	  <span class="close">×</span>
	  <img class="modal-content" id="img01">
	  <div id="caption"></div>
	</div>
	
	<script type="text/javascript">
		// 获取模态窗口
		var modal = document.getElementById('myModal');

		// 获取图片模态框，alt 属性作为图片弹出中文本描述
		var imgs = document.getElementsByTagName('img');
		var modalImg = document.getElementById('img01');
		var captionText = document.getElementById('caption');
		// 获取 <span> 元素，设置关闭模态框按钮
		var span = document.getElementsByClassName('close')[0];
		for (var i = 0; i < imgs.length; i++) {
			imgs[i].onclick = function() {
				modal.style.display = "block";
				modalImg.src = this.src;
				modalImg.alt = this.alt;
				captionText.innerHTML = this.alt;
			}
		}

		// 点击 <span> 元素上的 (x), 关闭模态框
		span.onclick = function() {
			modal.style.display = "none";
		}
		
		$('.btn-slider').on("click", function(){
			$('.origin').toggleClass('menu-open');
			$('.cr').toggleClass('menu-open');
			$('header').toggleClass('menu-open');
			$("body").toggleClass("hide-scroll");
		});
	</script>
</body>
</html>
