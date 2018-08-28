<template>
  <div>
    <div class="top">
      <div class="top-bt"></div>
      <div class="back" @click="back"></div>
    </div>
    <div class="content-wrapper">
      <div class="description">大苑，海淀名著位于大苑，海淀名著位于大苑，海淀名著位于大苑，海淀名著位于大苑，海淀名著位于大苑，海淀名著位于大苑，海淀名著位于大苑，海淀名著位于大苑，海淀名著位于大苑，海淀名著位于大苑，海淀名著位于大苑，海淀名著位于大苑， </div>
      <ul class="contact-way">
        <li>
          <div class="phone1"></div>
        </li>
        <li>
          <div class="phone2"></div>
        </li>
        <li>
          <div class="email"></div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    back () {
      this.$router.go(-1);
    }
  }
};
</script>

<style lang="stylus" scoped>
@import "../../common/mixin.styl"

.top
  position relative
  height 5.1rem
  bg-image("top_bg")
  background-position center -.2rem
  background-repeat no-repeat
  background-size 100% auto
  .top-bt
    position absolute
    z-index 0
    width 100%
    height 5.1rem
    bg-image("top_bt")
    background-position center center
    background-repeat no-repeat
    background-size 2.9rem auto
  .back
    position relative
    padding-top .26rem
    padding-bottom .26rem
    width .6rem
    height 1rem
    bg-image("back")
    background-position center center
    background-repeat no-repeat
    background-size .2rem auto

.content-wrapper
  .description
    padding .3rem
    font-size .28rem
    line-height .4rem
    color rgba(255,255,255,.5)
  .contact-way
    padding-top .7rem
    >li
      margin-bottom .6rem
      >div
        height .64rem
        background-repeat no-repeat
        background-position center center
        background-size auto 100%
        &.phone1
          bg-image('phone1')
        &.phone2
          bg-image('phone2')
        &.email
          bg-image('email')
</style>
