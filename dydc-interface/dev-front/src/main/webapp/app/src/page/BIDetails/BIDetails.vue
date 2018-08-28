<template>
  <div class="fullPage">
    <top-bar title="商户详情"></top-bar>
    <div class="content-wrapper">
      <div class="">
        <div class="bi-info">
          <img :src="item.img" alt="">
          <div class="top-text">
            <div class="ftitle">{{item.name}}</div>
            <div class="clearfix">
              <div class="fl title">{{item.typeName}}</div>
              <div class="price fr">¥{{item.price}}起</div>
            </div>
          </div>
        </div>
      </div>
      <div class="bi-details">
        <h3 class="title">然寿司</h3>
        <ul class="bi-details-list">
          <li>
            <h4 class="title">商户介绍</h4>
            <div class="content">商户介绍商户介绍商户介绍商户介绍商户介绍商户介绍商户介绍商户介绍商户介绍商户介绍商户介绍</div>
          </li>
          <li>
            <h4 class="title">商户介绍</h4>
            <div class="content">商户介绍商户介绍商户介绍商户介绍商户介绍商户介绍商户介绍商户介绍商户介绍商户介绍商户介绍</div>
          </li>
          <li>
            <h4 class="title">商户位置</h4>
            <div class="content">底商2091</div>
          </li>
          <li>
            <h4 class="title">联系电话</h4>
            <div class="content">13312341234</div>
          </li>
        </ul>
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
  data () {
    return {
      item: {
        img: './static/images/3_business_pic1@3x.png',
        name: '最新铁板烧日式主力',
        typeName: '日常饮食',
        price: '322.00'
      }
    };
  }

};
</script>

<style lang="stylus" scoped>
.bi-info
  position relative
  >img
    position absolute
    top 0
    left 0
    width 100%
    height 100%
    z-index 0
  .top-text
    position relative
    z-index 1
    height 100%
    padding 1.9rem 0.2rem 0.4rem
    background linear-gradient(to bottom, rgba(0, 0, 0, 0) 0%,rgba(0, 0, 0, 0.7) 100%)
    .ftitle
      font-size 0.24rem
      margin-bottom 0.2rem
      color #c4aa86
    .title
      font-size: 0.36rem
      color #fff
    .price
      font-size 0.36rem
      color #c4aa86
.bi-details
  padding 1rem .2rem .2rem
  h3.title
    padding-bottom .4rem
    font-size .36rem
    color #c4aa86
    text-align center
  .bi-details-list
    li
      padding-bottom .2rem
      h4.title
        color #927f64
        font-size .3rem
      .content
        padding .1rem .1rem .2rem
        font-size .26rem
        line-height .36rem
        color rgba(255,255,255,.4)
</style>
