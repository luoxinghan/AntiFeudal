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
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon"
	href="<%=basePath %>/image/icon/icon.ico" media="screen" />
<link rel="stylesheet" href="<%=basePath %>/css/loading.css" />

<script type="text/javascript">  
              
 //: 判断网页是否加载完成  
document.onreadystatechange = function () {   
    if(document.readyState == "complete") {         
        document.getElementById('hover-div').style.display='none';   
    }  
}    
</script>  
</head>
<body>
	<div id="hover-div" class="hover-div">
		<div id="loading" class="loading">
			<div class="obj"></div>
			<div class="obj"></div>
			<div class="obj"></div>
			<div class="obj"></div>
			<div class="obj"></div>
			<div class="obj"></div>
			<div class="obj"></div>
			<div class="obj"></div>
		</div>
	</div>
</body>
</html>