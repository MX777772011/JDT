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
<script src="<%=path%>/js/jquerylib/jquery-1.11.1.min.js"></script>
<script src="<%=path%>/js/layer/layer.js"></script>
<script src="<%=path%>/js/layer/laycode.js"></script>
<script src="<%=path%>/js/jquerylib/jquery-form.js"></script>
<script src="<%=path%>/js/jquerylib/jquery.cookies.js"></script>
<script src="<%=path%>/js/common/uuid.js"></script>
<script src="<%=path%>/js/common/cookieUtil.js"></script>

<link rel="stylesheet" type="text/css" href="${msUrl}/css/hebase.css">
<link rel="stylesheet" type="text/css" href="${msUrl}/css/liststyle.css">
<link rel="stylesheet" type="text/css" href="${msUrl}/css/layer/layer.css">
<link rel="stylesheet" type="text/css" href="${msUrl}/css/layer/laycode.css">

<script type="text/javascript">
	function refreshValid() {
		var _url = "ImageServlet?time=" + new Date().getTime();
		$("#validImg").attr('src', _url);
	}
	$(function() {

		$("input[name='machine_code']").val(LHJT_SESSION_ID);

	});

	function loginForm() {
		var index = layer.load(2);
		var option = {
			dataType : 'json',
			success : function(data) {
				layer.close(index);

				layer.msg(data.msg, {
					icon : -1,
					time : 2000
				//2秒关闭（如果不配置，默认是3秒）
				}, function() {
				});
			}
		};
		$("#loginForm").ajaxSubmit(option);
	}

	function requesCode(url) {
		var index = layer.load(2);
		var option = {
			dataType : 'json',
			url : url,
			success : function(data) {
				layer.msg(data.msg + ",code:" + data.code, {
					icon : -1,
					time : 3000
				//2秒关闭（如果不配置，默认是3秒）
				}, function() {
					//关闭layer
					
				});
				layer.close(index);
			}
		};
		$("#loginForm").ajaxSubmit(option);
	}
	function updateUserPassword(url) {
		var index = layer.load(2);
		var option = {
			dataType : 'json',
			url : url,
			success : function(data) {
				layer.msg(data.msg + ",code:" + data.code, {
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
</script>
</head>
<body class="login_body">
	<div class="login_con">
		<form action="register.do" class="login_form" method="post" id="loginForm">
			<input type="text" class="login_text" name="service" value="http://www.suntrayoa.com">
			登录名：
			<input type="text" class="login_text" name="username" value="13661386395">
			昵称：
			<input type="text" class="login_text" name="nickname" value="索超">
			手机：
			<input type="text" class="login_text" name="phone" value="13661386395">
			linkType：
			<select name="linkType">
				<option value="0" selected="selected">注册发验证码</option>
				<option value="2">找回密码发验证</option>
			</select>
			<br /> 密码：
			<input type="text" class="login_text" name="password" value="suochaochao123">
			source:
			<input type="text" class="login_text" name="source" value="http://www.suntrayoa.com">
			机器码：
			<input type="text" class="login_text" id="machineCode" name="machine_code">
			<input type="button" onclick="requesCode('putPhoneCode.do')" class="login_btn ft16 ftbol" value="获取验证码">
			验证码：
			<input type="text" class="login_text" name="code" value="">
			<input type="button" onclick="loginForm()" class="login_btn ft16 ftbol" value="立即注册">
			新密码：
			<input type="text" class="login_text" name="newPassword" value="suochao123">
			<input type="button" onclick="requesCode('updateUserPassword.do')" class="login_btn ft16 ftbol" value="通过手机验证码修改密码">
			<br />
			<select name="type">
				<option value="1" selected="selected">修改手机号</option>
				<option value="2">修改昵称</option>
				<option value="3">修改密码</option>
				<option value="5">获取用户信息</option>
			</select>
			<input type="button" onclick="requesCode('updateUser.do')" class="login_btn ft16 ftbol" value="修改用户信息">

			<input type="button" onclick="requesCode('updateUserPassword.do')" class="login_btn ft16 ftbol" value="通过手机验证码修改密码">
		</form>
	</div>
</body>
</html>