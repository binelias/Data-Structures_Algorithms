// Given an integer n, return true if it is a power of two. Otherwise, return false.

// An integer n is a power of two, if there exists an integer x such that n == 2x.

// Example 1:
// Input: n = 1
// Output: true
// Explanation: 20 = 1

// Example 2:
// Input: n = 16
// Output: true
// Explanation: 24 = 16

// Example 3:
// Input: n = 3
// Output: false

// Explaination: If number equals or less than 0 then it cant be any power of 2. Now for positive numbers, it should have only one binary bit as 1 (because power of 2 will come as 2^0,2^1,2^2.......).
// for example,
// 1 -> 2^0 -> 0000001
// 2 -> 2^1 -> 0000010
// 4 -> 2^2 -> 0000100
// 8 -> 2^3 -> 0001000
// 16-> 2^4 -> 0010000
// ....... and so on.
// So here we can take a bitwise and (&) operation between the number and a number less than it, if it equal to 0 then it means that no other position has high bit, except at one place. Thus return true, else false.

// for ex: take the number, n=16

// n (in bits) -> 1 0 0 0 0 (16 is a power of 2 and thus has only one high bit)
// n-1 (in bits) -> 0 1 1 1 1 ( n-1 i.e. 15 will make all bits high excpet the 5th bit)
// n & n-1 -> 0 0 0 0 0 (& operation will make all the bits to 0, thus its power of 2)

// we need to explain that if n is not a power of two then n & n - 1 > 0, for any n > 0, n & n - 1 can only remove the last 1 in the binary form of n.

class Solution {
  public boolean isPowerOfTwo(int n) {
      if(n <= 0) return false;
      return ((n & (n - 1)) == 0);
  }
}