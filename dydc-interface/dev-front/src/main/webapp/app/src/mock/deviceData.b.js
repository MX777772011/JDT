const roomTypeList = [
  {
    title: '全部',
    roomType: 'all',
    index: 0,
    isCheck: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/b_bg.png',
    isHasDimmer: false
  },
  {
    title: '餐厅',
    roomType: 'diningroom',
    index: 1,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/b/alone/restaurant/restaurant.png',
    isHasDimmer: false
  },
  {
    title: '书房',
    roomType: 'study',
    index: 2,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/b/alone/study/study.png',
    isHasDimmer: false
  },
  {
    title: '走廊',
    roomType: 'lobby',
    index: 3,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/b/alone/corridor/corridor.png',
    isHasDimmer: false
  },
  {
    title: '卧室',
    roomType: 'bedroom',
    index: 4,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/b/alone/bedroom/bedroom.png',
    isHasDimmer: true
  },
  {
    title: '卫生间',
    roomType: 'toilet',
    index: 5,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/b/alone/bathroom2/bathroom2.png',
    isHasDimmer: false
  },
  {
    title: '卧室2',
    roomType: 'bedroom',
    index: 6,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/b/alone/bedroom2/bedroom2.png',
    isHasDimmer: true
  },
  {
    title: '主人浴室',
    roomType: 'toilet',
    index: 7,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/b/alone/masterBathroom/masterBathroom.png',
    isHasDimmer: false
  },
  {
    title: '主人衣帽间',
    roomType: 'lobby',
    index: 8,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/b/alone/masterCloakroom/masterCloakroom.png',
    isHasDimmer: false
  },
  {
    title: '主人睡房',
    roomType: 'bedroom',
    index: 9,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/b/alone/masterBedroom/masterBedroom.png',
    isHasDimmer: true
  },
  {
    title: '客厅',
    roomType: 'lobby',
    index: 10,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/b/alone/parlour/parlour.png',
    isHasDimmer: false
  },
  {
    title: '卫生间1',
    roomType: 'toilet',
    index: 11,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/b/alone/bathroom1/bathroom1.png',
    isHasDimmer: false
  },
  {
    title: '玄关',
    roomType: 'lobby',
    index: 12,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/b/alone/porch/porch.png',
    isHasDimmer: false
  },
  {
    title: '化妆间',
    roomType: 'lobby',
    index: 13,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/b/alone/dressingRoom/dressingRoom.png',
    isHasDimmer: false
  }
];

