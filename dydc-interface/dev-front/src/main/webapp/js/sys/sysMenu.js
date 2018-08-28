$(function() {
	var tableconfig={
			url : 'dataList.do',
			queryParams : function (params) {//查询参数，如果无自定义查询参数，可以不用写
				return {
					rows : params.pageSize,//每页多少条
					page : params.pageNumber,//当前页
					sort : params.sortName,//根据哪个字段排序
					order : params.sortOrder,//升降序 
					name : $("#name").val(),//自定义查询属性
					parentId : $("#_querypid").val()
				};
			},
			columns : [
						{
							checkbox : true
						},
						{
							field : 'id',
							title : 'ID',
							//width : 50,
							align : 'center',
							sortable : true
						},
						{
							field : 'name',
							title : '名称',
							//width : 120,
							align : 'center',
							sortable : true
						},
						{
							field : 'rank',
							title : '排序',
							align : 'center',
							//width : 80,
							sortable : true
						},
						{
							field : 'url',
							title : '路径',
							//width : 100,
							align : 'center',
							sortable : true
						},
						/*{
							field : 'createTime',
							title : '创建时间',
							//width : 150,
							align : 'center',
							sortable : true
						},
						{
							field : 'updateTime',
							title : '更新时间',
							//width : 150,
							align : 'center',
							sortable : true
						},*/
						{
							field : 'childMenus',
							title : '子菜单',
							//width : 120,
							align : 'center',
							formatter : function(value, row, index) {
								var html = "<a href='javascript:void(0)' onclick='toList(\""
										+ row.id + "\")'>子菜单管理(" + row.subCount
										+ ")</a>";
								return html;
							}
						} ]
			
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
				delAllLine(true);
				$.each(result.data.btns,function(i,btn){
					addLine(btn);
				});
			}
		}
	SPlatForm.post(postOption);
}


// 修改--根据记录打开弹窗
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
//增加隐藏弹出框里面的一行增加菜单的表单
function addLine(data){
	var table = $("#tyshuju");
	var	html = "<tr class='tb-line'>";
	html+=	   "	<td><input name=\"btnName\" type=\"text\" class=\"form-control\" ></td>";
	html+=	   "	<td><input name=\"btnType\" type=\"text\" class=\"form-control\"  ></td>";
	html+=	   "	<td><input name=\"actionUrls\" type=\"text\" class=\"form-control\"  ></td>";
	html+=	   "	<td align='center'><input type=\"button\" class=\"form-control remove-btn\" value=\"-\" ></input>";
	html+=	   "		<input class=\"hidden\" name=\"btnId\">";
	html+=	   "		<input class=\"hidden\" name=\"deleteFlag\">";
	html+=	   "	</td>";
	html+=	   "</tr>";
	var line = $(html);//将这段html封装为jQuery对象
	//绑定删除按钮事件
	$(".remove-btn",line).click(function(){
			
		var index=layer.confirm('删除确认','你确定删除菜单么?',function(r){
			if(r){
				delLine(line);
				layer.close(index);
			}
		})
	});
	if(data){
		if(data.id){
			$(".newFlag",line).html(''); //清空新增标记
		}
		$("input[name='btnId']",line).val(data.id);
		$("input[name='btnName']",line).val(data.btnName);
		$("input[name='btnType']",line).val(data.btnType);
		$("input[name='actionUrls']",line).val(data.actionUrls);
	}
 
	table.append(line);
	
	
	
	
}
//删除全部
function delAllLine(b){
	if(b){
		$(".tb-line").remove();
	}else{
		$(".tb-line").each(function(i,line){
			delLine($(line));
		});
	}
}	
//删除单行
function delLine(line){
	if(line){
		var btnId = $("input[name='btnId']",line).val();
		if(btnId){
			$("input[name='deleteFlag']",line).val(1); //设置删除状态
			line.fadeOut();
		}else{
			line.fadeOut("fast",function(){
				 $(this).remove();
			});
		}
	}
}
//设置默认按钮数据
function addDefBtns(){
	var defaultBtns= [
		{"btnName":"添加","menuid":2,"actionUrls":"save.do","btnType":"add"},
		{"btnName":"修改","menuid":2,"actionUrls":"getId.do|save.do","btnType":"edit"},
		{"btnName":"删除","menuid":2,"actionUrls":"delete.do","btnType":"remove"}
	];
	var tbline = $(".tb-line:visible");
	var btnType = $("input[name='btnType']",tbline);
	$.each(defaultBtns,function(i,btn){
		var isExists = false;
		//判断按钮类型是否存在
		if(btnType.length > 0){
			for(var i =0; i < btnType.length; i++){
				if(btnType.eq(i).val() == btn.btnType){
					isExists = true;
					break;
				}
			}
		}
		if(!isExists){
			addLine(btn);
		}
	});
}
//查询子菜单
function toList(pid){
	$("#_querypid").val(pid);
	$('#table').bootstrapTable("hideColumn","childMenus");
	$('#table').bootstrapTable("refresh");
	$("#btnfh").css('display','inline-block'); 
	$('#btnfh').removeClass('hidden');
	//$('#btnfh').show();
	
	
}
//返回父菜单
function returnFid(){
	$("#_querypid").val('');
	$('#table').bootstrapTable("showColumn","childMenus");
	$('#table').bootstrapTable("refresh");
	$('#btnfh').addClass('hidden');
	//$('#btnfh').hide();
	//$("#btnfh").css('display','none'); 
}
