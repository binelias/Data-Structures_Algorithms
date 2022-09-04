// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.


// Example 1:
// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]

// Example 2:
// Input: nums = [0]
// Output: [0]

package Leetcode.Algorithm I.TwoPointers;

public class MoveZeroes {
  //two pointer swap 
  public void moveZeroes(int[] nums) {
    int first = 0;
    int second = 0;
    while(first < nums.length) {
        if(nums[first] != 0) {
            int temp = nums[first];
            nums[first] = nums[second];
            nums[second] = temp;
            second++;
        }
        first++;
    }
  }

  public void moveZeroes2(int[] nums) {
    int nonZero = 0;
    
    for(int i = 0; i < nums.length; i++) {
        if(nums[i] != 0) {
            nums[nonZero++] = nums[i];
        }
    }
    
    for(int i = nonZero; i < nums.length; i++) {
        nums[i] = 0;
    }
  }//T:O(n), S:O(1)
}
