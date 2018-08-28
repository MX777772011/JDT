// 引用API文件
import api from '@/api/index.js';

const state = {
  sceneList: [
    {
      id: 'base01',
      pic: '0',
      type: '0',
      title: '宴会模式',
      flag: 0
    },
    {
      id: 'base02',
      pic: '1',
      type: '1',
      title: '剧场模式',
      flag: 0
    },
    {
      id: 'base03',
      pic: '2',
      type: '2',
      title: '睡眠模式',
      flag: 0
    },
    {
      id: 'base04',
      pic: '3',
      type: '3',
      title: '休息模式',
      flag: 0
    },
    {
      id: 'base05',
      pic: '4',
      type: '4',
      title: '起夜模式',
      flag: 0
    }
  ]
};

const getters = {
  getSceneList: state => state.sceneList,
  getSceneListThree: (state) => {
    let list = [];
    if (state.sceneList.length == 0) {
      return list;
    }
    for (let i = 0; i < 3; i++) {
      list.push(state.sceneList[i]);
    }
    list.push({
      pic: '5',
      type: '5',
      title: '更多模式',
      id: '0'
    });
    return list;
  }
};

const actions = {
  initSceneMode ({commit}) {
    // 初始化情景模式
    api.get('/dydcMode/queryBySn.do', null, r => {
      if (r.success) {
        commit('setSceneModeList', r.data);
        // this.dispatch('getSelectSceneMode');
      }
    }, r => {
      console.log(r.msg);
    });
  },
  setSelectSceneMode ({commit, state}, scene) {
    if (scene) {
      const flagTarget = scene.flag;
      commit('setSceneFlag', scene);
      // 修改走先提交再回滚
      api.post('/dydcMode/save.do', scene, r => {
        if (r.success) {
          commit('closeOtherSceneFlag', scene);
        } else {
          scene.flag = flagTarget;
        }
      }, r => {
        scene.flag = flagTarget;
      });
    } else {
      // 情景模式全关
    }
  }
};

const mutations = {
  setSceneModeList (state, sceneModeList) {
    let baseList = [
      {
        id: 'base01',
        pic: '0',
        type: '0',
        title: '宴会模式',
        flag: 0
      },
      {
        id: 'base02',
        pic: '1',
        type: '1',
        title: '剧场模式',
        flag: 0
      },
      {
        id: 'base03',
        pic: '2',
        type: '2',
        title: '睡眠模式',
        flag: 0
      },
      {
        id: 'base04',
        pic: '3',
        type: '3',
        title: '休息模式',
        flag: 0
      },
      {
        id: 'base05',
        pic: '4',
        type: '4',
        title: '起夜模式',
        flag: 0
      }
    ];
    state.sceneList = [...baseList, ...sceneModeList];
  },
  setSceneFlag (state, scene) {
    state.sceneList.forEach((o, i) => {
      if (o.id == scene.id) {
        if (o.flag == 1) {
          o.flag = 0;
        } else {
          o.flag = 1;
        }
      }
    });
  },
  closeOtherSceneFlag (state, scene) {
    state.sceneList.forEach((o, i) => {
      if (o.id != scene.id) {
        o.flag = 0;
      }
    });
  }
};

export default {
  state,
  getters,
  actions,
  mutations
};
