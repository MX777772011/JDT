import Vue from 'vue';
import Router from 'vue-router';
import NProgress from 'nprogress';
import 'nprogress/nprogress.css';
// 引入页面
// import index from '@/page/index/index';
import welcomePage from '@/page/welcomePage/welcomePage';
import login from '@/page/login/login';// 登录
import register from '@/page/register/register';// 注册
import forget from '@/page/forget/forget';// 忘记密码
import homePage from '@/page/homePage/homePage';// 首页
import smartHome from '@/page/smartHome/smartHome';// 智能家庭首页
import peopleLocation from '@/page/peopleLocation/peopleLocation';// 人员定位
import situationalMode from '@/page/situationalMode/situationalMode';// 情景模式
import newModel from '@/page/newModel/newModel';// 新情景模式
import myDeviceNew from '@/page/myDevice/myDevice-new';// 家庭设备户型图
import myDeviceList from '@/page/myDeviceList/myDeviceList';// 家庭设备列表
import panoramicModel from '@/page/panoramicModel/panoramicModel-new';// 全景模式
import intelligentProperty from '@/page/intelligentProperty/intelligentProperty';// 智能物业
import propertyRepair from '@/page/propertyRepair/propertyRepair';// 物业报修
import BI from '@/page/BI/BI';//  智能商业
import BIDetails from '@/page/BIDetails/BIDetails';// 商户详情
import intelligentService from '@/page/intelligentService/intelligentService';//  智能服务
import presonalCenter from '@/page/presonalCenter/presonalCenter';// 个人中心
import presonalinfo from '@/page/presonalinfo/presonalinfo';// 个人信息
import changeHeadPic from '@/page/changeHeadPic/changeHeadPic';// 修改头像
import myVisitor from '@/page/myVisitor/myVisitor';// 访客中心
import normalVisitor from '@/page/normalVisitor/normalVisitor';//
import driverVisitor from '@/page/driverVisitor/driverVisitor';//
import myVisitorRecod from '@/page/myVisitorRecod/myVisitorRecod';// 访客记录
import myVisitorDetails from '@/page/myVisitorDetails/myVisitorDetails';// 访客记录详情
import myMessage from '@/page/myMessage/myMessage';// 消息中心
import messageContent from '@/page/messageContent/messageContent';// 消息详情
import normalQes from '@/page/normalQes/normalQes';// 常见问题
import normalQesContent from '@/page/normalQesContent/normalQesContent';// 常见问题详情
import feedback from '@/page/feedback/feedback';// 问题反馈
import aboutUs from '@/page/aboutUs/aboutUs';// 关于我们
import otherPages from '@/page/0otherPages/0otherPages';

Vue.use(Router);

const router = new Router({
  routes: [
    {
      path: '/',
      redirect: '/smartHome'
    },
    {
      path: '/welcomePage',
      name: 'welcomePage',
      component: welcomePage
    },
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/forget',
      name: 'forget',
      component: forget
    },
    {
      path: '/register',
      name: 'register',
      component: register
    },
    {
      path: '/homePage',
      name: 'homePage',
      component: homePage
    },
    {
      path: '/smartHome',
      name: 'smartHome',
      component: smartHome
    },
    {
      path: '/peopleLocation',
      name: 'peopleLocation',
      component: peopleLocation
    },
    {
      path: '/situationalMode',
      name: 'situationalMode',
      component: situationalMode
    },
    {
      path: '/newModel',
      name: 'newModel',
      component: newModel
    },
    {
      path: '/panoramicModel',
      name: 'panoramicModel',
      component: panoramicModel
    },
    {
      path: '/intelligentProperty',
      name: 'intelligentProperty',
      component: intelligentProperty
    },
    {
      path: '/propertyRepair',
      name: 'propertyRepair',
      component: propertyRepair
    },
    {
      path: '/myDeviceNew',
      name: 'myDeviceNew',
      component: myDeviceNew
    },
    {
      path: '/myDeviceList',
      name: 'myDeviceList',
      component: myDeviceList
    },
    {
      path: '/presonalCenter',
      name: 'presonalCenter',
      component: presonalCenter
    },
    {
      path: '/presonalinfo',
      name: 'presonalinfo',
      component: presonalinfo
    },
    {
      path: '/changeHeadPic',
      name: 'presonalinfo',
      component: changeHeadPic
    },
    {
      path: '/myVisitor',
      name: 'myVisitor',
      component: myVisitor,
      children: [
        {
          path: '',
          component: normalVisitor
        },
        {
          path: 'normalVisitor',
          name: 'normalVisitor',
          component: normalVisitor
        },
        {
          path: 'driverVisitor',
          name: 'driverVisitor',
          component: driverVisitor
        }
      ]
    },
    {
      path: '/myVisitorRecod',
      name: 'myVisitorRecod',
      component: myVisitorRecod
    },
    {
      path: '/myVisitorDetails',
      name: 'myVisitorDetails',
      component: myVisitorDetails
    },
    {
      path: '/myMessage',
      name: 'myMessage',
      component: myMessage
    },
    {
      path: '/messageContent',
      name: 'messageContent',
      component: messageContent
    },
    {
      path: '/normalQes',
      name: 'normalQes',
      component: normalQes
    },
    {
      path: '/normalQesContent',
      name: 'normalQesContent',
      component: normalQesContent
    },
    {
      path: '/feedback',
      name: 'feedback',
      component: feedback
    },
    {
      path: '/aboutUs',
      name: 'aboutUs',
      component: aboutUs
    },
    {
      path: '/BI',
      name: 'BI',
      component: BI
    },
    {
      path: '/BIDetails',
      name: 'BIDetails',
      component: BIDetails
    },
    {
      path: '/intelligentService',
      name: 'intelligentService',
      component: intelligentService
    },
    {
      path: '/otherPages/:id',
      name: 'otherPages',
      component: otherPages
    }
  ]
});

// 路由跳转前验证
router.beforeEach((to, from, next) => {
  // 开启进度条
  NProgress.start();

  next();
});

router.afterEach(() => {
  // router跳转后
  NProgress.done(); // 结束Progress
});

export default router;
