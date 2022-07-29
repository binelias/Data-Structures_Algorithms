// array of integers, return the indices of 2 numbers that add up to a given target
//Input: 2 arguments, an array of integers, target
//Output: 2 indices of add up to target

//Step1: Verify the constraints:
  //1.are all numbers positive/negative or both? all numbers are positive
  //2.are there duplicate numbers?No
  //3.will there be a solution available? No
  //4.what do we return if there's no soln? return null
  //5.can there be multiple pairs that add up to target?No, only one pair

//Step 2: write out some test cases
  // input[1,3,7,9,2] t=11 
  // out[3,4]

  // input[1,3,7,9,2] t=25 
  // out null

  // input[] t=1 
  // out null

  // input[5] t=5 
  // out null

  // input[1,6] t=7
  // out[0,1]

//Step3: Figure out Soln w/out code
  // formula:
  // numberToFind = target- nums[P1]
  // so numberTofind is P2

//Step4: Write the code

const findTwoSum = function(nums,target) {
  for(let P1 =0; P1<nums.length; P1++) {
    const numberToFind = target - nums[P1];
    for(P2 = P1+1; P2<nums.length; P2++) {
      if(numberToFind === nums[p2]) {
        return [P1,P2]
      }
    }
  }
  return null;
}
//O(n^2)

//Step 5: double check for errors
//Step 6: test our code w/ our test cases
//Step 7: space & time complexity

var findTwoSum1 = function(nums, target) {
  //{numberTofind:index}
  const numsMap = {};
  for(let p = 0; p < nums.length; p++){
    const currentMapVal = numsMap[nums[p]];
    if(currentMapVal >=0) {
      return [currentMapVal,p];
    }else {
      const numberTofind = target - nums[p];
      numsMap[numberTofind] =p;
    }
  }
  return null;
};
//O(n)

var findTwoSum2 = function(nums, target) {
  const numsMap = new Map();
  for(let p = 0; p < nums.length; numsMap.set(nums[p],p++)){
      if(numsMap.has(target - nums[p])) {
        return [numsMap.get(target-nums[p]),p];
      }
  }
  return null;
};
//O(n)






