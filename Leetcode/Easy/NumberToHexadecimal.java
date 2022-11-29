// Given an integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.

// All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.

// Note: You are not allowed to use any built-in library method to directly solve this problem.

// Example 1:

// Input: num = 26
// Output: "1a"
// Example 2:

// Input: num = -1
// Output: "ffffffff"

// Basic idea: each time we take a look at the last four digits of
// binary verion of the input, and maps that to a hex char
// shift the input to the right by 4 bits, do it again
// until input becomes 0.

class Solution {
  char[] map = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

  public String toHex(int num) {
    if (num == 0)
      return "0";
    String result = "";
    while (num != 0) {
      result = map[(num & 15)] + result;
      num = (num >>> 4);
    }
    return result;
  }
}