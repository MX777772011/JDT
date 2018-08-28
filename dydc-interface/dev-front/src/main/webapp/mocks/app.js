let express = require('express');    //引入express模块
let bodyParser=require('body-parser');
let Mock = require('mockjs');        //引入mock模块

let app = express();                //实例化express
// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: false }))

// parse application/json
app.use(bodyParser.json())

/**
 * 配置test.action路由
 * @param  {[type]} req  [客户端发过来的请求所带数据]
 * @param  {[type]} res  [服务端的相应对象，可使用res.send返回数据，res.json返回json数据，res.down返回下载文件]
 */
app.all('/admin/toLogin.do', function(req, res) {
  /**
     * mockjs中属性名‘|’符号后面的属性为随机属性，数组对象后面的随机属性为随机数组数量，正则表达式表示随机规则，+1代表自增
     */
    console.log(req.query);
    res.json(Mock.mock({
      "success": true,
      "msg":"登录成功",
      "data":{

      }
  }));
});

// 设备
app.all('/admin/dydcHouseArea/queryByArea.do', function(req, res) {
  /**
     * mockjs中属性名‘|’符号后面的属性为随机属性，数组对象后面的随机属性为随机数组数量，正则表达式表示随机规则，+1代表自增
     */
    console.log(req.query);
    res.json(Mock.mock({
      // "success": true,
      // "msg":"列表读取成功",
      // "data":{
        roomTypeList: [//房间类别
          {
            title: '玄关',//显示名称
            roomtype: 'porch',//房间类型，应该对应图标，字典
            roomindex: 0,//房间在客户端唯一标识，这个东西，需要前台做好后，后台维护的时候，对应维护
            roomid: 1001,//后台表主键
          },
          {
            title: '客厅',//显示名称
            roomtype: 'parlour',//房间类型，应该对应图标，字典
            roomindex: 1,//房间在客户端唯一标识，这个东西，需要前台做好后，后台维护的时候，对应维护
            roomid: 1002,//后台表主键
          },
          {
            title: '卧室1',
            roomtype: 'bedroom',
            roomindex: 2,
            roomid: 1003,
          },
          {
            title: '衣帽间1',
            roomtype: 'cloakroom',
            roomindex: 3,
            roomid: 1004,
          },
          {
            title: '卫生间1',
            roomtype: 'toilet',
            roomindex: 4,
            roomid: 1005,
          },
          {
            title: '卧室2',
            roomtype: 'bedroom',
            roomindex: 5,
            roomid: 1006,
          },
          {
            title: '衣帽间2',
            roomtype: 'cloakroom',
            roomindex: 6,
            roomid: 1007,
          },
          {
            title: '卫生间2',
            roomtype: 'toilet',
            roomindex: 7,
            roomid: 1008,
          },
          {
            title: '卧室3',
            roomtype: 'bedroom',
            roomindex: 8,
            roomid: 1009,
          },
          {
            title: '卧室3走廊',
            roomtype: 'corridor',
            roomindex: 9,
            roomid: 1010,
          },
          {
            title: '卫生间3',
            roomtype: 'toilet',
            roomindex: 10,
            roomid: 1011,
          },
          {
            title: '书房',
            roomtype: 'study',
            roomindex: 11,
            roomid: 1012,
          },
          {
            title: '餐厅',
            roomtype: 'diningroom',
            roomindex: 12,
            roomid: 1013,
          },
          {
            title: '走廊',
            roomtype: 'corridor',
            roomindex: 13,
            roomid: 1014,
          },
        ],
      // }
  }));
});

