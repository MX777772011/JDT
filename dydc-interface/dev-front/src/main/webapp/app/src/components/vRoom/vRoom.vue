<template>
  <div :class="status==true?'on':''">
    <i class="icon" :class="roomtype"></i>
    <span class="text">{{name}}</span>
  </div>
</template>

<script>
export default {
  props: {
    name: {
      type: String
    },
    roomtype: {
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
  display: inline-block
  width: 1.3rem
  height: 0.7rem
  margin-bottom: 0.1rem
  background-repeat: no-repeat
  background-size: 0.66rem 0.66rem
  background-position: center center
  &.all
    bg-image('room_all')
  &.bedroom
    bg-image('room_bedroom')
  &.diningroom
    bg-image('room_diningroom')
  &.cloakroom
    bg-image('room_lobby')
  &.porch
    bg-image('room_lobby')
  &.parlour
    bg-image('room_lobby')
  &.corridor
    bg-image('room_lobby')
  &.study
    bg-image('room_study')
  &.toilet
    bg-image('room_toilet')
.text
  display: inline-block
  width: 1.3rem
  height: 0.3rem
  line-height: 0.3rem
  text-align: center
  font-size: 0.22rem
  color: rgba(211,182,143,0.5)
.on
  .icon
      &.all
        bg-image('room_all_on')
      &.bedroom
        bg-image('room_bedroom_on')
      &.diningroom
        bg-image('room_diningroom_on')
      &.cloakroom
        bg-image('room_lobby_on')
      &.porch
        bg-image('room_lobby_on')
      &.parlour
        bg-image('room_lobby_on')
      &.corridor
        bg-image('room_lobby_on')
      &.study
        bg-image('room_study_on')
      &.toilet
        bg-image('room_toilet_on')
  .text
    color: rgba(211,182,143,1)
</style>
