<template>
  <div class="warpper">
    <img class="backimg" src="./property_pic.png">
    <labelBar :labelBarData="labelBarData" @emitEve="emitEve"></labelBar>
    <footBar :index="footBarIndex"></footBar>
    <div class="phoneDiv">
      <span>您的专属管家</span>
      <img src="./2_property_phone@3x.png">
    </div>
  </div>
</template>

<script>
import labelBar from '../../components/labelBar/labelBar';
import footBar from '../../components/footBar/footBar';
export default {
  data () {
    return {
      footBarIndex: 'intelligentProperty',
      labelBarData: [
        {
          imgIcon: './static/images/labelBarIcon/2_property_fix@3x.png',
          text: '物业报修',
          path: '/propertyRepair',
          func: 'repair'
        },
        {
          imgIcon: './static/images/labelBarIcon/2_property_barbecue@3x.png',
          text: '烧烤区预约',
          path: '',
          func: 'bbq'
        },
        {
          imgIcon: './static/images/labelBarIcon/2_property_service@3x.png',
          text: '服务预约',
          path: 'service',
          func: 'service'
        },
        {
          imgIcon: './static/images/labelBarIcon/2_property_p@3x.png',
          text: '车位管理',
          path: 'p',
          func: 'parking'
        }
      ]
    };
  },
  components: {
    footBar,
    labelBar
  },
  methods: {
    emitEve (obj) {
      if (obj.func) {
        this[obj.func]();
      }
    },
    repair () {
      this.$router.push('/otherPages/4_1');
    },
    bbq () {
      this.$router.push('/otherPages/5_1');
    }
  }
};
</script>

<style lang="stylus" scoped>
  .warpper
    width: 100%
    height: 100%
    background: #171e3b
    .backimg
      width: 100%
    .phoneDiv
      width: 3rem
      position: fixed
      bottom: 1.8rem
      left: 50%
      transform: translateX(-50%)
      span
        display: block
        text-align: center
        font-size: 0.25rem
        padding: 0.2rem 0
        color: #6c7483
      img
        width: 100%
</style>
