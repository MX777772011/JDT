﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="shortcut icon" href="${msUrl}/images/bimages/favicon.png" type="image/png">

  <title>互联网项目基础开发平台</title>
  
  
<%@include file="/WEB-INF/view/include.jsp"%>
<script src="${msUrl}/js/bootstraplib/raphael-2.1.0.min.js"></script>

<script type="text/javascript">
		

		
		var mainPop;//主页弹窗
		var mainMultiTabs;//主页签
		//加载页面，右侧div将服务器的page加载过来
		function loadPage(url) {
			var path = window.location.hash.replace('#', '');
			if(path.indexOf("?")!=-1
			&&url.indexOf("?")!=-1
			&&path.indexOf(url.substring(0,url.indexOf("?")))!=-1
			&&url!=path){
				return;
			}
			
			SPlatForm.load({
				target:$(".contentpanel"),
				url:"${msUrl}"+url,
				success:function(response,status){
					chooseNav(url);
					showButton(url);	
				}
			});
		}
		
		function chooseNav(url){
			 $('#left-menu').find(".active").each(function() {
			 	$(this).removeClass("active");
			 });
			 
			  $('#left-menu').find("a[href*='#']").each(function() {
			  	$(this).css("color","#94989d");
			  });
			 
		 	 $('#left-menu').find("a[href='#"+url+"']").each(function() {
		 	 	var navParent= $(this).parents(".nav-parent");
		 		navParent.addClass("active nav-active");
		 		 $(this).parents(".children").css("display","block");
		 		 $(this).css("color","#1caf9a");
		 		 var toptitle=navParent.children("a").html().replace("<span>","").replace("</span>","");
		 		 var subtitle="<span>"+$(this).text()+"</span>";
		 		 $('#pageHeaderRight').html(toptitle+subtitle);
		 	});
			
		}
		
		function openBModal(obj){
			$(obj).modal('show');
			$("body").css('padding-right','0px');
		}
		
		function closeBModal(obj){
			$(obj).modal('hide');
		}
		//根据权限显示菜单的toolbar
		function showButton(url){
			var urlPost = {'url':url};
			$.post(
					"${msUrl}/getActionBtn.do", 
					urlPost,
					function(data) {
					if(data.success){//操作成功
						if(data.allType){//如果是超级管理员
							$('#toolbar span').each(function(){
								 $(this).show();
							   // $(this).attr("fun");
							  });
						}else{//不是超级管理员
							$('#toolbar span').each(function(){
								if($(this).attr("fun")!=null){
									$(this).hide();
								}
								if($.inArray($(this).attr("fun"), data.types)>-1){
									 $(this).show();
								}
							  });
						}
					}else{
						layer.msg(data.msg, {
							tips : 2
						});
					}
			},"json");
		}
		
		// 修改我的密码--打开弹窗
		function updateMyPwd() {
			$( "#updateMyPwdForm" ).validate().resetForm();
			mainPop=layer.open( {
				type : 1,
				area : [ '420px', '240px' ], //宽高
				content : $("#update"),
				success: function(layero, index){
				 $("#update").removeClass("hidden");
		    }
			});
	
		}
		
		// 修改我的密码--保存按钮
		function updateMyPwdSave() {
			if(!$("#updateMyPwdForm").valid()){
				return;
			}
			var oldPwd=$("#myOldPwd").val();
			var newPwd=$("#myNewPwd").val();
			$("#updateMyPwdForm").clearForm(true);
			$.post(
					"${msUrl}/modifyPwd.do", 
					{"oldPwd":oldPwd,"newPwd":newPwd},
					function(result) {
					if (result.success) {
						layer.msg(result.msg, {
							tips : 2
						});
						//关闭layer
						layer.close(mainPop);
					
					} else {
						layer.msg(result.msg, {
							tips : 2
						});
					}
			},"json");
		}	

		$(document).ready(function() {
			//左侧菜单点开效果
		/*	$("#list_ul a").click(function() {
				if($(this).attr("openwindow")!=null){
					window.open($(this).attr("page"));
				}else{
					loadPage($(this).attr("page"));
				}
			});
			*/
			//初始化验证
			 $.validator.setDefaults({
					ignore: []
				});//如果有display:none的情况，加上这个，会验证display none的必填项
			 $("#updateMyPwdForm").validate();
			mainMultiTabs = $('.contentpanel').multitabs({//赋值进入全局变量，方便调用
				 	layout:'dev_main',
		        	iframeTabPane : {
		            	otherHeight : 50
		        	},
		        	fixed:false,
		        	showHash:true
		    	});
		});
 			$(document).ajaxError(function(event,xhr,settings,errorType){
 				if(xhr.status=="504"){
					layer.msg("登录超时，请重新登录", {
						tips : 2
					}, function() {
						location.reload();
					});
 				}else{
					layer.msg("系统错误，请稍后再试", {
						tips : 2
					});
 				}
			 });
   	
	
	/*function initPage(p) {
		/*var module = p;
		requirejs.undef(module);
		require([module], function(module) {
			ko.cleanNode($('.content')[0]);
			$('.content').html('');
			$('.content').html(module.template);
			if(module.model){
				module.model.data.content = ko.observableArray([]);
				ko.applyBindings(module.model, $('.content')[0]);
				module.init(id);
			}else{
				module.init(id, $('.content')[0]);
			}
		})
	}*/
	
	 
	 $(document).ready(function(){
		$.validator.setDefaults({
			ignoreTitle:'ignoreTitle',
			showErrors: function(map, list) {
				this.currentElements.removeAttr("title").removeClass("error");
				var tip_option={
						animation:true,
						placement:'right',
						trigger:'manual '
				}
				$.each(list, function(index, error) {
					$(error.element).removeAttr("title").removeClass("error");
					$(error.element).removeAttr("data-original-title");
					$(error.element).attr("title", error.message);
					$(error.element).attr("data-original-title", error.message);
					$(error.element).addClass("error");
					$(error.element).tooltip(tip_option).tooltip('show');
					 //layer.tips(error.message,error.element, {
					//    tips: [2, '#78BA32'],
					//	tipsMore: true
					//});
				}); 
			},
			focusCleanup:true,
			unhighlight: function(element,errorClass,validClass){
				$(element).tooltip('destroy');
			}
		});
	});
		

