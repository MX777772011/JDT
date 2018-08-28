<template>
  <div class="fullPage">
    <top-bar  title="智能服务" :isBack="false"></top-bar>
    <div class="content-wrapper">
      <div class="means-area">
        <div class="title">生活缴费</div>
        <div class="means">
          <div class="means-item">
            <i class="icon waterrate"></i>
            <div class="means-name">水费</div>
          </div>
          <div class="means-item">
            <i class="icon energycharge"></i>
            <div class="means-name">电费</div>
          </div>
          <div class="means-item">
            <i class="icon gascharge"></i>
            <div class="means-name">燃气费</div>
          </div>
          <div class="means-item">
            <i class="icon telephonecharge"></i>
            <div class="means-name">手机话费</div>
          </div>
        </div>
      </div>
      <div class="means-area">
        <div class="title">看病就医</div>
        <div class="means">
          <div class="means-item">
            <i class="icon registration"></i>
            <div class="means-name">挂号</div>
          </div>
          <div class="means-item">
            <i class="icon healthinfo"></i>
            <div class="means-name">体检信息</div>
          </div>
        </div>
      </div>
      <div class="means-area">
        <div class="title">出行服务</div>
        <div class="means">
          <div class="means-item">
            <i class="icon registration"></i>
            <div class="means-name">火车票</div>
          </div>
        </div>
      </div>
    </div>
    <footBar :index="footBarIndex"></footBar>
  </div>
</template>

<script>
import topBar from '@/components/topBar/topBar';
import footBar from '@/components/footBar/footBar';

export default {
  data () {
    return {
      footBarIndex: 'intelligentService'
    };
  },
  components: {
    topBar,
    footBar
  }
};
</script>

<style lang="stylus" scoped>
@import "../../common/mixin.styl";

.content-wrapper
  .means-area
    padding .2rem 0
    .title
      padding 0 .2rem
      font-size .28rem
      margin-bottom .2rem
      color rgba(255,255,255,.5)
    .means
      display flex
      background rgb(35,39,66)
      .means-item
        flex 1
        max-width 25%
        padding .3rem 0
        text-align center
        .means-name
          font-size .24rem
          line-height .4rem
          margin-top .2rem
          color #c4aa86
        >.icon
          display inline-block
          width .75rem
          height .75rem
          background-repeat no-repeat
          background-position center center
          background-size 100% 100%
          &.telephonecharge
            bg-image("telephonecharge")
          &.energycharge
            bg-image("energycharge")
          &.gascharge
            bg-image("gascharge")
          &.waterrate
            bg-image("waterrate")
          &.registration
            bg-image("registration")
          &.healthinfo
            bg-image("healthinfo")
</style>