// 设备
app.all('/admin/dydcHouseDevice/queryDevice.do', function(req, res) {
  /**
     * mockjs中属性名‘|’符号后面的属性为随机属性，数组对象后面的随机属性为随机数组数量，正则表达式表示随机规则，+1代表自增
     */
    console.log(req.query);
    res.json(Mock.mock({
      // "success": true,
      // "msg":"列表读取成功",
      // "data":{
        equipmentList: [//设备列表
          {
            roomid: 1001,//房间列表中的id
            roomindex: 0,//设备所在房间的index
            title: '玄关筒灯',//名称
            devicetype: 'tubeLamp',//设备类型，字典
            deviceindex: 0,//前端给出，后台对应维护就可以
            dimmer:0,//调光灯标识，0非，1调光灯
            deviceid:"88800001"//设备id，后续控制、监控状态用
          },
          {
            roomid: 1001,//房间列表中的id
            roomindex: 0,//设备所在房间的index
            title: '玄关洗墙灯',//名称
            devicetype: 'wallLamp',//设备类型，字典
            deviceindex: 1,//前端给出，后台对应维护就可以
            dimmer:0,//调光灯标识，0非，1调光灯
            deviceid:"88800002"//设备id，后续控制、监控状态用
          },
          {
            roomid: 1002,//房间列表中的id
            roomindex: 1,
            title: '客厅灯带',
            devicetype: 'lamp',
            deviceindex: 0,
            dimmer:0,
            deviceid:"88800003"
          },
          {
            roomid: 1002,//房间列表中的id
            roomindex: 1,
            title: '客厅射灯',
            devicetype: 'tubeLamp',
            deviceindex: 1,
            dimmer:0,
            deviceid:"88800004"
          },
          {
            roomid: 1002,//房间列表中的id
            roomindex: 1,
            title: '客厅筒灯',
            devicetype: 'tubeLamp',
            deviceindex: 2,
            dimmer:0,
            deviceid:"88800005"
          },
          {
            roomid: 1002,//房间列表中的id
            roomindex: 1,
            title: '客厅洗墙灯',
            devicetype: 'wallLamp',
            deviceindex: 3,
            dimmer:0,
            deviceid:"88800006"
          },
          {
            roomid: 1002,//房间列表中的id
            roomindex: 1,
            title: '客厅窗帘',
            devicetype: 'windowCurtains',
            deviceindex: 4,
            dimmer:0,
            deviceid:"88800007"
          },
          {
            roomid: 1003,//房间列表中的id
            roomindex: 2,
            title: '卧室1调光灯1',
            devicetype: 'dimmer',
            deviceindex: 0,
            dimmer:1,
            deviceid:"88800008"
          },
          {
            roomid: 1003,//房间列表中的id
            roomindex: 2,
            title: '卧室1调光灯2',
            devicetype: 'dimmer',
            deviceindex: 1,
            dimmer:1,
            deviceid:"88800009"
          },
          {
            roomid: 1003,//房间列表中的id
            roomindex: 2,
            title: '卧室1灯带',
            devicetype: 'lamp',
            deviceindex: 2,
            dimmer:0,
            deviceid:"88800010"
          },
          {
            roomid: 1003,//房间列表中的id
            roomindex: 2,
            title: '卧室1筒灯',
            devicetype: 'tubeLamp',
            deviceindex: 3,
            dimmer:0,
            deviceid:"88800011"
          },
          {
            roomid: 1003,//房间列表中的id
            roomindex: 2,
            title: '卧室1射灯',
            devicetype: 'tubeLamp',
            deviceindex: 4,
            dimmer:0,
            deviceid:"88800012"
          },
          {
            roomid: 1003,//房间列表中的id
            roomindex: 2,
            title: '卧室1窗帘',
            devicetype: 'windowCurtains',
            deviceindex: 5,
            dimmer:0,
            deviceid:"88800013"
          },
          {
            roomid: 1003,//房间列表中的id
            roomindex: 2,
            title: '卧室1洗墙灯',
            devicetype: 'wallLamp',
            deviceindex: 6,
            dimmer:0,
            deviceid:"88800014"
          },
          {
            roomid: 1004,//房间列表中的id
            roomindex: 3,
            title: '衣帽间1筒灯',
            devicetype: 'tubeLamp',
            deviceindex: 0,
            dimmer:0,
            deviceid:"88800015"
          },
          {
            roomid: 1005,//房间列表中的id
            roomindex: 4,
            title: '卫生间1筒灯',
            devicetype: 'tubeLamp',
            deviceindex: 0,
            dimmer:0,
            deviceid:"88800016"
          },
          {
            roomid: 1005,//房间列表中的id
            roomindex: 4,
            title: '卫生间1化妆灯',
            devicetype: 'wallLamp',
            deviceindex: 1,
            dimmer:0,
            deviceid:"88800017"
          },
          {
            roomid: 1005,//房间列表中的id
            roomindex: 4,
            title: '卫生间1换气扇',
            devicetype: 'ventilator',
            deviceindex: 2,
            dimmer:0,
            deviceid:"88800018"
          },
          {
            roomid: 1005,//房间列表中的id
            roomindex: 4,
            title: '卫生间1窗帘',
            devicetype: 'windowCurtains',
            deviceindex: 3,
            dimmer:0,
            deviceid:"88800019"
          },
          {
            roomid: 1006,//房间列表中的id
            roomindex: 5,
            title: '卧室2调光灯1',
            devicetype: 'dimmer',
            deviceindex: 0,
            dimmer:1,
            deviceid:"88800020"
          },
          {
            roomid: 1006,//房间列表中的id
            roomindex: 5,
            title: '卧室2调光灯2',
            devicetype: 'dimmer',
            deviceindex: 1,
            dimmer:1,
            deviceid:"88800021"
          },
          {
            roomid: 1006,//房间列表中的id
            roomindex: 5,
            title: '卧室2灯带',
            devicetype: 'lamp',
            deviceindex: 2,
            dimmer:0,
            deviceid:"88800022"
          },
          {
            roomid: 1006,//房间列表中的id
            roomindex: 5,
            title: '卧室2筒灯',
            devicetype: 'tubeLamp',
            deviceindex: 3,
            dimmer:0,
            deviceid:"88800023"
          },
          {
            roomid: 1006,//房间列表中的id
            roomindex: 5,
            title: '卧室2射灯',
            devicetype: 'tubeLamp',
            deviceindex: 4,
            dimmer:0,
            deviceid:"88800024"
          },
          {
            roomid: 1006,//房间列表中的id
            roomindex: 5,
            title: '卧室2窗帘',
            devicetype: 'windowCurtains',
            deviceindex: 5,
            dimmer:0,
            deviceid:"88800025"
          },
          {
            roomid: 1007,//房间列表中的id
            roomindex: 6,
            title: '衣帽间2筒灯',
            devicetype: 'tubeLamp',
            deviceindex: 0,
            dimmer:0,
            deviceid:"88800026"
          },
          {
            roomid: 1007,//房间列表中的id
            roomindex: 6,
            title: '衣帽间2窗帘',
            devicetype: 'windowCurtains',
            deviceindex: 1,
            dimmer:0,
            deviceid:"88800027"
          },
          {
            roomid: 1008,//房间列表中的id
            roomindex: 7,
            title: '卫生间2筒灯',
            devicetype: 'tubeLamp',
            deviceindex: 0,
            dimmer:0,
            deviceid:"88800028"
          },
          {
            roomid: 1008,//房间列表中的id
            roomindex: 7,
            title: '卫生间2化妆灯',
            devicetype: 'wallLamp',
            deviceindex: 1,
            dimmer:0,
            deviceid:"88800029"
          },
          {
            roomid: 1008,//房间列表中的id
            roomindex: 7,
            title: '卫生间2换气扇',
            devicetype: 'ventilator',
            deviceindex: 2,
            dimmer:0,
            deviceid:"88800030"
          },
          {
            roomid: 1009,//房间列表中的id
            roomindex: 8,
            title: '卧室3调光灯1',
            devicetype: 'dimmer',
            deviceindex: 0,
            dimmer:1,
            deviceid:"88800031"
          },
          {
            roomid: 1009,//房间列表中的id
            roomindex: 8,
            title: '卧室3调光灯2',
            devicetype: 'dimmer',
            deviceindex: 1,
            dimmer:1,
            deviceid:"88800032"
          },
          {
            roomid: 1009,//房间列表中的id
            roomindex: 8,
            title: '卧室3灯带',
            devicetype: 'lamp',
            deviceindex: 2,
            dimmer:0,
            deviceid:"88800033"
          },
          {
            roomid: 1009,//房间列表中的id
            roomindex: 8,
            title: '卧室3筒灯',
            devicetype: 'tubeLamp',
            deviceindex: 3,
            dimmer:0,
            deviceid:"88800034"
          },
          {
            roomid: 1009,//房间列表中的id
            roomindex: 8,
            title: '卧室3射灯',
            devicetype: 'tubeLamp',
            deviceindex: 4,
            dimmer:0,
            deviceid:"88800035"
          },
          {
            roomid: 1009,//房间列表中的id
            roomindex: 8,
            title: '卧室3窗帘',
            devicetype: 'windowCurtains',
            deviceindex: 5,
            dimmer:0,
            deviceid:"88800036"
          },
          {
            roomid: 1009,//房间列表中的id
            roomindex: 8,
            title: '卧室3洗墙灯',
            devicetype: 'wallLamp',
            deviceindex: 6,
            dimmer:0,
            deviceid:"88800037"
          },
          {
            roomid: 1010,//房间列表中的id
            roomindex: 9,
            title: '卧室3走廊',
            devicetype: 'tubeLamp',
            deviceindex: 0,
            dimmer:0,
            deviceid:"88800038"
          },
          {
            roomid: 1011,//房间列表中的id
            roomindex: 10,
            title: '卫生间3筒灯',
            devicetype: 'tubeLamp',
            deviceindex: 0,
            dimmer:0,
            deviceid:"88800039"
          },
          {
            roomid: 1011,//房间列表中的id
            roomindex: 10,
            title: '卫生间3化妆灯',
            devicetype: 'wallLamp',
            deviceindex: 1,
            dimmer:0,
            deviceid:"88800040"
          },
          {
            roomid: 1011,//房间列表中的id
            roomindex: 10,
            title: '卫生间3换气扇',
            devicetype: 'ventilator',
            deviceindex: 2,
            dimmer:0,
            deviceid:"88800041"
          },
          {
            roomid: 1012,//房间列表中的id
            roomindex: 11,
            title: '书房灯带',
            devicetype: 'lamp',
            deviceindex: 0,
            dimmer:0,
            deviceid:"88800042"
          },
          {
            roomid: 1012,//房间列表中的id
            roomindex: 11,
            title: '书房筒灯',
            devicetype: 'tubeLamp',
            deviceindex: 1,
            dimmer:0,
            deviceid:"88800043"
          },
          {
            roomid: 1012,//房间列表中的id
            roomindex: 11,
            title: '书房射灯',
            devicetype: 'tubeLamp',
            deviceindex: 2,
            dimmer:0,
            deviceid:"88800044"
          },
          {
            roomid: 1013,//房间列表中的id
            roomindex: 12,
            title: '餐厅灯带',
            devicetype: 'lamp',
            deviceindex: 0,
            dimmer:0,
            deviceid:"88800045"
          },
          {
            roomid: 1013,//房间列表中的id
            roomindex: 12,
            title: '餐厅吊灯',
            devicetype: 'pendant',
            deviceindex: 1,
            dimmer:0,
            deviceid:"88800046"
          },
          {
            roomid: 1013,//房间列表中的id
            roomindex: 12,
            title: '餐厅筒灯',
            devicetype: 'tubeLamp',
            deviceindex: 2,
            dimmer:0,
            deviceid:"88800047"
          },
          {
            roomid: 1013,//房间列表中的id
            roomindex: 12,
            title: '餐厅洗墙灯',
            devicetype: 'wallLamp',
            deviceindex: 3,
            dimmer:0,
            deviceid:"88800048"
          },
          {
            roomid: 1014,//房间列表中的id
            roomindex: 13,
            title: '走廊筒灯',
            devicetype: 'tubeLamp',
            deviceindex: 0,
            dimmer:0,
            deviceid:"88800049"
          },
        ],   
      // }
  }));
});

