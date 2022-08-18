// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

// Example 3:
// Input: nums = [], target = 0
// Output: [-1,-1]

const binarySearch = (nums, left, right, target) => {
  while(left <= right) {
      const mid = Math.floor((left + right)/2);
      const foundVal = nums[mid];
      if(foundVal === target) return mid;
      else if(foundVal < target) left = mid + 1;
      else right = mid - 1;
  }
  return -1;
}

const searchRange = function(nums, target) {
  const firstPos = binarySearch(nums, 0, nums.length -1, target);
  if(nums.length < 1) return [-1, -1];
  if(firstPos === -1) return [-1, -1];
  
  let endPos = firstPos, startPos = firstPos, temp1, temp2;
  
  while(startPos !== -1) {
      temp1 = startPos;
      startPos = binarySearch(nums, 0, startPos -1, target);
  }
  startPos = temp1;
  
  while(endPos !== -1) {
      temp2 = endPos;
      endPos = binarySearch(nums, endPos + 1, nums.length - 1, target);
  }
  endPos = temp2;
  return [startPos, endPos];
};//T: O(logn), S: O(1)