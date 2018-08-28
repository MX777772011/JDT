<template>
  <div>
    <div v-for="(item,index) in labelBarData" :key="index" class="labelBar" @click="thatClick(item)">
      <div class="line-icon">
        <i class="icon icon-fix" :class="iconFunc(item.func)"></i>
      </div>
      <div class="line-total">{{item.text}}</div>
      <div class="more"></div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    labelBarData: {
      type: Array
    }
  },
  methods: {
    iconFunc (icon) {
      let iconFull = 'icon-';
      switch (icon) {
        case 'repair':
          iconFull += 'fix';
          break;
        case 'bbq':
          iconFull += 'barbecue';
          break;
        case 'service':
          iconFull += 'service';
          break;
        case 'parking':
          iconFull += 'p';
          break;
        default:
          break;
      }
      return iconFull;
    },
    thatClick (obj) {
      console.log(obj);
      this.$emit('emitEve', obj);
    }
  }
};
</script>

<style lang="stylus" scoped>
@import "../../common/mixin.styl"

.labelBar
  position: relative
  display flex
  width: 100%
  height: 0.8rem
  background: #232742
  margin-bottom: 0.02rem
  padding .2rem
  .line-icon
    flex 0 0 .6rem
    width .6rem
    text-align center
    padding .02rem 0
    .icon
      display inline-block
      vertical-align top
      width .32rem
      height .36rem
      background-size .32rem .32rem
      background-repeat no-repeat
      background-position left  center
      &.icon-fix
        bg-image('property_fix')
      &.icon-barbecue
        bg-image('property_barbecue')
      &.icon-p
        bg-image('property_p')
      &.icon-service
        bg-image('property_service')
  .line-total
    flex 1
    font-size: 0.3rem
    line-height: 0.4rem
    color: #c4aa86
    padding-left .2rem
  .more
    flex 0 0 .14rem
    width .14rem
    bg-image('property_more')
    background-position center center
    background-size .14rem .26rem
    background-repeat no-repeat
</style>
