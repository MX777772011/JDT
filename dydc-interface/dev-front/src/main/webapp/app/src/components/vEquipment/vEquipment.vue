<template>
  <div :class="[status>0?'on':'',size]">
    <i class="icon" :class="devicetype"></i>
    <span class="text">{{name}}</span>
  </div>
</template>

<script>
export default {
  props: {
    size: {
      type: String
    },
    name: {
      type: String
    },
    devicetype: {
      type: String
    },
    status: {
      type: [String, Number, Boolean]
    }
  }
};
</script>

<style lang="stylus" scoped>
@import '../../common/mixin.styl';

.icon
  display inline-block
  vertical-align top
  width .66rem
  height .66rem
  background-position center center
  background-repeat no-repeat
  background-size .66rem .66rem
  &.deskLamp
    bg-image('deskLamp')
  &.windowCurtains
    bg-image('windowCurtains')
  &.lamp
    bg-image('lamp')
  &.pendant
    bg-image('pendant')
  &.tubeLamp
    bg-image('tubeLamp')
  &.air
    bg-image('air')
  &.dimmer
    bg-image('dimmer')
  &.pendant
    bg-image('wallLamp')
  &.wallLamp
    bg-image('wallLamp')
  &.ventilator
    bg-image('ventilator')
  &.more
    bg-image('more')
.text
  display inline-block
  margin-top 0.1rem
  width 100%
  height 0.3rem
  line-height 0.3rem
  text-align center
  color rgba(211,182,143,0.5)
.on
  .icon
    &.deskLamp
      bg-image('deskLamp_on')
    &.windowCurtains
      bg-image('windowCurtains_on')
    &.lamp
      bg-image('lamp_on')
    &.pendant
      bg-image('pendant_on')
    &.tubeLamp
      bg-image('tubeLamp_on')
    &.air
      bg-image('air_on')
    &.dimmer
      bg-image('dimmer_on')
    &.pendant
      bg-image('wallLamp_on')
    &.wallLamp
      bg-image('wallLamp_on')
    &.ventilator
      bg-image('ventilator_on')
  .text
    color: rgba(211,182,143,1)

.big
  .icon
    display inline-block
    vertical-align top
    width 1.2rem
    height 1.2rem
    background-position center center
    background-repeat no-repeat
    background-size 1.2rem 1.2rem
  .text
    display: inline-block
    margin-top: 0.1rem
    width: 100%
    height: 0.3rem
    line-height: 0.3rem
    font-size .24rem
    text-align: center
    color rgba(255,255,255,.2)
    letter-spacing .02rem
</style>
