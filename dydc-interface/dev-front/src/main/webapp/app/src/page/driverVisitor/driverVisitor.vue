<template>
  <div>
    <div class="form-wrapper">
      <div class="form-line">
        <label class="form-label">访客姓名</label>
        <input class="form-input" type="text">
      </div>
      <div class="form-line">
        <label class="form-label">停车位</label>
        <input class="form-input" type="text">
      </div>
      <div class="form-line">
        <label class="form-label">到访时间</label>
        <input class="form-input" type="text">
      </div>
      <div class="form-line">
        <label class="form-label">对方车牌</label>
        <input class="form-input" type="text">
      </div>
    </div>
    <div class="form-wrapper">
      <div class="form-line">
        <label class="form-label">是否代支付</label>
        <input class="form-input" type="text">
      </div>
      <div class="form-line">
        <label class="form-label">欢迎词</label>
        <input class="form-input" type="text">
      </div>
      <div class="form-line">
        <label class="form-label">欢送词</label>
        <input class="form-input" type="text">
      </div>
    </div>
    <div class="btn-wrapper">
      <div class="submit" @click="submit">生成二维码</div>
    </div>
    <qr-visitor :show="popShow" @popEvent="popEvent"></qr-visitor>
  </div>
</template>

<script>
import qrVisitor from '@/components/qrVisitor/qrVisitor';

export default {
  components: {
    qrVisitor
  },
  created () {
    console.log(this.$route);
  },
  data () {
    return {
      popShow: false
    };
  },
  methods: {
    submit () {
      this.popShow = true;
      console.log(this.popShow);
    },
    popEvent (obj) {
      this.popShow = false;
    }

  }
};
</script>

<style lang="stylus" scoped>
.form-wrapper
  margin-bottom .2rem
  background rgb(35,39,66)
  .form-line
    display flex
    height .8rem
    padding 0 .2rem
    border-bottom 1px solid #171e3b
    .form-label
      display block
      flex 0 0 2rem
      color rgba(255,255,255,.8)
      font-size .28rem
      height .8rem
      padding .2rem 0
      line-height .4rem
    .form-input
      flex 1
      display block
      height 100%
      background transparent
      margin 0
      text-align right
      font-size .28rem
      color #fff
.btn-wrapper
  margin-top 1rem
  .submit
    display block
    width 7rem
    margin 0 auto
    height .9rem
    background-image:url("/static/images/button.png")
    background-repeat: no-repeat
    background-size 100% 100%
    text-align: center
    line-height 0.9rem
    font-size:0.32rem
    color: #514b4b
</style>
