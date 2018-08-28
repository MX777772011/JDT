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
		<script src="<%=path %>/js/jquerylib/jquery.cookies.js"></script>
		<script src="<%=path %>/js/common/uuid.js"></script>
		<script src="<%=path %>/js/common/cookieUtil.js"></script>
		
		<link rel="stylesheet" type="text/css" href="${msUrl}/css/hebase.css">
		<link rel="stylesheet" type="text/css" href="${msUrl}/css/liststyle.css">
		<link rel="stylesheet" type="text/css" href="${msUrl}/css/layer/layer.css">
		<link rel="stylesheet" type="text/css" href="${msUrl}/css/layer/laycode.css">
		
		<script type="text/javascript">
		function refreshValid(){
			var _url = "ImageServlet?time="+new Date().getTime();
			$("#validImg").attr('src',_url);
		}
	    $(function(){
	    	$("input[name='machine_code']").val(LHJT_SESSION_ID);
	    });
		function loginForm(){
			//if(form.form('validate')){//验证 等验证框架整入喉补充
			var index = layer.load(2);
			var option = {
				dataType:'json',
				success:function(data){ 
					layer.close(index);
					
					layer.msg(data.msg+",code:"+data.code, {
					icon : -1,
					time : 3000
					//2秒关闭（如果不配置，默认是3秒）
					}, function() {
							//关闭layer
					});
				}
			};
			$("#loginForm").ajaxSubmit(option);
		}
		function showValue(){
			$.post("${msUrl}/redisDemo/getRedisInfo.do",{key:$('#key').val()},function(data){
				alert("value："+data.value);
			},"json");
		}		
		function logout(){
			$.post("${msUrl}/logout.do",{key:$('#key').val()},function(data){
				alert("value："+data.value);
			},"json");
		}	
</script>
</head>
	<body class="login_body">
		<div class="login_con">
			<form action="toLogin.do" class="login_form" method="post" id="loginForm">
				<input type="text" class="login_text" name="username"  value="13661386395">
				<input type="text" id='log_pwd' class="login_pwd" name="password" value="suochao123">
				<p class="login_code clearfix">
				<input type="text" class="login_text" id="machineCode" name="machine_code"  value="">
				<input type="text" class="login_text" name="service" value="http://www.suntrayoa.com">
				<!--	<img onclick="refreshValid()" id="validImg" src="<%=path %>/ImageServlet?time=new Date().getTime()" height="44" width="97" alt="点击刷新验证码">-->
				</p>
				<p class="login_p" id="logp">
					<input type="checkbox" class="hidden">
					<span class="checkspan">记住用户名</span>
					<a href="toRegister.do">注册</a>
				</p>
				<input type="button" onclick="loginForm()" class="login_btn ft16 ftbol" value="立即登录">
				
				<input type="button" onclick="logout()" class="login_btn ft16 ftbol" style ="margin-top:10px;"value="立即退出">
				<input type="text" name="key" id="key" class="form-control" value="${key}"/>
				<input type="button" onclick="showValue()" class="login_btn ft16 ftbol" value="获取redis值">
			</form>
		</div>
	</body>
</html>