<template>
  <div class="fullPage">
    <top-bar title="我的设备" rightIcon="mydevicetile"  @topbarRightEvent="toDeviceTile"  @topbarLeftEvent="toSmartHome"></top-bar>
    <div class="content-wrapper">
      <div class="means-area" v-for="(parentItem,index) in roomTypeList" :key="index">
        <div class="title">{{parentItem.title}}</div>
        <div class="means-list">
          <div class="means">
            <div class="means-item" v-for="(item,index) in parentItem.equipmentList" :key="index" @click="equipmentCheckEvent(item)">
              <v-equipment :name="item.title" :devicetype="item.devicetype" :status.sync="item.isopen"></v-equipment>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import topBar from '@/components/topBar/topBar';
import vEquipment from '@/components/vEquipment/vEquipment';
// 引入数据
import { mapGetters } from 'vuex';

export default {
  components: {
    topBar,
    vEquipment
  },
  data () {
    return {
    };
  },
  computed: {
    ...mapGetters({
      roomTypeList: 'getHouseDouble'
    })
  },
  methods: {
    toSmartHome () {
      this.$router.push('/smartHome');
    },
    toDeviceTile () {
      this.$router.push('/myDeviceNew');
    },
    equipmentCheckEvent (item) {
      this.$store.dispatch('updateDeviceStatus', item);
    }
  }
};
</script>

<style lang="stylus" scoped>
@import "../../common/mixin.styl";

.content-wrapper
  .means-area
    padding .2rem 0
    .title
      padding 0 .2rem
      font-size .28rem
      margin-bottom .2rem
      color rgba(255,255,255,.5)
    .means-list
      position relative
      width: 100%
      min-height: 1.8rem
      overflow-x auto
      background rgb(35,39,66)
      .means
        display flex
        flex-wrap wrap
        .means-item
          flex: 0 0 1.5rem
          width: 1.5rem
          height: 1.8rem
          padding: 0.4rem 0.15rem 0.3rem
          text-align: center
</style>
