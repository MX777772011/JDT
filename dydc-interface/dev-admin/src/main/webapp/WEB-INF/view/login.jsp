<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
  <head>
  		<title>互联网项目开发平台2.0.1</title>
		<script src="<%=path %>/js/jquerylib/jquery-1.11.1.min.js"></script>
		<script src="<%=path %>/js/layer/layer.js"></script>
		<script src="<%=path %>/js/layer/laycode.js"></script>
		<script src="<%=path %>/js/jquerylib/jquery-form.js"></script>
		<link rel="stylesheet" type="text/css" href="${msUrl}/css/hebase.css">
		<link rel="stylesheet" type="text/css" href="${msUrl}/css/liststyle.css">
		<link rel="stylesheet" type="text/css" href="${msUrl}/css/layer/layer.css">
		<link rel="stylesheet" type="text/css" href="${msUrl}/css/layer/laycode.css">
		
		<script type="text/javascript">
		function refreshValid(){
			var _url = "ImageServlet?time="+new Date().getTime();
			$("#validImg").attr('src',_url);
		}

		function loginForm(){
			//if(form.form('validate')){//验证 等验证框架整入喉补充
			
			var index = layer.load(2);
				
			var option = {
				dataType:'json',
				success:function(data){ 
					layer.close(index);
					
					layer.msg(data.msg, {
					icon : -1,
					time : 1000
					//2秒关闭（如果不配置，默认是3秒）
					}, function() {
							//关闭layer
						
						if (data.success) {
							window.location = "main.shtml";
						}else{
							$('#validInput').val('');
							refreshValid();//刷新验证码
							
						}
					});
				}
			};
			$("#loginForm").ajaxSubmit(option);

		 
		//}
		}

		$(document).ready(function(){
			document.getElementById('validInput').onkeydown=function(ev)
			{
				var oEvent=ev||event;
				if(oEvent.keyCode==13)
				{
					loginForm();
				}
			}
		});
</script>
</head>
	<body class="login_body">
		<div class="login_con">
			<form action="toLogin.do" class="login_form" method="post" id="loginForm">
				<input type="text" class="login_text" name="email"  value="">
				<input type="password" id='log_pwd' class="login_pwd" name="pwd" value="">
				<%-- <p class="login_code clearfix">
					<input type="text" class="login_text" id="validInput" name="verifyCode">
					<img onclick="refreshValid()" id="validImg" src="<%=path %>/ImageServlet?time=new Date().getTime()" height="44" width="97" alt="点击刷新验证码">
				</p> --%>
				<p class="login_p" id="logp" style="text-align: right">
					<span class="checkspan">记住密码</span>
<!-- 					<a href="找回密码.htm">忘记密码？</a> -->
				</p>
				<input type="button" onclick="loginForm()" class="login_btn ft16 ftbol" value="立即登录">
			</form>
		</div>
	</body>
</html>