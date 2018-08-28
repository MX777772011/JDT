<template>
  <div class="warpper">
    <div class="headBar">
      <img class="goHomeBg" ref="bg" src="./family_gohome.png">
      <div class="messageDiv" @click="toMessage">
        <img src="./family_mail.png">
        <div class="messageNotice">1</div>
      </div>
      <div class="rightBtnDiv">
        <img src="./family_station.png" @click="familyLocation">
        <img src="./family_visiter.png" @click="familyVisiter">
        <img src="./family_video.png" @click="familyVideo">
      </div>
      <div class="operationBtnDiv" name="familyMode">
        <img class="operationBtn" src="./family_gohome_button.png" v-on:click="operationBtn($event)">
        <div class="operationSpan">
          <span :class="isBack?'operation_on':''">回家模式</span>
          <span :class="isBack?'':'operation_on'">离家模式</span>
        </div>
      </div>
    </div>
    <div class="scene-box" >
      <scene-mode v-for="(item,index) in sceneList" :key="index" :scene.sync="item" :index="index" @tapEvent="patternEvent"></scene-mode>
    </div>
    <div class="equipmentDiv">
      <div class="equipmentDivContent" v-for="(item,index) in equipmentList" :key="index" @click="equipmentEvent(item,index)">
        <v-equipment size="big" :name="item.title" :devicetype="item.devicetype" :status.sync="item.isopen"></v-equipment>
      </div>
    </div>
    <footBar :index="footBarIndex"></footBar>
  </div>
</template>

<script>
import footBar from '@/components/footBar/footBar';
import sceneMode from '@/components/sceneMode/sceneMode';
import vEquipment from '@/components/vEquipment/vEquipment';
//
import { mapGetters, mapActions } from 'vuex';

export default {
  components: {
    footBar,
    sceneMode,
    vEquipment
  },
  data () {
    return {
      footBarIndex: 'smartHome',
      isBack: true
    };
  },
  computed: {
    ...mapGetters({
      selectSceneId: 'getSelectSceneId', // 当前选择的情景模式
      sceneList: 'getSceneListThree', // 情景模式列表
      equipmentList: 'getEquipmentThree'// 设备列表
    })
  },
  created () {
    if (this.equipmentList.length < 3) {
      this.initHouseData();
      this.initSceneMode();
    }
  },
  methods: {
    ...mapActions({
      initHouseData: 'initHouseData',
      initSceneMode: 'initSceneMode',
      setDeviceListOff: 'setDeviceListOff'
    }),
    toMessage () {
      this.$router.push('/myMessage');
    },
    familyLocation () {
      this.$router.push('/otherPages/1_1');
    },
    familyVisiter () {
      this.$router.push('/myVisitor');
    },
    familyVideo () {
      this.$router.push('/otherPages/3_1');
    },
    operationBtn (event) {
      let gohome = require('./family_gohome_button.png');
      let leave = require('./family_leave_button.png');
      let gohomeBg = require('./family_gohome.png');
      let leaveBg = require('./family_leavehome.png');
      this.isBack = !this.isBack;
      if (this.isBack) {
        event.target.src = gohome;
        this.$refs.bg.src = gohomeBg;
      } else {
        event.target.src = leave;
        this.$refs.bg.src = leaveBg;
        this.$store.dispatch('setSelectSceneMode', '');
        this.$store.dispatch('setDeviceListOff');
      }
    },
    patternEvent (obj) {
      // 修改情景模式
      if (this.isBack) {
        if (obj.index == 3) {
          this.$router.push('/situationalMode');
          return;
        }
        this.$store.dispatch('setSelectSceneMode', obj.obj);
      }
    },
    equipmentEvent (item, index) {
      // 修改设备状态
      if (this.isBack) {
        if (index === 3) {
          this.$router.push('/myDeviceNew');
          return;
        }
        this.$store.dispatch('updateDeviceStatus', item);
      }
    }
  }
};
</script>

<style lang="stylus" scoped>
.warpper
  width: 100%
  height: 100%
  background: #171e3b
  .headBar
    width:100%
    position:relative
    .goHomeBg
      width:100%
    .messageDiv
      position:absolute
      top:0.38rem
      left:0.2rem
      img
        width:0.5rem
      .messageNotice
        position:absolute
        top:-10px
        right:-10px
        width:20px
        height:20px
        border-radius:50%
        color:#ffffff
        background:red
        text-align: center
        line-height:18px
        opacity:0.8
    .rightBtnDiv
      position:absolute
      top:0.26rem
      right:0.18rem
      img
        display: block
        width:1.2rem
        margin-top:0.35rem
    .operationBtnDiv
      width:3.6rem
      position:absolute
      bottom:0
      left:0
      right:0
      margin:auto
      transform: translateY(58%)
      .operationBtn
        width:100%
      .operationSpan
        font-size:0
        box-sizing: border-box
        width:100%
        height:0.3rem
        span
          display:inline-block
          width:50%
          height:100%
          font-size:0.22rem
          text-align: center
          color:#ffffff
          opacity:0.44
          letter-spacing:2px
        .operation_on
          color:#d3b68f !important
  .scene-box
    display flex
    flex-wrap wrap
    margin-top 1.3rem
    width 100%
    padding 0.08rem
    font-size 0
    .scene-mode
      width 50%
  .equipmentDiv
    display flex
    position relative
    margin-top 0.08rem
    margin-bottom 0.9rem
    padding 0 .15rem
    background rgba(255,255,255,.05)
    .equipmentDivContent
      flex 0 0 1.8rem
      width 1.8rem
      height 2.4rem
      padding 0.4rem 0.15rem 0.4rem
      text-align center
      box-sizing: border-box
</style>
