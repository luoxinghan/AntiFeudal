<%@page import="java.util.ArrayList"%>
<%@page import="top.antifeudal.entity.Origin"%>
<%@page import="top.antifeudal.impl.OriginImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	ArrayList<Origin> origins = new OriginImpl().getAllNotDeleteOrigins();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/common/bcommon.css">
<script type="text/javascript" src="<%=basePath%>/js/bPhoto.js"></script>
<script src="<%=basePath %>/common/jquery/jquery-3.3.1.js" /></script>
<link rel="stylesheet" href="<%=basePath %>/common/sweetalert/sweetalert.css" />
<script type="text/javascript" src="<%=basePath %>/common/sweetalert/sweetalert-dev.js"></script>
<title>图片上传</title>
</head>
<body>
	<div class="add-area">
		<h2>上传照片的江湖规矩</h2>
		<p>1.照片要横着<br/>2.上传后缀为jpg或者png<br/>
		   3.照片大小小于1M，大了占内存嗷<br/>4.一次只能上传一张(对不起程序员该打，后续更改)</p>
		<form method="post" action="<%=basePath %>UploadHandleServlet" enctype="multipart/form-data">
			<div class="search-box">
				<a class="file-choose"><input type="file" name="file" value="file">选择文件</a>
				<a class="file-name file-info"></a>
				<a class="file-tip file-info"></a>
			</div>
			<select class="search-select" name="originId">
				<%
				for(int i = 0; i < origins.size(); i++) { 
				%>
				<option value="<%=origins.get(i).getId() %>">
					<%=(origins.get(i).getCountry() + '/' + origins.get(i).getState() + '/' + origins.get(i).getCity()) %>
				</option>
				<%
				}
				%>
			</select>
			<input class="search-box" type="text" name="fileDes" placeholder="File Describe"/>
			<textarea class="search-text-area" name="remark" placeholder="Remark"></textarea><br/>
			<input class="config-button" disabled="disabled" type="submit" value="上传">
			<a href="<%=basePath %>/PhotoManagement"><input class="btn btn-add-rt" type="button" value="返回"></a>
		</form>
	</div>
	
	
	<script type="text/javascript">
	$(".file-choose").on("change","input[type='file']",function(){
	    var filePath=$(this).val();
	    if(filePath.indexOf("jpg")!=-1 || filePath.indexOf("png")!=-1){
	        $(".file-tip").html("").hide();
	        var arr=filePath.split('\\');
	        var fileName=arr[arr.length-1];
	        $(".file-name").html(fileName);
	        $(".file-choose").css("color","#95a5a6");
	        $('.config-button').addClass('btn-add-fu');
	        $(".config-button").attr("disabled", false);
	    }else{
	        $(".file-name").html("");
	        $(".file-tip").html("您未上传文件，或者您上传文件类型有误！").show();
	        $('.config-button').removeClass('btn-add-fu');
	        $(".file-choose").css("color","#1E88C7");
	        $(".config-button").attr("disabled", true);
	        return false 
	    }
	});
</script>
</body>
</html>