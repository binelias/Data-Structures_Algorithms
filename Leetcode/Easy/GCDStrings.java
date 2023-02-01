// For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).

// Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.


// Example 1:

// Input: str1 = "ABCABC", str2 = "ABC"
// Output: "ABC"
// Example 2:

// Input: str1 = "ABABAB", str2 = "ABAB"
// Output: "AB"
// Example 3:

// Input: str1 = "LEET", str2 = "CODE"
// Output: ""

// Constraints:

// 1 <= str1.length, str2.length <= 1000
// str1 and str2 consist of English uppercase letters.

// Greatest Common Divisor
// Intuition
// Here is a more mathmatical approach to the problem. Note that this approach is more advanced/elegant and you should not feel discouraged if you do not come up with it on the spot in an interview.

// 1. How to verify if there exists any divisible string?

// Suppose there exists a divisible string base, we can write str1 and str2 in the form of multiples of base. Take the following picture as an example.

// img

// Since both strings contains multiples of the identical segment base, their concatenation must be consistent, regardless of the order (str1 + str2 = str2 + str1).

// img

// Therefore, we need to check if two concatenations made by str1 and str2 in both orders are the same. If they are not consistent, it means there is no divisible strings and we should return "" as required. Otherwise, there exists a GCD string of str1 and str2.

// 2. If there are divisible strings, what is the length of the GCD string?

// We focus on the substring gcdBase whose length equals the greatest common divisor of the lengths of str1 and str2 (take the above picture as an example, the lengths of str1 and str2 are 9 and 6, so we focus on the substring of length 3, which is gcdBase = ABC). We will show that if there exists divisible strings, then the gcdBase must be the GCD string.

// For convenience, we refer to the length of str1, str2 and gcdBase as m, n, gcdLength respectively.

// Is it possible for the GCD string to be shorter than gcdBase?

// No. We can prove it by contradiction. Assume that a string shorterBase is shorter than gcdBase (shorterLength < gcdLength, and gcdBase is not the GCD string).

// shorterBase is a divisible string, thus shorterLength is a divisor of m and n.

// Since gcdLength is the greatest common divisor of m and n, gcdLength is divisible by shorterLength.

// Both str1 and str2 contains multiples of gcdBase, so gcdBase is also a divisible string, which means that the GCD string is at least as long as gcdBase.

// Therefore it is not possible for the GCD string to be shorter than gcdBase.

// Let's look at the following example where gcdBase = ABCABC. Note that we are not sure if gcdBase is the GCD string yet.

// img

// There exists a shorter substring shorterBase = ABC which divides both str1 and str2. Can this divisible string be the GCD of strings?

// img

// Both str1 and str2 contain multiples of shorterBase.

// img

// Recall that the length of gcdBase is the GCD of the lengths of str1 and str2, thus it is divisible by the length of shorterBase.

// img

// Since gcdLength is a divisor of both m and n, both str1 and str2 contain multiples of gcdBase, thus gcdBase is also a divisible string.

// img

// We have shown that if there is a shorter string that divides both str1 and str2, then gcdBase is also a divisible string, so a divisible string shorter than gcdBase can never be the GCD string.

// Is it possible for the a string longer than gcdBase to be divisible, and thus gcdBase is not the GCD string?

// No. Assume that there exists a string longerBase that is a divisible string with length longerLength > gcdLength,

// Since longerBase is a divisible string, its length longerLength must be a divisor of m and n.

// This contradicts the assumption that gcdLength is the GCD of m and n.

// Therefore there doesn't exist a divisible string longer than gcdBase.

// In conclusion, if there exists divisible strings, the GCD string must be gcdBase.


// Algorithm
// Check if the concatenations of str1 and str2 in different orders are the same.

// If not, return "".
// Get the GCD gcdLength of the two lengths of str1 and str2.

// Return the prefix string with a length of gcdLength of either str1 or str2 as the answer.

class Solution {
  public String gcdOfStrings(String str1, String str2) {
      // Check if they have non-zero GCD string.
      if (!(str1 + str2).equals(str2 + str1)) {
          return "";
      }
      
      // Get the GCD of the two lengths.
      int gcdLength = gcd(str1.length(), str2.length());
      return str1.substring(0, gcdLength);
  
  }
  
  public int gcd(int x, int y) {
      if (y == 0) {
          return x;
      } else {
          return gcd(y, x % y);
      }    
  }
}