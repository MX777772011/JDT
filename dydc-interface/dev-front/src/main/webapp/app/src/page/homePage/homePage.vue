<template>
  <div class="warpper">
    <img class="topBg" src="./1_home_pic@3x.png">
    <div class="weather">
      <i :class="weatherAndCarNum.img"></i>
      <div>
        <span>{{weatherAndCarNum.temp1}}° /{{weatherAndCarNum.temp2}}°</span>
        <span>{{weatherAndCarNum.weather}}</span>
      </div>
    </div>
    <div class="limitLine" v-show="weatherAndCarNum.carcode">
      <span>今日限行</span>
      <span class="icon">{{weatherAndCarNum.carcode.split('、')[0]}}</span>
      <span class="icon">{{weatherAndCarNum.carcode.split('、')[1]}}</span>
    </div>
    <div class="tab">
      <div>
        <router-link :to="{path:'/smartHome'}" class="smartHome">
          <i class="icon"></i>
          <span>智能家居</span>
        </router-link>
      </div>
      <div>
        <router-link :to="{path:'/intelligentProperty'}" class="intelligentProperty">
          <i class="icon"></i>
          <span>智能物业</span>
        </router-link>
      </div>
      <div>
        <router-link :to="{path:'/BI'}" class="BI">
          <i class="icon"></i>
          <span>智能商业</span>
        </router-link>
      </div>
      <div>
        <router-link :to="{path:'/intelligentService'}" class="intelligentService">
          <i class="icon"></i>
          <span>智能服务</span>
        </router-link>
      </div>
      <div>
        <router-link :to="{path:'/presonalCenter'}" class="presonalCenter">
          <i class="icon"></i>
          <span>个人中心</span>
        </router-link>
      </div>
    </div>
    <div class="msg">
      <div class="left">
        温馨提示
        <i></i>
      </div>
      <div class="right">
        您的电费余额已不足30元，请尽快缴费
      </div>
    </div>
    <div class="recommend">
      <div class="top">
        <span class="title">为您推荐</span>
        <span class="more">查看更多<i></i></span>
      </div>
      <div class="bottom">
        <div v-for="(item, index) in this.recommend" :key="index">
          <i :style="{backgroundImage:'url('+item.img+')'}"></i>
          <span>{{item.title}}</span>
          <span class="money">￥{{item.money}}起</span>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import {mapGetters} from 'vuex';
