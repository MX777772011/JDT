<template>
  <div class="warpper" v-on:click="redirect()">
    <img class="logo" src="/static/images/logo.png">
    <img class="bg" src="./welcomeBg.png">
  </div>
</template>

<script>
export default {
  methods: {
    redirect (event) {
      this.$router.push('/login');
    }
  }
};
</script>

<style lang="stylus" scoped>
  .warpper
    width:100%
    height:100%
    background: #0f1c39
    position:relative
    .logo
      width:2.34rem
      position:absolute
      top:2.18rem
      left:50%
      transform:translate(-50%)
    .bg
      width:100%
      position:fixed
      bottom:0
</style>
