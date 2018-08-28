<template>
  <div class="fullPage">
    <top-bar  @topbarLeftEvent="toPresonalCenter" @topbarRightEvent="toRecord" :activeIndex="activeIndex" :topBarObj="topBarObj" rightIcon="record"></top-bar>
    <div class="content-wrapper">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import topBar from '@/components/topBarLink/topBarLink';

export default {
  components: {
    topBar
  },
  data () {
    return {
      topBarObj: {
        leftTitle: '普通访客',
        leftLink: 'normalVisitor',
        rightTitle: '驾车访客',
        rightLink: 'driverVisitor'
      },
      activeIndex: 1
    };
  },
  methods: {
    toPresonalCenter () {
      this.$router.push('/presonalCenter');
    },
    toRecord () {
      this.$router.push('/myVisitorRecod');
    }
  }
};
</script>

<style lang="stylus" scoped>
.content-wrapper
  .router-view
    width 100%
    height 100%
</style>
