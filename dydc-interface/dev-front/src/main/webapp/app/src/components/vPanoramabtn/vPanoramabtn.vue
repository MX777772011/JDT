<template>
  <div class="panoramaBtnGroup">
    <span class="panoramaBtn" v-for="(item,index) in roomtype" :key="index" :class="'c_1_'+item.roomindex" v-if="item.roomindex!==''" @click="toRoom(item.roomid)">{{roomTypeText(item.roomtype)}}</span>
  </div>
</template>

<script>
export default {
  props: {
    roomtype: {
      type: Array
    }
  },
  created () {
    console.log(this.roomtype);
  },
  methods: {
    roomTypeText (roomtype) {
      let roomText = '';
      switch (roomtype) {
        case 'bedroom':
          roomText = '卧室';
          break;
        case 'cloakroom':
          roomText = '衣帽间';
          break;
        case 'toilet':
          roomText = '卫生间';
          break;
        case 'porch':
          roomText = '玄关';
          break;
        case 'parlour':
          roomText = '客厅';
          break;
        case 'corridor':
          roomText = '走廊';
          break;
        case 'study':
          roomText = '书房';
          break;
        case 'diningroom':
          roomText = '餐厅';
          break;
        default:
          break;
      }
      return roomText;
    },
    toRoom (roomid) {
      this.$emit('toRoom', roomid);
      // this.$route.push({path:'/xxx',params:{id:1}})
    }
  }
};
</script>

<style lang="stylus" scoped>
.panoramaBtnGroup
  position absolute
  z-index 10
  width 100%
  height 100%
  .panoramaBtn
    border 1px solid rgb(211, 182, 143)
    color rgb(211, 182, 143)
    padding 0px 0.1rem
    height 0.4rem
    text-align: center
    line-height 0.34rem
    border-radius 0.3rem
    position absolute
    &.c_0
      top 44%
      left 46%
    &.c_1
      top 74%
      left 55%
    &.c_2
      top 80%
      left 84%
    &.c_3
      top 62%
      left 84%
    &.c_4
      top 48%
      left 84%
    &.c_5
      top 8%
      left 68%
    &.c_6
      top 2%
      left 84%
    &.c_7
      top 28%
      left 64%
    &.c_8
      top 84%
      left 28%
    &.c_9
      top 60%
      left 35%
    &.c_10
      top 66%
      left 20%
    &.c_11
      top 24%
      left 86%
    &.c_12
      top 24%
      left 48%
    &.c_13
      top 45%
      left 72%
    &.c_1_0
      top 44%
      left 42%
    &.c_1_1
      top 74%
      left 34%
    &.c_1_2
      top 80%
      left 8%
    &.c_1_3
      top 62%
      left 2%
    &.c_1_4
      top 48%
      left 2%
    &.c_1_5
      top 8%
      left 22%
    &.c_1_6
      top 2%
      left 3%
    &.c_1_7
      top 28%
      left 22%
    &.c_1_8
      top 84%
      left 62%
    &.c_1_9
      top 60%
      left 54%
    &.c_1_10
      top 66%
      left 62%
    &.c_1_11
      top 24%
      left 4%
    &.c_1_12
      top 24%
      left 42%
    &.c_1_13
      top 40%
      left 16%
</style>
