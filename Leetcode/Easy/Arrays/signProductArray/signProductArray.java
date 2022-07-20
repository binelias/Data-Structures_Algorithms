package Leetcode;

// Given:Write a function solution that given an array A of N integers [-100, 100] returns the sign (-1,0,1) of all numbers in thearray multiple together
// Input:
//   A=[1-2-35]
//   A=[123-5]
//   A=[120-5]
// Output:
//   return 1
//   return-1
//   return0
// Soln:
	//This problemis simple countthe number of negative numbers and exit early if it encounters 0


public class signProductArray {
  public int solution2(int[] nums){
    var negative = 0;
    for (var num : nums){
      if (num < 0){
        negative++;
      }else if (num == 0){
        return 0;
      }
    }
    return (negative & 1) == 0 ? 1 : -1;
  }
}
