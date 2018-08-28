// 引用API文件
import api from '@/api/index.js';

const state = {
  checkRoomId: '',
  roomTypeList: [],
  equipmentList: []
};

const getters = {
  getRoom: (state) => {
    let list = [...state.roomTypeList];
    list.unshift({
      title: '全部',
      roomtype: 'all',
      roomindex: '',
      roomid: ''
    });
    return list;
  },
  getEquipment: state => state.equipmentList,
  getHouseDouble: (state) => {
    let list = [];
    state.roomTypeList.forEach(element => {
      let listItem = {...element};
      listItem.equipmentList = [];
      state.equipmentList.forEach(item => {
        const item2 = {...item};
        if (listItem.roomid == item2.roomid) {
          listItem.equipmentList.push(item2);
        }
      });
      list.push(listItem);
    });
    return list;
  },
  getEquipmentThree: (state) => {
    // smartHome使用
    if (state.equipmentList.length == 0) {
      return [];
    }
    let list = [];
    for (let i = 0; i < 3; i++) {
      list.push(state.equipmentList[i]);
    }
    list.push({
      devicetype: 'more',
      title: '更多设备',
      isopen: 0
    });
    return list;
  },
  getCheckRoomId: (state) => {
    return state.checkRoomId;
  },
  getRoomEquipment: (state, getters) => {
    // 根据选择房间的id筛选设备列表
    let list = [];
    const checkRoomId = getters.getCheckRoomId;
    state.equipmentList.forEach(element => {
      if (element.roomid == checkRoomId) {
        list.push(element);
      }
    });
    return list;
  },
  getRoomAdjustable: (state, getters) => {
    // 选择房间的设备返回房间可调节设备的列表
    let list = [];
    const equipmentList = getters.getRoomEquipment;
    equipmentList.forEach(element => {
      if (element.dimmer == 1) {
        list.push(element);
      }
    });
    return list;
  }
};

const actions = {
  initHouseData ({commit}) {
    // 初始化房间和设备信息
    api.get('/dydcHouseArea/queryByArea.do', null, r => {
      // if (r.success) {
      commit('setHouseRoom', r);
      this.dispatch('initDeviceData');
      // }
    }, r => {
      console.log(r.msg);
    });
  },
  initDeviceData ({commit}) {
    // 初始化房间和设备信息
    api.get('/dydcHouseDevice/queryDevice.do', null, r => {
      // if (r.success) {
      commit('setHouseDevice', r);
      this.dispatch('updateDeviceListStatus');
      // }
    }, r => {
      console.log(r.msg);
    });
  },
  updateDeviceListStatus ({commit}) {
    // 批量更新设备信息
    api.post('/getDeviceListStatus.do', null, r => {
      if (r.success) {
        commit('setDeviceList', r.data.statusList);
      }
    }, r => {
      console.log(r.msg);
    });
  },
  updateDeviceStatus ({commit}, deviceItem) {
    // 单个更新设备信息- 用于开关普通设备
    const olditem = {...deviceItem};
    let newitem = {...deviceItem};
    newitem.isopen = newitem.isopen > 0 ? 0 : 1;// 仅用于开关
    const deviceChangeObj = {
      oldDeviceItem: olditem,
      newDeviceItem: newitem
    };
    this.dispatch('updateDevice', deviceChangeObj);
  },
  updateDeviceVal ({commit}, deviceChangeObj) {
    // 单个更新设备信息- 调光灯、窗帘
    this.dispatch('updateDevice', deviceChangeObj);
  },
  updateDevice ({commit}, deviceChangeObj, newDeviceItem) {
    // 单个更新设备信息-调用接口
    const olditem = {...deviceChangeObj.oldDeviceItem};
    const newitem = {...deviceChangeObj.newDeviceItem};
    const val = newitem.isopen;
    commit('setDevice', newitem);
    let sendData = {
      val: val,
      addrSet: newitem.addrset,
      eis: newitem.eis
    };
    api.post('/dydcHouseInfo/controlDevice.do', sendData, r => {
      if (!r.success) {
        // 如果失败状态回滚
        commit('setDevice', olditem);
      }
    }, r => {
      // 如果失败状态回滚
      commit('setDevice', olditem);
    });
  },
  setDeviceListOff ({commit}) {
    // 批量设置设备关闭--离家模式
    let sendData = {};
    let olditem = [...this.state.device.equipmentList];
    let eqList = [];
    this.state.device.equipmentList.forEach((element, i) => {
      eqList.push({...element});
      eqList[i].isopen = 0;
    });
    commit('setDeviceList', eqList);
    sendData.equipmentList = JSON.stringify(eqList);
    api.post('/updateDeviceStatus.do', sendData, r => {
      if (!r.success) {
        // 如果失败状态回滚
        commit('setDeviceList', olditem);
      }
    }, r => {
      // 如果失败状态回滚
      commit('setDeviceList', olditem);
    });
  }
};

const mutations = {
  setCheckRoomId (state, roomid) {
    state.checkRoomId = roomid;
  },
  setHouseRoom (state, houseRoomData) {
    // 获取所有房间
    state.roomTypeList = houseRoomData.roomTypeList;
  },
  setHouseDevice (state, houseDeviceData) {
    // 获取所有设备
    let eqList = [];
    houseDeviceData.equipmentList.forEach((element, i) => {
      element.isopen = 0;// 将设备默认状态设置为关
      eqList.push(element);
    });
    state.equipmentList = eqList;
  },
  setDeviceList (state, statusList) {
    // 批量更新设备信息
    state.equipmentList.forEach((element, i) => {
      statusList.forEach((item, i) => {
        if (element.deviceid == item.deviceid && item.val !== null) {
          element.isopen = item.val;
        }
      });
    });
  },
  setDevice (state, deviceData) {
    // 单个更新设备信息- 用于开关普通设备
    for (let i = 0; i < state.equipmentList.length; i++) {
      if (state.equipmentList[i].deviceid == deviceData.deviceid) {
        state.equipmentList.splice(i, 1, deviceData);
        break;
      }
    }
  }
};

export default {
  state,
  getters,
  actions,
  mutations
};