export default{
  data () {
    return {
      recommend: [
        {
          img: './static/images/tuijian.png',
          title: '铁板烧日式料理',
          money: '168.00'
        },
        {
          img: './static/images/tuijian.png',
          title: '最新韩式美甲',
          money: '132.00'
        },
        {
          img: './static/images/tuijian.png',
          title: '休闲会所',
          money: '588.00'
        }
      ]
    };
  },
  computed: {
    ...mapGetters({
      weatherAndCarNum: 'getWeatherAndCarNum'
    })
  },
  mounted () {
    setTimeout(() => this.$store.commit('clearHouseTypeTimer'),
      5000
    );
    this.$store.dispatch('initWeatherAndCarNum');
  }
};
</script>
<style lang="stylus" scoped>
@import "../../common/mixin.styl";
.warpper
  width: 100%
  height: 100%
  background: #171e3b
  position: relative
  .topBg
    width: 100%
  .weather
    position: absolute
    top: 0.2rem
    left: 0.2rem
    display: flex
    i
      display: block
      width: 0.8rem
      height: 0.8rem
      background-repeat: no-repeat
      background-size: 100% 100%
      &.d0
        background-image: url('./weather/weather_00@3x.png')
      &.n0
        background-image: url('./weather/weather_00_night@3x.png')
      &.d1
        background-image: url('./weather/weather_01@3x.png')
      &.n1
        background-image: url('./weather/weather_01_night@3x.png')
      &.d2
        background-image: url('./weather/weather_02@3x.png')
      &.n2
        background-image: url('./weather/weather_02@3x.png')
      &.d3
        background-image: url('./weather/weather_03@3x.png')
      &.n3
        background-image: url('./weather/weather_03_night@3x.png')
      &.d4
        background-image: url('./weather/weather_04@3x.png')
      &.n4
        background-image: url('./weather/weather_04@3x.png')
      &.d5
        background-image: url('./weather/weather_05@3x.png')
      &.n5
        background-image: url('./weather/weather_05@3x.png')
      &.d6
        background-image: url('./weather/weather_06@3x.png')
      &.n6
        background-image: url('./weather/weather_06@3x.png')
      &.d7
        background-image: url('./weather/weather_07@3x.png')
      &.n7
        background-image: url('./weather/weather_07@3x.png')
      &.d8
        background-image: url('./weather/weather_08@3x.png')
      &.n8
        background-image: url('./weather/weather_08@3x.png')
      &.d9
        background-image: url('./weather/weather_03@3x.png')
      &.n9
        background-image: url('./weather/weather_09@3x.png')
      &.d10
        background-image: url('./weather/weather_10@3x.png')
      &.n10
        background-image: url('./weather/weather_10@3x.png')
      &.d11
        background-image: url('./weather/weather_11@3x.png')
      &.n11
        background-image: url('./weather/weather_11@3x.png')
      &.d12
        background-image: url('./weather/weather_12@3x.png')
      &.n12
        background-image: url('./weather/weather_12@3x.png')
      &.d13
        background-image: url('./weather/weather_13@3x.png')
      &.n13
        background-image: url('./weather/weather_13_night@3x.png')
      &.d14
        background-image: url('./weather/weather_14@3x.png')
      &.n14
        background-image: url('./weather/weather_14@3x.png')
      &.d15
        background-image: url('./weather/weather_15@3x.png')
      &.n15
        background-image: url('./weather/weather_15@3x.png')
      &.d16
        background-image: url('./weather/weather_16@3x.png')
      &.n16
        background-image: url('./weather/weather_16@3x.png')
      &.d17
        background-image: url('./weather/weather_17@3x.png')
      &.n17
        background-image: url('./weather/weather_17@3x.png')
      &.d18
        background-image: url('./weather/weather_18@3x.png')
      &.n18
        background-image: url('./weather/weather_18@3x.png')
      &.d19
        background-image: url('./weather/weather_19@3x.png')
      &.n19
        background-image: url('./weather/weather_19@3x.png')
      &.d20
        background-image: url('./weather/weather_20@3x.png')
      &.n20
        background-image: url('./weather/weather_20@3x.png')
      &.d21
        background-image: url('./weather/weather_21@3x.png')
      &.n21
        background-image: url('./weather/weather_21@3x.png')
      &.d22
        background-image: url('./weather/weather_22@3x.png')
      &.n22
        background-image: url('./weather/weather_22@3x.png')
      &.d23
        background-image: url('./weather/weather_23@3x.png')
      &.n23
        background-image: url('./weather/weather_23@3x.png')
      &.d24
        background-image: url('./weather/weather_24@3x.png')
      &.n24
        background-image: url('./weather/weather_24@3x.png')
      &.d25
        background-image: url('./weather/weather_25@3x.png')
      &.n25
        background-image: url('./weather/weather_25@3x.png')
      &.d26
        background-image: url('./weather/weather_26@3x.png')
      &.n26
        background-image: url('./weather/weather_26@3x.png')
      &.d27
        background-image: url('./weather/weather_27@3x.png')
      &.n27
        background-image: url('./weather/weather_27@3x.png')
      &.d28
        background-image: url('./weather/weather_28@3x.png')
      &.n28
        background-image: url('./weather/weather_28@3x.png')
      &.d29
        background-image: url('./weather/weather_29@3x.png')
      &.n29
        background-image: url('./weather/weather_29@3x.png')
      &.d30
        background-image: url('./weather/weather_30@3x.png')
      &.n30
        background-image: url('./weather/weather_30@3x.png')
      &.d31
        background-image: url('./weather/weather_31@3x.png')
      &.n31
        background-image: url('./weather/weather_31@3x.png')
      &.d53
        background-image: url('./weather/weather_53@3x.png')
      &.n53
        background-image: url('./weather/weather_53@3x.png')
    div
      span
        display: block
        padding-left: 0.2rem
        font-size: 0.2rem
        line-height: 0.4rem
        color: #ffffff
  .limitLine
    font-size: 0.3rem
    color: #ffffff
    position: absolute
    top: 0.35rem
    right: 0.2rem
    span
      display: inline-block
      margin-left: 0.05rem
      height: 0.5rem
      line-height: 0.5rem
      text-align: center
      &.icon
        width: 0.5rem
        height: 0.5rem
        background-image: url('./1_home_traffic_restriction_bg@3x.png')
        background-repeat: no-repeat
        background-size: 100% 100%
  .tab
    display flex
    width: 100%
    height: 2rem
    background-repeat: no-repeat
    background-size:100% 100%
    box-sizing: border-box
    font-size: 0
    background-color: #12183f
    div
      flex 1
      display: flex
      justify-content: center
      align-items: center
      >a
        display block
        i.icon
          display block
          width .8rem
          height .8rem
          margin .1rem auto .1rem
          background-repeat no-repeat
          background-position center center
          background-size 100% 100%
        span
          font-size .24rem
          color:rgba(255,255,255,.2)
          letter-spacing:2px
      .smartHome>i
        bg-image('1_home_icon1@3x')
      .intelligentProperty>i
        bg-image('1_home_icon2@3x')
      .BI>i
        bg-image('1_home_icon3@3x')
      .intelligentService>i
        bg-image('1_home_icon4@3x')
      .presonalCenter>i
        bg-image('1_home_icon5@3x')
  .msg
    width: 100%
    margin: 0.2rem 0
    padding: 0 0.17rem
    height: 0.8rem
    background-color: #12183f
    display: flex
    align-items: center
    .left
      flex: 0 0 1.8rem
      font-size: 0.24rem
      color: #d3b68f
      vertical-align: middle
      i
        display: inline-block
        width: 0.24rem
        height: 0.24rem
        vertical-align: middle
        bg-image('1_home_horn@3x')
        background-repeat: no-repeat
        background-size: 100% 100%
    .right
      font-size: 0.26rem
      color: #ffffff
      opacity: 0.5
  .recommend
    width: 100%
    padding: 0.17rem
    background-color: #12183f
    .top
      display: flex
      justify-content: space-between
      span
        color: #ffffff
        opacity: 0.7
        &.title
          font-size: 0.28rem
        &.more
          font-size: 0.25rem
          vertical-align: middle
          i
            display: inline-block
            width: 0.18rem
            height: 0.25rem
            margin-left: 0.1rem
            bg-image('1_home_Backicon@3x')
            background-repeat: no-repeat
            background-size: 100% 100%
    .bottom
      width: 100%
      height: 3rem
      padding: 10px 0 0 0
      display: flex
      justify-content: space-between
      div
        width: 32%
        height: 100%
        display: flex
        flex-direction: column
        text-align: left
        i
          display: inline-block
          width: 100%
          height: 100%
          background-repeat: no-repeat
          background-size: 100% 100%
        span
          display: block
          font-size: 0.27rem
          color: #ffffff
          opacity: 0.7
          line-height: 0.4rem
          &.money
            color: #d3b68f
</style>
