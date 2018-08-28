$(function() {
	var tableconfig={
		url : 'dataList.do',
		queryParams : function (params) {
			return {
				rows : params.pageSize,// 每页多少条
				page : params.pageNumber,// 当前页
				sort : params.sortName,// 根据哪个字段排序
				order : params.sortOrder,// 升降序
				email : $("#email").val(),// 自定义查询属性
				nickName : $("#nicknName").val(),
				orgId : $("#queryOrgId").val()
			};
		},
		columns : [ {
			checkbox : true
		}, {
			field : "id",
			title : 'ID',
			width : 50,
			align : 'center',
			sortable : true
		}, {
			field : "email",
			title : "邮箱",
			width : 120,
			align : 'center',
			sortable : true
		}, {
			field : "nickName",
			title : "昵称",
			align : 'center',
			width : 120,
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
			field : "isTeamLeader",
			title : "是否项目经理",
			width : 80,
			align : 'center',
			sortable : true,
			formatter : function(value, row, index) {
				if (value == 0) {
					return "否";
				}
				if (value == 1) {
					return "是";
				}
			}
		}, {
			field : "loginTime",
			title : "最后登录时间",
			width : 150,
			align : 'center',
			sortable : true
		}, {
			field : 'orgName',
			title : '所属机构',
			width : 80,
			align : 'center',
			sortable : true
		}, {field:[
		     {
					field : 'roleStr',
					title : '角色',
					width : 150,
					align : 'center',
					sortable : true
				}, {
					field : 'roleStr',
					title : '角色',
					width : 150,
					align : 'center',
					sortable : true
				}
		     ]
		} ]
	}
	STableUtils.initBootstrapTable(tableconfig);
});

// 添加记录
function add() {
	var treeObj = $.fn.zTree.getZTreeObj("editTree");
	treeObj.checkAllNodes(true);
	var nodes = treeObj.getCheckedNodes(true);
	if (nodes.length > 0) {
		for (var i = 0; i < nodes.length; i++) {
			treeObj.checkNode(nodes[i], false, true, false);
		}
	}
	
	$("#editForm").clearForm(true);
	SPlatForm.openModal('#editDiv');
	
	var treeObj = $.fn.zTree.getZTreeObj("editTree");
	treeObj.expandAll(true);
}
// 删除记录
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

// 修改--根据记录打开弹窗
function update() {
	$("input[type='radio']").attr("checked",false);
	$("#editForm").validate();
	$("#editForm").clearForm(true);
	
	var array=STableUtils.getOneSelect('table');//获取选中的记录
	if(array){
		loadData(array[0].id);
		
		var treeObj = $.fn.zTree.getZTreeObj("editTree");
		treeObj.expandAll(true);
	}
}
 

// 修改--保存按钮
function updateSave() {
	if ($("#editForm").valid()) {
		var zTree = $.fn.zTree.getZTreeObj("editTree")
		var nodes = zTree.getCheckedNodes(true);
		$("#orgId").val(typeof(nodes[0])=="undefined"?"":nodes[0].id);
		
		SPlatForm.ajaxSubmit($("#editForm"),{//ajaxSubmit提交表单
			successTodo : function(result){//成功的回调
				SPlatForm.alert(result.msg);
				SPlatForm.closeModal('#editDiv');
				STableUtils.refreshTable();//执行成功后刷新页面
			}
		}) ;
	}
}



 
// 修改--根据id读取数据方法
function loadData(id) {
	var postOption={
			url : "getId.do",
			data : {id:id},
			success : function(result){//成功的回调
				SPlatForm.openModal('#editDiv');
				$("#editForm").fill(result.data); 
				var ztreeRadio = $.fn.zTree.getZTreeObj("editTree");
				var node = ztreeRadio.getNodesByParam("id", result.data.orgId,
						null);
				ztreeRadio.checkNode(node[0], true, true, null);
			}
		}
	SPlatForm.post(postOption);
}
 

// 授权--打开弹窗
function authorRole() { 
	var array=STableUtils.getOneSelect('table');//获取选中的记录
	if(array){
		SPlatForm.openModal('#authorizeid');
		
		$("#emailEdit").val('');
		$("#editId").val('');
		$('#roleIds').multiselect('deselectAll', false);
		
		
		var postOption={
				url : "getUser.do",
				data : {id:array[0].id},
				success : function(result){//成功的回调
					$("#emailEdit").val(array[0].email);
					$("#editId").val(array[0].id);
					$('#roleIds').multiselect('select', result.data.roleIds);
				}
		}
		SPlatForm.post(postOption);
	}
}

// 授权--保存按钮
function authorRoleSave() {
	var arr = []; // 主键名称
	if($('#roleIds').val()!=null){
		$.each($('#roleIds').val(), function(i, record) {
			arr.push('roleIds=' + record);
		});
	}
	arr.push('id=' + $('#editId').val());
	var data = arr.join("&");
	
	var postOption={
			url : "addUserRole.do",
			data : data,
			success : function(result){//成功的回调
				SPlatForm.closeModal('#authorizeid');
				SPlatForm.alert(result.msg);
				STableUtils.refreshTable();//执行成功后刷新页面
			}
		}
	SPlatForm.post(postOption);
} 
// 修改密码--打开弹窗
function updateUserPwd() {
	$("#updateUserPwdForm").validate();
	$("#updateUserPwdForm").clearForm(true);
	
	var array=STableUtils.getOneSelect('table');//获取选中的记录
	if(array){
		$('#updateUserPwdId').val(array[0].id);
		SPlatForm.openModal('#updatepassword');
	}
}
// 修改密码--保存按钮
function updateUserPwdSave() {
	if (!$("#updateUserPwdForm").valid()) {
		return;
	}
	var id = $("#updateUserPwdId").val();
	var oldPwd = $("#oldPwd").val();
	var newPwd = $("#newPwd").val();
	
	
	
	var postOption={
			url : "updatePwd.do",
			data : {
				"id" : id,
				"oldPwd" : oldPwd,
				"newPwd" : newPwd
			},
			success : function(result){//成功的回调
				SPlatForm.closeModal('#updatepassword');
				SPlatForm.alert(result.msg);
			}
		}
	SPlatForm.post(postOption);
}


// 清空按组织机构查询中的查询条件
function clearOrgQueryParam() {
	$("#orgName").val("");
	$("#queryOrgId").val("");
}
