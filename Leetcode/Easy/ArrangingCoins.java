// You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

// Given the integer n, return the number of complete rows of the staircase you will build.

// Example 1:

// Input: n = 5
// Output: 2
// Explanation: Because the 3rd row is incomplete, we return 2.
// Example 2:

// Input: n = 8
// Output: 3
// Explanation: Because the 4th row is incomplete, we return 3.

// If we look deeper into the formula of the problem, we could actually solve it with the help of mathematics, without using any iteration.

// As a reminder, the constraint of the problem can be expressed as follows:

// k(k+1)≤2Nk(k + 1) \le 2Nk(k+1)≤2N

// This could be solved by completing the square technique,

// (k+12)2−14≤2N\left(k + \frac{1}{2}\right)^2 - \frac{1}{4} \le 2N(k+ 
// 2
// 1
// ​
//  ) 
// 2
//  − 
// 4
// 1
// ​
//  ≤2N

// that results in the following answer:

// k=[2N+14−12]k = \left[\sqrt{2N + \frac{1}{4}} - \frac{1}{2}\right]k=[ 
// 2N+ 
// 4
// 1
// ​

// ​
//  − 
// 2
// 1
// ​
//  ]

// Implementation

// Complexity Analysis

// Time complexity : O(1)\mathcal{O}(1)O(1).

// Space complexity : O(1)\mathcal{O}(1)O(1).

class Solution {
  public int arrangeCoins(int n) {
    return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
  }
}