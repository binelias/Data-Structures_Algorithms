// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
// Example 2:

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
// Explanation: [4,9] is also accepted.

// Constraints:

// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000

// Approach 2: Built-in Set Intersection
// Intuition

// There are built-in intersection facilities, which provide O(n+m)\mathcal{O}(n + m)O(n+m) time complexity in the average case and O(n×m)\mathcal{O}(n \times m)O(n×m) time complexity in the worst case.

// Complexity Analysis

// Time complexity : O(n+m)\mathcal{O}(n + m)O(n+m) in the average case and O(n×m)\mathcal{O}(n \times m)O(n×m) in the worst case when load factor is high enough.

// Space complexity : O(n+m)\mathcal{O}(n + m)O(n+m) in the worst case when all elements in the arrays are different.

class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<Integer>();
    for (Integer n : nums1)
      set1.add(n);
    HashSet<Integer> set2 = new HashSet<Integer>();
    for (Integer n : nums2)
      set2.add(n);

    set1.retainAll(set2);

    int[] output = new int[set1.size()];
    int idx = 0;
    for (int s : set1)
      output[idx++] = s;
    return output;
  }
}