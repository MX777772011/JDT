<template>
  <div class="fullPage">
    <topBar title="情景模式" rightText="新增情景" @topbarRightEvent="toNewMode"></topBar>
    <div class="content-wrapper">
      <div class="remarks">情景模式"单击"可开关,"长按"可编辑</div>
      <div class="scene-box" >
        <scene-mode v-for="(item,index) in sceneList" :key="index" :scene.sync="item" :index="index"  @tapEvent="tapEvent"></scene-mode>
      </div>
    </div>
    <transition name="fade">
      <pop-bar :fullCancel='false' :show='popShow' :eventList="popEventList" :itemId="sceneId" @popEvent="popEvent"></pop-bar>
    </transition>
  </div>
</template>

<script>
import topBar from '@/components/topBar/topBar';
import popBar from '@/components/popBar/popBar';
import sceneMode from '@/components/sceneMode/sceneMode';
import { mapGetters } from 'vuex';

export default {
  components: {
    topBar,
    popBar,
    sceneMode
  },
  data () {
    return {
      popShow: false,
      popEventList: [
        {
          name: '编辑', // 按钮名
          eventName: 'edit', // 触发的事件
          path: '/newModel'
        },
        {
          name: '删除', // 按钮名
          eventName: 'del', // 触发的事件
          path: '/situationalMode'
        }
      ],
      eventIndex: '', // 当前触发事件的序号
      sceneId: -1// 模式id
    };
  },
  computed: {
    ...mapGetters({
      sceneList: 'getSceneList'
    })
  },
  mounted () {
    console.log(this.sceneList);
    this.$store.dispatch('initSceneMode');
  },
  methods: {
    toNewMode () {
      this.$router.push('/newModel');
    },
    tapEvent (obj) {
      console.log(obj);
      if (obj.isLongTap) {
        this.eventIndex = obj.index;
        this.popShow = true;
        this.sceneId = obj.obj.id;
      } else {
        this.$store.dispatch('setSelectSceneMode', obj.obj);
      }
    },
    popEvent (obj) {
      if (obj.eventName) {
        this[obj.eventName](obj);
      }
      this.popShow = false;
    },
    edit (obj) {
      console.log(obj.id);
      this.$router.push({
        name: 'newModel',
        params: {
          id: obj.id
        }
      });
    },
    del (obj) {
      this.$api.post('/dydcMode/delete.do', {id: obj.id}, r => {
        if (r.success) {
          this.$store.dispatch('initSceneMode');
        }
      }, r => {
        console.log(r.msg);
      });
    }
  }
};
</script>

<style lang="stylus" scoped>
.content-wrapper
  padding-top .2rem
  .scene-box
    display flex
    flex-wrap wrap
    width 100%
    padding 0.08rem
    font-size 0
    .scene-mode
      width 50%
  .remarks
    padding 0 .16rem
    font-size .2rem
    color rgba(255,255,255,.5)
</style>
