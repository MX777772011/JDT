var LHJT_SESSION_ID = getSessionId();
function getSessionId() {
	var lhjt_session_id = $.cookie('LHJT_SESSION_ID');
	if (!lhjt_session_id) {
		lhjt_session_id = new UUID().createUUID();
		$.cookie('LHJT_SESSION_ID', lhjt_session_id,{path:'/'});
	}
	return lhjt_session_id;
}
var TOKEN = $.cookie('TOKEN') === undefined ? '' : $.cookie('TOKEN');
var USER_ID = $.cookie('USER_ID') === undefined ? '' : $.cookie('USER_ID');

function writeCooike(LHJT_SESSION_ID, TOKEN, USER_ID) {
	$.cookie('LHJT_SESSION_ID', LHJT_SESSION_ID,{path:'/'});
	$.cookie('TOKEN', TOKEN,{path:'/'});
	$.cookie('USER_ID', USER_ID,{path:'/'});
}

function commonAjax(url, type, data, success, failed, error) {
	commonAjaxUtil(url, type, data, true, success, failed, error);
}
function commonAjaxUtil(url, type, data, async, success, failed, error) {
	failed = failed === undefined ||failed ==null ? $.noop : failed;
	error = error === undefined ||error ==null ? $.noop : error;
	$.ajax({
		type : type,
		url : url,
		data : data,// 你的formid
		async : async,
		traditional: true,
		dataType : "json",
		error : function(request) {
			error(request);
		},
		beforeSend : function(xhr) {
			xhr.setRequestHeader('LHJT_SESSION_ID', LHJT_SESSION_ID);
			xhr.setRequestHeader('USER_ID', USER_ID);
			xhr.setRequestHeader('TOKEN', TOKEN);
		},
		success : function(data) {
			if (data.status == 1) {
				success(data);
			} else {
				failed(data);
			}
		},
	});
}
function commonGetAjax(url, data, success, failed, error) {
	commonAjax(url, "GET", data, success, failed, error);
}
function commonPostAjax(url, data, success, failed, error) {
	commonAjax(url, "POST", data, success, failed, error);
}

function commonGetCity(code, id,afterSetCity) {
	afterSetCity = afterSetCity === undefined ? $.noop : afterSetCity;
	commonGetAjax(ctx + "front/interface/area/getcity/" + code, {}, function(data) {
		$(id).empty();
		$(id).html($("<option>").text("请选择").val(""));
		for (var i = 0; i < data.data.length; i++) {
			$(id).append($("<option>").text(data.data[i].name).val(data.data[i].code));
		}
		afterSetCity();
	}, function(data) {
		alert(data.msg);
	});
}

/**
 * 绑定省市区自动关联，需初始化省份数据commonGetCity('00000',id) select 控件
 * 
 * @param id1
 *            省id
 * @param id2
 *            市id
 * @param id3
 *            区id
 */
function commonBindGetCity(id1, id2, id3) {
	// 省 市 区
	if (id1 && id2) {
		$(id1).off("change").on("change", function() {
			$(id3).html($("<option>").text("请选择").val(""));
			commonGetCity($(this).val(), id2);
		});
		if (id2 && id3) {

			$(id2).off("change").on("change",function() {
				commonGetCity($(this).val(), id3);
			});
		}
	}
}

function refresh_verify_code(type, id) {
	commonGetAjax(ctx + "front/interface/patchca/captcha?type=" + type, {}, function(data) {
		$(id).attr("src", data.data);
	}, function(data) {
		alert(data.msg);
	});
}
function bind_verify_code(type, id) {
	$(id).click(function() {
		refresh_verify_code(type, id);
	}).click();
}
function bind_mobile_code(type,mobile,id){
	$(id).click(
			function(){
				commonGetAjax(ctx+"front/interface/patchca/mobileCaptcha?type="+type+"&mobile="+$(mobile).val(), {}, function(data){
					alert(data.msg);
				},function(data){
					alert(data.msg);
				});
			}
	);
}