</script>
  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>


<body class="mainbody">

<!-- Preloader -->
<div id="preloader">
    <div id="status"><i class="fa fa-spinner fa-spin"></i></div>
</div>

<section>

  <div class="leftpanel">

    <div class="logopanel">
        <h1><span>[</span> 开发平台v1.0 <span>]</span></h1>
    </div><!-- logopanel -->

    <div class="leftpanelinner">

        <!-- This is only visible to small devices -->
        <div class="visible-xs hidden-sm hidden-md hidden-lg">
            <div class="media userlogged">
                <img alt="" src="${msUrl}/images/bimages/photos/loggeduser.png" class="media-object">
                <div class="media-body">
                    <h4>${user.nickName}</h4>
                    <span></span>
                </div>
            </div>

            <h5 class="sidebartitle actitle">Account</h5>
            <ul class="nav nav-pills nav-stacked nav-bracket mb30">
              <li><a href="profile.html"><i class="fa fa-user"></i> <span>修改密码</span></a></li>
             <!--  <li><a href=""><i class="fa fa-cog"></i> <span>Account Settings</span></a></li>
              <li><a href=""><i class="fa fa-question-circle"></i> <span>Help</span></a></li>
               --><li><a href="logout.shtml"><i class="fa fa-sign-out"></i> <span>登出</span></a></li>
            </ul>
        </div>

      <h5 class="sidebartitle">Navigation</h5>
      <ul class="nav nav-pills nav-stacked nav-bracket" id="left-menu">
        <li class="active"><a href="main.shtml"
         class="multitabs" data-content="main" data-iframe="true"
        ><i class="fa fa-home"></i> <span>主页</span></a></li>
        
        
        <c:forEach var="item" items="${menuList}" varStatus="var">
         <c:if test="${item.isopen==1}">
         	<li><a href="${item.url}">
         	<i class="fa fa-${item.icon}"></i> 
	         <span>${item.text}</span></a></li>
         </c:if>
          <c:if test="${item.isopen!=1}">
	          <li class="nav-parent"><a href="">
	         <i class="fa fa-${item.icon}"></i> 
	         <span>${item.text}</span></a>
	          <ul class="children">
	          <c:forEach var="node" items="${item.children}">
	          	 <c:if test="${node.isopen==1}">
	          		 <li><a href="${msUrl}${node.url}" target="_blank">
	          		 <i class="fa fa-caret-right"></i>${node.text}</a></li>
	          	 </c:if>
	          	 <c:if test="${node.isopen!=1}">
	          		 <li><a href="#${msUrl}${node.url}" 
	          		 class="multitabs"  data-content="nofe" data-iframe="true"
	          		 ><i class="fa fa-caret-right"></i>${node.text}</a></li>
	          	 </c:if>
	            </c:forEach>
	          </ul>
	        </li>
          </c:if>
         
		</c:forEach>
		<!--  		
        <li><a href="email.html"><span class="pull-right badge badge-success">2</span><i class="fa fa-envelope-o"></i> <span>Email</span></a></li>
        <li class="nav-parent"><a href=""><i class="fa fa-suitcase"></i> <span>UI Elements</span></a>
          <ul class="children">
            <li><a href="buttons.html"><i class="fa fa-caret-right"></i> Buttons</a></li>
            <li><a href="icons.html"><span class="pull-right badge badge-danger">updated</span><i class="fa fa-caret-right"></i> Icons</a></li>
            <li><a href="typography.html"><i class="fa fa-caret-right"></i> Typography</a></li>
            <li><a href="alerts.html"><i class="fa fa-caret-right"></i> Alerts &amp; Notifications</a></li>
            <li><a href="modals.html"><i class="fa fa-caret-right"></i> Modals</a></li>
            <li><a href="tabs-accordions.html"><i class="fa fa-caret-right"></i> Tabs &amp; Accordions</a></li>
            <li><a href="sliders.html"><i class="fa fa-caret-right"></i> Sliders</a></li>
            <li><a href="graphs.html"><i class="fa fa-caret-right"></i> Graphs &amp; Charts</a></li>
            <li><a href="widgets.html"><i class="fa fa-caret-right"></i> Panels &amp; Widgets</a></li>
            <li><a href="extras.html"><i class="fa fa-caret-right"></i> Extras</a></li>
          </ul>
        </li> -->		
      </ul>

      <div class="infosummary">
        <h5 class="sidebartitle">Information Summary</h5>
        <ul>
            <li>
                <div class="datainfo">
                    <span class="text-muted">日流量</span>
                    <h4>630, 201</h4>
                </div>
                <div id="sidebar-chart" class="chart"></div>
            </li>
            <li>
                <div class="datainfo">
                    <span class="text-muted">平均用户</span>
                    <h4>1, 332, 801</h4>
                </div>
                <div id="sidebar-chart2" class="chart"></div>
            </li>
            <li>
                <div class="datainfo">
                    <span class="text-muted">磁盘使用率</span>
                    <h4>82.2%</h4>
                </div>
                <div id="sidebar-chart3" class="chart"></div>
            </li>
            <li>
                <div class="datainfo">
                    <span class="text-muted">cpu使用率</span>
                    <h4>140.05 - 32</h4>
                </div>
                <div id="sidebar-chart4" class="chart"></div>
            </li>
            <li>
                <div class="datainfo">
                    <span class="text-muted">内存使用率</span>
                    <h4>32.2%</h4>
                </div>
                <div id="sidebar-chart5" class="chart"></div>
            </li>
        </ul>
      </div><!-- infosummary -->

    </div><!-- leftpanelinner -->
  </div><!-- leftpanel -->

  <div class="mainpanel">

    <div class="headerbar">

      <a class="menutoggle"><i class="fa fa-bars"></i></a>

      <form class="searchform" action="index.html" method="post">
        <input type="text" class="form-control" name="keyword" placeholder="Search here..." />
      </form>

      <div class="header-right">
        <ul class="headermenu">
          <!-- <li>
            <div class="btn-group">
              <button class="btn btn-default dropdown-toggle tp-icon" data-toggle="dropdown">
                <i class="glyphicon glyphicon-user"></i>
                <span class="badge">2</span>
              </button>
              <div class="dropdown-menu dropdown-menu-head pull-right">
                <h5 class="title">2 Newly Registered Users</h5>
                <ul class="dropdown-list user-list">
                  <li class="new">
                    <div class="thumb"><a href=""><img src="${msUrl}/images/bimages/photos/user1.png" alt="" /></a></div>
                    <div class="desc">
                      <h5><a href="">Draniem Daamul (@draniem)</a> <span class="badge badge-success">new</span></h5>
                    </div>
                  </li>
                  <li class="new">
                    <div class="thumb"><a href=""><img src="${msUrl}/images/bimages/photos/user2.png" alt="" /></a></div>
                    <div class="desc">
                      <h5><a href="">Zaham Sindilmaca (@zaham)</a> <span class="badge badge-success">new</span></h5>
                    </div>
                  </li>
                  <li>
                    <div class="thumb"><a href=""><img src="${msUrl}/images/bimages/photos/user3.png" alt="" /></a></div>
                    <div class="desc">
                      <h5><a href="">Weno Carasbong (@wenocar)</a></h5>
                    </div>
                  </li>
                  <li>
                    <div class="thumb"><a href=""><img src="${msUrl}/images/bimages/photos/user4.png" alt="" /></a></div>
                    <div class="desc">
                      <h5><a href="">Nusja Nawancali (@nusja)</a></h5>
                    </div>
                  </li>
                  <li>
                    <div class="thumb"><a href=""><img src="${msUrl}/images/bimages/photos/user5.png" alt="" /></a></div>
                    <div class="desc">
                      <h5><a href="">Lane Kitmari (@lane_kitmare)</a></h5>
                    </div>
                  </li>
                  <li class="new"><a href="">See All Users</a></li>
                </ul>
              </div>
            </div>
          </li>
          <li>
            <div class="btn-group">
              <button class="btn btn-default dropdown-toggle tp-icon" data-toggle="dropdown">
                <i class="glyphicon glyphicon-envelope"></i>
                <span class="badge">1</span>
              </button>
              <div class="dropdown-menu dropdown-menu-head pull-right">
                <h5 class="title">您有一条新消息</h5>
                <ul class="dropdown-list gen-list">
                  <li class="new">
                    <a href="">
                   <span class="thumb"><img src="${msUrl}/images/bimages/photos/user5.png" alt="" /></span>
                    <span class="desc">
                      <span class="name">合伙人中心 <span class="badge badge-success">new</span></span>
                      <span class="msg">您上传的简历已审核通过...</span>
                    </span>
                    </a>
                  </li>
                  <li>
                    <a href="">
                    <span class="thumb"><img src="${msUrl}/images/bimages/photos/user5.png" alt="" /></span>
                    <span class="desc">
                      <span class="name">合伙人中心 </span>
                      <span class="msg">您有一个商业推荐待处理...</span>
                    </span>
                    </a>
                  </li>
                  <li>
                    <a href="">
                    <span class="thumb"><img src="${msUrl}/images/bimages/photos/user3.png" alt="" /></span>
                    <span class="desc">
                      <span class="name">Weno Carasbong</span>
                      <span class="msg">Lorem ipsum dolor sit amet...</span>
                    </span>
                    </a>
                  </li>
                  <li>
                    <a href="">
                    <span class="thumb"><img src="${msUrl}/images/bimages/photos/user4.png" alt="" /></span>
                    <span class="desc">
                      <span class="name">Zaham Sindilmaca</span>
                      <span class="msg">Lorem ipsum dolor sit amet...</span>
                    </span>
                    </a>
                  </li>
                  <li>
                    <a href="">
                    <span class="thumb"><img src="${msUrl}/images/bimages/photos/user5.png" alt="" /></span>
                    <span class="desc">
                      <span class="name">Veno Leongal</span>
                      <span class="msg">Lorem ipsum dolor sit amet...</span>
                    </span>
                    </a>
                  </li>
                  <li class="new"><a href="">Read All Messages</a></li>
                </ul>
              </div>
            </div>
          </li>
          <li>
            <div class="btn-group">
              <button class="btn btn-default dropdown-toggle tp-icon" data-toggle="dropdown">
                <i class="glyphicon glyphicon-globe"></i>
                <span class="badge">5</span>
              </button>
              <div class="dropdown-menu dropdown-menu-head pull-right">
                <h5 class="title">You Have 5 New Notifications</h5>
                <ul class="dropdown-list gen-list">
                  <li class="new">
                    <a href="">
                    <span class="thumb"><img src="${msUrl}/images/bimages/photos/user4.png" alt="" /></span>
                    <span class="desc">
                      <span class="name">Zaham Sindilmaca <span class="badge badge-success">new</span></span>
                      <span class="msg">is now following you</span>
                    </span>
                    </a>
                  </li>
                  <li class="new">
                    <a href="">
                    <span class="thumb"><img src="${msUrl}/images/bimages/photos/user5.png" alt="" /></span>
                    <span class="desc">
                      <span class="name">Weno Carasbong <span class="badge badge-success">new</span></span>
                      <span class="msg">is now following you</span>
                    </span>
                    </a>
                  </li>
                  <li class="new">
                    <a href="">
                    <span class="thumb"><img src="${msUrl}/images/bimages/photos/user3.png" alt="" /></span>
                    <span class="desc">
                      <span class="name">Veno Leongal <span class="badge badge-success">new</span></span>
                      <span class="msg">likes your recent status</span>
                    </span>
                    </a>
                  </li>
                  <li class="new">
                    <a href="">
                    <span class="thumb"><img src="${msUrl}/images/bimages/photos/user3.png" alt="" /></span>
                    <span class="desc">
                      <span class="name">Nusja Nawancali <span class="badge badge-success">new</span></span>
                      <span class="msg">downloaded your work</span>
                    </span>
                    </a>
                  </li>
                  <li class="new">
                    <a href="">
                    <span class="thumb"><img src="${msUrl}/images/bimages/photos/user3.png" alt="" /></span>
                    <span class="desc">
                      <span class="name">Nusja Nawancali <span class="badge badge-success">new</span></span>
                      <span class="msg">send you 2 messages</span>
                    </span>
                    </a>
                  </li>
                  <li class="new"><a href="">See All Notifications</a></li>
                </ul>
              </div>
            </div>
          </li>
           -->
          <li>
            <div class="btn-group">
              <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                <img src="${msUrl}/images/bimages/photos/loggeduser.png" alt="" />
                ${user.nickName}
                <span class="caret"></span>
              </button>
              <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
                <li><a href="profile.html"><i class="glyphicon glyphicon-user"></i>修改密码</a></li>
              <!--   <li><a href="#"><i class="glyphicon glyphicon-cog"></i> Account Settings</a></li>
                <li><a href="#"><i class="glyphicon glyphicon-question-sign"></i> Help</a></li>
                 --><li><a href="logout.shtml"><i class="glyphicon glyphicon-log-out"></i> 登出</a></li>
              </ul>
            </div>
          </li>
          <!-- <li>
            <button id="chatview" class="btn btn-default tp-icon chat-icon">
                <i class="glyphicon glyphicon-comment"></i>
            </button>
          </li> -->
        </ul>
      </div><!-- header-right -->

    </div><!-- headerbar -->


    <div class="contentpanel">
    </div><!-- contentpanel -->

  </div><!-- mainpanel -->

  <div class="rightpanel">
    <!-- Nav tabs -->
    <ul class="nav nav-tabs nav-justified">
        <li class="active"><a href="#rp-alluser" data-toggle="tab"><i class="fa fa-users"></i></a></li>
        <li><a href="#rp-favorites" data-toggle="tab"><i class="fa fa-heart"></i></a></li>
        <li><a href="#rp-history" data-toggle="tab"><i class="fa fa-clock-o"></i></a></li>
        <li><a href="#rp-settings" data-toggle="tab"><i class="fa fa-gear"></i></a></li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div class="tab-pane active" id="rp-alluser">
            <h5 class="sidebartitle">Online Users</h5>
            <ul class="chatuserlist">
                <li class="online">
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/userprofile.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Eileen Sideways</strong>
                            <small>Los Angeles, CA</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li class="online">
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/user1.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <span class="pull-right badge badge-danger">2</span>
                            <strong>Zaham Sindilmaca</strong>
                            <small>San Francisco, CA</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li class="online">
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/user2.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Nusja Nawancali</strong>
                            <small>Bangkok, Thailand</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li class="online">
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/user3.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Renov Leongal</strong>
                            <small>Cebu City, Philippines</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li class="online">
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/user4.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Weno Carasbong</strong>
                            <small>Tokyo, Japan</small>
                        </div>
                    </div><!-- media -->
                </li>
            </ul>

            <div class="mb30"></div>

            <h5 class="sidebartitle">Offline Users</h5>
            <ul class="chatuserlist">
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/user5.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Eileen Sideways</strong>
                            <small>Los Angeles, CA</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/user2.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Zaham Sindilmaca</strong>
                            <small>San Francisco, CA</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/user3.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Nusja Nawancali</strong>
                            <small>Bangkok, Thailand</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/user4.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Renov Leongal</strong>
                            <small>Cebu City, Philippines</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/user5.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Weno Carasbong</strong>
                            <small>Tokyo, Japan</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/user4.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Renov Leongal</strong>
                            <small>Cebu City, Philippines</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/user5.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Weno Carasbong</strong>
                            <small>Tokyo, Japan</small>
                        </div>
                    </div><!-- media -->
                </li>
            </ul>
        </div>
        <div class="tab-pane" id="rp-favorites">
            <h5 class="sidebartitle">Favorites</h5>
            <ul class="chatuserlist">
                <li class="online">
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/user2.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Eileen Sideways</strong>
                            <small>Los Angeles, CA</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/user1.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Zaham Sindilmaca</strong>
                            <small>San Francisco, CA</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/user3.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Nusja Nawancali</strong>
                            <small>Bangkok, Thailand</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li class="online">
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/user4.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Renov Leongal</strong>
                            <small>Cebu City, Philippines</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li class="online">
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/user5.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Weno Carasbong</strong>
                            <small>Tokyo, Japan</small>
                        </div>
                    </div><!-- media -->
                </li>
            </ul>
        </div>
        <div class="tab-pane" id="rp-history">
            <h5 class="sidebartitle">History</h5>
            <ul class="chatuserlist">
                <li class="online">
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/user4.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Eileen Sideways</strong>
                            <small>Hi hello, ctc?... would you mind if I go to your...</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/user2.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Zaham Sindilmaca</strong>
                            <small>This is to inform you that your product that we...</small>
                        </div>
                    </div><!-- media -->
                </li>
                <li>
                    <div class="media">
                        <a href="#" class="pull-left media-thumb">
                            <img alt="" src="${msUrl}/images/bimages/photos/user3.png" class="media-object">
                        </a>
                        <div class="media-body">
                            <strong>Nusja Nawancali</strong>
                            <small>Are you willing to have a long term relat...</small>
                        </div>
                    </div><!-- media -->
                </li>
            </ul>
        </div>
        <div class="tab-pane pane-settings" id="rp-settings">

            <h5 class="sidebartitle mb20">Settings</h5>
            <div class="form-group">
                <label class="col-xs-8 control-label">Show Offline Users</label>
                <div class="col-xs-4 control-label">
                    <div class="toggle toggle-success"></div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-8 control-label">Enable History</label>
                <div class="col-xs-4 control-label">
                    <div class="toggle toggle-success"></div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-8 control-label">Show Full Name</label>
                <div class="col-xs-4 control-label">
                    <div class="toggle-chat1 toggle-success"></div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-8 control-label">Show Location</label>
                <div class="col-xs-4 control-label">
                    <div class="toggle toggle-success"></div>
                </div>
            </div>

        </div><!-- tab-pane -->

    </div><!-- tab-content -->
  </div><!-- rightpanel -->


