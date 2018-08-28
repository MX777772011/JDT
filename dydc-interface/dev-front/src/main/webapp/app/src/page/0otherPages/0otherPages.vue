<template>
  <div class="bg" :class="'bg'+url" @click="isBackFun">
    <div class="back" v-if="btnGroup.back" @click.stop="back"></div>
    <div class="btn1" v-if="btnGroup.btn1" @click.stop="btn1"></div>
    <div class="btn2" v-if="btnGroup.btn2" @click.stop="btn2"></div>
    <div class="btn3" v-if="btnGroup.btn3" @click.stop="btn3"></div>
    <div class="btn4" v-if="btnGroup.btn4" @click.stop="btn4"></div>
    <div class="btn5" v-if="btnGroup.btn5" @click.stop="btn5"></div>
    <div class="btn6" v-if="btnGroup.btn6" @click.stop="btn6"></div>
    <div class="btn7" v-if="btnGroup.btn7" @click.stop="btn7"></div>
    <div class="btn8" v-if="btnGroup.btn8" @click.stop="btn8"></div>
    <div class="btn9" v-if="btnGroup.btn9" @click.stop="btn9"></div>
    <div class="btn10" v-if="btnGroup.btn10" @click.stop="btn10"></div>
    <div class="btn11" v-if="btnGroup.btn11" @click.stop="btn11"></div>
    <div class="btn12" v-if="btnGroup.btn12" @click.stop="btn12"></div>
    <div class="btn13" v-if="btnGroup.btn13" @click.stop="btn13"></div>
    <div class="btn14" v-if="btnGroup.btn14" @click.stop="btn14"></div>
    <div class="btn15" v-if="btnGroup.btn15" @click.stop="btn15"></div>
    <div class="btn16" v-if="btnGroup.btn16" @click.stop="btn16"></div>
    <div class="btn17" v-if="btnGroup.btn17" @click.stop="btn17"></div>
    <div class="btn18" v-if="btnGroup.btn18" @click.stop="btn18"></div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      url: '',
      isBack: false, // 是否具备全局返回
      btnGroup: {
        back: false,
        btn1: false,
        btn2: false,
        btn3: false,
        btn4: false,
        btn5: false,
        btn6: false,
        btn7: false,
        btn8: false,
        btn9: false,
        btn10: false,
        btn11: false,
        btn12: false,
        btn13: false,
        btn14: false,
        btn15: false,
        btn16: false,
        btn17: false,
        btn18: false
      }
    };
  },
  watch: {
    '$route': 'fetchData'
  },
  created () {
    this.fetchData();
    // this.$route.param;
  },
  methods: {
    fetchData () {
      this.isBack = false;
      for (var key in this.btnGroup) {
        this.btnGroup[key] = false;
      }
      let url = this.$route.params.id;
      this.url = url;
      if (url === '0_0') {
        this.btnGroup.back = true;
      } else if (url === '1_1') {
        this.btnGroup.back = true;
        this.btnGroup.btn1 = true;
      } else if (url === '1_2') {
        this.isBack = true;
        this.btnGroup.btn2 = true;
      } else if (url === '1_3') {
        this.btnGroup.back = true;
      } else if (url === '2_1') {
        this.btnGroup.back = true;
        this.btnGroup.btn11 = true;
      } else if (url === '2_2') {
        this.isBack = true;
        this.btnGroup.btn2 = true;
      } else if (url === '2_3') {
        this.btnGroup.back = true;
      } else if (url === '3_1') {
        this.btnGroup.back = true;
        this.btnGroup.btn3 = true;
        this.btnGroup.btn4 = true;
      } else if (url === '3_2') {
        this.btnGroup.back = true;
        this.btnGroup.btn4 = true;
        this.btnGroup.btn6 = true;
        this.btnGroup.btn12 = true;
      } else if (url === '3_3') {
        this.btnGroup.back = true;
        this.btnGroup.btn4 = true;
        this.btnGroup.btn6 = true;
      } else if (url === '3_4') {
        this.btnGroup.back = true;
        this.btnGroup.btn3 = true;
        this.btnGroup.btn5 = true;
        this.btnGroup.btn12 = true;
      } else if (url === '3_5') {
        this.btnGroup.back = true;
        this.btnGroup.btn3 = true;
        this.btnGroup.btn5 = true;
      } else if (url === '4_1') {
        this.btnGroup.back = true;
        this.btnGroup.btn7 = true;
        this.btnGroup.btn8 = true;
      } else if (url === '4_2') {
      } else if (url === '4_3') {
        this.btnGroup.back = true;
        this.btnGroup.btn9 = true;
        this.btnGroup.btn13 = true;
      } else if (url === '4_4') {
        this.btnGroup.back = true;
        this.btnGroup.btn14 = true;
      } else if (url === '5_1') {
        this.btnGroup.back = true;
        this.btnGroup.btn10 = true;
      } else if (url === '5_2') {
        this.isBack = true;
        this.btnGroup.btn10 = true;
      } else if (url === '6_1') {
        this.btnGroup.back = true;
        this.btnGroup.btn7 = true;
        this.btnGroup.btn14 = true;
        this.btnGroup.btn15 = true;
      } else if (url === '6_2') {
      } else if (url === '6_3') {
        this.isBack = true;
        this.btnGroup.btn10 = true;
      } else if (url === '6_4') {
        this.btnGroup.back = true;
        this.btnGroup.btn9 = true;
        this.btnGroup.btn14 = true;
        this.btnGroup.btn16 = true;
      } else if (url === '6_5') {
      } else if (url === '6_6') {
        this.isBack = true;
        this.btnGroup.btn10 = true;
      } else if (url === '6_7') {
        this.btnGroup.back = true;
        this.btnGroup.btn17 = true;
        this.btnGroup.btn18 = true;
      } else if (url === '6_8') {
        this.btnGroup.back = true;
      } else if (url === '6_9') {
        this.btnGroup.back = true;
      }
    },
    back () {
      let url = this.url;
      if (url === '3_1' || url === '3_2' || url === '3_4') {
        this.$router.push('/smartHome');
      } else if (url === '4_1' || url === '4_3') {
        this.$router.push('/intelligentProperty');
      } else if (url === '6_1' || url === '6_4') {
        this.$router.push('/presonalCenter');
      } else {
        this.$router.go(-1);
      }
    },
    btn1 () {
      let url = this.url;
      if (url === '1_1') {
        this.$router.push('/otherPages/1_2');
      } else if (url === '1_1') {

      }
    },
    btn2 () {
      let url = this.url;
      if (url === '1_2') {
        this.$router.push('/otherPages/1_3');
      } else if (url === '2_2') {
        this.$router.push('/otherPages/2_3');
      }
    },
    btn3 () {
      let url = this.url;
      if (url === '3_1') {
        this.$router.push('/otherPages/3_2');
      } else if (url === '3_4' || url === '3_5') {
        this.$router.push('/otherPages/3_1');
      }
    },
    btn4 () {
      let url = this.url;
      if (url === '3_1') {
        this.$router.push('/otherPages/3_4');
      } else if (url === '3_2' || url === '3_3') {
        this.$router.push('/otherPages/3_1');
      }
    },
    btn5 () {
      let url = this.url;
      if (url === '3_4' || url === '3_5') {
        this.$router.push('/otherPages/3_2');
      }
    },
    btn6 () {
      let url = this.url;
      if (url === '3_2' || url === '3_3') {
        this.$router.push('/otherPages/3_4');
      }
    },
    btn7 () {
      let url = this.url;
      if (url === '4_1') {
        this.$router.push('/otherPages/4_3');
      } else if (url === '6_1') {
        this.$router.push('/otherPages/6_4');
      }
    },
    btn8 () {
      let url = this.url;
      if (url === '4_1') {
        this.$router.push('/otherPages/4_3');
      }
    },
    btn9 () {
      let url = this.url;
      if (url === '4_3') {
        this.$router.push('/otherPages/4_1');
      } else if (url === '6_4') {
        this.$router.push('/otherPages/6_1');
      }
    },
    btn10 () {
      let url = this.url;
      if (url === '5_1') {
        this.$router.push('/otherPages/5_2');
      } else if (url === '5_2') {
        this.$router.push('/intelligentProperty');
      } else if (url === '6_3' || url === '6_6') {
        this.$router.push('/presonalCenter');
      }
    },
    btn11 () {
      let url = this.url;
      if (url === '2_1') {
        this.$router.push('/otherPages/2_2');
      }
    },
    btn12 () {
      let url = this.url;
      if (url === '3_2') {
        this.$router.push('/otherPages/3_3');
      } else if (url === '3_4') {
        this.$router.push('/otherPages/3_5');
      }
    },
    btn13 () {
      let url = this.url;
      if (url === '4_3') {
        this.$router.push('/otherPages/4_4');
      }
    },
    btn14 () {
      let url = this.url;
      if (url === '4_4') {
        this.$router.push('/otherPages/4_1');
      } else if (url === '6_1' || url === '6_4') {
        this.$router.push('/otherPages/6_7');
      }
    },
    btn15 () {
      let url = this.url;
      if (url === '6_1') {
        this.$router.push('/otherPages/6_3');
      }
    },
    btn16 () {
      let url = this.url;
      if (url === '6_4') {
        this.$router.push('/otherPages/6_6');
      }
    },
    btn17 () {
      let url = this.url;
      if (url === '6_7') {
        this.$router.push('/otherPages/6_8');
      }
    },
    btn18 () {
      let url = this.url;
      if (url === '6_7') {
        this.$router.push('/otherPages/6_9');
      }
    },
    isBackFun () {
      // 点页面是否返回
      if (this.isBack) {
        this.back();
      }
    }
  }
};
</script>

