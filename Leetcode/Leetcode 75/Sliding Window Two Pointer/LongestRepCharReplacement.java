// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

// Return the length of the longest substring containing the same letter you can get after performing the above operations.

// Example 1:
// t: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.

// Example 2:
// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.

package Leetcode.Leetcode 75.Sliding Window Two Pointer;

public class LongestRepCharReplacement {
  public int characterReplacement(String s, int k) {
    int[] freq = new int[26];
    int mostFreqLetter = 0, l = 0, max =0;
    
    for(int r = 0; r < s.length(); r++) {
        freq[s.charAt(r) - 'A']++;
        mostFreqLetter = Math.max(mostFreqLetter, freq[s.charAt(r) - 'A']);
        
        int lettersToChange = (r - l + 1) - mostFreqLetter;
        if(lettersToChange > k) {
            freq[s.charAt(l) - 'A']--;
            l++;
        }
        max = Math.max(max, r - l + 1);
    }
    return max;
  }
}//Time Complexity: O(N), Space Complexity: O(1)
