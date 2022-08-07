// You are given an array of positive integers where each integer rep the height of vert line on a chart. Find two lines which together with the x-axis forms a container that would hold the greatest amt of water. Return the area of water it would hold.

// Input
// [1,8,6,2,9,4]

// Output
// [8,9]
// area = 8*3 = 24


// Step1: Constraint
// Does thick affect area? No
// do left and right sides of graph count as walls? no
// does higher line inside our contaier affect area? no

// Step2: testCases
// [7,1,2,3,9] 7x4 = 28
// []  0
// [7] 0
// [6,9,3,4,5,8] 8x4 = 32

// Step3:soln w/out code
// min(a,b) x (bi-ai)

//Step4: code

//Brute force
//Time Limit Exceeded in leetcode
const maxArea = function(height) {
  let maxxArea = 0;
  for (let i = 0; i < height.length; i++) {
      for (let j = i+1; j < height.length; j++) {
        const heights = Math.min(height[i],height[j]);
        const width = j-i;
        const area = heights*width;
        maxxArea = Math.max(maxxArea, area);
      } 
  }
  return maxxArea;
}// T: O(n^2) Space: O(1)

//optimal soln
// one left pointer and right pointer moving to it
// area = min(a,b) x (bi-ai)

const maxArea1 = function(height) {
  let p1 = 0, p2 = height.length-1, maxxArea = 0;
  while(p1<p2) {
      const heights = Math.min(height[p1],height[p2]);
      const width = p2-p1;
      const area = heights*width;
      maxxArea = Math.max(maxxArea, area);

      if(height[p1] <= height[p2]) p1++;
      else p2--;
  }
  return maxxArea;
};






