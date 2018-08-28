<template>
  <label class="maple-checkbox">
    <input type="checkbox" class="ios-switch red bigswitch" :checked="isOpen==0?false:true" @click="checkEvent"/>
    <div><div></div></div>
  </label>
</template>

<script>
export default {
  props: {
    isOpen: {
      type: Number
    }
  },
  methods: {
    checkEvent () {
      this.$emit('equipmentEvent');
    }
  }
};
</script>

<style lang="stylus" scoped>
.maple-checkbox
  position relative
  display inline-block
/*表单开关样式*/
.maple-checkbox input[type="checkbox"]
  position absolute
  opacity 0
  z-index -1
/* Normal Track */
input[type="checkbox"].ios-switch + div
  vertical-align middle
  width .4rem
  height .2rem
  border 1px solid rgba(0,0,0,.4)
  border-radius 999rem
  background-color rgba(0, 0, 0, 0.1)
  -webkit-transition-duration .4s
  -webkit-transition-property background-color, box-shadow
  box-shadow inset 0 0 0 0px rgba(0,0,0,0.4)
/* Normal Knob */
input[type="checkbox"].ios-switch + div > div
  float left
  width .18rem
  height .18rem
  border-radius inherit
  background #ffffff
  -webkit-transition-timing-function cubic-bezier(.54,1.85,.5,1)
  -webkit-transition-duration 0.4s
  -webkit-transition-property transform, background-color, box-shadow
  -moz-transition-timing-function cubic-bezier(.54,1.85,.5,1)
  -moz-transition-duration 0.4s
  -moz-transition-property transform, background-color
  box-shadow 0 .01rem .05rem rgba(0, 0, 0, 0.3), 0 0 0 .01rem rgba(0, 0, 0, 0.4)
  pointer-events none
  // margin-top .01rem
  // margin-left .02rem
/* Big Track */
input[type="checkbox"].bigswitch.ios-switch + div
  width .83rem   /*开关宽度*/
  height .50rem  /*开关高度*/
/* Big Knob */
input[type="checkbox"].bigswitch.ios-switch + div > div
  width .45rem    /*按钮宽度*/
  height .45rem   /*按钮高度*/
  margin-top .01rem
/* Checked Big Knob (Blue Style) */
input[type="checkbox"].bigswitch.ios-switch:checked + div > div
  -webkit-transform translate3d(.34rem, 0, 0) /*控制按钮的左右*/
  -moz-transform translate3d(.34rem, 0, 0)
  box-shadow 0 .04rem .08rem rgba(0, 0, 0, 0.3), 0 0 0 .01rem #dec5a3;
/*改变颜色的*/
input[type="checkbox"].red.ios-switch:checked + div
  background-color #dec5a3
  border .01rem solid #dec5a3
  box-shadow inset 0 0 0 .1rem #dec5a3
input[type="checkbox"].red.ios-switch:checked + div > div
  box-shadow 0 .02rem .05rem rgba(0, 0, 0, 0.3), 0 0 0 .01rem #dec5a3
</style>
