// 引用API文件
import api from '@/api/index.js';

const state = {
  houseType: {
    homestatus: 0, // 0离家模式，1回家模式
    roomnum: '', // 房间号
    phone: '', // 手机号
    housetypeid: '', // 户型
    id: 0,
    sn: '', // sn号
    username: '' // 用户名
  }
};

const getters = {
  getHouseType: state => state.houseType
};

const actions = {
  initHouseType ({commit}, phone) {
    api.post('/dydcHouseInfo/queryByPhone.do', phone, r => {
      if (r.success) {
        commit('setHouseType', r.data);
      }
    }, r => {
      console.log(r.msg);
    });
    let index = setInterval(() => {
      api.post('/dydcHouseInfo/queryByPhone.do', phone, r => {
        if (r.success) {
          commit('setHouseType', r.data);
        }
      }, r => {
        console.log(r.msg);
      });
    }, 30000);
    commit('setHouseTypeTimerIndex', index);
  }
};

const mutations = {
  setHouseType (state, houseTypeData) {
    state.houseType = houseTypeData;
  }
};

export default {
  state,
  getters,
  actions,
  mutations
};
