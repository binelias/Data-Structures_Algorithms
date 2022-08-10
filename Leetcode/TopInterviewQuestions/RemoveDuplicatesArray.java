// Example 1:
// Input: nums = [1,1,2]
// Output: [1,2]
// Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).

// Example 2:
// Input: nums = [0,0,1,1,1,2,2,3,3,4]
// Output: [0,1,2,3,4]
// Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).

package Leetcode.TopInterviewQuestions;

public class RemoveDuplicatesArray {
  public int removeDuplicates(int[] nums) {
    int i = 1;
    for(int num: nums) {
      if(num>nums[i-1]) nums[i++] = num;
    }
    return i;  
  }  
}
