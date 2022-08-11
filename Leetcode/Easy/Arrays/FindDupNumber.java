// Example 1:
// Input: nums = [1,3,4,2,2]
// Output: 2

// Example 2:
// Input: nums = [3,1,3,4,2]
// Output: 3

import java.util.*;

class Solution {
  //hashSet
  public int findDuplicate(int[] nums) {
      HashSet<Integer> set = new HashSet<>();
      for(int i = 0; i<nums.length-1; i++) {
          set.add(nums[i]);
          if (set.contains(nums[i+1])) {
              return nums[i+1];
          }
      }
      return -1;
  }

  //HashSet 2
  public int findDuplicate2(int[] nums) {
    Set<Integer> seen = new HashSet<Integer>();
    for (int num : nums) {
        if (seen.contains(num))
            return num;
        seen.add(num);
    }
    return -1;
  }

  //Negative marking
  public int findDuplicate3(int[] nums) {
    int duplicate = -1;
    for (int i = 0; i < nums.length; i++) {
        int cur = Math.abs(nums[i]);
        if (nums[cur] < 0) {
            duplicate = cur;
            break;
        }
        nums[cur] *= -1;
    }
    
    // Restore numbers
    for (int i = 0; i < nums.length; i++)
        nums[i] = Math.abs(nums[i]);

    return duplicate;
  }
}