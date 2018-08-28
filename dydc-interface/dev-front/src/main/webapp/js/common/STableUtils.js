/*!
 * 定义bootstrap Table 的常用方法
 * version: 1.0.0-2016.12.01
 * @requires jquery ,bootstrap,bootstrapTable 
 * @auth yangzc
 */
var STableUtils={
	initBootstrapTable:function(config){//init时，请在config中指定url(必填)和queryparam(选填)
		config = config || {};//如果为空，设置为空集合
		var tablename = config.tablename||"table";
		config.method = config.method|| "post";
		config.contentType =  config.contentType||"application/x-www-form-urlencoded";// 远程数据请求的“contentType”类型,默认请写此
		config.dataType = config.dataType|| "json";// 远程数据请求返回的数据类型
		config.idField =  config.idField || "id";
		config.sidePagination =  config.sidePagination || "server";// 定义表格分页的位置，只能是“client”（客户端）和“server”（服务器端）。
		config.pagination = config.pagination || true;// 设置True在表格底部显示分页工具栏。
		config.pageNumber = config.pageNumber || 1;//默认第一页
		config.pageSize = config.pageSize || 10;//默认每页10条
		config.pageList = config.pageList || [ 10, 25, 50, 100 ];
		config.queryParamsType = "RESTFul";// 设置为“limit”可以发送标准的RESTFul类型的参数请求。
		// 默认请使用这个，如果项目上分页为limit方式时，写limit 与分页返回参数相关
		// 我们默认不会使用limit 模式
		// pageSize, pageNumber, searchText, sortName, sortOrder。返回 false
		// 可以禁用请求。
		config.smartDisplay = true;// 设置为True智能显示分页或者Card View。
		// config.cardView = true;//启用cardView模式
		// config.showToggle = true;// 设置为True可显示切换普通表格和名片（card）布局。
		// config.search = true;
		// config.searchAlign = 'right';
		config.selectItemName = 'btSelectItem';// 单选框或者复选框的name
		config.showHeader = config.showHeader || true;// 显示表头
		config.showColumns =  config.showColumns ||true;// 设置为True可显示表格显示/隐藏列表。
		// config.minimumCountColumns = config.minimumCountColumns || 1;//表格显示/隐藏列表时可设置最小隐藏的列数。
		// config.undefinedText = config.undefinedText || "---";//数据为空时显示
		config.striped =  config.striped || true;// 使表格带有条纹。
		config.showRefresh = config.showRefresh || true;// 设置为True可显示刷新按钮。
		config.toolbar = config.toolbar || "#toolbar";// 定义toolbar是哪个
		config.toolbarAlign = config.toolbarAlign || "left";// 对齐方式
		config.clickToSelect = config.clickToSelect || true;// 设置为True时点击行即可选中单选/复选框。
		// config.singleSelect = config.clickToSelect || true;//只能选择一条记录
		// config.checkboxHeader = config.checkboxHeader || true;//设置为False时隐藏表头中的全选复选框。
		// config.maintainSelected = config.maintainSelected || true;//设置为True当换页或者搜索时保持选中的行。
		// config.sortable = config.sortable || true;//设置为False时禁用所有列的排序。
		config.showExport = config.showExport || true;// 设置为true，显示导出按钮。
		config.exportDataType = config.exportDataType || 'all';//导出所有记录用all，导出当页用basic，导出选择项，用selected
		// config.exportTypes = config.exportTypes || ['json', 'xml', 'csv', 'txt', 'sql',
		// 'excel'];//出口类型，支持类型：“JSON”，“XML”，“PNG”，“CSV”，“TXT”，“SQL”，“文档”，“Excel的”，“简报”，“PDF”。
		// config.height = config.height || "auto";
		config.queryParams= config.queryParams || function(params) {
			return {
				rows : params.pageSize,//每页多少条
				page : params.pageNumber,//当前页
				sort : params.sortName,//根据哪个字段排序
				order : params.sortOrder//升降序 
			};
		}
		config.onLoadSuccess = config.onLoadSuccess || function(data) {// 加载成功后所做的事情
			if (data.success == false) {
				SPlatForm.alert(data.msg);
			}
			//重新调整页面高度
//			var parentDoc =$(window.parent.document);
//			if(parentDoc!=null){
//	        var tabA = $(parentDoc).context.URL.split("#")[1];
//		        if(tabA !=null && tabA!=""){
//					var contentsHeight=$(document).contents().find(".panel").height()+40;
////					var iframeHeight=$(parentDoc).find("iframe[src='"+tabA+"']").height();;
////					var frameMaxHeight=Math.max(iframeHeight,contentsHeight);
//					alert(contentsHeight);
//			        $(parentDoc).find("iframe[src='"+tabA+"']").attr('height',contentsHeight);
//			    }
//			}
			//调整页面高度结束
		};
		config.onLoadError = config.onLoadError || function(status) {
			if (status == "504") {
				SPlatForm.alert("登录超时，请重新登录", {
					callback: function() {
						SPlatForm.reloadPage();
					}
				});
			}
		};
		$('#'+tablename).bootstrapTable(config);
	},
	getOneSelect:function(tablename,lessMsg,moreMsg){
		tablename = tablename || 'table';
		lessMsg = lessMsg || '请选择一条记录';
		moreMsg = moreMsg || '仅能选择一条记录';
		var array=$('#'+tablename).bootstrapTable('getSelections');
		if(array.length<1){
			SPlatForm.alert(lessMsg);
			return;
		}	

		if(array.length>1){
			SPlatForm.alert(moreMsg);
			return;
		}
		return array;
	},
	getMultiSelect:function(tablename,lessMsg){
		tablename = tablename || 'table';
		lessMsg = lessMsg || '请选择一条记录';
		var array=$('#table').bootstrapTable('getSelections');
		if(array.length<=0){
			SPlatForm.alert(lessMsg);
			return ;
		}
		return array;
	},
	//刷新页面 //用于在save delete方法后对于表单的刷新 ，(currentPage)当前页不变化
	refreshTable:function(tablename){
		tablename=tablename||'table';//如果未指定,默认是table
		$('#'+tablename).bootstrapTable('refresh');
	},
	//重新加载页面 //用于search方法，搜索后重返第一页
	reloadTable:function(tablename){
		tablename=tablename||'table';//如果未指定,默认是table
		$('#'+tablename).bootstrapTable('refreshOptions',{
			pageNumber:1
		});
	},
	//joinArr如果是上一次arr join("&")的结果，那么传进来的时候，请使用split("&");
	getDataFromArrayAndKey:function(array,idKey,joinArr){
		var arr = joinArr || [],idKey = idKey || 'id'; //主键名称
		$.each(array,function(i,record){
			arr.push(idKey+'='+record[idKey]);
		});
		return arr.join("&");
	}
}