const equipmentList = [
  {
    title: '餐厅灯带',
    deviceType: 'lamp',
    index: 1,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/restaurant/lamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/restaurant/lamp.png'
  },
  {
    title: '餐厅吊灯',
    deviceType: 'pendant',
    index: 1,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/restaurant/pendant.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/restaurant/pendant.png'
  },
  {
    title: '餐厅筒灯',
    deviceType: 'tubeLamp',
    index: 1,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/restaurant/tubeLamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/restaurant/tubeLamp.png'
  },
  {
    title: '书房筒灯',
    deviceType: 'tubeLamp',
    index: 2,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/study/tubeLamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/study/tubeLamp.png'
  },
  {
    title: '书房窗帘',
    deviceType: 'windowCurtains',
    index: 2,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/study/windowCurtains.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/study/windowCurtains.png'
  },
  {
    title: '走廊筒灯',
    deviceType: 'tubeLamp',
    index: 3,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/corridor/tubeLamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/corridor/tubeLamp.png'
  },
  {
    title: '卧室窗帘',
    deviceType: 'windowCurtains',
    index: 4,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/bedroom/windowCurtains.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/bedroom/windowCurtains.png'
  },
  {
    title: '卧室灯带',
    deviceType: 'lamp',
    index: 4,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/bedroom/lamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/bedroom/lamp.png'
  },
  {
    title: '卧室调光灯1',
    deviceType: 'dimmer',
    index: 4,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/bedroom/dimmer.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/bedroom/dimmer.png'
  },
  {
    title: '卧室调光灯2',
    deviceType: 'dimmer',
    index: 4,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/bedroom/dimmer2.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/bedroom/dimmer2.png'
  },
  {
    title: '卧室筒灯',
    deviceType: 'tubeLamp',
    index: 4,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/bedroom/tubeLamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/bedroom/tubeLamp.png'
  },
  {
    title: '卫生间筒灯',
    deviceType: 'tubeLamp',
    index: 5,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/bathroom2/tubeLamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/bathroom2/tubeLamp.png'
  },
  {
    title: '卧室2窗帘',
    deviceType: 'windowCurtains',
    index: 6,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/bedroom2/windowCurtains.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/bedroom2/windowCurtains.png'
  },
  {
    title: '卧室2灯带',
    deviceType: 'lamp',
    index: 6,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/bedroom2/lamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/bedroom2/lamp.png'
  },
  {
    title: '卧室2调光灯1',
    deviceType: 'dimmer',
    index: 6,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/bedroom2/dimmer.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/bedroom2/dimmer.png'
  },
  {
    title: '卧室2调光灯2',
    deviceType: 'dimmer',
    index: 6,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/bedroom2/dimmer2.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/bedroom2/dimmer2.png'
  },
  {
    title: '卧室2筒灯',
    deviceType: 'tubeLamp',
    index: 6,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/bedroom2/tubeLamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/bedroom2/tubeLamp.png'
  },
  {
    title: '主人浴室灯带',
    deviceType: 'lamp',
    index: 7,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/masterBathroom/lamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/masterBathroom/lamp.png'
  },
  {
    title: '主人浴室筒灯',
    deviceType: 'tubeLamp',
    index: 7,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/masterBathroom/tubeLamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/masterBathroom/tubeLamp.png'
  },
  {
    title: '主人衣帽间筒灯',
    deviceType: 'tubeLamp',
    index: 8,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/masterCloakroom/tubeLamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/masterCloakroom/tubeLamp.png'
  },
  {
    title: '主人睡房窗帘',
    deviceType: 'windowCurtains',
    index: 9,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/masterBedroom/windowCurtains.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/masterBedroom/windowCurtains.png'
  },
  {
    title: '主人睡房灯带',
    deviceType: 'lamp',
    index: 9,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/masterBedroom/lamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/masterBedroom/lamp.png'
  },
  {
    title: '主人睡房调光灯1',
    deviceType: 'dimmer',
    index: 9,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/masterBedroom/dimmer.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/masterBedroom/dimmer.png'
  },
  {
    title: '主人睡房调光灯2',
    deviceType: 'dimmer',
    index: 9,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/masterBedroom/dimmer2.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/masterBedroom/dimmer2.png'
  },
  {
    title: '主人睡房筒灯',
    deviceType: 'tubeLamp',
    index: 9,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/masterBedroom/tubeLamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/masterBedroom/tubeLamp.png'
  },
  {
    title: '客厅窗帘',
    deviceType: 'windowCurtains',
    index: 10,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/parlour/windowCurtains.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/parlour/windowCurtains.png'
  },
  {
    title: '客厅灯带',
    deviceType: 'lamp',
    index: 10,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/parlour/lamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/parlour/lamp.png'
  },
  {
    title: '客厅筒灯',
    deviceType: 'tubeLamp',
    index: 10,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/parlour/tubeLamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/parlour/tubeLamp.png'
  },
  {
    title: '客厅洗墙灯',
    deviceType: 'wallLamp',
    index: 10,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/parlour/wallLamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/parlour/wallLamp.png'
  },
  {
    title: '浴室1筒灯',
    deviceType: 'tubeLamp',
    index: 11,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/bathroom1/tubeLamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/bathroom1/tubeLamp.png'
  },
  {
    title: '玄关灯带',
    deviceType: 'lamp',
    index: 12,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/porch/lamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/porch/lamp.png'
  },
  {
    title: '玄关筒灯',
    deviceType: 'tubeLamp',
    index: 12,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/porch/tubeLamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/porch/tubeLamp.png'
  },
  {
    title: '化妆间筒灯',
    deviceType: 'tubeLamp',
    index: 13,
    isOpen: false,
    isShow: true,
    img: './static/images/apartmentLayoutDiagram/b/whole/dressingRoom/tubeLamp.png',
    isAlone: false,
    imgAlone: './static/images/apartmentLayoutDiagram/b/alone/dressingRoom/tubeLamp.png'
  }
];

export {
  roomTypeList,
  equipmentList
};
