<template>
  <div>
    <span class="luminanceRegulation" v-if="luminanceList.length>0"  @click="luminanceRegulation"><i></i>亮度调节</span>
    <transition name="fade">
      <div class="luminanceRegulationDiv" v-if="showLuminance">
        <div class="luminanceRegulationContent">
          <div class="LRBar">
            <div v-for="(item,index) in luminanceList" :key="index">
              <v-luminance :deviceItem="item"></v-luminance>
              <div class="title">{{item.title}}</div>
            </div>
          </div>
          <span class="remarks">您可以左右滑动<br/>调整适宜的宽度</span>
          <div class="optionBtn">
            <span>取消</span>
            <span class="sub" @click="luminanceRegulationSub">完成</span>
          </div>
        </div>
      </div>
    </transition>
  </div>
</template>

<script>
import vLuminance from '@/components/vLuminance/vLuminance';

export default {
  components: {
    vLuminance
  },
  props: {
    roomid: {
      type: [String, Number]
    }
  },
  data () {
    return {
      luminanceRegulationBtn: false,
      showLuminance: false,
      luminanceList: []
    };
  },
  created () {
    if (this.roomid) {
      this.$store.commit('setCheckRoomId', this.roomid);
      this.getRoomLuminance();
    }
  },
  watch: {
    roomid (val) {
      if (val) {
        this.$store.commit('setCheckRoomId', val);
        this.getRoomLuminance();
      } else {
        this.luminanceList = [];
      }
    },
    showLuminance (val) {
      if (val) {
        this.getRoomLuminance();
      }
    }
  },
  methods: {
    getRoomLuminance () {
      this.luminanceList = this.$store.getters.getRoomAdjustable;
    },
    luminanceRegulation () {
      this.showLuminance = true;
    },
    luminanceRegulationSub () {
      this.showLuminance = false;
    }
  }
};
</script>

<style lang="stylus" scoped>
@import "../../common/mixin.styl";

.fade-enter-active, .fade-leave-active
  transition opacity .1s
.fade-enter, .fade-leave-to
  opacity 0

.luminanceRegulation
  position: fixed
  left 0.5rem
  bottom 0.4rem
  font-size 0.32rem
  vertical-align middle
  i
    display inline-block
    width 0.4rem
    height 0.4rem
    bg-image("../../common/images/luminanceRegulation/brightness")
    // background-image url('/static/images/luminanceRegulation/1_family_mydevice4_brightness@3x.png')
    background-repeat no-repeat
    background-size 100% 100%

.luminanceRegulationDiv
  width: 100%
  height: 8rem
  padding: 0.2rem
  position: fixed
  bottom: 0
  .luminanceRegulationContent
    width: 100%
    height: 100%
    border-radius: 5px
    padding: 0.2rem
    background-color: rgba(158,158,158,0.7)
    display: flex
    position relative
    flex-direction: column
    align-items: center
    justify-content: center
    .LRBar
      width: 100%
      height: 4rem
      overflow: hidden
      position: relative
      .title
        text-align center
        font-size 0.22rem
        color #ffffff
        margin 0.1rem auto 0.3rem
    .remarks
      color #ffffff
      font-size 0.25rem
      line-height 0.3rem
      letter-spacing 0.02rem
    .optionBtn
      width 100%
      position absolute
      bottom: 0.3rem
      display flex
      justify-content: space-between
      span
        padding 0.2rem 0.6rem
        font-size 0.4rem
        color #ffffff
        opacity 0.5
        &.sub
          color #d3b68f
</style>
