// A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

// For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
// Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

// Example 1:

// Input: s = "25525511135"
// Output: ["255.255.11.135","255.255.111.35"]
// Example 2:

// Input: s = "0000"
// Output: ["0.0.0.0"]
// Example 3:

// Input: s = "101023"
// Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]

// Constraints:

// 1 <= s.length <= 20
// s consists of digits only.

// Iterative
// Intuition
// We need to separate the input string into 4 integers, so we can enumerate the length of the first 3 integers, len1, len2, len3. We could iterate over len1, len2, len3 with 3 nested loops and the last integer is the remaining part after separating out the first 3.

// We can make the ranges of len1, len2, len3 tighter:

// len1 should be in the range [max(1, s.length() - 9), min(3, s.length() - 3] since we need to separate 3 more integers after it and the length of each integer is in [1..3].
// Similarly, len2 should be in the range [max(1, s.length() - len1 - 6, min(3, s.length() - len1 - 2]
// len3 should be in the range [max(1, s.length() - len1 - len2 - 3), min(3, s.length() - len1 - len2 - 1]
// In this way, the last part's length is always in the range of [1..3], then we can split each substring out based on the lengths and check whether they are valid. Each integer can be validated before starting the loop of the next part to prevent wasting time.

// Algorithm
// Initialize an array of strings ans.
// Iterate over the range of len1, the length of the first integer.
// If the first integer is valid, then we iterate over len2's range.
// If the second integer is also valid, then we iterate over len3's range.
// If both third and fourth integers are valid, concatenate all four integers together with a character '.' between any 2 neighbors, and add the result string to ans.
// Return ans.

class Solution {
  private boolean isValid(String s, int start, int length) {
    return length == 1 ||
        (s.charAt(start) != '0' &&
            (length < 3 ||
                s.substring(start, start + length).compareTo("255") <= 0));
  }

  public List<String> restoreIpAddresses(String s) {
    List<String> ans = new ArrayList<>();
    for (int len1 = Math.max(1, s.length() - 9); len1 <= 3 && len1 <= s.length() - 3; ++len1) {
      if (!isValid(s, 0, len1)) {
        continue;
      }

      for (int len2 = Math.max(1, s.length() - len1 - 6); len2 <= 3 && len2 <= s.length() - len1 - 2; ++len2) {
        if (!isValid(s, len1, len2)) {
          continue;
        }
        for (int len3 = Math.max(1, s.length() - len1 - len2 - 3); len3 <= 3
            && len3 <= s.length() - len1 - len2 - 1; ++len3) {
          if (isValid(s, len1 + len2, len3) &&
              isValid(s, len1 + len2 + len3,
                  s.length() - len1 - len2 - len3)) {
            ans.add(String.join(".", s.substring(0, len1),
                s.substring(len1, len1 + len2),
                s.substring(len1 + len2, len1 + len2 + len3),
                s.substring(len1 + len2 + len3)));
          }
        }
      }

    }
    return ans;
  }
}