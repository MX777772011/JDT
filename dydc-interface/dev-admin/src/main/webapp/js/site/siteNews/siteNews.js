$(function() {
	var tableconfig={
		url : 'dataList.do',
		queryParams : function(params) {
			return {
				rows : params.pageSize,// 每页多少条
				page : params.pageNumber,// 当前页
				sort : params.sortName,// 根据哪个字段排序
				order : params.sortOrder,// 升降序
				title : $("#title").val(),// 自定义查询属性
				pid : $("#pid").val()
			// 自定义查询属性

			};
		},
		columns : [ {
			checkbox : true
		}, {
			field : "id",
			title : "ID",
			width : 50,
			align : 'center',
			sortable : true
		}, {
			field : "title",
			title : "标题",
			width : 100,
			align : 'center',
			sortable : true
		}, {
			field : "newscolumn",
			title : "栏目",
			width : 100,
			align : 'center',
			sortable : true
		}, {
			field : "creatUserName",
			title : "创建人",
			width : 120,
			align : 'center',
			sortable : true
		}, {
			field : "createTime",
			title : "创建时间",
			width : 120,
			align : 'center',
			sortable : true
		}, {
			field : 'status',
			title : '状态',
			width : 80,
			align : 'center',
			sortable : true,
			styler : function(value, row, index) {
				if (value == 1) {
					return 'color:red;';
				}
			},
			formatter : function(value, row, index) {
				if (value == 0) {
					return "可用";
				}
				if (value == 1) {
					return "禁用";
				}
			}
		}, {
			field : "view",
			title : "访问量",
			width : 80,
			align : 'center',
			sortable : true
		}

		]
	}
	STableUtils.initBootstrapTable(tableconfig);
});
function del() {
	var array = STableUtils.getMultiSelect('table');//获取选中的记录
	if(array){
		SPlatForm.confirm('您确定要删除么',{
			btn:['删除','取消'],//如果不写，默认为 确认/取消
			confirm:function(){//点击确定时的操作
				var postOption={
					url : "delete.do",
					//默认按照id去找，如果使用其他主键，可以写参数(array,'id')
					data : STableUtils.getDataFromArrayAndKey(array),
					success : function(result){//成功的回调
						SPlatForm.alert(result.msg);
						STableUtils.refreshTable();//执行成功后刷新页面
					}
				}
				SPlatForm.post(postOption);
			}
		});
	}
}
// 添加
function add() {
	SPlatForm.createTab("/siteNews/toAddNews.do",{
			title : "新增新闻",
			content : "editor"
		});
}
// 修改
function update() {
	var array=STableUtils.getOneSelect('table');//获取选中的记录
	if(array){
		SPlatForm.createTab('/siteNews/toAddNews.do?id=' + array[0].id,{
			title : "编辑新闻:"+array[0].title,
			content : "editor"
		});
		
	}
}