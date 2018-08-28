<template>
  <div class="warpper">
    <top-bar title="全景模式"></top-bar>
    <div class="panorama">
      <div class="panoramaImage" ref="position" v-on:click="redirect($event)">
        <img :src="this.roomType[0].img">
      </div>
    </div>
  </div>
</template>

<script>
import topBar from '@/components/topBar/topBar';

export default {
  components: {
    topBar
  },
  data () {
    return {
      roomType: [
        {
          title: '全部',
          icon: './static/images/myDeviceIcon/family_mydevice_all.png',
          iconB: './static/images/myDeviceIcon/family_mydevice_all2.png',
          index: 0,
          isCheck: true,
          img: './static/images/apartmentLayoutDiagram/b/whole/b_bg.png',
          position: [0, 0]
        },
        {
          title: '餐厅',
          icon: './static/images/myDeviceIcon/family_mydevice_diningroom.png',
          iconB: './static/images/myDeviceIcon/family_mydevice_diningroom2.png',
          index: 1,
          isCheck: false,
          img: './static/images/apartmentLayoutDiagram/b/alone/restaurant/restaurant.png',
          position: [15, 39]
        },
        {
          title: '书房',
          icon: './static/images/myDeviceIcon/family_mydevice_study.png',
          iconB: './static/images/myDeviceIcon/family_mydevice_study2.png',
          index: 2,
          isCheck: false,
          img: './static/images/apartmentLayoutDiagram/b/alone/study/study.png',
          position: [25, 2]
        },
        {
          title: '走廊',
          icon: './static/images/myDeviceIcon/family_mydevice_lobby.png',
          iconB: './static/images/myDeviceIcon/family_mydevice_lobby2.png',
          index: 3,
          isCheck: false,
          img: './static/images/apartmentLayoutDiagram/b/alone/corridor/corridor.png',
          position: [39, 13]
        },
        {
          title: '卧室',
          icon: './static/images/myDeviceIcon/family_mydevice_bedroom_b.png',
          iconB: './static/images/myDeviceIcon/family_mydevice_bedroom_b2.png',
          index: 4,
          isCheck: false,
          img: './static/images/apartmentLayoutDiagram/b/alone/bedroom/bedroom.png',
          position: [75, 60]
        },
        {
          title: '卫生间',
          icon: './static/images/myDeviceIcon/family_mydevice_toilet.png',
          iconB: './static/images/myDeviceIcon/family_mydevice_toilet2.png',
          index: 5,
          isCheck: false,
          img: './static/images/apartmentLayoutDiagram/b/alone/bathroom2/bathroom2.png',
          position: [25, 22]
        },
        {
          title: '卧室2',
          icon: './static/images/myDeviceIcon/family_mydevice_bedroom_b.png',
          iconB: './static/images/myDeviceIcon/family_mydevice_bedroom_b2.png',
          index: 6,
          isCheck: false,
          img: './static/images/apartmentLayoutDiagram/b/alone/bedroom2/bedroom2.png',
          position: [5, 2]
        },
        {
          title: '主人浴室',
          icon: './static/images/myDeviceIcon/family_mydevice_toilet.png',
          iconB: './static/images/myDeviceIcon/family_mydevice_toilet2.png',
          index: 7,
          isCheck: false,
          img: './static/images/apartmentLayoutDiagram/b/alone/masterBathroom/masterBathroom.png',
          position: [50, 1]
        },
        {
          title: '主人衣帽间',
          icon: './static/images/myDeviceIcon/family_mydevice_lobby.png',
          iconB: './static/images/myDeviceIcon/family_mydevice_lobby2.png',
          index: 8,
          isCheck: false,
          img: './static/images/apartmentLayoutDiagram/b/alone/masterCloakroom/masterCloakroom.png',
          position: [63, 2]
        },
        {
          title: '主人睡房',
          icon: './static/images/myDeviceIcon/family_mydevice_bedroom_b.png',
          iconB: './static/images/myDeviceIcon/family_mydevice_bedroom_b2.png',
          index: 9,
          isCheck: false,
          img: './static/images/apartmentLayoutDiagram/b/alone/masterBedroom/masterBedroom.png',
          position: [80, 2]
        },
        {
          title: '客厅',
          icon: './static/images/myDeviceIcon/family_mydevice_lobby.png',
          iconB: './static/images/myDeviceIcon/family_mydevice_lobby2.png',
          index: 10,
          isCheck: false,
          img: './static/images/apartmentLayoutDiagram/b/alone/parlour/parlour.png',
          position: [70, 32]
        },
        {
          title: '卫生间1',
          icon: './static/images/myDeviceIcon/family_mydevice_toilet.png',
          iconB: './static/images/myDeviceIcon/family_mydevice_toilet2.png',
          index: 11,
          isCheck: false,
          img: './static/images/apartmentLayoutDiagram/b/alone/bathroom1/bathroom1.png',
          position: [63, 63]
        },
        {
          title: '玄关',
          icon: './static/images/myDeviceIcon/family_mydevice_lobby.png',
          iconB: './static/images/myDeviceIcon/family_mydevice_lobby2.png',
          index: 12,
          isCheck: false,
          img: './static/images/apartmentLayoutDiagram/b/alone/porch/porch.png',
          position: [47, 40]
        },
        {
          title: '化妆间',
          icon: './static/images/myDeviceIcon/family_mydevice_lobby.png',
          iconB: './static/images/myDeviceIcon/family_mydevice_lobby2.png',
          index: 13,
          isCheck: false,
          img: './static/images/apartmentLayoutDiagram/b/alone/dressingRoom/dressingRoom.png',
          position: [33, 22]
        }
      ]
    };
  },
  methods: {
    redirect (event) {
      let tagName = event.target.tagName.toLowerCase();
      if (tagName === 'span') {
        let index = event.target.getAttribute('index');
        this.$router.push({path: 'myDeviceNew', query: {'index': index}});
      }
    }
  },
  mounted () {
    for (let i = 1; i < this.roomtype.length; i++) {
      let curRoom = this.roomtype[i];
      let title = curRoom.title;
      let index = curRoom.index;
      let span = document.createElement('span');
      span.innerHTML = title;
      span.setAttribute('index', index);
      span.style.border = '1px solid #d3b68f';
      span.style.color = '#d3b68f';
      span.style.padding = '0 0.1rem';
      span.style.height = '0.4rem';
      span.style.textAlign = 'center';
      span.style.lineHeight = '0.3rem';
      span.style.borderRadius = '0.3rem';
      span.style.position = 'absolute';
      span.style.top = curRoom.position[0] + '%';
      span.style.left = curRoom.position[1] + '%';
      this.$refs.position.append(span);
    }
  }
};
</script>

<style lang="stylus" scoped>
.warpper
  width: 100%
  height: 100%
  background: #171e3b
  display: flex
  flex-direction: column
  .panorama
    flex: 1
    display: flex
    justify-content: center
    align-items: center
    width:100%
    .panoramaImage
      width: 90%
      position: relative
      img
        width:100%
        height:100%
</style>
