// div占满剩余空间方法  *注  tarEle:目标元素; othersEle:目标兄弟元素; warpper:目标父元素;
export function FillTheRemainingSpace (tarEle, othersEle, warpper) {
  console.log(warpper);
  var warpperHeight = warpper.offsetHeight;
  var othersHeight = 0;
  for (var i = 0; i < othersEle.length; i++) {
    othersHeight += othersEle[i].offsetHeight;
  }
  tarEle.style.height = (warpperHeight - othersHeight) + 'px';
}
