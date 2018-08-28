<template>
  <div class="warpper">
    <top-bar title="我的设备" rightIcon="devicelist" @topbarRightEvent="toDeviceList" @topbarLeftEvent="toSmartHome"></top-bar>
    <div class="roomType">
      <div class="roomTypeContent">
        <div class="roomTypeModel" v-for="(item, index) in roomType" :key="index" :class="item.roomid==checkroomid?'active':''" @click="roomCheckEvent(item)">
          <v-room :name="item.title" :roomtype="item.roomtype" :status.sync="item.roomid==checkroomid"></v-room>
        </div>
      </div>
    </div>
    <div class="myEquipment">
      <div class="myEquipmentContent">
        <div class="myEquipmentModel" v-for="(item,index) in equipment" :key="index" v-show="item.roomid==checkroomid||checkroomid==''"   @click="equipmentCheckEvent(item)">
          <v-equipment :name="item.title" :devicetype="item.devicetype" :status.sync="item.isopen"></v-equipment>
        </div>
      </div>
    </div>
    <div class="panorama">
      <img v-for="(item, index) in roomType" :key="index+1000" :src="roomBg(item)" v-show="item.roomid==checkroomid" style="-webkit-transform:scaleX(-1);">
      <img v-for="(item, index) in equipment" :key="index" :src="deviceImg(item,checkroomid)" v-show="item.isopen>0&(item.roomid==checkroomid||checkroomid=='')" style="-webkit-transform:scaleX(-1);">
    </div>
    <span class="panoramicModel" @click="toPanoramicModel">全景模式</span>
    <v-adjustable :roomid.sync="checkroomid"></v-adjustable>
  </div>
</template>

<script>
import topBar from '@/components/topBar/topBar';
import vRoom from '@/components/vRoom/vRoom';
import vEquipment from '@/components/vEquipment/vEquipment';
import vAdjustable from '@/components/vAdjustable/vAdjustable';

// 引入数据
// import {roomTypeList, equipmentList} from '@/mock/deviceData';
import { mapGetters } from 'vuex';

export default {
  components: {
    topBar,
    vRoom,
    vEquipment,
    vAdjustable
  },
  data () {
    return {
      checkroomid: '',
      luminanceRegulationBtn: true, // 调光灯按钮状态
      luminanceRegulationDiv: true // 调光灯界面
    };
  },
  created () {
    if (this.$route.params.roomid) {
      this.checkroomid = this.$route.params.roomid;
    }
  },
  computed: {
    ...mapGetters({
      roomType: 'getRoom',
      equipment: 'getEquipment'
    })
  },
  methods: {
    returnImg (obj) {
      return obj.isAlone ? obj.imgAlone : obj.img;
    },
    toSmartHome () {
      this.$router.push('/smartHome');
    },
    toDeviceList () {
      this.$router.push('/myDeviceList');
    },
    roomCheckEvent (item) {
      this.checkroomid = item.roomid;
    },
    equipmentCheckEvent (item) {
      // item.isopen = !item.isopen;
      this.$store.dispatch('updateDeviceStatus', item);
    },
    luminanceRegulation () {
      // 未实现功能，取设备亮度数据填充到this.touchObj对象中
      let scheduleOne = this.touchObj.touchObjOne.schedule;
      this.$refs.imgOne.style.left = (scheduleOne * 5) + '%';
      let scheduleTwo = this.touchObj.touchObjTwo.schedule;
      this.$refs.imgTwo.style.left = (scheduleTwo * 5) + '%';
      this.luminanceRegulationDiv = true;
    },
    luminanceRegulationSub () {
      this.luminanceRegulationDiv = false;
    },
    toPanoramicModel () {
      this.$router.push('/panoramicModel');
    },
    updateLuminance (obj) {
      console.log(obj);
    }
  }
};
</script>

<style lang="stylus" scoped>
@import "../../common/mixin.styl";

.warpper
  width 100%
  height 100%
  background #171e3b
  display flex
  flex-direction column
  .roomType
    flex 0 0 2.2rem
    position relative
    z-index 2
    width 100%
    height 2.2rem
    overflow-x auto
    overflow-y hidden
    .roomTypeContent
      display flex
      min-width 100%
      background rgba(35,39,66,1)
      .roomTypeModel
        position relative
        flex 0 0 1.5rem
        width 1.5rem
        padding 0.3rem 0.1rem
        background rgba(35,39,66,1)
        &.active
          &:after
            position absolute
            top 100%
            left 50%
            margin-left -0.2rem
            border-top 0.2rem solid rgba(35,39,66,1)
            border-left 0.2rem solid transparent
            border-right 0.2rem solid transparent
            border-bottom 0.2rem solid transparent
            z-index 10
            content ' '
  .myEquipment
    flex 0 0 1.8rem;
    position relative
    z-index 1
    width 100%
    height 1.8rem
    margin-top -0.2rem
    overflow-x auto
    .myEquipmentContent
      display flex
      .myEquipmentModel
        flex 0 0 1.5rem
        width 1.5rem
        height 1.8rem
        padding 0.4rem 0.15rem 0.3rem
        text-align center
  .panorama
    flex 1
    display flex
    justify-content center
    align-items center
    img
      max-width 6.4rem
      max-height 50%
      position absolute
  .panoramicModel
    position fixed
    right 0.5rem
    bottom 0.4rem
    font-size 0.32rem
    color rgba(211,182,143,0.5)
</style>