<style lang="stylus" scoped>
@import "../../common/mixin.styl"

.bg
  position relative
  height 100%
  width 100%
  background-position center -5%
  background-repeat no-repeat
  background-size 100% 100%
  &.bg0_0
    background-image url("0_0.jpg")
  &.bg1_1
    background-image url("1_1.jpg")
  &.bg1_2
    background-image url("1_2.jpg")
  &.bg1_3
    background-image url("1_3.jpg")
  &.bg2_1
    background-image url("2_1.jpg")
  &.bg2_2
    background-image url("2_2.jpg")
  &.bg2_3
    background-image url("2_3.jpg")
  &.bg3_1
    background-position center 0
    background-image url("3_1.jpg")
  &.bg3_2
    background-position center 0
    background-image url("3_2.jpg")
  &.bg3_3
    background-position center 0
    background-image url("3_3.jpg")
  &.bg3_4
    background-position center 0
    background-image url("3_4.jpg")
  &.bg3_5
    background-position center 0
    background-image url("3_5.jpg")
  &.bg4_1
    background-image url("4_1.jpg")
  &.bg4_2
    background-image url("4_2.jpg")
  &.bg4_3
    background-image url("4_3.jpg")
  &.bg4_4
    background-image url("4_4.jpg")
  &.bg5_1
    background-image url("5_1.jpg")
  &.bg5_2
    background-image url("5_2.jpg")
  &.bg6_1
    background-image url("6_1.jpg")
  &.bg6_2
    background-image url("6_2.jpg")
  &.bg6_3
    background-image url("6_3.jpg")
  &.bg6_4
    background-image url("6_4.jpg")
  &.bg6_5
    background-image url("6_5.jpg")
  &.bg6_6
    background-image url("6_6.jpg")
  &.bg6_7
    background-image url("6_7.jpg")
  &.bg6_8
    background-image url("6_8.jpg")
  &.bg6_9
    background-image url("6_9.jpg")
  >div
    position absolute
  .back
    top .2rem
    left 0rem
    width 2rem
    height 2rem
  .btn1
    top 7.6rem
    left 3.2rem
    width .8rem
    height .8rem
  .btn2
    top 4.2rem
    left 5.4rem
    width 1rem
    height 5.4rem
  .btn3
    top 11.2rem
    left 1.7rem
    width 1.4rem
    height 1rem
  .btn4
    top 11.2rem
    left 4.6rem
    width 1.4rem
    height 1rem
  .btn5
    top 11.2rem
    left .3rem
    width 1.4rem
    height 1rem
  .btn6
    top 11.2rem
    left 6rem
    width 1.4rem
    height 1rem
  .btn7
    top .2rem
    left 3.8rem
    width 2rem
    height .6rem
  .btn8
    top 9.8rem
    left .2rem
    width 7rem
    height 1rem
  .btn9
    top .2rem
    left 1.8rem
    width 2rem
    height .6rem
  .btn10
    top 3.2rem
    left .2rem
    width 7rem
    height 6rem
  .btn11
    top 4.2rem
    left 4.6rem
    width 1rem
    height 1rem
  .btn12
    top 2rem
    left 0rem
    height 7rem
    width 7.5rem
  .btn13
    top 2.8rem
    left 0rem
    height 10rem
    width 7.5rem
  .btn14
    top .2rem
    left 6.6rem
    width .8rem
    height .8rem
  .btn15
    top 6rem
    left .2rem
    width 7rem
    height .9rem
  .btn16
    top 8.7rem
    left .2rem
    width 7rem
    height .9rem
  .btn17
    top 1.2rem
    left .2rem
    width 7rem
    height 2rem
  .btn18
    top 5.2rem
    left .2rem
    width 7rem
    height 2rem
</style>
