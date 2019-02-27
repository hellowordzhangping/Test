<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!--   <link rel="stylesheet" href="css/index.css" /> -->
  </head>
	<style type="text/css">
	</style>
  
	<script type="text/javascript" src="js/jquery-3.1.1.min.js" ></script>
	<script type="text/javascript" >
		
		$(document).ready(function() {
			
			$(".find").click(function() {			// 登录按钮
				$(".find_frame").show();			// 登录框显示
				$(".cover").show();					// 遮蔽层显示
				$(".find_register").hide();			// 注册框隐藏
				return false;
			});
			
			$(".find_close").click(function() {		// 关闭按钮
				$(".find_frame").hide();			// 登录框隐藏
				$(".cover").hide();					// 遮蔽层隐藏
				$(".find_register").hide()			// 注册框隐藏
				return false;
			});
			
			$("#register").click(function() {
				$(".find_frame").hide();			// 登录框隐藏
				$(".cover").show();					// 遮蔽层显示
				$(".find_register").show();			// 注册框显示
				return false;
			});
			
			$("button[name='register_button']").click(function(){
				var u_v = $("input[name='register_username']").val();
				var p_v = $("input[name='register_password']").val();
				
				if (u_v == null || u_v == "") {
					alert("用户名不能为空");
					return false;
				} else if (p_v == null || p_v == "") {
					alert("密码不能为空");
					return false;
				}
				
				var params = {
					username : u_v,
					password : p_v
				};
				
				$.ajax({
					url: "select_insert",
					type: "post",
					data: params,
					dataType: "json",
					success:function(data, textStatus) {
						alert("成功");
					 	$("#tishi").empty();
						var result = data.result;
						if (result == "用户名或密码不能为空") {
							$(".cover").show();
							$(".find_frame").show();
							$("#tishi").html(result);
							$("#tishi").css({"color": "red","font-size": "10px"});
						} else {
							alert("注册成功");
							$(".cover").hide();
							$(".find_register").hide();	
						} 
					},
					error:function(data, textStatus) {
						alert("错误");
						return false;
					}
				
				});
			});
			
			$("button[name='find_button']").click(function() {
				var u_v = $("input[name='username']").val();
				var p_v = $("input[name='password']").val();
				
				if (u_v == "" || u_v == null) {
					alert("用户名不能为空");
					return false;
				} 
				if (p_v == "" || p_v == null) {
					alert("密码不能为空");
				}
				
				var params = {
					username : u_v,
					password : p_v
				};
				
				$.ajax({
					url: "select_find",
					type: "post",
					data: params,
					dataType: "json",
					success:function(data, textStatus) {
						alert("成功");
						 $("#tishi").empty();
						var result = data.result;
						if (result == "用户名或密码不能为空") {
							$(".cover").show();
							$(".find_frame").show();
							$("#tishi").html(result);
							$("#tishi").css({"color": "red","font-size": "10px"});
						} else if (result == "用户名或密码错误") {
							$(".cover").show();
							$(".find_frame").show();
							$("#tishi").html(result);	
							$("#tishi").css({"color": "red","font-size": "10px"});
						} else {
							$(".document").empty();
							$(".find_frame").hide();
							$(".cover").hide();
							$(".document").html("欢迎您:" + result + "<a href='session_close'>注销</a>");
						} 
					},
					error:function(data, textStatus) {
						alert("错误");
						return false;
					}
				});
			});
		});
		
	</script>
  
  <body>

		<div>
			<center>登录
			<form action="User_find" method="post">
				<div class="frame_middle_username">
					账号:<input type="text" name="username" />
				</div>
				<br/>
				<div>
					密码:<input type="password" name="password" />						
				</div>
				<span id="tishi">${requestScope.result }</span>
				<br/>
				<input type="submit" name="登录" />
				</form>
				</center>
				
		</div>
		
	
			<center>
			注册
			<form action="User_insert" method="post">
				<div class="register_middle_username">
					账号:<input type="text" name="username" />
				</div>
				<br/>
				<div>
					密码:<input type="password" name="password" />						
				</div>
				<span id="tishi"></span>
				<br/>
			           <input type="submit" name="注册" />
			   </form>
			           
			</center>
		

	
  </body>
</html>