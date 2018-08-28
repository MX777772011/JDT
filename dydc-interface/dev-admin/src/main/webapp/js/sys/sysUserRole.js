$(function () {
	var tableconfig={
		url:'dataList.do',
		queryParams : function (params) {//查询参数，如果无自定义查询参数，可以不用写
			return {
              	 rows: params.pageSize,//每页多少条
              	 page: params.pageNumber,//当前页
              	 sort: params.sortName,//根据哪个字段排序
              	 order: params.sortOrder,//升降序 
                   email: $("#email").val(),//自定义查询属性
                   nickName: $("#nickName").val()//自定义查询属性
               };
		},
		 columns: [
                   {checkbox:true},
                   {field: "id", title:'ID',width:50,align:'center',sortable:true},
                   {field: "email", title: "邮箱",width:120,align:'center',sortable:true},
                   {field: "nickName", title: "昵称",width:120,align:'center',sortable:true},
                   {field:'state',title:'状态',width:80,align:'center',sortable:true,styler:function(value,row,index){
						if(value == 1){
							  return 'color:red;';  
							}
						},
						formatter:function(value,row,index){
							if(value == 0){
								return "可用";
							}
							if(value == 1){
								return "禁用";
							}
						}},
                   {field: "createTime", title: "创建时间",width:150,align:'center',sortable:true},
                   {field: "loginCount", title: "登陆次数",width:80,align:'center',sortable:true},
                   {field: "loginTime", title: "最后登录时间",width:150,align:'center',sortable:true},
                   {field:'roleStr',title:'角色',width:150,align:'center',sortable:true}
               ]
		
		}
            
	STableUtils.initBootstrapTable(tableconfig);   
            
} );
 



