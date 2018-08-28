<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>微信页面</title>
<meta name="viewport" content="width=device-width,user-scalable=no,initial-scale=1, maximum-scale=1">
	<link type="text/css" rel="stylesheet" href="<%=path %>/css/wechat/index.css" />
	<link type="text/css" rel="stylesheet" href="<%=path %>/css/wechat/accordion.css" />
	<script src="<%=path %>/js/jquerylib/jquery-1.11.1.min.js"></script>
   	 <!--layer-->
   	 <link rel="stylesheet" type="text/css" href="<%=path %>/css/layer/layer.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/layer/laycode.css">
   	<script src="<%=path %>/js/layer/layer.js"></script>
	<script src="<%=path %>/js/layer/laycode.js"></script>
</head>

<style type="text/css">
</style>
<body>
<div style="float:left;width:25%;">
<div id="appmsg200159594" class="pp">
<div class="appmsg multi" data-fileid="200159570" data-id="200159594">
<div class="appmsg_content">
<div class="appmsg_info">
	<em class="appmsg_date">${addtime}</em>
</div>

<div class="cover_appmsg_item" onmouseover="mouseover('header')" onmouseout="mouseout('header')">
	<h4 class="appmsg_title">
		<a target="_blank" href="#">${headerNews.title}</a>
	</h4>
	<div class="appmsg_thumb_wrp">
		<img class="appmsg_thumb" alt="" src="${headerNews.imagePath}">
	</div>
	<div class="fe" style="display: none">
		<a class="edit1" href="#" onclick="goUpate('${headerNews.id}')"></a>
	</div>
</div>

<c:forEach items="${newsList}" var="news">
	<div class="appmsg_item" onmouseover="mouseover('item')" onmouseout="mouseout('item')">
		<div class="fd" style="display: none">
			<a class="edit" id="edit" href="#" onclick="goUpate('${news.id}')" ></a>
			<a class="dete" id="delete"  href="#" onclick="goDelete('${news.id}')"></a>
		</div>
		<img class="appmsg_thumb" alt="" src="${news.imagePath}">
		<h4 class="appmsg_title">
			<a target="_blank" href="#">${news.title}</a>
		</h4>
		</div>

</c:forEach>
	</div>
</div>

</div>
</div>
<script type="text/javascript">
	function mouseover(symbol){
		if(symbol=='header'){
			$(".fe").removeAttr("style");
			$(".fd").attr("style","display:none");
		}else if(symbol=='item'){
		    $(".fe").attr("style","display:none");
			$(".fd").removeAttr("style");
		}
	}
	
	function mouseout(symbol){
		if(symbol=='header'){
			$(".fe").attr("style","display:none");
		}else if(symbol=='item'){
			$(".fd").attr("style","display:none");
		}
	}
	
	
	function goUpate(newsId){
		var  url = 'weixinNewsitem.do?goUpdate&id='+newsId;
		$("#showframe").attr("src",url);
	}
	
	function goDelete(newsId){
		layer.confirm('您确定要删除吗？', {
			btn : [ '删除', '取消' ], //按钮
			shade : false
		//不显示遮罩
				}, function() {
					var url = "<%=request.getContextPath() %>/weixinNewsitem/delete.do?id="+newsId;
					$.ajax({
						url:url,
						dataType:"JSON",
						method:"post",
						success:function(data){
						    if(data.success){
						    	layer.msg('已删除', {
									tips : 2
								});
							}
						    location.reload(); 
						}
					});
					
				}, function() {
					layer.msg('已取消', {
						tips : 2
					});
				});
	}
	
	function refresh(){
		 location.reload(); 
	}
	
</script>

<div style="float:right;width:75%;">
<iframe scrolling="yes" id="showframe" src="" frameborder="0" style="width:100%;height:520px;"></iframe></div>

</body>
</html>
