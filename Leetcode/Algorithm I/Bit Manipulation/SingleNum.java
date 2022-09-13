// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

// You must implement a solution with a linear runtime complexity and use only constant extra space.


// Example 1:
// Input: nums = [2,2,1]
// Output: 1

// Example 2:
// Input: nums = [4,1,2,1,2]
// Output: 4

// Example 3:
// Input: nums = [1]
// Output: 1

// A XOR A = 0 and the XOR operator is commutative, the solution will be very straightforward.

// we use bitwise XOR to solve this problem :

// first , we have to know the bitwise XOR in java

// 0 ^ N = N
// N ^ N = 0
// So..... if N is the single number

// N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N

// = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N

// = 0 ^ 0 ^ ..........^ 0 ^ N

// = N

class Solution {
  public int singleNumber(int[] nums) {
      int res = 0;
      
      for( int i = 0; i < nums.length; i++) {
          res ^= nums[i];
      }
      return res;
  }
}