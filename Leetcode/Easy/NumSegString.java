// Given a string s, return the number of segments in the string.

// A segment is defined to be a contiguous sequence of non-space characters.

// Example 1:

// Input: s = "Hello, my name is John"
// Output: 5
// Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
// Example 2:

// Input: s = "Hello"
// Output: 1

// Constraints:

// 0 <= s.length <= 300
// s consists of lowercase and uppercase English letters, digits, or one of the following characters "!@#$%^&*()_+-=',.:".
// The only space character in s is ' '.

// Intuition

// If we cannot afford to allocate linear additional space, a fairly simple algorithm can deduce the number of segments in linear time and constant space.

// Algorithm

// To count the number of segments, it is equivalent to count the number of string indices at which a segment begins. Therefore, by formally defining the characteristics of such an index, we can simply iterate over the string and test each index in turn. Such a definition is as follows: a string index begins a segment if it is preceded by whitespace (or is the first index) and is not whitespace itself, which can be checked in constant time. Finally, we simply return the number of indices for which the condition is satisfied.

class Solution {
  public int countSegments(String s) {
    int segmentCount = 0;

    for (int i = 0; i < s.length(); i++) {
      if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
        segmentCount++;
      }
    }
    return segmentCount;
  }
}// T:O(n), S:O(1)