const house = {
  'c': {
    roomList: ['porch', 'parlour', 'bedroom1', 'cloakroom1', 'bathroom1', 'bedroom2', 'cloakroom2', 'bathroom2', 'bedroom3', 'corridor2', 'bathroom3', 'study', 'restaurant', 'corridor1']
  }
};
console.log(house);

export default {
  install (Vue, options) {
    Vue.prototype.roomBg = function (item) {
      if (item.roomid == '') {
        return './static/images/houseType/' + 'c' + '/' + 'bg.png';
      }
      return './static/images/houseType/' + 'c' + '/' + house['c'].roomList[item.roomindex] + '/' + 'bg.png';
    };
    Vue.prototype.deviceImg = function (item, checkroomid) {
      let isAlone = item.roomid == checkroomid ? '_alone' : '_whole';
      return './static/images/houseType/' + 'c' + '/' + house['c'].roomList[item.roomindex] + '/' + item.deviceindex + '_' + item.devicetype + isAlone + '.png';
    };
  }
};
