// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import App from './App';
//
import store from './store';
import router from './router';
//
import FastClick from 'fastclick';
import pdSelect from 'pd-select';
import VueQriously from 'vue-qriously';

// 引入全局样式
import './common/mixin.styl';

// 引用全局的配置文件
import config from './config/index.js';
import eqImg from '@/config/eqImg.js';

// 根据不同环境注入不同ajax
import api from './api/index.js';
// 将API方法绑定到全局
Vue.prototype.$api = api;

FastClick.attach(document.body);

// 将全局变量绑定到vue
Vue.use(config);
Vue.use(eqImg);
// 绑定选择框
Vue.use(pdSelect);
// 绑定二维码
Vue.use(VueQriously);

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
});
