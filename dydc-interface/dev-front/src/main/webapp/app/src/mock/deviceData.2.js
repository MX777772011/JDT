const roomTypeList = [
  {
    title: '玄关',
    roomType: 0,
    roomId: 1,
    isHasDimmer: false
  },
  {
    title: '客厅',
    roomType: 1,
    roomId: 2,
    isHasDimmer: false
  }
];

const equipmentList = [
  {
    roomId: 1,
    title: '玄关筒灯',
    deviceType: 'tubeLamp',
    deviceIndex: 0,
    isOpen: 1
  },
  {
    roomId: 2,
    title: '客厅窗帘',
    deviceType: 'windowCurtains',
    deviceIndex: 0,
    isOpen: 1
  },
  {
    roomId: 2,
    title: '客厅灯带',
    deviceType: 'lamp',
    deviceIndex: 1,
    isOpen: 1
  },
  {
    roomId: 2,
    title: '客厅筒灯',
    deviceType: 'tubeLamp',
    deviceIndex: 2,
    isOpen: 1
  },
  {
    roomId: 2,
    title: '客厅洗墙灯',
    deviceType: 'wallLamp',
    deviceIndex: 3,
    isOpen: 1
  },
  {
    roomId: 2,
    title: '客厅顶灯',
    deviceType: 'pendant',
    deviceIndex: 4,
    isOpen: 1
  }
];

export {
  roomTypeList,
  equipmentList
};
