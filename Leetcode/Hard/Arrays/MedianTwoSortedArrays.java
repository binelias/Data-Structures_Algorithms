// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).


// Example 1:
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.

// Example 2:
// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

class Solution {
  //Binary Search
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int m = nums1.length; 
      int n = nums2.length;
      int len = m + n;
      if(len % 2 == 0) {
          double left = (double)findKthHelper(nums1, 0, nums2, 0, len/2);
          double right = (double)findKthHelper(nums1, 0, nums2, 0, len/2 + 1);
          return (double)(left + right)/2;
      }else {
          return findKthHelper(nums1, 0, nums2, 0, len/2 + 1);
      }
  }
  
  private int findKthHelper(int[] A, int aStart, int[] B, int bStart, int k) {
      if(aStart >= A.length) {
          return B[bStart + k - 1];
      }
      if(bStart >= B.length) {
          return A[aStart + k - 1];
      }
      if(k == 1) {
          return Math.min(A[aStart], B[bStart]);
      }
      
      int aMid = aStart + k/2 - 1;
      int bMid = bStart + k/2 - 1;
      int aVal = aMid >= A.length ? Integer.MAX_VALUE : A[aMid];
      int bVal = bMid >= B.length ? Integer.MAX_VALUE : B[bMid];
      if(aVal <= bVal) {
          return findKthHelper(A, aMid + 1, B, bStart, k - k/2);
      }else {
          return findKthHelper(A, aStart, B, bMid + 1, k - k/2);
      }
  }
}