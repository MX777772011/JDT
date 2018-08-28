<template>
  <div class="scene_item" :class="scene.flag==1?'on':''"><!---->
    <div class="scene_mode" :class="'pic_'+scene.pic" @touchstart.prevent.stop="start($event)"  @touchmove.prevent.stop="move($event)" @touchend.prevent.stop="end($event)">
      <div class="scene_content">
        <div class="total">{{scene.title}}</div>
        <div class="icon_box">
          <i class="icon" :class="'type_'+scene.type"></i>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    scene: {
      type: Object
    },
    index: {
      type: Number
    }
  },
  data () {
    return {
      tapStartTime: 0,
      tapTime: '',
      tapStart: {}
    };
  },
  methods: {
    start (event) {
      this.tapStartTime = new Date().getTime();
      this.tapStart = event.targetTouches[0];
      this.tapTime = setTimeout(() => {
        this.$emit('tapEvent', {index: this.index, isLongTap: true, obj: this.scene});
        clearTimeout(this.tapTime);
      }, 500);
    },
    move (event) {
      let tapMove = event.targetTouches[0];
      if (Math.abs(tapMove.pageX - this.tapStart.pageX) > 10 || Math.abs(tapMove.pageY - this.tapStart.pageY) > 10) {
        // console.log('您移动的范围太大了');
        // clearTimeout(this.tapTime);
      }
    },
    end (event) {
      clearTimeout(this.tapTime);
      if ((new Date().getTime() - this.tapStartTime) > 500) {
        console.log('长按');
      } else {
        this.$emit('tapEvent', {index: this.index, isLongTap: false, obj: this.scene});
      }
    }
  }
};
</script>

<style lang="stylus" scoped>
@import "../../common/mixin.styl"

// 加载图片
.pic_0
 bg-image('scene_pic_banquet')
.pic_1
 bg-image('scene_pic_theater')
.pic_2
 bg-image('scene_pic_rest')
.pic_3
 bg-image('scene_pic_sleeping')
.pic_4
  bg-image('scene_pic_nightout')
.pic_5
  bg-image('scene_pic_more')
// 加载icon
.type_0
  bg-image('scene_banquet')
.type_1
  bg-image('scene_theater')
.type_2
  bg-image('scene_rest')
.type_3
  bg-image('scene_sleeping')
.type_4
  bg-image('scene_nightout')
.type_5
  bg-image('scene_more')

.scene_item
  padding .08rem
  width 50%
  color #726765
  &.on,&:active
    color #0c1434
    // 加载图片
    .pic_0
     bg-image('scene_pic_banquet_a')
    .pic_1
     bg-image('scene_pic_theater_a')
    .pic_2
     bg-image('scene_pic_rest_a')
    .pic_3
     bg-image('scene_pic_sleeping_a')
    .pic_4
      bg-image('scene_pic_nightout_a')
    // 加载icon
    .type_0
      bg-image('scene_banquet_a')
    .type_1
      bg-image('scene_theater_a')
    .type_2
      bg-image('scene_rest_a')
    .type_3
      bg-image('scene_sleeping_a')
    .type_4
      bg-image('scene_nightout_a')
  .scene_mode
    // border 1px solid #6d6467
    background-size 100% 100%
    background-repeat no-repeat
    .tap_area
      display none
      position absolute
      top 0
      left 0
      width 100%
      height 100%
      z-index 1
    .scene_content
      display flex
      height 1.12rem
      // background linear-gradient(to right,rgba(47,51,77,.2) 0%,rgba(47,51,77,1) 40%,rgba(47,51,77,1) 100%);
      .total
        flex 1
        padding .2rem .09rem 0 0
        text-align right
        font-size .26rem
        line-height .7rem
        font-weight 300
      .icon_box
        flex 0 0 .8rem
        .icon
          display inline-block
          width .9rem
          height 1.2rem
          background-size 1.3rem auto
          background-position -.3rem -.1rem
          background-repeat no-repeat
          &.type_5
            height 1.1rem
            background-position .1rem center
            background-size .5rem auto

</style>