app.all('/admin/getDeviceListStatus.do', function(req, res) {
  /**
     * mockjs中属性名‘|’符号后面的属性为随机属性，数组对象后面的随机属性为随机数组数量，正则表达式表示随机规则，+1代表自增
     */
    res.json(Mock.mock({
      "success": true,
      "msg":"批量设备状态抓取成功",
      "data":{
        "statusList|1-49": [//状态列表
          {
            'deviceid|+1': 88800001,//设备id，后续控制、监控状态用
            'val|0-1': 1,//开关状态，0关，1开
            'light': 15//亮度，0-255的数值
          }
        ] 
      }
  }));
});

app.all('/admin/dydcHouseInfo/controlDevice.do', function(req, res) {
  /**
     * mockjs中属性名‘|’符号后面的属性为随机属性，数组对象后面的随机属性为随机数组数量，正则表达式表示随机规则，+1代表自增
     */
    let deviceid=req.body.deviceid;
    res.json(Mock.mock({
      "success|1-10": false,
      "msg":"设备状态更新成功",
      "data":{
        "deviceid":deviceid,
        'val|0-1': 200,//开关状态，0关，1开
        'light': 15//亮度，0-255的数值
      }
  }));
});

app.all('/admin/updateDeviceListStatus.do', function(req, res) {
  /**
     * mockjs中属性名‘|’符号后面的属性为随机属性，数组对象后面的随机属性为随机数组数量，正则表达式表示随机规则，+1代表自增
     */
    res.json(Mock.mock({
      "success|1-10": false,
      "msg":"批量设备状态更新成功",
      "data":{
        "deviceid|88800001-88800031":88800001,
        'isopen|0-1': 1,//开关状态，0关，1开
        'light': 15//亮度，0-255的数值
      }
  }));
});


