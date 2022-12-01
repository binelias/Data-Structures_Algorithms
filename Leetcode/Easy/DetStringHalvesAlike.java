// You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.

// Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.

// Return true if a and b are alike. Otherwise, return false.

// Example 1:

// Input: s = "book"
// Output: true
// Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
// Example 2:

// Input: s = "textbook"
// Output: false
// Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
// Notice that the vowel o is counted twice.

// ALgorithm
// Firstly, we create a dictionary of vowels. Then go through the word by counting vowels from left to middle and right to the middle. Finally, compare the result.
// Complexity

// Time O(N)
// Space O(10)

class Solution {
  public boolean halvesAreAlike(String s) {
    var v = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    int a = 0, b = 0;
    for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
      if (v.contains(s.charAt(i)))
        a += 1;
      if (v.contains(s.charAt(j)))
        b += 1;
    }
    return a == b;
  }
}