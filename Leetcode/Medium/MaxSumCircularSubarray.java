// Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

// A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

// A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

// Example 1:

// Input: nums = [1,-2,3,-2]
// Output: 3
// Explanation: Subarray [3] has maximum sum 3.
// Example 2:

// Input: nums = [5,-3,5]
// Output: 10
// Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
// Example 3:

// Input: nums = [-3,-2,-3]
// Output: -2
// Explanation: Subarray [-2] has maximum sum -2.

// Constraints:

// n == nums.length
// 1 <= n <= 3 * 104
// -3 * 104 <= nums[i] <= 3 * 104

// Approach: Calculate the "Minimum Subarray"
// Intuition
// As mentioned before, we know that the maximum "normal sum" is the Maximum Subarray problem which can be found with Kadane's. As such, we can focus on finding the "special sum".

// Instead of thinking about the "special sum" as the sum of a prefix and a suffix, we can think about it as the sum of all elements, minus a subarray in the middle. In this case, we want to minimize this middle subarray's sum, which we can calculate using Kadane's algorithm as well.

// Details to consider:

// The minimum subarray contains at least one element which means the "special sum" never contains all elements. This is fine since the "normal sum" already takes the whole array as a candidate.

// If the minimum subarray contains all elements, the "special sum" will be an empty array which is invalid. In this case, all prefix or suffix sums are non-positive (otherwise, we could remove the prefix or suffix from the elements to obtain a subarray with a lower sum). So any "special sum" is non-positive. Consider 2 sub-cases:

// 2.1. The "normal sum" is non-negative, in this case, it's always the final answer since it's no less than the "special sum" which is 0 (because in this case, the "special sum" would be the sum of an empty array).

// 2.2. The "normal sum" is negative, recall that the "normal sum" takes any single element as its candidate too, this means all the elements are negative and the "normal sum" is the overall largest element, which is the final answer.

// As you can see, in both cases when the minimum subarray contains all elements, the final answer is the "normal sum". We can tell if the minimum subarray contains all elements by also calculating the total sum of the array.

// Algorithm
// Calculate the maximum subarray maxSum using Kadane's algorithm.
// Calculate the minimum subarray minSum using Kadane's algorithm, by using Math.min() instead of Math.max().
// Calculate the sum of all the elements in nums, sum
// If minSum == sum return maxSum, otherwise return max(maxSum, sum - minSum).

class Solution {
  public int maxSubarraySumCircular(int[] nums) {
      int curMax = 0, curMin = 0, sum = 0, maxSum = nums[0], minSum = nums[0];
      for (int num : nums) {
          curMax = Math.max(curMax, 0) + num;
          maxSum = Math.max(maxSum, curMax);
          curMin = Math.min(curMin, 0) + num;
          minSum = Math.min(minSum, curMin);
          sum += num;  
      }
      return sum == minSum ? maxSum : Math.max(maxSum, sum - minSum);
  }