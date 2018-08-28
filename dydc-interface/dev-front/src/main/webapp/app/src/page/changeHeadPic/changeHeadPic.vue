<template>
  <div class="fullPage">
    <top-bar title="头像" rightIcon="menu" @topbarRightEvent="changeHeadPic"></top-bar>
    <div class="content-wrapper">
      <div class="headPicBox">
        <img src="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=282609871,2046421540&fm=58&bpow=2048&bpoh=2745">
      </div>
    </div>
    <transition name="fade">
      <pop-bar :show='popShow' :eventList="popEventList" @popEvent="popEvent"></pop-bar>
    </transition>
  </div>
</template>

<script>
import topBar from '@/components/topBar/topBar';
import popBar from '@/components/popBar/popBar';

export default {
  components: {
    topBar,
    popBar
  },
  data () {
    return {
      popShow: false,
      popEventList: [
        {
          name: '拍照', // 按钮名
          eventName: 'camera'// 触发的事件
        },
        {
          name: '从手机相册选择', // 按钮名
          eventName: 'loadPhone'// 触发的事件
        },
        {
          name: '保存图片', // 按钮名
          eventName: 'savePic'// 触发的事件
        }
      ]
    };
  },
  methods: {
    changeHeadPic () {
      this.popShow = true;
    },
    popEvent (obj) {
      if (obj.eventName) {
        this[obj.eventName]();
      }
      this.popShow = false;
    },
    camera () {
    }
  }
};
</script>

<style lang="stylus" scoped>
@import "../../common/mixin.styl";

.content-wrapper
  display flex
  flex-direction column
  justify-content center
  .headPicBox
    max-height 10rem
    img
      width 100%
      max-height 10rem
</style>
