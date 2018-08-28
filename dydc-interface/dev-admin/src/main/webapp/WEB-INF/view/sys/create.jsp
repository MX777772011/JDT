<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>jQeury.steps Demos</title>
<meta name="description" content="">
<%@include file="/WEB-INF/view/include.jsp"%>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="${msUrl}/css/steps/normalize.css">
<link rel="stylesheet" href="${msUrl}/css/steps/main.css">
<link rel="stylesheet" href="${msUrl}/css/steps/jquery.steps.css">
<script src="${msUrl}/js/steps/jquery.steps.js"></script>


</head>

<body>
	<header>
		<h1>生成规则</h1>
		<nav>
			<ul>
				<li>表名、字段名以"_"分割，然后用驼峰法进行命名</li>
				<li>表名前缀在生成累的时候会去掉，如果不填写前缀，则当作没有前缀，不进行处理</li>
				<li></li>
			</ul>
		</nav>
	</header>
	<form id="example-advanced-form" action="${msUrl}/sys/createjava/viewTable.do" method="post">
		<h3>数据库连接</h3>
		<fieldset>
			<input type="hidden" name="currentIndex" value="1">
			<label for="userName-2">数据库类型 *</label>
			<br>
			<select name="dbType" style="width: 20%;">
				<option value="1">MySQL</option>
				<option value="2">Oracle</option>
				<option value="3">SqlServer</option>
				<option value="4">PostgreSQL</option>
			</select>
			<br>
			<label for="userName-2">数据库IP *</label>
			<input type="text" name="ip" id="ip" class="required" value="${defaultIp}" />
			<label for="userName-2">数据库端口号 *</label>
			<input type="text" name="port" id="port" class="required" value="${defaultPort}" />
			<label for="userName-2">数据库库名 *</label>
			<input type="text" name="dbName" id="dbName" class="required" value="${defaultDb}" />
			<label for="userName-2">数据库用户名 *</label>
			<input type="text" name="username" id="username" class="required" value="${defaultUserName}" />
			<label for="userName-2">数据库密码 *</label>
			<input type="password" name="dbpwd" id="dbpwd" class="required" value="${defaultPassword}" />
			<p>(*) 必输项</p>
			<input type="hidden" name="currentIndex1" value="0">
			<button type="button" onclick="viewTable(1)" class="btn btn-primary">
				<i class="fa  fa-search"></i>
				验证
			</button>
		</fieldset>

		<h3>输入表名及生成路劲</h3>
		<fieldset>
			<label for="userName-2">请输入要生成的表名 *</label>
			<input type="text" name="tableName" id="tableName" class="required" />
			<label for="userName-2">请输入要生成的表备注 *</label>
			<input type="text" name="tableRemark" id="tableRemark" class="required" />
			<label for="userName-2">请输入工程路径 *</label>
			<input type="text" name="devPath" id="devPath" class="required" value="${devPath}" />
			<p>(*) 必输项</p>
			<input type="hidden" name="currentIndex2" value="0">
			<button type="button" onclick="viewTable(2)" class="btn btn-primary">
				<i class="fa  fa-search"></i>
				验证
			</button>
		</fieldset>

		<h3>生成文件</h3>
		<fieldset>
			<div class="row">
				<input type="checkbox" name="isShwoMenu" id="isShwoMenu" value="1" />
				<label for="acceptTerms-2">是否生成菜单</label>
			</div>
			<div class="row">
				<input type="checkbox" name="isAddJsp" id="isAddJsp" value="1" checked="checked" />
				<label for="acceptTerms-2">是否生成AddJsp</label>
			</div>
			<div class="row">
				<input type="checkbox" name="isBean" id="isBean" value="1" checked="checked" />
				<label for="acceptTerms-3">是否生成Bean</label>
			</div>
			<div class="row">
				<input type="checkbox" name="isController" id="isController" value="1" checked="checked" />
				<label for="acceptTerms-4">是否生成Controller</label>
			</div>
			<!-- 	<div class="row">
		<input type="checkbox" name="isEditjsp" id=isEditjsp" value="1" checked="checked"/><label for="acceptTerms-5">是否生成Editjsp</label>
    	</div> -->
			<div class="row">
				<input type="checkbox" name="isJs" id="isJs" value="1" checked="checked" />
				<label for="acceptTerms-6">是否生成Js</label>
			</div>
			<div class="row">
				<input type="checkbox" name="isListJsp" id="isListJsp" value="1" checked="checked" />
				<label for="acceptTerms-7">是否生成ListJsp</label>
			</div>
			<div class="row">
				<input type="checkbox" name="isMapperJava" id="isMapperJava" value="1" checked="checked" />
				<label for="acceptTerms-8">是否生成MapperJava</label>
			</div>
			<div class="row">
				<input type="checkbox" name="isMapperXMl" id="isMapperXMl" value="1" checked="checked" />
				<label for="acceptTerms-9">是否生成MapperXMl</label>
			</div>
			<div class="row">
				<input type="checkbox" name="isService" id="isService" value="1" checked="checked" />
				<label for="acceptTerms-10">是否生成Service</label>
			</div>
			<div class="row">
				<input type="checkbox" name="isModel" id="isModel" value="1" checked="checked" />
				<label for="acceptTerms-10">是否生成Model</label>
			</div>

		</fieldset>
		<input type="hidden" name="json_string" id="json_string" value="">
	</form>
	<div class="row" id="create_coloumn">
		<div class="row" v-if="show">
			<div class="col-sm-1 text-center">字段</div>
			<div class="col-sm-1 text-center">备注</div>
			<div class="col-sm-1 text-center">类型</div>
			<div class="col-sm-1 text-center">非空</div>
			<div class="col-sm-2 text-center">长度/大小</div>
			<div class="col-sm-2 text-center">邮箱/身份证/手机</div>
			<div class="col-sm-2 text-center">枚举</div>
			<div class="col-sm-2 text-center">正则</div>
		</div>
		<div class="row" v-for="coloumn in coloumns" v-if="show">
			<div class="col-sm-1 text-center">
				<input v-model="coloumn.COLUMN_NAME" type="text" class="form-control" disabled="disabled">
			</div>
			<div class="col-sm-1 text-center">
				<input v-model="coloumn.COLUMN_COMMENT" type="text" class="form-control">
			</div>
			<div class="col-sm-1 text-center">
				<label class="control-label">{{coloumn.DATA_TYPE}}</label>
			</div>
			<div class="col-sm-1 text-center">
				<label class="checkbox-inline">
					<input v-model="coloumn.IS_NULLABLE" type="checkbox" name="fields.canBeNull" class="form-control" />
				</label>
			</div>
			<div class="col-sm-1 text-center">
				<input type="text" v-model="coloumn.MIN_LENGTH" class="form-control" />
			</div>
			<div class="col-sm-1 text-center">
				<input type="text" v-model="coloumn.MAX_LENGTH" class="form-control" />
			</div>
			<div class="col-sm-2 text-center">
				<label class="checkbox-inline">
					<input v-model="coloumn.IS_EMAIL" type="checkbox" class="form-control" />
				</label>
				<label class="checkbox-inline">
					<input v-model="coloumn.IS_MOBILE" type="checkbox" class="form-control" />
				</label>
				<label class="checkbox-inline">
					<input v-model="coloumn.IS_IDNO" type="checkbox" class="form-control" />
				</label>
			</div>
			<div class="col-sm-2 text-center">
				<input type="text" v-model="coloumn.ENUMAT" class="form-control" placeholder="以,分隔的字符串" />
			</div>
			<div class="col-sm-2 text-center">
				<input type="text" v-model="coloumn.REGEX" class="form-control" placeholder="正则表达式" />
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="${msUrl}/js/vue.js"></script>
<script type="text/javascript">
	var create_coloumn = new Vue({
		el : "#create_coloumn",
		data : {
			show : false,
			coloumns : [ {
				COLUMN_NAME : "",
				COLUMN_COMMENT : "",
				DATA_TYPE : "",
				IS_NULLABLE : "",
				MIN_LENGTH : "",
				MAX_LENGTH : "",
				IS_EMAIL : "",
				IS_MOBILE : "",
				IS_IDNO : "",
				ENUMAT : "",
				REGEX : ""
			} ]
		}
	});
	function getPfix() {
		var tableName = $("#tableName").val();
		var p = tableName.split("_")[0];
		$("#pfix").val(p + "_");
	}

	$.fn.serializeObject = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name]) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	}

	function viewTable(currentIndex) {
		var returnResult = false;
		$("input[name='currentIndex']").val(currentIndex);
		SPlatForm.ajaxSubmit($("#example-advanced-form"), {
			successTodo : function(result) {//成功的回调
				if (result.success) {
					SPlatForm.alert(result.msg);//调用公共alert
					$("input[name='currentIndex" + currentIndex + "']").val("1");
					if (currentIndex == 2) {
						create_coloumn.show = true;
						create_coloumn.coloumns = result.data;
						for (var i = 0; i < result.data.length; i++) {
							if (result.data[i].IS_NULLABLE == 'YES') {
								create_coloumn.coloumns[i].IS_NULLABLE = false;
							} else {
								create_coloumn.coloumns[i].IS_NULLABLE = true;
							}
						}
					}
				} else {
					$("input[name='currentIndex" + currentIndex + "']").val("0");
				}
			}
		});
	}
	function createFile() {
		$("#json_string").val(JSON.stringify(create_coloumn.coloumns));
		SPlatForm.ajaxSubmit($("#example-advanced-form"), {
			url : '${msUrl}/sys/createjava/createFile.do',
			successTodo : function(result) {//成功的回调
				if (result.msg) {
					SPlatForm.alert("生成成功");//调用公共alert
				} else {
					SPlatForm.alert(result.msg);//调用公共alert
				}
			}
		});
	}

	var form = $("#example-advanced-form").show();
	form.steps({
		height : "100",
		headerTag : "h3",
		bodyTag : "fieldset",
		transitionEffect : "slideLeft",
		onStepChanging : function(event, currentIndex, newIndex) {

			// Allways allow previous action even if the current form is not valid!
			if (currentIndex > newIndex) {
				return true;
			}
			// Forbid next action on "Warning" step if the user is to young
			if (newIndex === 3 && Number($("#age-2").val()) < 18) {
				return false;
			}
			// Needed in some cases if the user went back (clean up)
			if (currentIndex < newIndex) {
				// To remove error styles
				form.find(".body:eq(" + newIndex + ") label.error").remove();
				form.find(".body:eq(" + newIndex + ") .error").removeClass("error");
			}
			form.validate().settings.ignore = ":disabled,:hidden";
			//验证表单
			var returnvalid = form.valid();
			var ajaxver = $("input[name='currentIndex" + (currentIndex * 1 + 1) + "']").val();
			if (ajaxver == "0") {
				SPlatForm.alert("验证通过才能进行下一步");
				returnvalid = false;
			}
			return returnvalid;
		},
		onStepChanged : function(event, currentIndex, priorIndex) {
			// Used to skip the "Warning" step if the user is old enough.
			if (currentIndex === 2 && Number($("#age-2").val()) >= 18) {
				form.steps("next");
			}
			// Used to skip the "Warning" step if the user is old enough and wants to the previous step.
			if (currentIndex === 2 && priorIndex === 3) {
				form.steps("previous");
			}

		},
		onFinishing : function(event, currentIndex) {
			form.validate().settings.ignore = ":disabled";
			return form.valid();
		},
		onFinished : function(event, currentIndex) {
			createFile();
		}
	}).validate({
		errorPlacement : function errorPlacement(error, element) {
			element.before(error);
		},
		rules : {
			confirm : {
				equalTo : "#password-2"
			}
		}
	});
</script>

</html>