<template>
  <div class="fullPage">
    <top-bar  title="个人信息"></top-bar>
    <div class="content-wrapper">
      <div class="line-wrapper big-line" @click="toChangeHeadPic">
        <div class="title">头像</div>
        <div class="content">
          <img class="head-img" src="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=282609871,2046421540&fm=58&bpow=2048&bpoh=2745" alt="">
        </div>
        <div class="more"></div>
      </div>
      <div class="line-wrapper">
        <div class="title">姓名</div>
        <div class="content">老胡</div>
      </div>
      <div class="line-wrapper">
        <div class="title">住址</div>
        <div class="content">6号楼-4单元-501</div>
      </div>
    </div>
  </div>
</template>

<script>
import topBar from '@/components/topBar/topBar';

export default {
  components: {
    topBar
  },
  methods: {
    toChangeHeadPic () {
      this.$router.push('/changeHeadPic');
    }
  }
};
</script>

<style lang="stylus" scoped>
@import "../../common/mixin.styl";
.content-wrapper
  padding-top .2rem
  .line-wrapper
    display flex
    align-items center
    background rgb(35,39,66)
    padding .2rem .2rem .2rem .2rem
    border-bottom 1px solid #171e3b
    &.big-line
      padding .40rem .2rem .40rem .2rem
      margin-bottom .2rem
    .title
      flex 0 0 .8rem
      color #fff
      font-size .3rem
      line-height .4rem
    .content
      flex 1
      font-size .3rem
      line-height .4rem
      color rgba(255,255,255,.5)
      text-align right
      .head-img
        width 1.4rem
        height 1.5rem
    .more
      flex 0 0 .34rem
      width .34rem
      height .26rem
      bg-image('more')
      background-position right center
      background-size .14rem .26rem
      background-repeat no-repeat
</style>
