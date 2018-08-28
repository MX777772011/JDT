<template>
  <div class="topBar">
    <div class="top-bar-left">
      <div class="backBtn" :class="isBack?'backIcon':''" @click="back"></div>
    </div>
    <div class="title-wrapper clearfix">
      <div class="title-box">
        <div class="title-item" :class="active=='left'?'active':''" @click="changeAct('left')">{{topBarObj.leftTitle}}</div>
        <div class="title-item" :class="active=='right'?'active':''" @click="changeAct('right')">{{topBarObj.rightTitle}}</div>
      </div>
    </div>
    <div class="top-bar-right ">
      <div class="rightText" @click="rightEvent" v-if="rightText">{{rightText}}</div>
      <div class="menu" @click="rightEvent" v-if="!rightText">
        <i class="icon" :class="rightIcon"></i>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    isBack: {
      type: Boolean,
      default: true
    },
    title: {
      type: String,
      default: '菜单'
    },
    rightIcon: {
      type: String,
      default: ''
    },
    rightText: {
      type: String,
      default: ''
    },
    topBarObj: {
      type: Object
    }
  },
  data () {
    return {
      active: '',
      route: ''
    };
  },
  created () {
    this.active = 'left';
    this.route = this.$route.fullPath;
  },
  methods: {
    back () {
      // 点击左侧如果没有自定义事件默认返回上一页
      if (this.isBack && !this.$listeners.topbarLeftEvent) {
        this.$router.go(-1);
      } else {
        this.$emit('topbarLeftEvent');
      }
    },
    changeAct (act) {
      this.active = act;
      const route = this.route;
      console.log(route);
      if (act == 'left') {
        this.$router.push(route + '/' + this.topBarObj.leftLink);
      } else if (act == 'right') {
        this.$router.push(route + '/' + this.topBarObj.rightLink);
      }
    },
    rightEvent () {
      // 点击右侧菜单传递的事件
      this.$emit('topbarRightEvent');
    }

  }
};
</script>

<style lang="stylus" scoped>
@import "../../common/mixin.styl"

.topBar
  flex 0 0 1rem
  display flex
  align-items center
  width 100%
  height 1rem
  bg-image("family_top_bg")
  background-repeat: no-repeat
  background-size 100% 80%
  background-color #171c39
  position:relative
  padding: 0.26rem 0.2rem 0.2rem 0.2rem
  box-shadow 0 0 0.05rem 0rem rgba(0,0,0,.5)
  .top-bar-left
    flex 0 0 1.5rem
    .backBtn
      position relative
      width 0.4rem
      height 0.4rem
      background-repeat no-repeat
      background-size: 0.2rem 0.4rem
      &:after
        position absolute
        content ' '
        top -.1rem
        bottom -.1rem
        left -.1rem
        right -.1rem
      &.backIcon
        bg-image('back')
  .title-wrapper
    flex 1
    .title-box
      display flex
      width 4rem
      margin 0 auto
      height .58rem
      border .02rem solid rgb(208,183,149)
      border-radius .1rem
      .title-item
        color rgb(208,183,149)
        flex 1
        font-size .3rem
        line-height .54rem
        text-align center
        &.active
          color #171e3b
          background rgb(208,183,149)
  .top-bar-right
    flex 0 0 1.5rem
    .rightText
      width 100%
      height .4rem
      color rgb(208,183,149)
      text-align right
      line-height .4rem
      font-size .3rem
    .menu
      position relative
      float right
      height 0.4rem
      &:after
        position absolute
        content ' '
        top -.1rem
        bottom -.1rem
        left -.1rem
        right -.1rem
      .icon
        display inline-block
        width .4rem
        height 0.4rem
        background-position center
        background-repeat no-repeat
        background-size 0.4rem 0.4rem
        &.menu
          bg-image('menu')
          background-size 0.4rem 0.08rem
        &.devicelist
          bg-image('family_mydevice_list')
        &.mydevicetile
          bg-image('family_mydevice_tile')
        &.record
          background-size 0.32rem 0.4rem
          bg-image('record')
</style>
