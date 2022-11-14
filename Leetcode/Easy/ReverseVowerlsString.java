// Given a string s, reverse only all the vowels in the string and return it.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

// Example 1:

// Input: s = "hello"
// Output: "holle"
// Example 2:

// Input: s = "leetcode"
// Output: "leotcede"

// Constraints:

// 1 <= s.length <= 3 * 105
// s consist of printable ASCII characters.

// Algorithm
// Initialize the left pointer start to 0, and the right pointer end to s.size() - 1.
// Keep iterating until the left pointer catches up with the right pointer:
// Keep incrementing the left pointer start until it's pointing to a non-vowel character.
// Keep decrementing the right pointer end until it's pointing to a non-vowel character.
// Swap the characters at the start and end.
// Increment the start pointer and decrement the end pointer.
// Return the string s.

class Solution {
  // Return true if the character is a vowel (case-insensitive)
  boolean isVowel(char c) {
    return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u'
        || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U';
  }

  // Function to swap characters at index x and y
  void swap(char[] chars, int x, int y) {
    char temp = chars[x];
    chars[x] = chars[y];
    chars[y] = temp;
  }

  public String reverseVowels(String s) {
    int start = 0;
    int end = s.length() - 1;
    // Convert String to char array as String is immutable in Java
    char[] sChar = s.toCharArray();

    // While we still have characters to traverse
    while (start < end) {
      // Find the leftmost vowel
      while (start < s.length() && !isVowel(sChar[start])) {
        start++;
      }
      // Find the rightmost vowel
      while (end >= 0 && !isVowel(sChar[end])) {
        end--;
      }
      // Swap them if start is left of end
      if (start < end) {
        swap(sChar, start++, end--);
      }
    }

    // Converting char array back to String
    return new String(sChar);
  }// T:O(n), S:o(1)
}