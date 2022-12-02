// Two strings are considered close if you can attain one from the other using the following operations:

// Operation 1: Swap any two existing characters.
// For example, abcde -> aecdb
// Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
// For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
// You can use the operations on either string as many times as necessary.

// Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

// Example 1:

// Input: word1 = "abc", word2 = "bca"
// Output: true
// Explanation: You can attain word2 from word1 in 2 operations.
// Apply Operation 1: "abc" -> "acb"
// Apply Operation 1: "acb" -> "bca"
// Example 2:

// Input: word1 = "a", word2 = "aa"
// Output: false
// Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
// Example 3:

// Input: word1 = "cabbba", word2 = "abbccc"
// Output: true
// Explanation: You can attain word2 from word1 in 3 operations.
// Apply Operation 1: "cabbba" -> "caabbb"
// Apply Operation 2: "caabbb" -> "baaccc"
// Apply Operation 2: "baaccc" -> "abbccc"

class Solution {
  public boolean closeStrings(String word1, String word2) {
    int a = word1.length();
    int b = word2.length();

    // if length is not equal return false
    if (a != b)
      return false;

    int[] al = new int[26];
    int[] bl = new int[26];

    // store the freq of each character
    for (int i = 0; i < a; i++) {
      al[word1.charAt(i) - 'a']++;
      bl[word2.charAt(i) - 'a']++;
    }

    // if not same characters are present
    for (int i = 0; i < al.length; i++) {
      if ((al[i] == 0 && bl[i] != 0) || (al[i] != 0 && bl[i] == 0))
        return false;
    }

    // now checking if characters are present with same freq or not
    Arrays.sort(al);
    Arrays.sort(bl);
    for (int i = 0; i < al.length; i++) {
      if (al[i] != bl[i])
        return false;
    }
    return true;
  }
}