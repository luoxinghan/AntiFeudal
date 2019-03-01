<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/antiFeudal.css" />
<link rel="shortcut icon" type="image/x-icon" href="<%=basePath %>/image/icon/icon.ico" media="screen" />
<link rel="stylesheet" href="<%=basePath %>/css/style.css">
<script src="<%=basePath %>/js/jquery.js" /></script>
<script type="text/javascript" src="<%=basePath %>/js/antiFeudal.js" /></script>
<title>Anti-Feudal</title>
</head>
<body>
	<jsp:include page="./loading.jsp"></jsp:include>
	<ul class="nav">
		<!-- <li style="margin-top:12px;width: 180px;"><img src="<%=basePath %>/image/LOGO.png"/></li> -->
		<li style="width: 15px;"><div style="width: 6px;height: 40px;background-color: #DB9019;"></div></li>
		<li><a id="navon0" class="active" href="javascript:void(0)">首</a></li>
		<li><a id="navon1" href="javascript:void(0)">壹</a></li>
		<li><a id="navon2" href="javascript:void(0)">貳</a></li>
		<li><a id="navon3" href="javascript:void(0)">叄</a></li>
		<li><a id="navon4" href="javascript:void(0)">肆</a></li>
		<li><a id="navon5" href="javascript:void(0)">伍</a></li>
	</ul>
	
  	<div id="div0">
  		<div class="mid">
  			<!-- <video class="bgvid"  onMouseOver="this.muted=true;" onMouseOut="this.muted=true;" autoplay="autoplay" 
			loop="loop" autobuffer="true">
	  		<source src="./video/破云.mp4" type="video/mp4">
	  			未找到视频文件
	  		</video> -->
			<h1 class="xmTrip">
				对不起 暂未搭建完成
			</h1>
  		</div>
  	</div>
	<div id="div1">
		<h1 class="textHead">—— 壹 ——</h1>
  <div class="cont s--inactive">
  <!-- cont inner start -->
  <div class="cont__inner">
    <!-- el start -->
    <div class="el">
      <div class="el__overflow">
        <div class="el__inner">
          <div class="el__bg"></div>
          <div class="el__preview-cont">
            <h2 class="el__heading">Section 1</h2>
          </div>
          <div class="el__content">
            <div class="el__text">Whatever</div>
            <div class="el__close-btn"></div>
          </div>
        </div>
      </div>
      <div class="el__index">
        <div class="el__index-back">1</div>
        <div class="el__index-front">
          <div class="el__index-overlay" data-index="1">1</div>
        </div>
      </div>
    </div>
    <!-- el end -->
    <!-- el start -->
    <div class="el">
      <div class="el__overflow">
        <div class="el__inner">
          <div class="el__bg"></div>
          <div class="el__preview-cont">
            <h2 class="el__heading">Section 2</h2>
          </div>
          <div class="el__content">
            <div class="el__text">Whatever</div>
            <div class="el__close-btn"></div>
          </div>
        </div>
      </div>
      <div class="el__index">
        <div class="el__index-back">2</div>
        <div class="el__index-front">
          <div class="el__index-overlay" data-index="2">2</div>
        </div>
      </div>
    </div>
    <!-- el end -->
    <!-- el start -->
    <div class="el">
      <div class="el__overflow">
        <div class="el__inner">
          <div class="el__bg"></div>
          <div class="el__preview-cont">
            <h2 class="el__heading">Section 3</h2>
          </div>
          <div class="el__content">
            <div class="el__text">Whatever</div>
            <div class="el__close-btn"></div>
          </div>
        </div>
      </div>
      <div class="el__index">
        <div class="el__index-back">3</div>
        <div class="el__index-front">
          <div class="el__index-overlay" data-index="3">3</div>
        </div>
      </div>
    </div>
    <!-- el end -->
    <!-- el start -->
    <div class="el">
      <div class="el__overflow">
        <div class="el__inner">
          <div class="el__bg"></div>
          <div class="el__preview-cont">
            <h2 class="el__heading">Section 4</h2>
          </div>
          <div class="el__content">
            <div class="el__text">Whatever</div>
            <div class="el__close-btn"></div>
          </div>
        </div>
      </div>
      <div class="el__index">
        <div class="el__index-back">4</div>
        <div class="el__index-front">
          <div class="el__index-overlay" data-index="4">4</div>
        </div>
      </div>
    </div>
    <!-- el end -->
    <!-- el start -->
    <div class="el">
      <div class="el__overflow">
        <div class="el__inner">
          <div class="el__bg"></div>
          <div class="el__preview-cont">
            <h2 class="el__heading">Section 5</h2>
          </div>
          <div class="el__content">
            <div class="el__text">Whatever</div>
            <div class="el__close-btn"></div>
          </div>
        </div>
      </div>
      <div class="el__index">
        <div class="el__index-back">5</div>
        <div class="el__index-front">
          <div class="el__index-overlay" data-index="5">5</div>
        </div>
      </div>
    </div>
    <!-- el end -->
  </div>
  <!-- cont inner end -->
</div>
  </div>
	</div>
	<div id="div2">
		<h1 class="textHead">—— 贰 ——</h1>
	</div>
	<div id="div3">
		<h1 class="textHead">—— 叄 ——</h1>
	</div>
	<div id="div4">
		<h1 class="textHead">—— 肆 ——</h1>
	</div>
	<div id="div5">
		<h1 class="textHead">—— 伍 ——</h1>
	</div>
	<div class="bottom">
		<div class="copyright">© 2017 anti-feudal版权所有</div>
	</div>
</body>
</html>