<template>
  <div class="fullPage">
    <baidu-map class="bm-view" center="北京" ak="FIgaD3dabc1BuSvZvGAd2qSvNceOvnLU">
      <bm-navigation anchor="BMAP_ANCHOR_BOTTOM_RIGHT"></bm-navigation>
    </baidu-map>
  </div>
</template>

<script>
import BaiduMap from 'vue-baidu-map/components/Map/Map.vue';
// import BmNavigation from 'vue-baidu-map/components/BmNavigation/BmNavigation.vue';

export default {
  components: {
    BaiduMap
    // BmNavigation
  }
};
</script>

<style lang="stylus" scoped>
.bm-view {
  width: 100%;
  height: 100%;
}
</style>
