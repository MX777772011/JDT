<template>
  <div class="warpper">
    <div class="faultType">
      <span class="title">故障类型</span>
      <div>
        <span>上下水</span>
        <span>电器设备</span>
        <span>燃气设备</span>
        <span>其他</span>
      </div>
    </div>
    <div class="repairMessage">
      <span class="title">报修信息</span>
      <div>
        <textarea maxlength="200" placeholder="请输入报修信息......"></textarea>
        <span>0/200</span>
      </div>
    </div>
    <upload-picture :config="pictureConfig"></upload-picture>
    <div class="btn">我要报修</div>
  </div>
</template>

<script>
import uploadPicture from '../../components/uploadPicture/uploadPicture';
export default {
  data () {
    return {
      pictureConfig: {
        maxLength: 5
      }
    };
  },
  components: {
    uploadPicture
  }
};
</script>

<style lang="stylus" scoped>
  .warpper
    width: 100%
    height: 100%
    background: #171e3b
    .topBar
      width:100%
      height:1rem
      background-image:url("/static/images/family_top_bg.png")
      background-repeat: no-repeat
      background-size:100% 100%
      position:relative
      .backBtn
        width:0.2rem
        position:absolute
        left: 0.2rem
        bottom:0.15rem
      .checkBtn
        border-radius: 0.1rem
        border: 1px solid #e0b487
        width: 4rem
        height: 0.5rem
        position: absolute
        bottom: 0.1rem
        left: 50%
        transform: translateX(-50%)
        font-size: 0
        box-sizing: border-box
        div
          display: inline-block
          width: 50%
          height: 100%
          font-size: 0.3rem
          text-align: center
          line-height: 0.5rem
          color: #e0b487
        .repair
          border-bottom-left-radius: 0.1rem
          border-top-left-radius: 0.1rem
        .schedule
          border-bottom-right-radius: 0.1rem
          border-top-right-radius: 0.1rem
        .check
          background: #e0b487
          color: #161c39
    .faultType
      width: 100%
      margin-top: 0.5rem
      padding: 0.2rem
      .title
        font-size: 0.3rem
        color: #68707d
      div
        width: 100%
        margin-top: 0.2rem
        display: flex
        align-content: flex-start
        span
          font-size: 0.3rem
          color: #a59890
          border: 1px solid #a59890
          padding: 0.13rem 0.25rem
          margin-right: 0.2rem
    .repairMessage
      width: 100%
      margin: 0.2rem 0
      .title
        font-size: 0.3rem
        color: #68707d
        margin-left: 0.2rem
      div
        width: 100%
        height: 2.5rem
        margin-top: 0.2rem
        position: relative
        textarea
          width: 100%
          height: 100%
          padding: 0.2rem
          background: #112740
          font-size: 0.3rem
          color: #ffffff
        span
          position: absolute
          bottom: 0.2rem
          right: 0.2rem
          font-size: 0.3rem
          color: #68707d
    .btn
      width: 94vw
      margin: 1rem 0 0 3vw
      height: 1rem
      border-radius: 5px
      background: #d3b68f
      text-align: center
      line-height: 1rem
      font-size: 0.4rem
</style>
