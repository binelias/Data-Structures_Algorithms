// Example 1:
// Input: haystack = "hello", needle = "ll"
// Output: 2

// Example 2:
// Input: haystack = "aaaaa", needle = "bba"
// Output: -1


package Leetcode.TopInterviewQuestions;

class Solution {
  public int strStr1(String haystack, String needle) {
      int res = haystack.indexOf(needle);
      return res;
  }
}

