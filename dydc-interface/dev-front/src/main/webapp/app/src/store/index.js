import Vue from 'vue';
import vuex from 'vuex';
import houseType from './modules/houseType'; // 房屋信息
import weatherAndCarNum from './modules/weatherAndCarNum'; // 天气限行车号信息
import timer from './modules/timer'; // 定时器标识集
import sceneMode from './modules/sceneMode';// 情景模式
import device from './modules/device';// 情景模式
import createLogger from 'vuex/dist/logger';

Vue.use(vuex);

// env里去获取当前的环境是否需要开启严格模式
// 在发布环境开启严格模式会造成性能上不必要的损失
const debug = process.env.NODE_ENV !== 'production';

export default new vuex.Store({
  modules: {
    houseType,
    weatherAndCarNum,
    timer,
    sceneMode,
    device
  },
  strict: debug,
  plugins: debug ? [createLogger()] : []
});
