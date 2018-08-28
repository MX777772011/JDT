$(function() {
	var tableconfig={
		url : 'dataList.do',
		queryParams : function (params) {//查询参数，如果无自定义查询参数，可以不用写
			return {
				rows : params.pageSize,//每页多少条
				page : params.pageNumber,//当前页
				sort : params.sortName,//根据哪个字段排序
				order : params.sortOrder,//升降序 
				roleName : $("#roleName").val()
			//自定义查询属性
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
			field : "roleName",
			title : "角色名称",
			width : 150,
			align : 'center',
			sortable : true
		}, {
			field : 'state',
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
			field : "createTime",
			title : "创建时间",
			width : 150,
			align : 'center',
			sortable : true
		}, {
			field : "updateTime",
			title : "更新时间",
			width : 150,
			align : 'center',
			sortable : true
		}, {
			field : "descr",
			title : "角色描述",
			width : 150,
			align : 'center',
			sortable : true
		} ]
	}
	STableUtils.initBootstrapTable(tableconfig);
});
//删除
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
//添加
function add(id){ 
	$("#editForm").clearForm(true);
	clearTreeData();
	SPlatForm.openModal('#editDiv');
}	
//修改--根据id读取数据方法
function loadData(id) {
	
	var postOption={
			url : "getId.do",
			data : {id:id},
			success : function(result){//成功的回调
				SPlatForm.openModal('#editDiv');
				$("#editForm").fill(result.data); 
				var btnIds  = result.data.btnIds;
				var menuIds  = result.data.menuIds;
				$.each(btnIds,function(i,id){
					setTreeValue("btn_"+id);
				});
				
				$.each(menuIds,function(i,id){
					setTreeValue("menu_"+id);
				});
			}
		}
	SPlatForm.post(postOption);
}
//修改
function update(){
	$("input[type='radio']").attr("checked",false);
	$( "#editForm" ).validate();
	$( "#editForm" ).clearForm(true);
	clearTreeData();
	var array=STableUtils.getOneSelect('table');//获取选中的记录
	if(array){
		loadData(array[0].id);
	}
}
//编辑
function updateSave() {
	if ($("#editForm").valid()) {
		var checknodes = $('#menu-tree').tree('getChecked');
		var innodes = $('#menu-tree').tree('getChecked', 'indeterminate');
		buildTreeData(checknodes);
		buildTreeData(innodes);
		SPlatForm.ajaxSubmit($("#editForm"),{//ajaxSubmit提交表单
			successTodo : function(result){//成功的回调
				SPlatForm.alert(result.msg);
				SPlatForm.closeModal('#editDiv');
				STableUtils.refreshTable();//执行成功后刷新页面
			}
		}) ;
	}
}
