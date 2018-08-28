<template>
  <div>
    <transition name="fade">
      <div  v-if="show">
        <div class="layer-wrapper"></div>
        <div class="pop-wrapper" @click="cancel(0)">
          <div class="btn-wrapper" @click.stop>
            <a href="javascript:void(0)" class="btn" @click="cancel(1)">取消</a>
          </div>
          <ul class="pop-list" @click.stop>
            <li v-for="item in eventList" :key="item.eventName">
              <a href="javascript:void(0)" class="btn" @click.prevent="tap(item)">{{item.name}}</a>
            </li>
          </ul>
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
    },
    eventList: {
      type: Array
    },
    fullCancel: {
      type: Boolean,
      default: true
    },
    itemId: {
      type: Number
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
.fade-enter-active, .fade-leave-active
  transition opacity .1s
.fade-enter, .fade-leave-to
  opacity 0

.layer-wrapper
  position fixed
  z-index 9
  top 0
  left 0
  width 100%
  height 100%
  background rgba(0,0,0,.5)

.pop-wrapper
  display flex
  flex-direction column-reverse
  position fixed
  z-index 10
  top 0
  left 0
  width 100%
  height 100%
  padding .2rem 0
  .btn
    display block
    width 7rem
    height .8rem
    line-height .4rem
    padding .2rem
    font-size .3rem
    text-align center
    background #fff
    color #161c39
  .btn-wrapper
    flex 0 0 1rem
    padding-top .2rem
    .btn
      margin 0 auto
      border-radius .1rem .1rem .1rem .1rem
  .pop-list
    width 7rem
    margin 0 auto
    overflow hidden
    border-radius .1rem .1rem .1rem .1rem
    >li
      border-bottom 1px solid #161c39
</style>
