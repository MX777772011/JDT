<template>
  <div >
    <transition name="fade">
      <div class="pop" v-if="show">
        <div class="layer-wrapper"></div>
        <div class="pop-wrapper" @click="cancel(0)">
          <div class="title-line">
            <div class="pop-cancel" @click="cancel(0)">取消</div>
            <div class="pop-title">二维码</div>
            <div class="pop-sure" @click="cancel(0)">确定</div>
          </div>
          <div class="pop-content">
            <qriously class="qriously" value="Hello" :size="140" />
          </div>
        </div>
      </div>
    </transition>
  </div>
</template>

<script>
export default {
  props: {
    show: {
      type: Boolean
      // default: true
    },
    fullCancel: {
      type: Boolean,
      default: true
    }
  },
  data () {
    return {

    };
  },
  methods: {
    tap (item) {
      item.id = this.itemId;
      this.$emit('popEvent', item);
    },
    cancel (isBtn) {
      if (isBtn || this.fullCancel) {
        this.$emit('popEvent', {});
      }
    }
  }
};
</script>

<style lang="stylus" scoped>
.pop
  display flex
  justify-content center
  align-items center
  position fixed
  width 100%
  height 100%
  top 0
  left 0
.fade-enter-active, .fade-leave-active
  transition: opacity .1s
.fade-enter, .fade-leave-to
  opacity: 0

.layer-wrapper
  position fixed
  z-index 9
  top 0
  left 0
  width 100%
  height 100%
  background rgba(0,0,0,.5)

.pop-wrapper
  position relative
  z-index 10
  top 0
  left 0
  background rgba(220,224,227,1)
  border-radius .2rem
  overflow hidden
  .title-line
    display flex
    justify-content space-between
    border-bottom 1px solid #cdcdcd
    >div
      font-size .3rem
      padding .2rem
      &.pop-cancel
        color rgb(144,144,144)
      &.pop-title
        color #333
        min-width 3rem
        text-align center
      &.pop-sure
        color rgb(0,3,16)
  .pop-content
    text-align center
    padding .5rem
    .qriously
      background #fff
      display inline-block
</style>
