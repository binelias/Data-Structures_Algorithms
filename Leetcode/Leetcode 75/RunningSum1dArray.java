// Example 1:
// Input: nums = [1,2,3,4]
// Output: [1,3,6,10]
// Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

// Example 2:
// Input: nums = [1,1,1,1,1]
// Output: [1,2,3,4,5]
// Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].

// Example 3:
// Input: nums = [3,1,2,10,1]
// Output: [3,4,6,16,17]

package Leetcode.Leetcode 75;

public class RunningSum1dArray {
  //Using Input Array for Output
  public int[] runningSum(int[] nums) {
    for(int i = 1; i < nums.length; i++) {
        nums[i] += nums[i-1];
    }
    return nums;
  }//T: O(n), S:O(1)

  // Using Separate Space
  public int[] runningSum(int[] nums) {
    int result[] = new int[nums.length];
    result[0] = nums[0];
    
    for(int i = 1; i < nums.length; i++) {
        result[i] = result[i-1] + nums[i];
    }
    return result;
  }//T: O(n), S:O(1)
}
