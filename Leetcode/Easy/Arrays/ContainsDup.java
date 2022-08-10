// Example 1:
// Input: nums = [1,2,3,1]
// Output: true

// Example 2:
// Input: nums = [1,2,3,4]
// Output: false

// Example 3:
// Input: nums = [1,1,1,3,3,4,3,2,4,2]
// Output: true

package Leetcode.Easy.Arrays;
import java.util.*;

class Solution {
  //using hashSet
  public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for(int i = 0; i<nums.length-1; i++) {
        set.add(nums[i]);
        if (set.contains(nums[i+1])) {
            return true;
        }
    }
    return false;
  }

  public boolean containsDuplicate2(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int value = 0;
    for(Integer num: nums){
      if (map.containsKey(num)) {
          return true;
      } else map.put(num, value+=1);
    }
    return false;
}
}
