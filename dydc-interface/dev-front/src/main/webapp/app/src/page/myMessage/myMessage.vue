<template>
  <div class="fullPage">
    <top-bar title="消息中心"></top-bar>
    <div class="content-wrapper">
      <div class="message-box" @click="toMessage">
        <div class="message-icon message"></div>
        <div class="message-content">
          <div class="title-line">
            <h3 class="title">系统消息</h3>
            <div class="time">2018-05-10 10:00:00</div>
          </div>
          <div class="text">系统升级了、许多新功能，欢迎广大群众更新使用</div>
        </div>
      </div>
      <div class="message-box">
        <div class="message-icon pay"></div>
        <div class="message-content">
          <div class="title-line">
            <h3 class="title">缴费通知</h3>
            <div class="time">2018-05-10 10:00:00</div>
          </div>
          <div class="text">系统升级了、许多新功能，欢迎广大群众更新使用</div>
        </div>
      </div>
      <div class="message-box">
        <div class="message-icon expire"></div>
        <div class="message-content">
          <div class="title-line">
            <h3 class="title">到期通知</h3>
            <div class="time">2018-05-10 10:00:00</div>
          </div>
          <div class="text">系统升级了、许多新功能，欢迎广大群众更新使用</div>
        </div>
      </div>
      <div class="message-box">
        <div class="message-icon expire"></div>
        <div class="message-content">
          <div class="title-line">
            <h3 class="title">到期通知</h3>
            <div class="time">2018-05-10 10:00:00</div>
          </div>
          <div class="text">系统升级了、许多新功能，欢迎广大群众更新使用</div>
        </div>
      </div>
      <div class="message-box">
        <div class="message-icon expire"></div>
        <div class="message-content">
          <div class="title-line">
            <h3 class="title">到期通知</h3>
            <div class="time">2018-05-10 10:00:00</div>
          </div>
          <div class="text">系统升级了、许多新功能，欢迎广大群众更新使用</div>
        </div>
      </div>
      <div class="message-box">
        <div class="message-icon expire"></div>
        <div class="message-content">
          <div class="title-line">
            <h3 class="title">到期通知</h3>
            <div class="time">2018-05-10 10:00:00</div>
          </div>
          <div class="text">系统升级了、许多新功能，欢迎广大群众更新使用</div>
        </div>
      </div>
      <div class="message-box">
        <div class="message-icon expire"></div>
        <div class="message-content">
          <div class="title-line">
            <h3 class="title">到期通知</h3>
            <div class="time">2018-05-10 10:00:00</div>
          </div>
          <div class="text">系统升级了、许多新功能，欢迎广大群众更新使用</div>
        </div>
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
    toMessage () {
      this.$router.push('/messageContent');
    }
  }
};
</script>

<style lang="stylus" scoped>
@import "../../common/mixin.styl";

.content-wrapper
  .message-box
    display flex
    margin-bottom .2rem
    padding .4rem .2rem
    background rgb(35,39,66)
    .message-icon
      flex  0 0 1rem
      width 1rem
      height 1rem
      border-radius 50%
      overflow hidden
      background-color rgba(255,255,255,.1)
      background-position center center
      background-repeat no-repeat
      &.pay
        bg-image("pay")
        background-size 1rem 1rem
      &.message
        bg-image("message")
        background-size 1rem 1rem
      &.expire
        bg-image("expire")
        background-size 1rem 1rem
    .message-content
      flex 1
      width 0
      padding .1rem 0rem .1rem .2rem
      .title-line
        display flex
        justify-content space-between
        align-items center
        margin-bottom .1rem
        h3.title
          color #c4aa86
          font-size .32rem
          line-height .4rem
        .time
          font-size .26rem
          color rgba(196,170,134,.6)
      .text
        width 100%
        overflow hidden
        text-overflow ellipsis
        white-space nowrap
        color rgba(255,255,255,.6)
        font-size .28rem
        line-height .3rem
</style>
