const equipmentList = [
  {
    title: '玄关',
    roomType: 'lobby',
    roomId: 1,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/c/alone/porch/porch.png',
    isHasDimmer: false,
    roomDeviceList: [{
      title: '玄关筒灯',
      deviceType: 'lamp',
      index: 1,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/porch/tubeLamp.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/porch/tubeLamp.png'
    }]
  },
  {
    title: '客厅',
    roomType: 'lobby',
    roomId: 2,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/c/alone/parlour/parlour.png',
    isHasDimmer: false,
    roomDeviceList: [{
      title: '客厅窗帘',
      deviceType: 'curtain',
      index: 2,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/parlour/windowCurtains.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/parlour/windowCurtains.png'
    },
    {
      title: '客厅灯带',
      deviceType: 'lamp',
      index: 2,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/parlour/lamp.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/parlour/lamp.png'
    },
    {
      title: '客厅筒灯',
      deviceType: 'lamp',
      index: 2,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/parlour/tubeLamp.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/parlour/tubeLamp.png'
    },
    {
      title: '客厅洗墙灯',
      deviceType: 'lamp',
      index: 2,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/parlour/wallLamp.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/parlour/wallLamp.png'
    },
    {
      title: '客厅顶灯',
      deviceType: 'lamp',
      index: 2,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/parlour/pendant.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/parlour/pendant.png'
    }]
  },
  {
    title: '主人睡房',
    roomType: 'bedroom',
    roomId: 3,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/c/alone/masterBedroom/masterBedroom.png',
    isHasDimmer: true,
    roomDeviceList: [
      {
        title: '主人睡房窗帘',
        deviceType: 'curtain',
        index: 3,
        isOpen: false,
        isShow: true,
        img: './static/images/apartmentLayoutDiagram/c/whole/masterBedroom/windowCurtains.png',
        isAlone: false,
        imgAlone: './static/images/apartmentLayoutDiagram/c/alone/masterBedroom/windowCurtains.png'
      },
      {
        title: '主人睡房灯带',
        deviceType: 'lamp',
        index: 3,
        isOpen: false,
        isShow: true,
        img: './static/images/apartmentLayoutDiagram/c/whole/masterBedroom/lamp.png',
        isAlone: false,
        imgAlone: './static/images/apartmentLayoutDiagram/c/alone/masterBedroom/lamp.png'
      },
      {
        title: '主人睡房调光灯1',
        deviceType: 'dimminglight',
        index: 3,
        isOpen: false,
        isShow: true,
        img: './static/images/apartmentLayoutDiagram/c/whole/masterBedroom/dimmer.png',
        isAlone: false,
        imgAlone: './static/images/apartmentLayoutDiagram/c/alone/masterBedroom/dimmer.png'
      },
      {
        title: '主人睡房调光灯2',
        deviceType: 'dimminglight',
        index: 3,
        isOpen: false,
        isShow: true,
        img: './static/images/apartmentLayoutDiagram/c/whole/masterBedroom/dimmer2.png',
        isAlone: false,
        imgAlone: './static/images/apartmentLayoutDiagram/c/alone/masterBedroom/dimmer2.png'
      },
      {
        title: '主人睡房筒灯',
        deviceType: 'lamp',
        index: 3,
        isOpen: false,
        isShow: true,
        img: './static/images/apartmentLayoutDiagram/c/whole/masterBedroom/tubeLamp.png',
        isAlone: false,
        imgAlone: './static/images/apartmentLayoutDiagram/c/alone/masterBedroom/tubeLamp.png'
      }
    ]
  },
  {
    title: '主人衣帽间',
    roomType: 'lobby',
    roomId: 4,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/c/alone/masterCloakroom/masterCloakroom.png',
    isHasDimmer: false,
    roomDeviceList: [{
      title: '主人衣帽间筒灯',
      deviceType: 'lamp',
      index: 4,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/masterCloakroom/tubeLamp.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/masterCloakroom/tubeLamp.png'
    }]
  },
  {
    title: '主人浴室',
    roomType: 'toilet',
    roomId: 5,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/c/alone/masterBathroom/masterBathroom.png',
    isHasDimmer: false,
    roomDeviceList: [{
      title: '主人浴室筒灯',
      deviceType: 'lamp',
      index: 5,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/masterBathroom/tubeLamp.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/masterBathroom/tubeLamp.png'
    }]
  },
  {
    title: '餐厅',
    roomType: 'diningroom',
    roomId: 6,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/c/alone/restaurant/restaurant.png',
    isHasDimmer: false,
    roomDeviceList: [{
      title: '餐厅灯带',
      deviceType: 'lamp',
      index: 6,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/restaurant/lamp.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/restaurant/lamp.png'
    },
    {
      title: '餐厅吊灯',
      deviceType: 'lamp',
      index: 6,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/restaurant/pendant.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/restaurant/pendant.png'
    },
    {
      title: '餐厅筒灯',
      deviceType: 'lamp',
      index: 6,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/restaurant/tubeLamp.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/restaurant/tubeLamp.png'
    }]
  },
  {
    title: '书房',
    roomType: 'study',
    roomId: 7,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/c/alone/study/study.png',
    isHasDimmer: false,
    roomDeviceList: [{
      title: '书房筒灯',
      deviceType: 'lamp',
      index: 7,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/study/tubeLamp.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/study/tubeLamp.png'
    },
    {
      title: '书房灯带',
      deviceType: 'curtain',
      index: 7,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/study/lamp.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/study/lamp.png'
    }]
  },
  {
    title: '走廊',
    roomType: 'lobby',
    roomId: 8,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/c/alone/corridor1/corridor.png',
    isHasDimmer: false,
    roomDeviceList: [{
      title: '走廊筒灯',
      deviceType: 'lamp',
      index: 8,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/corridor1/tubeLamp.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/corridor1/tubeLamp.png'
    }]
  },
  {
    title: '次卧走廊',
    roomType: 'lobby',
    roomId: 9,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/c/alone/corridor2/corridor.png',
    isHasDimmer: false,
    roomDeviceList: [{
      title: '次卧走廊筒灯',
      deviceType: 'lamp',
      index: 9,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/corridor2/tubeLamp.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/corridor2/tubeLamp.png'
    }]
  },
  {
    title: '次卧卧室',
    roomType: 'bedroom',
    roomId: 10,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/c/alone/bedroom2/bedroom.png',
    isHasDimmer: true,
    roomDeviceList: [{
      title: '次卧室窗帘',
      deviceType: 'curtain',
      index: 10,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/bedroom2/windowCurtains.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/bedroom2/windowCurtains.png'
    },
    {
      title: '次卧室灯带',
      deviceType: 'lamp',
      index: 10,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/bedroom2/lamp.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/bedroom2/lamp.png'
    },
    {
      title: '卧室调光灯1',
      deviceType: 'dimminglight',
      index: 10,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/bedroom2/dimmer.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/bedroom2/dimmer.png'
    },
    {
      title: '卧室调光灯2',
      deviceType: 'dimminglight',
      index: 10,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/bedroom2/dimmer2.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/bedroom2/dimmer2.png'
    },
    {
      title: '卧室筒灯',
      deviceType: 'lamp',
      index: 10,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/bedroom2/tubeLamp.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/bedroom2/tubeLamp.png'
    }]
  },
  {
    title: '卫生间',
    roomType: 'toilet',
    roomId: 11,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/c/alone/bedroom2Bathroom/bedroom2Bathroom.png',
    isHasDimmer: false,
    roomDeviceList: [{
      title: '卫生间筒灯',
      deviceType: 'lamp',
      index: 11,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/bedroom2Bathroom/tubeLamp.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/bedroom2Bathroom/tubeLamp.png'
    }]
  },
  {
    title: '客人卧室',
    roomType: 'bedroom',
    roomId: 12,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/c/alone/bedroom/bedroom.png',
    isHasDimmer: true,
    roomDeviceList: [{
      title: '客人卧室窗帘',
      deviceType: 'curtain',
      index: 12,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/bedroom/windowCurtains.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/bedroom/windowCurtains.png'
    },
    {
      title: '客人卧室灯带',
      deviceType: 'lamp',
      index: 12,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/bedroom/lamp.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/bedroom/lamp.png'
    },
    {
      title: '客人卧室调光灯1',
      deviceType: 'dimminglight',
      index: 12,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/bedroom/dimmer.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/bedroom/dimmer.png'
    },
    {
      title: '客人卧室调光灯2',
      deviceType: 'dimminglight',
      index: 12,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/bedroom/dimmer2.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/bedroom/dimmer2.png'
    },
    {
      title: '客人卧室筒灯',
      deviceType: 'lamp',
      index: 12,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/bedroom/tubeLamp.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/bedroom/tubeLamp.png'
    }]
  },
  {
    title: '客卧卫生间',
    roomType: 'toilet',
    roomId: 13,
    isCheck: false,
    img: './static/images/apartmentLayoutDiagram/c/alone/bathroom1/bathroom.png',
    isHasDimmer: false,
    roomDeviceList: [{
      title: '客人浴室筒灯',
      deviceType: 'lamp',
      index: 13,
      isOpen: false,
      isShow: true,
      img: './static/images/apartmentLayoutDiagram/c/whole/bathroom1/tubeLamp.png',
      isAlone: false,
      imgAlone: './static/images/apartmentLayoutDiagram/c/alone/bathroom1/tubeLamp.png'
    }]
  }
];

export {
  equipmentList
};
