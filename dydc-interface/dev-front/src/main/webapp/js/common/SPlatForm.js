/*!
 * 将项目常用方法公用话，为了处理程序员平时不处理，又需要大量操作的东西
 * version: 1.0.0-2016.12.01
 * @requires jquery ,jquery.form  
	bootstrap.js  bootstrap-waiting.js   layer.js
	jquery-multitabs.js
 * @auth yangzc
 */
var SPlatForm={
	ajaxSubmit:function(formTarget,option){
		option = option || {};
		option.dataType = option.dataType || 'json';
		option.success =  option.success || function(data) {
								SPlatForm.hideLoading();
								if (!data.success) {
									if(option.unsuccessTodo){//因为存在success，所以用successToDo来记录
										option.unsuccessTodo(data);
									}else{
										SPlatForm.alert(data.msg);//调用公共alert
									}
								}else{
									if(option.successTodo){//因为存在success，所以用successToDo来记录
										option.successTodo(data);
									}
								}
							};
		option.error = option.error || function(xhr, status, text){
								SPlatForm.hideLoading();
								if (xhr.status == "504") {
									SPlatForm.alert("登录超时，请重新登录", {
										callback: function() {
											SPlatForm.reloadPage();
										}
									});
								}else{
									SPlatForm.alert("系统错误，请稍后再试");
								} 
							};
		this.showLoading();
		$(formTarget).ajaxSubmit(option);
	},
	load:function(option){//定义 option.url ,option.target
		this.showLoading();
		$(option.target).load(option.url, function(response,status) {
			SPlatForm.hideLoading();
			if(status=="error"){
				SPlatForm.alert("系统错误，请稍后再试");
				return;
			}
			if(option.success){
				option.success(response,status);	
			}
		});
	},
	post:function(option){//定义option.url,option.data ,option.success
		this.showLoading();
		$.post(option.url, option.data, function(result) {
			SPlatForm.hideLoading();
			if (result.success){
				if(option.success){
					option.success(result);
				}
			} else {
				if(option.unsuccess){
					option.unsuccess(result);
				}else{
					SPlatForm.alert(result.msg);
				}
			}
		},"json").error(function(xhr, status, text){
			SPlatForm.hideLoading();
			if (xhr.status == "504") {
				SPlatForm.alert("登录超时，请重新登录",{
					callback: function() {
						SPlatForm.reloadPage();
					}
				});
			}else{
				SPlatForm.alert("系统错误，请稍后再试");
			}
		});
	},

	//打开弹窗
	openModal:function(obj){
		//重新调整iframe高度，避免弹窗内容太多，被iframe遮住
		$(obj).off();
		$(obj).on('shown.bs.modal', function () {
			var parentDoc =$(window.parent.document);
			if(parentDoc!=null){
	        var tabA = $(parentDoc).context.URL.split("#")[1];
		        if(tabA !=null && tabA!=""){
					var iframeHeight=$(document).contents().height();
					var modalHeight=$(obj).find(".modal-content").height();
					var frameMaxHeight=Math.max(iframeHeight,modalHeight+60);//+60px 是因为bootstrap.min.css 中写的margin 30px
//					alert(iframeHeight+"#"+frameMaxHeight);
			        $(parentDoc).find("iframe[src='"+tabA+"']").attr('height',frameMaxHeight);
			    }
			}
		});
		//打开弹窗
		$(obj).modal('show');
		$("body").css('padding-right','0px');
	},
	//关闭弹窗
	closeModal:function(obj){
		$(obj).modal('hide');
	},
	//提示信息
	alert:function(msg,option){
		//Iframe模式使用parentAlert,非页签模式使用currentAlert
		this.parentAlert(msg,option);
//		this.currentAlert(msg,option);
	},

	//提示信息
	confirm:function(msg,option){
		//Iframe模式使用parentConfirm,非页签模式使用currentConfrim
		this.parentConfirm(msg,option);
//		this.currentConfirm(msg,option);
	},
	
	//公用显示loading方法，所有组件调用
	showLoading:function(config){
		//this.parentShowLoading(config);
		this.currentShowLoading(config);
	},

	hideLoading:function(config){
		//this.parentHideLoading(config);
		this.currentHideLoading(config);
	},
	
	reloadPage:function(){
		location.reload();
	},
	//至少需要定义config.url,config.title,config.type,如果是iframe模式
	//其他模式仅需要url即可
	goPage:function(url,config){
		//this.loadPage(url,config);
		//this.createTab(url,config);
	},
	
	createTab:function(url,config){
		var turnTo=msUrl+url;
		parent.mainMultiTabs.create({
			url:turnTo,
			title:config.title || 'new Tab',
			content:config.content || 'nofe'
		},true);
	},
	
	//仅用于标签content为editor的模式，去除掉unsave，这样关闭的时候不会提示是否确认 
	setTagSaved:function(config){
		var parentDoc =$(window.parent.document);
		if(parentDoc!=null){
        var tabA = $(parentDoc).context.URL.split("#")[1];
	        if(tabA !=null && tabA!=""){
	        	 $(parentDoc).find("iframe[src='"+tabA+"']").removeClass('unsave');
		    }
		}
	},
	closeTag:function(config){
		var parentDoc =$(window.parent.document);
		if(parentDoc!=null){
        var tabA = $(parentDoc).context.URL.split("#")[1];
	        if(tabA !=null && tabA!=""){
		         var currentTab=$(parentDoc).find("a[data-id='"+tabA+"']");
		         parent.mainMultiTabs.close(currentTab);
		    }
		}
	},
	/*prvate方法，请不要使用，在项目中请使用goPage
	 * 暂时不启用非标签模式，之后再写
	loadPage:function(url,config){
		//load(url);
	},*/
	
	
	//private方法，请不要在项目中使用,在项目中请直接使用公共的SPlateForm.confirm
	parentConfirm:function(msg,option){
		parent.SPlatForm.currentConfirm(msg,option);
	},

	//private方法，请不要在项目中使用,在项目中请直接使用公共的SPlateForm.confirm
	currentConfirm:function(msg,option){
		
		option.btn = option.btn || ['确定','取消'];
		layer.confirm( msg ,{
		    btn: option.btn, //按钮
		}, function(index){
			if(option.confirm){
				option.confirm();	
			}
			layer.close(index);
		}, function(index){
			if(option.cancel){
				option.cancel();
			}
			layer.close(index);
		});
	},
	
	//private方法，请不要在项目中使用,在项目中请直接使用公共的SPlateForm.alert
	parentAlert:function(msg,option){
		parent.SPlatForm.currentAlert(msg,option);
	},
	
	//private方法，请不要在项目中使用,在项目中请直接使用公共的SPlateForm.alert
	//提示信息
	currentAlert:function(msg,option){
		layer.msg(msg, {
			tips : 2
		},function(){
			if(option.callback){
				option.callback();
			}
		});
	},
	
	//private方法，请不要在项目中使用，在项目中请直接使用公共的SPlateForm.showLoading SPlateForm.hideLoading
	//父窗口显示loading的方法，用于多页签工作台模式，显示父窗口的loading
	parentShowLoading:function(config){
		parent.SPlatForm.currentShowLoading(config);
	},
	parentHideLoading:function(config){
		parent.SPlatForm.currentHideLoading(config);
	},
	
	//private方法，请不要在项目中使用，在项目中请直接使用公共的SPlateForm.showLoading SPlateForm.hideLoading
	//用于当前页显示loading的方法，用于非多页签工作台模式页面，在当前页显示loading
	currentShowLoading:function(config){
		waitingDialog.show('加载中...');
	},
	currentHideLoading:function(config){
		waitingDialog.hide();
	}
	
}