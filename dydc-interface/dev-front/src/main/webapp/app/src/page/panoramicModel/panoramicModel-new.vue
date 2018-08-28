<template>
  <div class="warpper">
    <top-bar title="全景模式"></top-bar>
    <div class="panorama">
      <div class="panoramaImage">
        <!-- 户型背景图 -->
        <img class="bg" :src="roomBg(houseType)"  style="-webkit-transform:scaleX(-1);">
        <!-- 设备图片 -->
        <img v-for="(item, index) in equipment" :key="index+1000" :src="deviceImg(item,checkroomid)" v-show="item.isopen==1" style="-webkit-transform:scaleX(-1);">
        <!-- 按钮 -->
        <v-panoramabtn :roomtype="roomtype" @toRoom="toRoom"></v-panoramabtn>
        <!-- <span v-for="(item, index) in roomType" class="panoramaBtn" :class="'btnps'+"></span> -->
      </div>
      <!-- panoramaBtn -->
    </div>
  </div>
</template>

<script>
import topBar from '@/components/topBar/topBar';
import vPanoramabtn from '@/components/vPanoramabtn/vPanoramabtn';
import {mapGetters} from 'vuex';

export default {
  components: {
    topBar,
    vPanoramabtn
  },
  data () {
    return {
      houseType: {
        title: '全部',
        roomtype: 'all',
        roomindex: '',
        roomid: ''
      },
      checkroomid: ''
    };
  },
  computed: {
    ...mapGetters({
      roomtype: 'getRoom',
      equipment: 'getEquipment'
    })
  },
  methods: {
    toRoom (roomid) {
      this.$router.push({name: 'myDeviceNew', params: {roomid: roomid}});
    }
  }
};
</script>

<style lang="stylus" scoped>
.warpper
  width: 100%
  height: 100%
  background: #171e3b
  display: flex
  flex-direction: column
  .panorama
    position relative
    flex: 1
    display: flex
    justify-content: center
    align-items: center
    width:100%
    justify-content: center
    align-items: center
    padding-bottom .2rem
    .panoramaImage
      display: flex
      justify-content: center
      align-items: center;
      position: relative
    img
      width: 100%
      height: 100%
      position: absolute
      &.bg
        max-width: 6.4rem
        max-height: 50%
        position relative
</style>
