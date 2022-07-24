// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]

var twoSum = function(nums, target) {
  //{numberTofind:index}
  const numsMap = {};
  for(let p = 0; p < nums.length; p++){
    if(numsMap[nums[p]] >=0) {
      return [numsMap[nums[p]],p];
    }else {
      const numberTofind = target - nums[p];
      numsMap[numberTofind] =p;
    }
  }
  return null;
};