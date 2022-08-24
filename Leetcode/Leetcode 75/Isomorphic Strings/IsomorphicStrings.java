// Given two strings s and t, determine if they are isomorphic.

// Two strings s and t are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

// Example 1:
// Input: s = "egg", t = "add"
// Output: true

// Example 2:
// Input: s = "foo", t = "bar"
// Output: false

// Example 3:
// Input: s = "paper", t = "title"
// Output: true
class Solution {
  public boolean isIsomorphic(String s, String t) {
      HashMap<Character, Character> map = new HashMap<>();
      HashSet<Character> set = new HashSet<>();
      for(int i = 0; i < s.length(); i++) {
        char sChar = s.charAt(i);
        char tChar = t.charAt(i);
          
        if(map.containsKey(sChar)) {
            if(map.get(sChar) != tChar) return false;
        }else {
            if(set.contains(tChar)) return false;
            map.put(sChar, tChar);
            set.add(tChar);
        }
      }
      return true;
  }
}