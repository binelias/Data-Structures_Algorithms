// Given an array of integers rep an elevation map where the width of each bar is 1, return how much rainwater can be trapped.

// Step1: Constraints
// Do the left and right sides of the graph count as walls? No
// will there be neg integers? No

// step2: testCases
// [0,1,0,2,1,0,3,1,0,1,2] 8
// [] 0
// [3] 0
// [3,4,3,] 0

// step3: figure out a  solution w/out code

// const current water = min(maxL, maxR) - cH
// total = 0
// maxL = 0
// maxR =3

// step4:code
//Brute force
const getTrappedRainwater = function(height) {
  let totalWater = 0;
  for(let p = 0; p < height.length; p++) {
    let leftP = p, rightP= p, maxLeft = 0, maxRight = 0; 
    while(leftP >= 0) {
      maxLeft = Math.max(maxLeft, height[leftP]);
      leftP--;
    }
    while(rightP < height.length ) {
      maxRight = Math.max(maxRight, height[rightP]);
      rightP++;
    }

    const currentWater = Math.min(maxLeft, maxRight) - height[p];
    if(currentWater >=0) {
      totalWater += currentWater;
    }
  }
  return totalWater;
}//time limit exceeded
//t: O(n^2), S: O(1) 

//optimal code using 2 pointers outside
// const currentWater = min(maxL, maxR) - currentHeight
//logical steps
// 1. Identify pointer w/ lesser value
// 2. Is this pointer value lesser than or equal to the max on that side
//   yes - update max on that side
//   no - get water for point. add to total
// 3. move pointer inwards
// 4. repeat fo other pointer


const getTrappedRainwater = function(height) {
  let left = 0, right = height.length-1, totalWater=0, maxLeft = 0, maxRight = 0;

  while(left < right) {
    if(height[left] <=  height[right]) {
      if(height[left] >= maxLeft) {
        maxLeft = height[left];
      }else {
        totalWater += maxLeft - height[left];
      }
      left++;
    }else {
      if(height[right] >= maxRight) {
        maxRight = height[right];
      }else {
        totalWater += maxRight - height[right];
      }
      right--;
    }
  }
  return totalWater;
}//t: O(n), s: O(1)