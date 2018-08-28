<template>
  <div class="pictureDiv">
    <div class="pictureTitle">
      <span>上传图片（最多上传{{config.maxLength}}张）</span>
      <span class="pictureLength">{{currentLength}}/{{config.maxLength}}</span>
    </div>
    <div class="pictureModule">
      <div v-for="(item,index) in config.maxLength" :key="index">+</div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    config: {
      type: Object
    }
  },
  data () {
    return {
      currentLength: 0
    };
  }
};
</script>

<style lang="stylus" scoped>
.pictureDiv
  width: 100%
  background: #112740
  .pictureTitle
    width: 100%
    padding: 0.2rem
    font-size: 0.3rem
    color: #68707d
    .pictureLength
      float: right
  .pictureModule
    width: 100%
    padding: 0.16rem
    box-sizing: border-box
    font-size: 0
    display: flex
    justify-content: space-between
    div
      box-sizing: border-box
      width: 18%
      height: 17vw
      background: #2d324f
      text-align: center
      line-height: 17vw
      font-size: 1rem
      font-weight: lighter
      color: #e0b487
</style>
