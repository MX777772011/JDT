<template>
  <div class="module-wrapper">
    <!-- <div v-for="(item,index) in list" :key="index" class="flexDiv">
      <img class="icon" :src="item.src">
      <img class="checkBtn" :src="item.checked?'/static/images/modeIcon/family_new_checked.png':'/static/images/modeIcon/family_new_Unchecked.png'">
    </div> -->
    <div class="module-content">
      <input type="hidden" v-bind:value="value">
      <div class="module-item" v-for="(item,index) in list" :key="index" @click="checkThis(index)" :class="value==index?'on':''">
        <div class="module-image">
          <img :src="item.src">
        </div>
        <i class="module-check"></i>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    list: {
      type: Array
    },
    value: {
      type: [String, Number]
    }
  },
  methods: {
    checkThis (val) {
      this.$emit('input', val);
    }
  }
};
</script>

<style lang="stylus" scoped>
@import "../../common/mixin.styl";

.module-wrapper
  width: 100%
  height: 1.4rem
  overflow-x: auto
  overflow-y: hidden
  .module-content
    display flex
    min-width 100%
    .module-item
      position: relative
      flex 0 0 1.5rem
      height 1.5rem
      padding .15rem
      &.on
        .module-check
          bg-image('checked')
      .module-image
        width 100%
        height 100%
        // background rgba(255,255,255,.2)
        img
          width 100%
          height 100%
      .module-check
        position:absolute
        top .15rem
        right .15rem
        width 0.3rem
        height .3rem
        background-repeat no-repeat
        background-position center center
        background-size .3rem
        bg-image('unchecked')
</style>
