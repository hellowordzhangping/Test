<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Admin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/Admin.css"  />
	<style type="text/css">
		
		
	</style>
	
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
		
		$(document).ready(function() {
			
			$(".operation_one,.operation_two,.operation_three").mouseover(function() {
				$(this).css("cursor", "pointer");
			});
			
			$(".operation_one").click(function() {
				$(this).css("background-color", "red");
				$(".operation_two").css("background-color", "#DDD");
				$(".operation_three").css("background-color", "#DDD");
			});
			
			$(".operation_two").click(function() {
				$(this).css("background-color", "red");
				$(".operation_three").css("background-color", "#DDD");
				$(".operation_one").css("background-color", "#DDD");
			});
			
			$(".operation_three").click(function() {
				$(this).css("background-color", "red");
				$(".operation_two").css("background-color", "#DDD");
				$(".operation_one").css("background-color", "#DDD");
			});
		});
		
	</script>
	</head>
	
	<body>
		<div class="big_div">
				<div class="div_top">
				
			</div>
			<div class="div_left">
				<div class="head_picture">

				</div>
				<center><span classd="admin">管理员：<s:property value="username" /></span></center>
				<button class="operation_one">
					查询用户
				</button>
				<button class="operation_three">
					
				</button>
			</div>
			<div class="div_right">
				<iframe src="" name="operation" width="1135px" height="620px" frameborder="1" scrolling="no"></iframe>
			</div>
		</div>
	</body>
</html>
				