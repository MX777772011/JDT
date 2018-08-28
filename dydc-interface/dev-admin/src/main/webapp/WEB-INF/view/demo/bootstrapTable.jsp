<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bcss/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bcss/bootstraptable/bootstrap-table.css">
	<script src="<%=request.getContextPath() %>/js/jquerylib/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstraplib/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstraplib/bootstraptable/bootstrap-table.js"></script>
	<script type="text/javascript">
	$(function() {
		$('#table').bootstrapTable( {
			method : "post",
			contentType : "application/x-www-form-urlencoded",//远程数据请求的“contentType”类型,默认请写此
			dataType : "json",//远程数据请求返回的数据类型
			url : 'sysLog/dataList.do',
			idField : "id",
			sidePagination : "server",//定义表格分页的位置，只能是“client”（客户端）和“server”（服务器端）。
			pagination : true,//设置True在表格底部显示分页工具栏。
			pageNumber : 1,
			pageSize : 10,
			pageList : [ 10, 25, 50, 100 ],
			queryParamsType : "RESTFul",//设置为“limit”可以发送标准的RESTFul类型的参数请求。  默认请使用这个，如果项目上分页为limit方式时，写limit
			queryParams : queryParams,//远程数据请求时，可以通过queryParams来格式化所需要的数据信息，参数（对象）包含了：
			//pageSize, pageNumber, searchText, sortName, sortOrder。返回 false 可以禁用请求。
			smartDisplay : true,//设置为True智能显示分页或者Card View。
			//              cardView:true,//启用cardView模式
			showToggle : true,//设置为True可显示切换普通表格和名片（card）布局。
			//                 search: true,
			//                 searchAlign: 'right',
			selectItemName : 'btSelectItem',//单选框或者复选框的name，用于多个表格使用radio的情况。
			showHeader : true,//显示表头
			showColumns : true,//设置为True可显示表格显示/隐藏列表。
			//                 minimumCountColumns:1,//表格显示/隐藏列表时可设置最小隐藏的列数。
			//                 undefinedText:"---",//数据为空时显示 
			striped : true,//使表格带有条纹。
			showRefresh : true,//设置为True可显示刷新按钮。
			toolbar : "#toolbar",//定义toolbar是哪个
			toolbarAlign : "left",//对齐方式
			clickToSelect : true,//设置为True时点击行即可选中单选/复选框。
			//                 singleSelect:true,//只能选择一条记录
			//                 checkboxHeader:true,//设置为False时隐藏表头中的全选复选框。
			//                 maintainSelected:true,//设置为True当换页或者搜索时保持选中的行。
			//                 sortable:true,//设置为False时禁用所有列的排序。
			showExport : true,//设置为true，显示导出按钮。
			// exportTypes:['json', 'xml', 'csv', 'txt', 'sql', 'excel'],//出口类型，支持类型：“JSON”，“XML”，“PNG”，“CSV”，“TXT”，“SQL”，“文档”，“Excel的”，“简报”，“PDF”。
			//                 height:"auto",

			columns : [ {
				field : "id",
				title : "ID",
				width : 50,
				align : 'center',
				sortable : true
			}, {
				field : "userId",
				title : "用户昵称",
				width : 100,
				align : 'center',
				sortable : true
			},  {
				field : "operationTime",
				title : "创建时间",
				width : 150,
				align : 'center',
				sortable : true
			}, 
			{
				field : "moduleName",
				title : "模块名称",
				width : 100,
				align : 'center',
				sortable : true
			}, {
				field : "operation",
				title : "操作方法",
				width : 100,
				align : 'center',
				sortable : true
			},{
				field : "url",
				title : "路径",
				width : 150,
				align : 'center',
				sortable : true
			}
		});
	});
	</script>
  </head>
  
  <body>
    	<table id="table"></table>
  </body>
</html>
