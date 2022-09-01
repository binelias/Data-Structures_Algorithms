// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You must write an algorithm with O(log n) runtime complexity.


// Example 1:
// Input: nums = [1,3,5,6], target = 5
// Output: 2

// Example 2:
// Input: nums = [1,3,5,6], target = 2
// Output: 1

// Example 3:
// Input: nums = [1,3,5,6], target = 7
// Output: 4

package Leetcode.Algorithm I.Binary Search;

public class SearchInsertPos {
  //Binary search
  public int searchInsert(int[] nums, int target) {
    int low = 0, high = nums.length;
    while(low < high){
      // when odd, return the only mid
      // when even, return the lower mid
      int mid = low + (int)Math.floor((high - low)/2);
      if(target > nums[mid]) low = mid + 1;
      else  high = mid;
    }
    return low;
  }
}
