<template>
  <div >
    <transition name="fade">
      <div  v-if="show">
        <div class="layer-wrapper"  @click="cancel"></div>
        <div class="pop-wrapper">
          <div class="btn-wrapper" @click.stop>
            <div class="clearfix">
              <div class="fl">
                <a href="javascript:void(0)" class="btn" @click="cancel">取消</a>
              </div>
              <div class="fr">
                <a href="javascript:void(0)" class="btn" @click="save">确定</a>
              </div>
            </div>
            <pd-select-box>
              <pd-select-item :listData="listData" type="cycle" v-model="hour"></pd-select-item>
              <pd-select-item :listData="listData2" type="cycle" v-model="minutes"></pd-select-item>
            </pd-select-box>
          </div>
        </div>
      </div>
    </transition>
  </div>
</template>

<script>
export default {
  props: {
    show: {
      type: Boolean
    }
  },
  data () {
    return {
      listData: Array.from({length: 24}, (value, index) => index),
      listData2: Array.from({length: 60}, (value, index) => index),
      hour: 0,
      minutes: 0,
      oldhour: 0,
      outminutes: 0
    };
  },
  watch: {
    show (val) {
      // this.oldhour = this.hour;
      // this.outminutes = this.minutes;
    }
  },
  methods: {
    cancel () {
      console.log(1);
      this.hour = this.oldhour;
      this.minutes = this.outminutes;
      this.$emit('popEvent', {});
    },
    save () {
      console.log(this.minutes);
      this.$emit('popEvent', {
        hour: this.hour,
        minutes: this.minutes
      });
    }
  }
};
</script>

<style lang="stylus" scoped>
.fade-enter-active, .fade-leave-active {
  transition: opacity .1s;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}

.layer-wrapper
  position fixed
  z-index 9
  top 0
  left 0
  width 100%
  height 100%
  background rgba(0,0,0,.5)
.pop-wrapper
  position relative
  z-index 10
  .btn-wrapper
    background #fff
    a
      display block
      padding .2rem
      font-size .3rem
      color #d6b082
</style>