</section>
<div id ="_welcome" class="_welcome" style="display:none">

      <div class="row">

        <div class="col-sm-6 col-md-3">
          <div class="panel panel-success panel-stat">
            <div class="panel-heading">

              <div class="stat">
                <div class="row">
                  <div class="col-xs-4">
                    <img src="${msUrl}/images/bimages/is-user.png" alt="" />
                  </div>
                  <div class="col-xs-8">
                    <small class="stat-label">Visits Today</small>
                    <h1>900k+</h1>
                  </div>
                </div><!-- row -->

                <div class="mb15"></div>

                <div class="row">
                  <div class="col-xs-6">
                    <small class="stat-label">Pages / Visit</small>
                    <h4>7.80</h4>
                  </div>

                  <div class="col-xs-6">
                    <small class="stat-label">% New Visits</small>
                    <h4>76.43%</h4>
                  </div>
                </div><!-- row -->
              </div><!-- stat -->

            </div><!-- panel-heading -->
          </div><!-- panel -->
        </div><!-- col-sm-6 -->

        <div class="col-sm-6 col-md-3">
          <div class="panel panel-danger panel-stat">
            <div class="panel-heading">

              <div class="stat">
                <div class="row">
                  <div class="col-xs-4">
                    <img src="${msUrl}/images/bimages/is-document.png" alt="" />
                  </div>
                  <div class="col-xs-8">
                    <small class="stat-label">% Unique Visitors</small>
                    <h1>54.40%</h1>
                  </div>
                </div><!-- row -->

                <div class="mb15"></div>

                <small class="stat-label">Avg. Visit Duration</small>
                <h4>01:80:22</h4>

              </div><!-- stat -->

            </div><!-- panel-heading -->
          </div><!-- panel -->
        </div><!-- col-sm-6 -->

        <div class="col-sm-6 col-md-3">
          <div class="panel panel-primary panel-stat">
            <div class="panel-heading">

              <div class="stat">
                <div class="row">
                  <div class="col-xs-4">
                    <img src="${msUrl}/images/bimages/is-document.png" alt="" />
                  </div>
                  <div class="col-xs-8">
                    <small class="stat-label">Page Views</small>
                    <h1>300k+</h1>
                  </div>
                </div><!-- row -->

                <div class="mb15"></div>

                <small class="stat-label">% Bounce Rate</small>
                <h4>34.23%</h4>

              </div><!-- stat -->

            </div><!-- panel-heading -->
          </div><!-- panel -->
        </div><!-- col-sm-6 -->

        <div class="col-sm-6 col-md-3">
          <div class="panel panel-dark panel-stat">
            <div class="panel-heading">

              <div class="stat">
                <div class="row">
                  <div class="col-xs-4">
                    <img src="${msUrl}/images/bimages/is-money.png" alt="" />
                  </div>
                  <div class="col-xs-8">
                    <small class="stat-label">Today's Earnings</small>
                    <h1>$655</h1>
                  </div>
                </div><!-- row -->

                <div class="mb15"></div>

                <div class="row">
                  <div class="col-xs-6">
                    <small class="stat-label">Last Week</small>
                    <h4>$32,322</h4>
                  </div>

                  <div class="col-xs-6">
                    <small class="stat-label">Last Month</small>
                    <h4>$503,000</h4>
                  </div>
                </div><!-- row -->

              </div><!-- stat -->

            </div><!-- panel-heading -->
          </div><!-- panel -->
        </div><!-- col-sm-6 -->
      </div><!-- row -->

      <div class="row">
        <div class="col-sm-8 col-md-9">
          <div class="panel panel-default">
            <div class="panel-body">
              <div class="row">
                <div class="col-sm-8">
                  <h5 class="subtitle mb5">Network Performance</h5>
                  <p class="mb15">Duis autem vel eum iriure dolor in hendrerit in vulputate...</p>
                  <div id="basicflot" style="width: 100%; height: 300px; margin-bottom: 20px"></div>
                </div><!-- col-sm-8 -->
                <div class="col-sm-4">
                  <h5 class="subtitle mb5">Server Status</h5>
                  <p class="mb15">Summary of the status of your server.</p>

                  <span class="sublabel">CPU Usage (40.05 - 32 cpus)</span>
                  <div class="progress progress-sm">
                    <div style="width: 40%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-primary"></div>
                  </div><!-- progress -->

                  <span class="sublabel">Memory Usage (32.2%)</span>
                  <div class="progress progress-sm">
                    <div style="width: 32%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success"></div>
                  </div><!-- progress -->

                  <span class="sublabel">Disk Usage (82.2%)</span>
                  <div class="progress progress-sm">
                    <div style="width: 82%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-danger"></div>
                  </div><!-- progress -->

                  <span class="sublabel">Databases (63/100)</span>
                  <div class="progress progress-sm">
                    <div style="width: 63%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-warning"></div>
                  </div><!-- progress -->

                  <span class="sublabel">Domains (2/10)</span>
                  <div class="progress progress-sm">
                    <div style="width: 20%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success"></div>
                  </div><!-- progress -->

                  <span class="sublabel">Email Account (13/50)</span>
                  <div class="progress progress-sm">
                    <div style="width: 26%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-success"></div>
                  </div><!-- progress -->


                </div><!-- col-sm-4 -->
              </div><!-- row -->
            </div><!-- panel-body -->
          </div><!-- panel -->
        </div><!-- col-sm-9 -->

        <div class="col-sm-4 col-md-3">

          <div class="panel panel-default">
            <div class="panel-body">
            <h5 class="subtitle mb5">Most Browser Used</h5>
            <p class="mb15">Duis autem vel eum iriure dolor in hendrerit in vulputate...</p>
            <div id="donut-chart2" class="ex-donut-chart"></div>
            </div><!-- panel-body -->
          </div><!-- panel -->

        </div><!-- col-sm-3 -->

      </div><!-- row -->

      <div class="row">

        <div class="col-sm-7">

          <div class="table-responsive">
            <table class="table table-bordered mb30">
            <thead>
              <tr>
                <th>#</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1</td>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <td>2</td>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
              </tr>
              <tr>
                <td>3</td>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
              </tr>
              <tr>
                <td>4</td>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <td>5</td>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
              </tr>
              <tr>
                <td>6</td>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
              </tr>
              <tr>
                <td>7</td>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
              </tr>
            </tbody>
          </table>
          </div><!-- table-responsive -->

        </div><!-- col-sm-7 -->

        <div class="col-sm-5">

          <div class="panel panel-success">
            <div class="panel-heading padding5">
              <div id="line-chart" class="ex-line-chart"></div>
            </div>
            <div class="panel-body">
              <div class="tinystat pull-left">
                <div id="sparkline" class="chart mt5"></div>
                <div class="datainfo">
                  <span class="text-muted">Average Sales</span>
                  <h4>$630,201</h4>
                </div>
              </div><!-- tinystat -->
              <div class="tinystat pull-right">
                <div id="sparkline2" class="chart mt5"></div>
                <div class="datainfo">
                  <span class="text-muted">Total Sales</span>
                  <h4>$139,201</h4>
                </div>
              </div><!-- tinystat -->
            </div>
          </div><!-- panel -->

        </div><!-- col-sm-6 -->
      </div><!-- row -->

      <div class="row">
        <div class="col-sm-6 col-md-4">
          <div class="panel panel-default widget-photoday">
            <div class="panel-body">
              <a href="" class="photoday"><img src="${msUrl}/images/bimages/photos/photo1.png" alt="" /></a>
              <div class="photo-details">
                <h4 class="photo-title">Strawhat In The Beach</h4>
                <small class="text-muted"><i class="fa fa-map-marker"></i> San Franciso, California, USA</small>
                <small>By: <a href="">ThemePixels</a></small>
              </div><!-- photo-details -->
              <ul class="photo-meta">
                <li><span><i class="fa fa-eye"></i> 32,102</span></li>
                <li><a href="#"><i class="fa fa-heart"></i> 1,003</a></li>
                <li><a href="#"><i class="fa fa-comments"></i> 52</a></li>
              </ul>
            </div><!-- panel-body -->
          </div><!-- panel -->
        </div><!-- col-sm-6 -->

        <div class="col-sm-6 col-md-4">
          <div class="panel panel-default panel-alt widget-messaging">
          <div class="panel-heading">
              <div class="panel-btns">
                <a href="" class="panel-edit"><i class="fa fa-edit"></i></a>
              </div><!-- panel-btns -->
              <h3 class="panel-title">Messaging</h3>
            </div>
            <div class="panel-body">
              <ul>
                <li>
                  <small class="pull-right">Dec 10</small>
                  <h4 class="sender">Jennier Lawrence</h4>
                  <small>Lorem ipsum dolor sit amet...</small>
                </li>
                <li>
                  <small class="pull-right">Dec 9</small>
                  <h4 class="sender">Marsha Mellow</h4>
                  <small>Lorem ipsum dolor sit amet...</small>
                </li>
                <li>
                  <small class="pull-right">Dec 9</small>
                  <h4 class="sender">Holly Golightly</h4>
                  <small>Lorem ipsum dolor sit amet...</small>
                </li>
                <li>
                  <small class="pull-right">Dec 10</small>
                  <h4 class="sender">Jennier Lawrence</h4>
                  <small>Lorem ipsum dolor sit amet...</small>
                </li>
                <li>
                  <small class="pull-right">Dec 9</small>
                  <h4 class="sender">Marsha Mellow</h4>
                  <small>Lorem ipsum dolor sit amet...</small>
                </li>
              </ul>
            </div><!-- panel-body -->
          </div><!-- panel -->
        </div><!-- col-sm-6 -->

        <div class="col-sm-6 col-md-4">
          <div class="panel panel-dark panel-alt widget-quick-status-post">
          <div class="panel-heading">
              <div class="panel-btns">
                <a href="" class="panel-close">&times;</a>
                <a href="" class="minimize">&minus;</a>
              </div><!-- panel-btns -->
              <h3 class="panel-title">Quick Status Post</h3>
            </div>
            <div class="panel-body">
              <ul class="nav nav-tabs nav-justified">
                <li class="active"><a href="#post-status" data-toggle="tab"><i class="fa fa-pencil"></i> <strong>Status</strong></a></li>
                <li><a href="#post-photo" data-toggle="tab"><i class="fa fa-picture-o"></i> <strong>Photo</strong></a></li>
                <li><a href="#post-checkin" data-toggle="tab"><i class="fa fa-map-marker"></i> <strong>Check-In</strong></a></li>
              </ul>
              <div class="tab-content">
                <div id="post-status" class="tab-pane active">
                  <input type="text" class="form-control" placeholder="What's your status?" />
                </div>
                <div id="post-photo" class="tab-pane">
                  <input type="text" class="form-control" placeholder="Choose photo" />
                </div>
                <div id="post-checkin" class="tab-pane">
                  <input type="text" class="form-control" placeholder="Search location" />
                </div>
                <button class="btn btn-primary btn-block mt10">Submit Post</button>
              </div><!-- tab-content -->

            </div><!-- panel-body -->
          </div><!-- panel -->

          <div class="mb20"></div>

          <div class="row">
            <div class="col-xs-6">
              <div class="panel panel-warning panel-alt widget-today">
                <div class="panel-heading text-center">
                  <i class="fa fa-calendar-o"></i>
                </div>
                <div class="panel-body text-center">
                  <h3 class="today">Fri, Dec 13</h3>
                </div><!-- panel-body -->
              </div><!-- panel -->
            </div>

            <div class="col-xs-6">
              <div class="panel panel-danger panel-alt widget-time">
                <div class="panel-heading text-center">
                  <i class="glyphicon glyphicon-time"></i>
                </div>
                <div class="panel-body text-center">
                  <h3 class="today">4:50AM PST</h3>
                </div><!-- panel-body -->
              </div><!-- panel -->
            </div>
          </div>
        </div><!-- col-sm-6 -->

      </div>


</div>
<link rel="stylesheet" href="${msUrl}/css/bcss/jquery-multitabs.css">
<script src="${msUrl}/js/jquerylib/jquery-multitabs.js"></script>
<script src="${msUrl}/js/bootstraplib/dashboard.js"></script>

</body>
</html>
