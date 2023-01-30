// The Tribonacci sequence Tn is defined as follows: 

// T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

// Given n, return the value of Tn.


// Example 1:

// Input: n = 4
// Output: 4
// Explanation:
// T_3 = 0 + 1 + 1 = 2
// T_4 = 1 + 1 + 2 = 4
// Example 2:

// Input: n = 25
// Output: 1389537

// Constraints:

// 0 <= n <= 37
// The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.

// Explanation
// Calculate next element d = a + b + c,
// let (a,b,c) = (b,c,d).
// Repeat this process n - 2 times;

// We can loop n times and return i0.
// It can remove the special cases for n < 2.
// But I did n - 2 loop on purpose.
// i1 and i2 will get overflow.
// Though it won't throw an error in Java. Hardly say it's a right answer.

// A possibly better solution is to start with the number before i0,i1,i2.
// As I did in python,
// i[-2] = 1
// i[-1] = 1
// i[0] = 0
// Then it won't have this problem.

// Complexity
// Time O(N)
// Space O(1)

class Solution {
  public int tribonacci(int n) {
      if (n < 2) return n;
      int a = 0, b = 1, c = 1, d;
      while (n-- > 2) {
          d = a + b + c;
          a = b;
          b = c;
          c = d;
      }
      return c;
  }
}