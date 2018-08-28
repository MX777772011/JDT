// 引入滚动条
import NProgress from 'nprogress';
// 引用mui
import mui from 'mui';
// 引用qs解决axios post方式，后台取不到数据的问题
import qs from 'qs';
// 引用axios
import axios from 'axios';
// 配置API接口地址
// var hostUrl = 'http://172.16.37.101:4000';// 仅在开发app中使用
var hostUrl = 'http://192.168.1.111:8080';// 仅在测试app中使用
var root = '/admin';

// 自定义判断元素类型JS
function toType (obj) {
  return ({}).toString.call(obj).match(/\s([a-zA-Z]+)/)[1].toLowerCase();
}
// 参数过滤函数
function filterNull (o) {
  for (var key in o) {
    if (o[key] === null) {
      delete o[key];
    }
    if (toType(o[key]) === 'string') {
      o[key] = o[key].trim();
    } else if (toType(o[key]) === 'object') {
      o[key] = filterNull(o[key]);
    } else if (toType(o[key]) === 'array') {
      o[key] = filterNull(o[key]);
    }
  }
  return o;
}

function apiAxios (method, url, params, success, failure) {
  if (params) {
    params = filterNull(params);
  }
  if (process.env.NODE_ENV === 'production') {
    NProgress.start();
    mui.ajax(hostUrl + root + url, {
      data: params,
      crossDomain: true,
      dataType: 'json', // 服务器返回json格式数据
      type: method, // HTTP请求类型
      success: function (res) {
        NProgress.done(); // 结束Progress
        console.log('请求成功');
        console.log(JSON.stringify(res));
        success(res);
      },
      error: function (xhr, type) {
        NProgress.done(); // 结束Progress
        console.log('请求错误了');
      }
    });
  } else {
    NProgress.start();
    axios.defaults.headers['Content-Type'] = 'application/x-www-form-urlencoded';
    axios({
      method: method,
      url: url,
      data: method === 'POST' || method === 'PUT' ? qs.stringify(params) : null,
      params: method === 'GET' || method === 'DELETE' ? qs.stringify(params) : null,
      baseURL: root,
      withCredentials: false
    })
      .then(function (res) {
        NProgress.done(); // 结束Progress
        if (res) {
          if (success) {
            success(res.data);
          }
        } else {
          if (failure) {
            failure(res.data);
          } else {
            window.alert('error: ' + JSON.stringify(res.data));
          }
        }
      })
      .catch(function (err) {
        NProgress.done(); // 结束Progress
        if (err) {
          window.alert('api error, HTTP CODE: ' + err);
        }
      });
  }
}

// 返回在vue模板中的调用接口
export default {
  get: function (url, params, success, failure) {
    return apiAxios('GET', url, params, success, failure);
  },
  post: function (url, params, success, failure) {
    return apiAxios('POST', url, params, success, failure);
  },
  put: function (url, params, success, failure) {
    return apiAxios('PUT', url, params, success, failure);
  },
  delete: function (url, params, success, failure) {
    return apiAxios('DELETE', url, params, success, failure);
  }
};
