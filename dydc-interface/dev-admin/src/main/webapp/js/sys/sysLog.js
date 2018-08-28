$(function() {
	var tableconfig={
		url : 'dataList.do',
		queryParams : function (params) {//查询参数，如果无自定义查询参数，可以不用写
			return {
				rows : params.pageSize,//每页多少条
				page : params.pageNumber,//当前页
				moduleName : $("#moduleName").val(),// 自定义查询属性
				operation : $("#operation").val(),
				minOperationTime : $("#minOperationTime").val(),
				maxOperationTime : $("#maxOperationTime").val()
			};
		},
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
		},
		{
			field : "details",
			title : "操作数据",
			width : 80,
			align : 'center',
			sortable : true
		}]
	}
	STableUtils.initBootstrapTable(tableconfig);
});
