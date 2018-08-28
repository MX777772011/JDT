<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include.jsp" %> 
<html>
<head>
<title>文件上传</title>
</head>
<body>
	
	<form class="form-horizontal" action="${ctx}admin/auth/ad/update" method="post">
	
		
		<div class="form-group">
			<label for="" class="col-sm-1 control-label">广告图片</label>
			<div class="col-sm-10">
				<div style="height:100px;">
						<img id="adShow" src="${ctx}${ad.url==null||ad.url==''?'static/images/default.png':ad.url}" class="img-responsive" style="border: 1px solid gray;max-height:100%">
				</div>
				<input id="adUpload" class="btn btn-success" type="button" value="上传图片 ">
				<input type="text" style="position: absolute;top: -500000px" name="url" required id="adUrl" value="${ad.url}">
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-3 text-center">
				<button type="button" class="btn btn-default" onclick="javascript:window.history.go(-1);">取消</button>
				<button type="submit" class="btn btn-success">保存</button>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript" src="${msUrl}/js/upload/ajaxupload.3.6.js"></script>
<script type="text/javascript">
	$("#adTarget").val($("#adTarget").attr("value"));
	$("#adPosition").val($("#adPosition").attr("value"));
	
	new AjaxUpload("#adUpload", {
		action : "${ctx}noauth/interface/upload/uploadimg?"+new Date(),
		name:"file",
		onChange : function(file, ext) {
			if (!(ext && /^(jpg|jpeg|JPG|JPEG|png|PNG|gif|GIF)$/.test(ext))) {
				alert("图片格式不正确,请选择 jpg|jpeg|JPG|JPEG|png|PNG|gif|GIF 格式的文件!", "系统提示");
				return false;
			}
		},
		onSubmit : function(file, ext) {
			if (!(ext && /^(jpg|jpeg|JPG|JPEG|png|PNG|gif|GIF)$/.test(ext))) {
				alert("图片格式不正确,请选择 jpg|jpeg|JPG|JPEG|png|PNG|gif|GIF 格式的文件!", "系统提示");
				return false;
			}
			$(".btn-success").attr({"disabled":"disabled"});
		},
		onComplete : function(file, response) {
			if (response) {
				var obj=jQuery.parseJSON(response);
				if(obj.code=="01"){
					$("#adShow").attr("src","${ctx}"+obj.path);
					$("#adUrl").val(obj.path);
				}else if(obj.code=="00"){
					alert("图片格式不正确,请选择 jpg 格式的文件!", "系统提示");
				}else{
					alert("上传错误！");
				}
				$(".btn-success").removeAttr("disabled");
			}
		}
	});
</script>
</html>