<template>
  <div>
    <div class="search-bar">
      <div class="input-box">
        <input type="text" placeholder="点击搜索">
      </div>
    </div>
    <ul class="list-wrapper">
      <li v-for="(item,index) in biList" :key="index" @click="toDetails">
        <img :src="item.img" alt="">
        <div class="top-text">
          <div class="ftitle">{{item.name}}</div>
          <div class="clearfix">
            <div class="fl title">{{item.typeName}}</div>
            <div class="price fr">¥{{item.price}}起</div>
          </div>
        </div>
      </li>
    </ul>
    <footBar :index="footBarIndex"></footBar>
  </div>
</template>

<script>
import footBar from '../../components/footBar/footBar';

export default {
  data () {
    return {
      footBarIndex: 'BI',
      biList: [
        {
          img: './static/images/3_business_pic1@3x.png',
          name: '最新铁板烧日式主力',
          typeName: '日常饮食',
          price: '322.00'
        },
        {
          img: './static/images/3_business_pic1@3x.png',
          name: '最新铁板烧日式主力',
          typeName: '日常饮食',
          price: '322.00'
        },
        {
          img: './static/images/3_business_pic1@3x.png',
          name: '最新铁板烧日式主力',
          typeName: '日常饮食',
          price: '322.00'
        }
      ]
    };
  },
  components: {
    footBar
  },
  methods: {
    toDetails () {
      this.$router.push('/BIDetails');
    }
  }
};
</script>

<style lang="stylus" scoped>
.search-bar
  display flex
  padding 0.2rem
  .input-box
    flex:1
    >input
      width 100%
      height 0.56rem
      border-radius 0.1rem
      background rgb(35, 39, 66)
      text-align center
      color #c4aa86
.list-wrapper
  >li
    position relative
    height 3.15rem
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
        font-size 0.36rem
        color #fff
      .price
        font-size 0.36rem
        color #c4aa86
</style>
