// You are given an integer array nums and two integers minK and maxK.

// A fixed-bound subarray of nums is a subarray that satisfies the following conditions:

// The minimum value in the subarray is equal to minK.
// The maximum value in the subarray is equal to maxK.
// Return the number of fixed-bound subarrays.

// A subarray is a contiguous part of an array.


// Example 1:

// Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
// Output: 2
// Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
// Example 2:

// Input: nums = [1,1,1,1], minK = 1, maxK = 1
// Output: 10
// Explanation: Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.

// Constraints:

// 2 <= nums.length <= 105
// 1 <= nums[i], minK, maxK <= 106

// Intuition
// Count the number of subarrays,
// using sliding window(three pointers).


// Explanation
// We maintain a maximum sliding window
// with alll elements in range [minK, maxK],
// For all A[i] as rightmost element of the subarray,
// we find the three indices j, where:
// jbad is index of last seen A[jbad] < minK || A[jbad] > maxK
// jmin is index of last seen A[jmin] = mink
// jmax is index of last seen A[jmax] = maxk

// Itearte the A[i],
// if A[i] < minK || A[i] > maxK, update jbad = i.
// if A[i] == minK, update jmin = i.
// if A[i] == maxK, update jmax = i.

// In the end of each iteration,
// the subarray ends at A[i]
// the starting element of the subarray,
// can be choosen in interval [jbad + 1, min(jmin, jmax)]
// There are min(jmin, jmax) - jbad choices,
// so we update res += max(0, min(jmin, jmax) - jbad).


// Complexity
// Time O(n)
// Space O(1)

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0, jbad = -1, jmin = -1, jmax = -1, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < minK || nums[i] > maxK) jbad = i;
            if (nums[i] == minK) jmin = i;
            if (nums[i] == maxK) jmax = i;
            res += Math.max(0L, Math.min(jmin, jmax) - jbad);
        }
        return res;
    }
}