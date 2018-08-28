<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
import plus from 'plus'; // use plus
import mui from 'mui'; // use mui

export default {
  name: 'App',
  created () {
    console.log(plus);
    console.log(mui);
    document.body.addEventListener('touchstart', function () {}, false);
  }
};
</script>

<style lang="stylus" scoped>
#app
  height 100%
</style>
