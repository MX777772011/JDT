<template>
  <div class="fullPage">
    <top-bar title="意见反馈"></top-bar>
    <div class="content-wrapper">
      <div class="feed-text">
        <textarea name="" rows="5" placeholder="欢迎吐槽产品"></textarea>
      </div>
      <upload-picture :config="pictureConfig"></upload-picture>
      <div class="contact-number">
        <label>联系电话</label>
        <div><input type="text" placeholder="请输入您的联系方式（选填）"></div>
      </div>
      <div class="">
        <a href="javascript:void(0)" class="submit">提交</a>
      </div>
    </div>
  </div>
</template>

<script>
import topBar from '@/components/topBar/topBar';
import uploadPicture from '@/components/uploadPicture/uploadPicture';

export default {
  data () {
    return {
      pictureConfig: {
        maxLength: 3
      }
    };
  },
  components: {
    topBar,
    uploadPicture
  },
  methods: {
  }
};
</script>

<style lang="stylus" scoped>
@import "../../common/mixin.styl";

.content-wrapper
  .feed-text
    background rgb(35,39,66)
    padding .2rem
    margin-bottom .2rem
    textarea
      width 100%
      background transparent
      color rgba(255,255,255,.7)
      font-size .3rem
      line-height .36rem
  .contact-number
    margin-top .2rem
    margin-bottom 1.2rem
    padding 0 .2rem
    label
      display block
      font-size .3rem
      line-height .4rem
      color #68707d
      margin-bottom .1rem
    input
      width 100%
      height .9rem
      padding 0 .2rem
      background rgb(35,39,66)
      border-radius .1rem
      font-size .3rem
      line-height .36rem
      color rgba(255,255,255,.7)
  .submit
    display block
    width 7rem
    margin 0 auto
    height .9rem
    bg-image ("../../common/images/button")
    // background-image:url("/static/images/button.png")
    background-repeat: no-repeat
    background-size 100% 100%
    text-align: center
    line-height 0.9rem
    font-size:0.32rem
    color: #514b4b
</style>