// 情景模式
app.all('/admin/getSceneModeList.do', function(req, res) {
  /**
     * mockjs中属性名‘|’符号后面的属性为随机属性，数组对象后面的随机属性为随机数组数量，正则表达式表示随机规则，+1代表自增
     */
    res.json(Mock.mock({
      "success": true,
      "msg":"读取情景模式列表",
      "data":{
        sceneModeList:[
          {
            id:'10001',
            pic: 'banquet',
            type: 'banquet',
            name: '宴会模式',
          },
          {
            id:'10002',
            pic: 'theater',
            type: 'theater',
            name: '剧场模式',
          },
          {
            id:'10003',
            pic: 'sleeping',
            type: 'sleeping',
            name: '睡眠模式',
          },
          {
            id:'10004',
            pic: 'rest',
            type: 'rest',
            name: '休息模式',
          },
          {
            id:'10005',
            pic: 'nightout',
            type: 'nightout',
            name: '起夜模式',
          }
        ]
      }
  }));
});

app.all('/admin/getSceneMode.do', function(req, res) {
  /**
     * mockjs中属性名‘|’符号后面的属性为随机属性，数组对象后面的随机属性为随机数组数量，正则表达式表示随机规则，+1代表自增
     */
    res.json(Mock.mock({
      "success|1-10": false,
      "msg":"获得当前情景模式",
      "data":{
        sceneId:'10001'
      }
  }));
});
app.all('/admin/dydcMode/queryBySn.do', function(req, res) {
  /**
     * mockjs中属性名‘|’符号后面的属性为随机属性，数组对象后面的随机属性为随机数组数量，正则表达式表示随机规则，+1代表自增
     */
    res.json(Mock.mock({
      "success|1-10": false,
      "msg":"获得当前情景模式",
      "data":{
        sceneId:'10001'
      }
  }));
});

app.all('/admin/setSceneMode.do', function(req, res) {
  /**
     * mockjs中属性名‘|’符号后面的属性为随机属性，数组对象后面的随机属性为随机数组数量，正则表达式表示随机规则，+1代表自增
     */
    let sceneId=req.body.sceneId;
    res.json(Mock.mock({
      "success|1-10": false,
      "msg":"场景模式设置成功",
      "data":{
        sceneId:sceneId,
        pic: 'nightout',
        type: 'nightout',
        name: '起夜模式',
      }
  }));
});
/**
* 监听8090端口
*/
app.listen('4000');
console.log('mock启动成功');