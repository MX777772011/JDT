<template>
  <div class="fullPage">
    <top-bar  title="个人中心" :isBack="false"></top-bar>
    <div class="content-wrapper">
      <div class="head-info" @click="toPresonalinfo">
        <div class="head-box">
          <img class="head-img" src="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=282609871,2046421540&fm=58&bpow=2048&bpoh=2745" alt="">
        </div>
        <div class="head-content">
          <div class="name">老胡</div>
          <div class="place">6号楼-4单元-501</div>
        </div>
        <div class="more"></div>
      </div>
      <div class="menu-wrapper">
        <div class="line" @click="toVisitor">
          <div class="line-icon">
            <i class="icon icon-visiter"></i>
          </div>
          <div class="line-total"><span>我的访客</span></div>
          <div class="more"></div>
        </div>
        <div class="line" @click="toMyMessage">
          <div class="line-icon">
            <i class="icon icon-feedback"></i>
          </div>
          <div class="line-total">
            <span>我的消息</span>
            <div class="msg">1</div>
          </div>
          <div class="more"></div>
        </div>
        <div class="line" @click="toNormalQes">
          <div class="line-icon">
            <i class="icon icon-question"></i>
          </div>
          <div class="line-total">常见问题</div>
          <div class="more"></div>
        </div>
        <div class="line" @click="toFeedback">
          <div class="line-icon">
            <i class="icon icon-record"></i>
          </div>
          <div class="line-total">意见反馈</div>
          <div class="more"></div>
        </div>
      </div>
      <div class="menu-wrapper mt120">
        <div class="line" @click="toAboutUs">
          <div class="line-icon">
            <i class="icon icon-setting"></i>
          </div>
          <div class="line-total">设置</div>
          <div class="more"></div>
        </div>
      </div>
    </div>
    <footBar :index="footBarIndex"></footBar>
  </div>
</template>

<script>
import topBar from '@/components/topBar/topBar';
import footBar from '../../components/footBar/footBar';

export default {
  data () {
    return {
      footBarIndex: 'presonalCenter'
    };
  },
  components: {
    topBar,
    footBar
  },
  methods: {
    toPresonalinfo () {
      this.$router.push('/presonalinfo');
    },
    toVisitor () {
      this.$router.push('/myVisitor');
    },
    toMyMessage () {
      this.$router.push('/myMessage');
    },
    toNormalQes () {
      this.$router.push('/normalQes');
    },
    toFeedback () {
      this.$router.push('/feedback');
    },
    toAboutUs () {
      this.$router.push('/aboutUs');
    }
  }
};
</script>

<style lang="stylus" scoped>
@import "../../common/mixin.styl";

.content-wrapper
  padding-top .2rem
  .more
    flex 0 0 .14rem
    width .14rem
    bg-image('more')
    background-position center center
    background-size .14rem .26rem
    background-repeat no-repeat
  .head-info
    display flex
    margin-bottom .15rem
    padding .4rem .2rem .4rem .6rem
    background rgb(35,39,66)
    .head-box
      flex 0 0 1.6rem
      width 1.6rem
      height 1.5rem
      padding-right .2rem
      .head-img
        width 100%
        height 100%
    .head-content
      flex 1
      padding-right .2rem
      .name
        color #c4aa86
        padding .3rem 0
        font-size .32rem
        line-height .32rem
      .place
        font-size .30rem
        color rgba(255,255,255,.5)
    .more
      height 1.5rem
  .menu-wrapper
    &.mt120
      margin-top 1.2rem
    .line
      display flex
      height .8rem
      background rgb(35,39,66)
      padding .2rem .2rem .2rem .6rem
      margin-bottom .02rem
      .line-icon
        flex 0 0 .6rem
        width .6rem
        padding .02rem 0
        text-align left
        .icon
          display inline-block
          vertical-align top
          width .32rem
          height .36rem
          background-size .32rem .32rem
          background-repeat no-repeat
          background-position left  center
          &.icon-visiter
            bg-image('visiter')
          &.icon-feedback
            bg-image('feedback')
          &.icon-question
            bg-image('question')
          &.icon-record
            background-size .32rem .36rem
            bg-image('record')
          &.icon-setting
            bg-image('setting')
      .line-total
        position relative
        flex 1
        font-size .30rem
        line-height .4rem
        color #c4aa86
        .msg
          position absolute
          top -.1rem
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
        height .4rem
</style>
