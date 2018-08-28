
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include.jsp"%>
<script type="text/javascript" src="${msUrl}/js/sys/sysLog.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	laydate({
	    elem: '#maxOperationTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
	    event: 'focus', //响应事件。如果没有传入event，则按照默认的click
	});
	laydate({
	    elem: '#minOperationTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
	    event: 'focus' ,//响应事件。如果没有传入event，则按照默认的click
	});
	
	$("#editForm").validate();
	laydate({
		elem: '#minOperationTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
		event: 'focus', //响应事件。如果没有传入event，则按照默认的click
		min: laydate.now(), //设定最小日期为当前日期
		max: '2099-06-16 23:59:59', //最大日期				
		format: 'YYYY/MM/DD',
		istime: true,
		istoday: false,
		choose: function(datas){ //选择日期完毕的回调
			maxOperationTime.min = datas;
			maxOperationTime.start = datas;
			/* alert(datas); */
		laydate({
			elem: '#maxOperationTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			event: 'focus', //响应事件。如果没有传入event，则按照默认的click
			min: datas,
			max: '2099-06-16 23:59:59',
			format: 'YYYY/MM/DD',
			istime: true,
			istoday: false,
			choose: function(datas){ //选择日期完毕的回调
				start.max = datas;
				/* alert(datas); */
			}
		});
		}
	});
	
});
</script>
  <div class="panel">
<div class="panel-heading">
<!--查询条件  -->
<form action="" class="list_con_form clearfix" id="searchForm">
	<span class="manage_unit clearfix"> <span class="manage_span_name">模块&nbsp&nbsp</span> <input
			type="text" name="moduleName" id="moduleName"  class="manage_input wd160" style="height: 40px" />
	</span>
	<span class="manage_unit clearfix"> <span class="manage_span_name">操作&nbsp&nbsp</span> <input
			type="text" name="operation" id="operation" class="manage_input wd160" style="height: 40px" />
	</span>
	<span class="manage_unit clearfix"><span class="manage_span_name">时间&nbsp&nbsp</span><input type="text" id="minOperationTime" class="laydate-icon" style="height: 40px" > &nbsp&nbsp到 </span>
	<span class="manage_unit clearfix"><span class="manage_span_name"></span><input type="text" id="maxOperationTime" class="laydate-icon" style="height: 40px" ></span>	

	<span class="manage_unit clearfix"> <input type="button" value="查询" onclick="STableUtils.reloadTable()" class="h32 inline_blo flole prl20 orage_bg"> </span>
</form>
</div>

<div class="dashed-line"></div>
<div class="panel-body">
<table id="table" class="table_data"></table>
</div></div>


