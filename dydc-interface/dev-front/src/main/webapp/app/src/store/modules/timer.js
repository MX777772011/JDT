const state = {
  timer: {
    houseTypeTimerIndex: -1, // 房屋信息定时器标识
    weatherAndCarNumTimerIndex: -1, // 首页天气限行车号信息定时器标识
    deviceStatusTimerIndex: -1 // 设备状态信息定时器标识
  }
};

const getters = {
  getTimer: state => state.timer
};

const actions = {};

const mutations = {
  // 设置房屋信息定时器标识
  setHouseTypeTimerIndex (state, index) {
    state.houseTypeTimerIndex = index;
  },
  // 清除房屋信息定时器
  clearHouseTypeTimer (state) {
    clearInterval(state.houseTypeTimerIndex);
  },
  // 设置天气限行车号信息定时器标识
  setWeatherAndCarNumTimerIndex (state, index) {
    state.weatherAndCarNumTimerIndex = index;
  },
  // 清除天气限行车号信息定时器
  clearWeatherAndCarNumTimerIndex (state) {
    clearInterval(state.weatherAndCarNumTimerIndex);
  },
  // 设置设备状态信息定时器标识
  setDeviceStatusTimerIndex (state, index) {
    state.deviceStatusTimerIndex = index;
  },
  // 清除设备状态信息定时器标识
  clearDeviceStatusTimerIndex (state) {
    clearInterval(state.deviceStatusTimerIndex);
  }
};

export default {
  state,
  getters,
  actions,
  mutations
};
