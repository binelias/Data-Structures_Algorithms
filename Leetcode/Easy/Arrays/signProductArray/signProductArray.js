var arraySign = function(nums) {
  let negative = 0;
  for (let num of nums){
    if (num < 0){
      negative++;
    }else if (num === 0){
      return 0;
    }
  }
  return (negative & 1) === 0 ? 1 : -1;
};