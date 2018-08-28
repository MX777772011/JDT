<template>
  <div class="fullPage">
    <top-bar title="常见问题"></top-bar>
    <div class="content-wrapper">
      <ul class="qes-list">
        <li>
          <a href="javascript:void(0)" @click="toQesContent">
            <div class="line-total">如何报修？</div>
            <div class="more"></div>
          </a>
        </li>
        <li>
          <a href="javascript:void(0)">
            <div class="line-total">烧烤区如何预约？</div>
            <div class="more"></div>
          </a>
        </li>
        <li>
          <a href="javascript:void(0)">
            <div class="line-total">情景模式能自定义设置吗？</div>
            <div class="more"></div>
          </a>
        </li>
        <li>
          <a href="javascript:void(0)">
            <div class="line-total">如何报修？</div>
            <div class="more"></div>
          </a>
        </li>
      </ul>
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
    toQesContent () {
      this.$router.push('/normalQesContent');
    }
  }
};
</script>

<style lang="stylus" scoped>
@import "../../common/mixin.styl";

.content-wrapper
  .qes-list
    >li>a
      display flex
      height .8rem
      background rgb(35,39,66)
      padding 0rem .2rem 0rem .2rem
      border-bottom 1px solid #171e3b
      .line-total
        position relative
        flex 1
        padding-top .2rem
        font-size .30rem
        line-height .4rem
        color #c4aa86
        .msg
          position absolute
          top .1rem
          left 1.12rem
          width .3rem
          height .3rem
          line-height .3rem
          overflow hidden
          text-align center
          color #fff
          background #e4393c
          border-radius 50%
          font-size .24rem
          box-shadow: 0px 0px 17px 0px #171e3b
      .more
        height .8rem
        flex 0 0 .14rem
        width .14rem
        bg-image('more')
        background-position center center
        background-size .14rem .26rem
        background-repeat no-repeat
</style>
