// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true

// Example 2:
// Input: s = "rat", t = "car"
// Output: false

// Constraints:

// 1 <= s.length, t.length <= 5 * 104
// s and t consist of lowercase English letters.

class Solution {
  public boolean isAnagram(String s, String t) {
      //corner case
      if(s == null || t == null || s.length() != t.length()) return false;
      
      
      //finding count of each char in string S
      HashMap<Character, Integer> map = new HashMap<>();
      for(int i = 0; i < s.length(); i++) {
          char S = s.charAt(i);
          map.put(S, map.getOrDefault(S,0) + 1);
      }
      
      //subtracting count for each character in string T, extra char found return false
      for(int i = 0; i <s.length(); i++) {
          char T = t.charAt(i);
          Integer count = map.get(T);
          if(count == null) return false;
          if(count.equals(1)) map.remove(T);
          else map.put(T, count - 1);
      }
      return true;
  }
}