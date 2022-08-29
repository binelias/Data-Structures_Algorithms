// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
import java.util.*;

public class twoSum {
  public int[] twoSum(int[] nums, int target) {
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int i = 0; i < nums.length; map.put(nums[i],i++)) {
        if (map.containsKey(target - nums[i])) 
          return new int[]{map.get(target - nums[i]),i};
      }
      return new int[]{0,0};
  }
}

