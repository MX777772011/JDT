var childPid  ;
var pidArray = [];
$(function() {
	var tableconfig={
url : 'dataList.do',
queryParams : function (params) {//查询参数，如果无自定义查询参数，可以不用写
return {
		rows : params.pageSize,// 每页多少条
		page : params.pageNumber,// 当前页
		sort : params.sortName,// 根据哪个字段排序
		order : params.sortOrder,//升降序 
		name : $("#name").val(),//自定义查询属性
		pid : $("#_querypid").val()
	};
},
columns : [
           {
        	   checkbox : true
           },
           {
        	   field : "id",
    	   title : "ID",
    	   //width : 50,
    	   align : 'center',
    	   sortable : true
       },
       {
    	   field : "name",
    	   title : "栏目名称",
    	   //width : 100,
    	   align : 'center',
    	   sortable : true,
    	   formatter : function(value, row, index) {
    		   var html = "<a href='#' onclick='loadPage(\"siteNews/childColumnList.shtml?pid="
    			   + row.id
    			   + "\");'>"
    			   + row.name
    			   + "</a>";
    		   return html;
    	   }
       },
       {
    	   field : "description",
    	   title : "描述",
    	   //width : 150,
    	   align : 'center',
    	   sortable : true
       },
       {
    	   field : "sorting",
    	   title : "排序",
    	   //width : 80,
    	   align : 'center',
    	   sortable : true
       },
       {
    	   field : "createTime",
    	   title : "日期",
    	   //width : 150,
    	   align : 'center',
    	   sortable : true
       },
       {
    	   field : "creatUserName",
    	   title : "创建人",
    	   //width : 120,
    	   align : 'center',
    	   sortable : true
       },
       {
    	   field : 'forbidden',
    	   title : '状态',
    	   //width : 80,
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
       },
       {
    	   field : "view",
    	   title : "访问量",
    	   //width : 80,
    	   align : 'center',
    	   sortable : true
       },
       {
    	   field : "type",
    	   title : "类别",
    	   //width : 80,
    	   align : 'center',
    	   sortable : true ,
    	   formatter : function (value,row,index){
    		   if (value == 0) {
    			   return "列表";
    		   }
    		   if (value == 1) {
    			   return "内容";
    		   }
    	   }
       },
       {
    	   field : 'childColumn',
    	   title : '子栏目',
    	   //width : 120,
    	   align : 'center',
    	   formatter : function(value, row, index) {
    		   var html = "<a href='#' onclick='toList("
    			   + row.id
    			   + ","+row.pid+")'>子栏目管理("
    			   + row.subCount + ")</a>";
    		   return html;
    	   }
       } ]
	}
	STableUtils.initBootstrapTable(tableconfig);
});
//删除
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
//添加
function add(){
	$("#editForm").clearForm(true);
	SPlatForm.openModal('#editDiv');
}
// 修改--根据id读取数据方法
function loadData(id) {
	var postOption={
			url : "getId.do",
			data : {id:id},
			success : function(result){//成功的回调
				SPlatForm.openModal('#editDiv');
				$("#editForm").fill(result.data); 
			}
		}
	SPlatForm.post(postOption);
}
//修改
function update(){
	$( "#editForm" ).validate();
	$( "#editForm" ).clearForm(true);
	var array=STableUtils.getOneSelect('table');//获取选中的记录
	if(array){
		loadData(array[0].id);
	}
}
//编辑
function updateSave(){
	if($("#editForm").valid()){
		SPlatForm.ajaxSubmit($("#editForm"),{//ajaxSubmit提交表单
			successTodo : function(result){//成功的回调
				SPlatForm.alert(result.msg);
				SPlatForm.closeModal('#editDiv');
				STableUtils.refreshTable();//执行成功后刷新页面
			}
		}) ;
	}
}
//返回子菜单
function toList(id,pid){
	pidArray.push(pid);//将所有pid存放数组
//	console.log("pidArray:"+pidArray);
	$("#_querypid").val(id);
	//$('#table').bootstrapTable("hideColumn","childColumn");
	$('#table').bootstrapTable("refresh");
	$("#btnfh").css('display','inline-block');
	$('#btnfh').removeClass('hidden');
	$("#btnfhs").css('display','inline-block');
	$('#btnfhs').removeClass('hidden');
}
//返回顶部
function returnFid(){
	$("#_querypid").val('');
	//$('#table').bootstrapTable("showColumn","childColumn");
	$('#table').bootstrapTable("refresh");
	$('#btnfh').addClass('hidden');
	$('#btnfhs').addClass('hidden');
}

//返回上一级
function returnGo(){
	childPid = pidArray[pidArray.length-1];
	//pidArray.pop();//移除最后一个元素并返回该元素值
	console.log("pidArray.pop():"+pidArray.pop());
	$("#_querypid").val(childPid);
	//$('#table').bootstrapTable("showColumn","childColumn");
	$('#table').bootstrapTable("refresh");	
	if(childPid==null){
		$('#btnfh').addClass('hidden');
		$('#btnfhs').addClass('hidden');
	}
}