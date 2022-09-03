// Given an array, rotate the array to the right by k steps, where k is non-negative.


// Example 1:
// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]

// Example 2:
// Input: nums = [-1,-100,3,99], k = 2
// Output: [3,99,-1,-100]
// Explanation: 
// rotate 1 steps to the right: [99,-1,-100,3]
// rotate 2 steps to the right: [3,99,-1,-100]

package Leetcode.Algorithm I.TwoPointers;

public class RotateArray {
  private void reverse(int[] nums, int i, int j) {
    int temp = 0;
    while(i < j) {
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        i++;
        j--;
    }
  }

  public void rotate(int[] nums, int k) {
      //corner cases
      if(nums == null || nums.length < 2) return;
      
      k = k % nums.length;
      reverse(nums, 0, nums.length - k - 1);
      reverse(nums, nums.length - k, nums.length -1);
      reverse(nums, 0, nums.length - 1);
  }
}
