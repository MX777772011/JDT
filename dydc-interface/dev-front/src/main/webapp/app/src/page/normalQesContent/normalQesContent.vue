<template>
  <div class="fullPage">
    <top-bar title="如何报修"></top-bar>
    <div class="content-wrapper">
      <div class="qes-cnotent">
        <p>1、 维修事件一般为周一周二维修事件一般为周一周二维修事件一般为周一周二维修事件一般为周一周二维修事件一般为周一周二维修事件一般为周一周二</p>
        <p>2、 维修事件一般为周一周二维修事件一般为周一周二维修事件一般为周一周二维修事件一般为周一周二维修事件一般为周一周二维修事件一般为周一周二</p>
        <p>3、 维修事件一般为周一周二维修事件一般为周一周二维修事件一般为周一周二维修事件一般为周一周二维修事件一般为周一周二维修事件一般为周一周二</p>
        <p>4、 维修事件一般为周一周二维修事件一般为周一周二维修事件一般为周一周二维修事件一般为周一周二维修事件一般为周一周二维修事件一般为周一周二</p>
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
  }
};
</script>

<style lang="stylus" scoped>
@import "../../common/mixin.styl";

.content-wrapper
  .qes-cnotent
    padding .2rem .4rem;
    font-size .3rem;
    line-height .4rem;
    color:rgba(255,255,255,.7)
    >p
      margin-bottom .2rem
      text-indent 2em
</style>
