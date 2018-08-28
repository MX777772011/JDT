<template>
  <div class="warpper">
    <img class="logo" src="/static/images/logo.png">
    <div class="main">
      <div class="modularDiv div_bg">
        <label for="userName">
          <img src="/static/images/user.png">
        </label>
        <input type="text" id="userName" v-model="phone" placeholder="用户名">
      </div>
      <div class="modularDiv div_bg">
        <label for="password">
          <img src="/static/images/key.png">
        </label>
        <input type="password" id="password" v-model="pwd" placeholder="密 码">
      </div>
      <div class="modularDiv forget">
        <span name="forget" v-on:click="toForget">忘记密码</span>
      </div>
      <div class="modularDiv landBtn" name="landBtn" v-on:click="toLogin">
        登 录
      </div>
      <div class="modularDiv registerDiv">
        <span class="registerSpan">还没有注册吗？</span><span class="register" name="register" v-on:click="toRegister"> 去注册</span>
      </div>
    </div>
  </div>
</template>

<script>
export default{
  data () {
    return {
      phone: '',
      pwd: ''
    };
  },
  methods: {
    toLogin () {
      if (!this.phone) {
        alert('请输入手机号');
        return false;
      }
      if (!this.pwd) {
        alert('请输入密码');
        return false;
      }
      if (!(/^1[3|4|5|7|8][0-9]\d{4,8}$/.test(this.phone))) {
        alert('不是完整的11位手机号或者正确的手机号前七位');
        return false;
      }
      if (this.pwd.length < 6) {
        alert('密码至少需要6位');
        return false;
      }
      let data = {
        email: this.phone,
        pwd: this.pwd
      };
      this.$api.post('/toLogin.do', data, r => {
        if (r.success) {
          localStorage.setItem('phone', this.phone);
          this.$store.dispatch('initHouseType', {phone: this.phone});
          this.$router.push('/homePage');
        }
      }, r => {
        console.log(r.msg);
      });
    },
    toRegister () {
      this.$router.push('/register');
    },
    toForget () {
      this.$router.push('/forget');
    }
  }
};
</script>

<style lang="stylus" scoped>
  .warpper
    width:100%
    height:100%
    background-image: url("login_bg.png")
    background-repeat: no-repeat
    background-size: 100% 100%
    position: relative
    .logo
      width:2.45rem
      position:absolute
      top:2.4rem
      left:50%
      transform:translate(-50%)
    .main
      box-sizing: border-box
      width:100%
      position:absolute
      top:5.5rem
      padding:0 10px
      .modularDiv
        width:100%
        height:0.7rem
        margin-bottom:0.32rem
      .div_bg
        background-image:url("/static/images/frame.png")
        background-repeat: no-repeat
        background-size:100% 100%
        display:table
        label
          display:table-cell
          vertical-align: middle
          img
            width:0.24rem
            vertical-align: middle
            margin-left:0.5rem
        input
          display:table-cell
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
      .forget
        text-align: right
        font-size:0.25rem
        color:#ffffff
        opacity: 0.3
      .landBtn
        background-image:url("/static/images/button.png")
        background-repeat: no-repeat
        background-size:100% 100%
        text-align: center
        line-height:0.7rem
        font-size:0.28rem
        color: #514b4b
        font-weight:700
      .registerDiv
        text-align: center
        font-size:0.25rem
        .registerSpan
          color: #ffffff
          opacity: 0.3
        .register
          color:#d3b68f
          opacity:0.8
</style>
