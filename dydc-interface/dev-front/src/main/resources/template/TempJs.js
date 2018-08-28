$(function() {
	var tableconfig={
			url : 'dataList.do',
			queryParams : function queryParams(params) {//查询参数，如果无自定义查询参数，可以不用写
				return {
					rows : params.pageSize,//每页多少条
					page : params.pageNumber,//当前页
					sort : params.sortName,//根据哪个字段排序
					order : params.sortOrder,//升降序 
					//name : $("#name").val(),//自定义查询属性
					parentId : $("#_querypid").val()
				};
			},
			columns :  [ {
				checkbox : true
			}, 
			#foreach ($col in $columnDatas)
			#if($col.columnName=='id')
				{
					field : "id",
					title : "ID",
					width : 50,
					align : 'center',
					sortable : true
				}
			#elseif($col.dataType=='java.util.Date')
				
			{
				field : "$col.columnName",
				title : "$col.columnComment",
				align : 'center',
				sortable : true
			}  
			#else
			{
				field : "$col.columnName",
				title : "$col.columnComment",
				align : 'center',
				sortable : true
			}  
			
			#end
			#if(!$foreach.last) 
			,
			#end
			
			#end
			]
	}
	STableUtils.initBootstrapTable(tableconfig);
});

//删除记录
function del(){ 
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
//添加纪录
function add(){ 
//	$("#editForm").clearForm(true);
//	SPlatForm.openModal('#editDiv');
	SPlatForm.createTab("/${lowerName}/toAdd.do",{
		title : "新增",
		content : "editor"
	});
}

// 修改--根据记录打开弹窗
/*function update(){
	$( "#editForm" ).validate();
	$( "#editForm" ).clearForm(true);
	var array=STableUtils.getOneSelect('table');//获取选中的记录
	SPlatForm.openModal('#editDiv');
	loadData(array[0].id);
}*/
//修改
function update(id) {
		SPlatForm.createTab('/${lowerName}/toAdd.do?id=' + id,{
			title : "修改信息",
			content : "editor"
		});
}
//编辑
function updateSave(){
	if($("#editForm").valid()){
		SPlatForm.ajaxSubmit($("#editForm"),{//ajaxSubmit提交表单
			successTodo : function(result){//成功的回调
				SPlatForm.closeModal('#editDiv');
				STableUtils.refreshTable();//执行成功后刷新页面
			}
		}) ;
	}
}

