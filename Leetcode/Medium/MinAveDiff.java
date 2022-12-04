// You are given a 0-indexed integer array nums of length n.

// The average difference of the index i is the absolute difference between the average of the first i + 1 elements of nums and the average of the last n - i - 1 elements. Both averages should be rounded down to the nearest integer.

// Return the index with the minimum average difference. If there are multiple such indices, return the smallest one.

// Note:

// The absolute difference of two numbers is the absolute value of their difference.
// The average of n elements is the sum of the n elements divided (integer division) by n.
// The average of 0 elements is considered to be 0.

// Example 1:

// Input: nums = [2,5,3,9,5,3]
// Output: 3
// Explanation:
// - The average difference of index 0 is: |2 / 1 - (5 + 3 + 9 + 5 + 3) / 5| = |2 / 1 - 25 / 5| = |2 - 5| = 3.
// - The average difference of index 1 is: |(2 + 5) / 2 - (3 + 9 + 5 + 3) / 4| = |7 / 2 - 20 / 4| = |3 - 5| = 2.
// - The average difference of index 2 is: |(2 + 5 + 3) / 3 - (9 + 5 + 3) / 3| = |10 / 3 - 17 / 3| = |3 - 5| = 2.
// - The average difference of index 3 is: |(2 + 5 + 3 + 9) / 4 - (5 + 3) / 2| = |19 / 4 - 8 / 2| = |4 - 4| = 0.
// - The average difference of index 4 is: |(2 + 5 + 3 + 9 + 5) / 5 - 3 / 1| = |24 / 5 - 3 / 1| = |4 - 3| = 1.
// - The average difference of index 5 is: |(2 + 5 + 3 + 9 + 5 + 3) / 6 - 0| = |27 / 6 - 0| = |4 - 0| = 4.
// The average difference of index 3 is the minimum average difference so return 3.
// Example 2:

// Input: nums = [0]
// Output: 0
// Explanation:
// The only index is 0 so return 0.
// The average difference of index 0 is: |0 / 1 - 0| = |0 - 0| = 0.

// Approach 2: Prefix Sum
// Intuition
// First of all, if you don't know, prefix sum is the technique where we generate a prefix array, and it's each element at (i + 1)th index stores the cumulative sum of all array elements from index 0 to index i.

// If you carefully notice, when in the previous approach at each index i, we needed sum of all elements of nums array from index 0 to index i, thus we can conclude that we can use a prefix array instead of iterating again on all elements.

// Just like, prefix sums, we can store suffix sum for the nums array to get the sum of all elements from index i + 1 till last index in optimal way. Let's understand this with the following example:

// prefix_suffix_example

// Algorithm
// Initialize variables:

// n, integer to store the number of elements in the array.
// minAvgDiff, initialized with a large integer value, stores the minimum average difference.
// ans, integer to store the index where we found the minimum average difference.
// prefixSum, suffixSum, integer arrays to store prefix and suffix sums for the nums array.
// Precompute prefix and suffix sums for the nums array.

// For prefix sum, iterate from start to end and add the current element to the previous prefix sum.
// For suffix sum, iterate from end to start and add the current element to the previous suffix sum.
// Iterate over each index of the nums array:

// At each index i, get the sum of all elements of the nums array from index 0 to index i stored in prefixSum[i + 1], and divide the sum by i + 1 to get the average of the left part of the array.
// Similarly, get the sum of elements from index i +1 to n - 1 stored in suffix[i + 1], and divide by n - i - 1 to get the average of the right part of the array.
// If the difference between the average of the left and right part of the array is smaller than minAvgDiff, then store this difference in minAvgDiff and the current index i in ans.
// Return ans.

class Solution {
  public int minimumAverageDifference(int[] nums) {
    int n = nums.length;
    int ans = -1;
    int minAvgDiff = Integer.MAX_VALUE;

    // Generate prefix and suffix sum arrays.
    long[] prefixSum = new long[n + 1];
    long[] suffixSum = new long[n + 1];

    for (int index = 0; index < n; ++index) {
      prefixSum[index + 1] = prefixSum[index] + nums[index];
    }

    for (int index = n - 1; index >= 0; --index) {
      suffixSum[index] = suffixSum[index + 1] + nums[index];
    }

    for (int index = 0; index < n; ++index) {
      // Calculate average of left part of array, index 0 to i.
      long leftPartAverage = prefixSum[index + 1];
      leftPartAverage /= (index + 1);

      // Calculate average of right part of array, index i+1 to n-1.
      long rightPartAverage = suffixSum[index + 1];
      // If right part have 0 elements, then we don't divide by 0.
      if (index != n - 1) {
        rightPartAverage /= (n - index - 1);
      }

      int currDifference = (int) Math.abs(leftPartAverage - rightPartAverage);
      // If current difference of averages is smaller,
      // then current index can be our answer.
      if (currDifference < minAvgDiff) {
        minAvgDiff = currDifference;
        ans = index;
      }
    }

    return ans;
  }
}// T:O(n), S:O(1)
