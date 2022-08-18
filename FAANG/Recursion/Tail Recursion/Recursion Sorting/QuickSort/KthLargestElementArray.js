// Given an integer array nums and an integer k, return the kth largest element in the array.

// Note that it is the kth largest element in the sorted order, not the kth distinct element.

// You must solve it in O(n) time complexity.

// Example 1:
// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5

// Example 2:
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
// Output: 4

//QuickSort Recursion 
const swap = function(nums, i, j) {
  const temp = nums[i];
  nums[i] = nums[j];
  nums[j] = temp;
}

//QuickSort Recursion
const getPartition = function(nums, left, right) {
  const pivotElement = nums[right];
  let partitionIdx = left;
  
  for(let j  = left; j < right; j++) {
      if(nums[j] <= pivotElement) {
          swap(nums, partitionIdx, j);
          partitionIdx++;
      }
  }
  swap(nums, partitionIdx, right);
  return partitionIdx;
  
}
const quickSort = function (nums, left, right) {
  if(left < right) {
      const partitionIdx = getPartition(nums, left, right);
      quickSort(nums, left, partitionIdx - 1);
      quickSort(nums, partitionIdx + 1, right);
  }
}

const findKthLargest = function(nums, k) {
  const idxToFind = nums.length - k;
  quickSort(nums, 0, nums.length-1);
  return nums[idxToFind];
}; //T: O(nlogn), S: O(logn)

//Hoare's Quickselect Algorithm
const getPartition2 = function(nums, left, right) {
  let i = left;
  
  for(let j  = left; j <= right; j++) {
      if(nums[j] <= nums[right]) {
          swap(nums, i, j);
          i++;
      }
  }
  return i - 1;
  
}
const quickSelect = function (nums, left, right, idxToFind) {
  const partitionIdx = getPartition2(nums, left, right);
  
  if(partitionIdx === idxToFind) return nums[partitionIdx];
  else if(idxToFind < partitionIdx) return quickSelect(nums, left, partitionIdx - 1, idxToFind);
  else return quickSelect(nums, partitionIdx + 1, right, idxToFind);
}//T: O(n^2) or O(n), S: O(1)

const findKthLargest2 = function(nums, k) {
  const idxToFind = nums.length - k;
  return quickSelect(nums, 0, nums.length - 1, idxToFind);
};
