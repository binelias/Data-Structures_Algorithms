// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

// In other words, return true if one of s1's permutations is the substring of s2.

// Example 1:
// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").

// Example 2:
// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false

package Leetcode.Algorithm I.Sliding Window;

// Algorithm
// The last approach can be optimized, if instead of comparing all the elements of the hashmaps for every updated s2maps2map corresponding to every window of s2s2 considered, we keep a track of the number of elements which were already matching in the earlier hashmap and update just the count of matching elements when we shift the window towards the right.

// To do so, we maintain a countcount variable, which stores the number of characters(out of the 26 alphabets), which have the same frequency of occurence in s1s1 and the current window in s2s2. When we slide the window, if the deduction of the last element and the addition of the new element leads to a new frequency match of any of the characters, we increment the countcount by 1. If not, we keep the countcount intact. But, if a character whose frequency was the same earlier(prior to addition and removal) is added, it now leads to a frequency mismatch which is taken into account by decrementing the same countcount variable. If, after the shifting of the window, the countcount evaluates to 26, it means all the characters match in frequency totally. So, we return a True in that case immediately.

public class PermutationString {
  //sliding window
  public boolean checkInclusion(String s1, String s2) {
    //Corner Case
    if(s1.length() > s2.length()) return false;
    
    int[] s1map = new int[26];
    int[] s2map = new int[26];
    
    for(int i = 0; i < s1.length(); i++) {
        s1map[s1.charAt(i) - 'a']++;
        s2map[s2.charAt(i) - 'a']++;
    }
    int count = 0;
    for(int i = 0; i < 26; i++) {
        if(s1map[i] == s2map[i]) count++;
    }
    
    for(int i = 0; i < s2.length() - s1.length(); i++) {
        int right = s2.charAt(i + s1.length()) - 'a', left = s2.charAt(i) - 'a';
        if(count == 26) return true;
        
        s2map[right]++;
        if(s2map[right] == s1map[right]) count++;
        else if(s2map[right] == s1map[right] + 1) count--;
        
        s2map[left]--;
        if(s2map[left] == s1map[left]) count++;
        else if(s2map[left] == s1map[left] - 1) count--;
    }
    return count == 26;
  }
}
