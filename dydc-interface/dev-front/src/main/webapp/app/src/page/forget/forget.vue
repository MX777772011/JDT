<template>
  <div class="warpper">
    <div class="main">
      <div class="modularDiv operationBar">
        <i class="backBtn" @click="back"></i>
        <span>忘了带钥匙？</span>
      </div>
      <div class="modularDiv div_bg">
        <label for="userName">
          <i class="label_icon label_user"></i>
        </label>
        <input type="text" id="userName" v-model="phone" placeholder="请输入手机号">
      </div>
      <div class="modularDiv div_bg">
        <label for="code">
          <i class="label_icon label_mail"></i>
        </label>
        <input type="text" id="code" v-model="pwd" placeholder="请输入短信验证码">
        <span class="getCode" v-on:click="getVerifyCode">获取验证码</span>
      </div>
      <div class="modularDiv div_bg">
        <label for="password">
          <i class="label_icon label_key"></i>
        </label>
        <input type="password" id="password" v-model="verifyCode" placeholder="请输入密码">
      </div>
      <div class="modularDiv landBtn" v-on:click="updatePwdUsePhone">
        换一把钥匙
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      phone: '',
      pwd: '',
      verifyCode: ''
    };
  },
  watch: {
  },
  methods: {
    back () {
      this.$router.go(-1);
    },
    updatePwdUsePhone () {
      if (!this.phone) {
        alert('请输入手机号');
        return false;
      }
      if (!this.pwd) {
        alert('请输入密码');
        return false;
      }
      if (!this.verifyCode) {
        alert('验证码不能为空');
        return false;
      }
      if (!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(this.phone))) {
        alert('不是完整的11位手机号或者正确的手机号前七位');
        return false;
      }
      if (this.pwd.length < 6) {
        alert('密码至少需要6位');
        return false;
      }
      let data = {
        email: this.phone,
        newPwd: this.pwd,
        verifyCode: this.verifyCode
      };
      let _this = this;
      this.$api.post('/sysUser/updatePwdUsePhone.do', data, function (data) {
        _this.$router.push('/smartHome');
      }, function (data) {
        alert(data.msg);
      });
    },
    getVerifyCode () {
      if (!this.phone) {
        alert('请输入手机号');
        return false;
      }
      let data = {
        phone: this.phone
      };
      let _this = this;
      this.$api.post('/getVerifyCode.do', data, function (data) {
        _this.verifyCode = data.msg;
      }, function (data) {});
    }
  }
};
</script>

<style lang="stylus" scoped>
@import "../../common/mixin.styl";

.warpper
  width:100%
  height:100%
  bg-image ("../../common/images/forget_bg")
  background-repeat: no-repeat
  background-size: 100% 100%
  position:relative
  .main
    box-sizing: border-box
    width:100%
    position:absolute
    top:0.6rem
    padding:0 10px
    .modularDiv
      width:100%
      height:0.8rem
      margin-bottom:0.32rem
    .operationBar
      text-align: center
      .backBtn
        position relative
        display block
        float: left
        width: 0.24rem
        height .4rem
        bg-image ("../../common/images/back")
        background-repeat: no-repeat
        background-size:100% auto
        &:after
          content '   '
          position absolute
          top -.1rem
          bottom -.1rem
          left -.1rem
          right -.1rem
      span
        text-align: center
        font-size: 0.3rem
        color:#ffffff
        opacity:0.6
    .div_bg
      display flex
      bg-image ("../../common/images/frame")
      background-repeat: no-repeat
      background-size:100% 100%
      label
        flex 0 0 1.4rem
        width 1.4rem
        padding 0.19rem 0rem
        text-align center
        i.label_icon
          display inline-block
          width:0.42rem
          height .42rem
          background-position center center
          background-size .42rem
          &.label_user
            bg-image ("../../common/images/user")
          &.label_mail
            bg-image ("../../common/images/mail")
          &.label_key
            bg-image ("../../common/images/key")
      input
        flex 1
        vertical-align: middle
        border:none
        background:none
        outline:none
        line-height:0.75rem
        font-size:0.28rem
        color:#ffffff
        &::-webkit-input-placeholder
          color:#ffffff
          opacity:0.2
      .getCode
        flex 0 0 1.6rem
        width 1.6rem
        text-align center
        line-height:0.8rem
        font-size:0.28rem
        color: #d3b68f
        opacity:0.8
    .landBtn
      bg-image ("../../common/images/button")
      background-repeat: no-repeat
      background-size:100% 100%
      text-align: center
      line-height:0.8rem
      font-size:0.28rem
      color: #514b4b
      font-weight:700
</style>
