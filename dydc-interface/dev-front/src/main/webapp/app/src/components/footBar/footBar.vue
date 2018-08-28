<template>
  <div class="footBar">
    <div>
      <router-link :to="{path:'/smartHome'}" class="smartHome" :class="index=='smartHome'?'active':''">
        <i class="icon"></i>
        <span>智能家居</span>
      </router-link>
    </div>
    <div>
      <router-link :to="{path:'/intelligentProperty'}" class="intelligentProperty" :class="index=='intelligentProperty'?'active':''">
        <i class="icon"></i>
        <span>智能物业</span>
      </router-link>
    </div>
    <div>
      <router-link :to="{path:'/BI'}" class="BI" :class="index=='BI'?'active':''">
        <i class="icon"></i>
        <span>智能商业</span>
      </router-link>
    </div>
    <div>
      <router-link :to="{path:'/intelligentService'}" class="intelligentService" :class="index=='intelligentService'?'active':''">
        <i class="icon"></i>
        <span>智能服务</span>
      </router-link>
    </div>
    <div>
      <router-link :to="{path:'/presonalCenter'}" class="presonalCenter" :class="index=='presonalCenter'?'active':''">
        <i class="icon"></i>
        <span>个人中心</span>
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    index: {
      type: String
    }
  }
};
</script>

<style lang="stylus" scoped>
@import "../../common/mixin.styl";

.footBar
  position:fixed
  z-index 9
  left:0
  bottom:0
  display flex
  width:100%
  height:1rem
  bg-image("foot_bg")
  background-repeat: no-repeat
  background-size:100% 100%
  box-sizing: border-box
  font-size:0
  div
    flex 1
    text-align: center
    >a
      display block
      &.active
        >span
          color:#c4aa86
          opacity:0.6
        &.smartHome>i
          bg-image('foot_tab_1')
        &.intelligentProperty>i
          bg-image('foot_tab_2')
        &.BI>i
          bg-image('foot_tab_3')
        &.intelligentService>i
          bg-image('foot_tab_4')
        &.presonalCenter>i
          bg-image('foot_tab_5')
      i.icon
        display block
        width .48rem
        height .48rem
        margin .1rem auto .1rem
        background-repeat no-repeat
        background-position center center
        background-size 100% 100%
      span
        font-size .24rem
        color:rgba(255,255,255,.2)
        letter-spacing:2px
    .smartHome>i
      bg-image('foot_tab_1b')
    .intelligentProperty>i
      bg-image('foot_tab_2b')
    .BI>i
      bg-image('foot_tab_3b')
    .intelligentService>i
      bg-image('foot_tab_4b')
    .presonalCenter>i
      bg-image('foot_tab_5b')
    // img
    //   display:block
    //   width:35%
    //   margin:0.06rem auto
    // span
    //   font-size:0.08rem
    //   color:#ffffff
    //   opacity:0.2
    //   letter-spacing:2px
    // .check
    //   color:#c4aa86
    //   opacity:0.6 !important
</style>
