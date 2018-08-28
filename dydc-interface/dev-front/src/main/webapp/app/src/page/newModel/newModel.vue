<template>
  <div class="fullPage">
    <topBar :title="topBarTitle" rightText="保存" @topbarRightEvent="save"></topBar>
    <div class="content-wrapper">
      <div class="mainModule">
        <span class="moduleTitle">模式名称</span>
        <div class="moduleContent">
          <input type="text" placeholder="请填写模式名称" v-model="form.title">
        </div>
      </div>
      <div class="mainModule">
        <span class="moduleTitle">模式图片</span>
        <pictureList :list="modelPictureList" v-model="form.pic"></pictureList>
      </div>
      <div class="mainModule">
        <span class="moduleTitle">模式类型</span>
        <pictureList :list="modelTypeList" v-model="form.type"></pictureList>
      </div>
      <div class="mainModule">
        <span class="moduleTitle">模式设备</span>
        <div class="switch-bar-wrapper">
          <switchBar v-for="(item,index) in equipment" :key="index" :item="item" @equipmentEvent="equipmentEvent(item)"></switchBar>
        </div>
      </div>
      <div class="mainModule">
        <span class="moduleTitle">是否定时开启本模式</span>
        <!-- <switchBar :list="switchTimeBarList"></switchBar> -->
      </div>
      <div class="dateDiv" v-show="switchTimeBarList[0].isOpen">
        <span>定时时间</span>
        <div ref="dateShowDom" @click="timepicker">
          <span v-if="form.time">{{form.time}}</span>
          <span v-else>请选择</span>
        </div>
        <i id="dateEventDom"></i>
      </div>
    </div>
    <pop-picker :show='pickerShow' @popEvent="popPickerEvent"></pop-picker>
  </div>
</template>

<script>
import topBar from '@/components/topBar/topBar';
import pictureList from '@/components/pictureList/pictureList';
import switchBar from '@/components/switchBar/switchBar';
import popPicker from '@/components/popPicker/popPicker';

export default {
  components: {
    pictureList,
    switchBar,
    topBar,
    popPicker
  },
  data () {
    return {
      modelPictureList: [
        {
          src: './static/images/modeIcon/family_new_pic1.png'
        },
        {
          src: './static/images/modeIcon/family_new_pic2.png'
        },
        {
          src: './static/images/modeIcon/family_new_pic3.png'
        },
        {
          src: './static/images/modeIcon/family_new_pic4.png'
        },
        {
          src: './static/images/modeIcon/family_new_pic5.png'
        }
      ],
      modelTypeList: [
        {
          src: './static/images/modeIcon/family_new_icon1.png'
        },
        {
          src: './static/images/modeIcon/family_new_icon2.png'
        },
        {
          src: './static/images/modeIcon/family_new_icon3.png'
        },
        {
          src: './static/images/modeIcon/family_new_icon4.png'
        },
        {
          src: './static/images/modeIcon/family_new_icon5.png'
        }
      ],
      equipment: [],
      switchTimeBarList: [
        {
          title: '定时开启',
          isOpen: true,
          otherIcon: true
        }
      ],
      form: {
        title: '',
        pic: 0,
        type: 0,
        time: ''
      },
      topBarTitle: '新增模式',
      pickerShow: false
    };
  },
  methods: {
    timepicker () {
      this.pickerShow = true;
      console.log(123);
    },
    popPickerEvent (obj) {
      if (obj.hour !== undefined) {
        let hour = obj.hour > 10 ? obj.hour : '0' + obj.hour;
        let minutes = obj.minutes > 10 ? obj.minutes : '0' + obj.minutes;
        this.form.time = '' + hour + ':' + minutes;
      }
      this.$nextTick(function () {
        this.pickerShow = false;
      });
    },
    save () {
      let ary = [];
      this.equipment.forEach(element => {
        let obj = {};
        obj.deviceid = element.deviceid;
        obj.addrset = element.addrset;
        obj.val = element.val;
        obj.eis = element.eis;
        ary.push(obj);
      });
      this.form.equipments = JSON.stringify(ary);
      console.log(this.form);
      this.$api.post('/dydcMode/save.do', this.form, r => {
        if (r.success) {
          console.log('保存成功');
          this.$router.push('/situationalMode');
        }
      }, r => {
        console.log(r.msg);
      });
    },
    equipmentEvent (item) {
      console.log(item.val);
      console.log('设备开关');
      if (item.val == 0) {
        item.val = 1;
      } else {
        item.val = 0;
      }
      console.log(item.val);
    }
  },
  created () {
    this.equipment = [...this.$store.getters.getEquipment];
    this.equipment.forEach(element => {
      element.val = 0;
    });
    let paramsID = this.$route.params.id;
    if (paramsID) {
      this.topBarTitle = '修改模式';
      this.$api.post('/dydcMode/getId.do', {id: paramsID}, r => {
        if (r.success) {
          this.form.id = r.data.id;
          this.form.title = r.data.title;
          this.form.pic = r.data.pic;
          this.form.type = r.data.type;
          this.form.time = r.data.time;
          this.equipment = JSON.parse(r.data.equipments);
        }
      }, r => {
        console.log(r.msg);
      });
    }
  }
};
</script>

<style lang="stylus" scoped>
.fullPage
  .content-wrapper
    width:100%
    .mainModule
      width:100%
      padding:0.2rem 0 .2rem 0
      .moduleTitle
        display:inline-block
        font-size:0.25rem
        padding-left:0.16rem
        color:#ffffff
        opacity:0.44
      .switch-bar-wrapper
        padding .16rem 0
      .moduleContent
        box-sizing: border-box
        width:100%
        padding:0.16rem
        input
          box-sizing: border-box
          width:100%
          height:0.8rem
          border:none
          background: #2d324f
          padding: 0 0.3rem 0 0.3rem
          font-size:0.3rem
          border-radius:10px
          letter-spacing: 2px
          color:#ffffff
          outline:none
          &::-moz-placeholder
            color: #ffffff
            opacity:0.24
          &::-webkit-input-placeholder
            color: #ffffff
            opacity:0.24
          &::-ms-input-placeholder
            color: #ffffff
            opacity:0.24
    .dateDiv
      width 100%
      height 0.8rem
      background #2d324f
      display flex
      span
        flex 0 0 1.5rem
        font-size: 0.25rem
        color #ffffff
        padding-left 0.16rem
        line-height 0.8rem
      div
        flex 1
        font-size 0.25rem
        color #999999
        line-height 0.8rem
        text-align right
      i
        flex 0 0 0.16rem
        height 0.3rem
        margin 0.25rem
        background-image url('/static/images/labelBarIcon/2_property_more@3x.png')
        background-repeat no-repeat
        background-size 100% 100%
</style>
