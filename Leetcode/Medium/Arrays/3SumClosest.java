// Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

// Return the sum of the three integers.

// You may assume that each input would have exactly one solution.


// Example 1:
// Input: nums = [-1,2,1,-4], target = 1
// Output: 2
// Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

// Example 2:
// Input: nums = [0,0,0], target = 1
// Output: 0

class Solution {
  //Three Pointers
  public int threeSumClosest(int[] nums, int target) {
      Arrays.sort(nums);
      int min = Integer.MAX_VALUE;
      int ans = 0;
      for(int i = 0; i < nums.length; ++i) {
          int j = i + 1;
          int k = nums.length - 1;
          while(j < k) {
              int sum = nums[i] + nums[j] + nums[k];
              if(min > Math.abs(target - sum)) {
                  min = Math.abs(target - sum);
                  ans  =sum;
              }
              if(sum > target) --k;
              else if(sum < target) ++j;
              else return sum;
          }
      }
      return ans;
      
  }//T:O(nlogn)
}