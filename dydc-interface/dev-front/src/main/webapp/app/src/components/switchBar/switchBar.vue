<template>
  <div class="moduleContentOther">
      <span>{{item.title}}</span>
      <check-btn :isOpen="item.val" @equipmentEvent="equipmentEvent"></check-btn>
      <!-- <img :src="item.isOpen?item.otherIcon?'/static/images/switchIcon/1_family_new_Switch(on)2@3x.png':'/static/images/switchIcon/family_new_Switch(on).png':'/static/images/switchIcon/family_new_Switch(off).png'"> -->
  </div>
</template>

<script>
import checkBtn from '@/components/checkBtn/checkBtn';

export default {
  components: {
    checkBtn
  },
  props: {
    item: {
      type: Object
    }
  },
  created () {
    console.log(this.item);
  },
  methods: {
    equipmentEvent () {
      this.$emit('equipmentEvent');
    }
  }
};
</script>

<style lang="stylus" scoped>
div.moduleContentOther
  width:100%
  height:0.8rem
  padding .16rem
  margin-bottom:1px
  background: #2d324f
  position:relative
  display flex
  justify-content space-between
  span
    display block
    font-size:0.25rem
    color:#ffffff
    line-height .48rem
  // img
  //   width:1rem
  //   position:absolute
  //   top:50%
  //   transform: translateY(-50%)
  //   right:0.16rem
</style>
