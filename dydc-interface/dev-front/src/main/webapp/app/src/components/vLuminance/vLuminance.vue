<template>
  <!-- <span>1</span> -->
  <div class="LRBarDiv">
    <i class="left" @click="reduce"></i>
    <div class="bar">
      <div v-for="(item, index) in 20" :key="index" class="levelBar" :class="schedule>=index+1?'active':''"></div>
      <div class="eventLayer" v-on:touchstart="start($event)" v-on:touchmove="move($event)" v-on:touchend="end($event)">
        <img ref="imgTwo" src="/static/images/luminanceRegulation/1_family_mydevice4_brightness_dot@3x.png">
      </div>
    </div>
    <i class="right" @click="improve"></i>
  </div>
</template>

<script>

export default {
  props: {
    deviceItem: {
      type: [Object]
    }
  },
  data () {
    return {
      creatTime: 0,
      qi: 0, // 起始标识
      startX: 0, // 开始触摸的位置
      moveX: 0, // 滑动时的位置
      endX: 0, // 结束触摸的位置
      disX: 0, // 移动距离
      elX: 0, // 元素宽度
      schedule: 15, // 用于进度条显示
      deviceVal: 15 // 用于实际灯光数据 但是与进度条数量同步
    };
  },
  created () {
    this.deviceVal = this.deviceItem.isopen == 1 ? 20 : parseInt(this.deviceItem.isopen / 255 * 20);
    this.schedule = this.deviceVal;
  },
  watch: {
    deviceVal (newVal, oldVal) {
      // 当亮度发生变化时
      if (this.creatTime < 1) {
        this.creatTime++;
      } else {
        this.emitLuminance();
      }
    }
  },
  methods: {
    start (event) {
      if (event.touches.length === 1) {
        this.startX = event.touches[0].clientX; // 记录开始位置
        this.elx = event.target.offsetWidth;
        this.qi = this.schedule;
      }
    },
    move (event) {
      if (event.touches.length === 1) {
        this.moveX = event.touches[0].clientX;
        this.disX = this.moveX - this.startX;
        // console.log(this.disX, '移动距离');
        // console.log(event.target.offsetWidth, '网页宽度');
        let p = (this.disX / event.target.offsetWidth * 20).toFixed(0);
        // console.log(p + '----' + this.schedule);
        let xx = parseInt(this.qi) + parseInt(p);
        if (xx >= 0 && xx <= 20) {
          this.schedule = xx;
          // event.target.getElementsByTagName('img')[0].style.left = (xx * 5) + '%';
        }
      }
    },
    end (event) {
      if (event.changedTouches.length === 1) {
        let endX = event.changedTouches[0].clientX;
        this.disX = endX - this.startX;
      }
      this.deviceVal = this.schedule;
    },
    reduce () {
      if (this.deviceVal > 0 && this.deviceVal == this.schedule) {
        this.deviceVal--;
        this.schedule = this.deviceVal;
      }
    },
    improve () {
      if (this.deviceVal < 20 && this.deviceVal == this.schedule) {
        this.deviceVal++;
        this.schedule = this.deviceVal;
      }
    },
    emitLuminance () {
      // 提交亮度
      let val = 0;
      if (this.schedule === 20) {
        val = 255;
      } else {
        val = parseInt(this.schedule / 20 * 255);
      }
      let olditem = {...this.deviceItem};
      let newitem = {...this.deviceItem};
      newitem.isopen = val;
      const deviceChangeObj = {
        oldDeviceItem: olditem,
        newDeviceItem: newitem
      };
      this.$store.dispatch('updateDeviceVal', deviceChangeObj);
    }
  }
};
</script>

<style lang="stylus" scoped>
.LRBarDiv
  width: 100%
  height: 1rem
  margin-top: 0.2rem
  display: flex
  i
    display: inline-block
    flex: 0 0 1rem
    height: 1rem
    background-repeat: no-repeat
    background-size: 50% 50%
    background-position: center
    background-color: rgba(78,78,78,0.7)
    &.left
      background-image: url('/static/images/luminanceRegulation/1_family_mydevice4_brightnessMax@3x.png')
      border-top-left-radius: 50%
      border-bottom-left-radius: 50%
    &.right
      background-image: url('/static/images/luminanceRegulation/1_family_mydevice4_brightnessMin@3x.png')
      border-top-right-radius: 50%
      border-bottom-right-radius: 50%
  .bar
    flex: 1
    background-color: rgba(78,78,78,0.7)
    display: flex
    justify-content: space-between
    align-items: center
    position: relative
    div
      &.levelBar
        width: 0
        height: 0.5rem
        border-left: 4px solid #ffffff
      &.active
        border-left: 4px solid #87D1FE
      &.eventLayer
        width: 100%
        height: 100%
        position absolute
        top 0
        left 0
        img
          width: 40%
          position: absolute
          left: 0
          top: -0.2rem
          transform: translateX(-95%)
</style>
