// Given a string s, find the length of the longest substring without repeating characters.

// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

// Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.

// Example 3:
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

package Leetcode.Algorithm I.Sliding Window;

public class LongSubstringWithoutRepeatingChar {
  //sliding window
  public int lengthOfLongestSubstring(String s) {
    //Base Case
    if(s.length() <= 1) return s.length();
    
    int longest = 0, left = 0;
    int[] nextIdx = new int[128];
    
    for(int right = 0; right < s.length(); right++) {
        left = Math.max(nextIdx[s.charAt(right)], left);
        longest = Math.max(longest, right - left + 1);
        nextIdx[s.charAt(right)] = right + 1;
    }
    return longest;
  }
  //sliding window with map
  public int lengthOfLongestSubstring2(String s) {
    //Base Case
    if(s.length() <= 1) return s.length();
    
    int longest = 0, left = 0;
    Map<Character, Integer> map = new HashMap<>();
    
    for(int right = 0; right < s.length(); right++) {
        if(map.containsKey(s.charAt(right))){
            left = Math.max(left, map.get(s.charAt(right)) + 1);
        }
        map.put(s.charAt(right),right);
        longest = Math.max(longest, right - left + 1);
    }
    return longest;
}
}
