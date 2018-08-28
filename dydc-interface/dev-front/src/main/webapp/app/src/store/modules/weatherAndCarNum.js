// 引用API文件
import api from '@/api/index.js';

const state = {
  weatherAndCarNum: {
    city: '', // 地区
    carcode: '', // 限行车号
    weather: '', // 天气
    temp2: '', // 最高温度
    temp1: '', // 最低温度
    img: ''
  }
};

const getters = {
  getWeatherAndCarNum: state => state.weatherAndCarNum
};

const actions = {
  initWeatherAndCarNum ({commit}) {
    api.post('dydcHouseInfo/getWeatherAndCarNum.do', {}, r => {
      if (r.success) {
        commit('setWeatherAndCarNum', r);
      }
    }, r => {
      console.log(r.msg);
    });
    let index = setInterval(() => {
      api.post('dydcHouseInfo/getWeatherAndCarNum.do', {}, r => {
        if (r.success) {
          commit('setWeatherAndCarNum', r);
        }
      }, r => {
        console.log(r.msg);
      });
    }, 600000);
    commit('setWeatherAndCarNumTimerIndex', index);
  }
};

const mutations = {
  setWeatherAndCarNum (state, weatherAndCarNumData) {
    state.weatherAndCarNum = weatherAndCarNumData;
  }
};

export default {
  state,
  getters,
  actions,
  mutations
};
