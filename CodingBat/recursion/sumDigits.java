// Given a non-negative int n, return the sum of its digits recursively (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).


// sumDigits(126) → 9
// sumDigits(49) → 13
// sumDigits(12) → 3

package CodingBat.recursion;

public class sumDigits {
  public int sumDigits(int n) {
    //Base case
    if(n == 0) return 0;
    
    //Recursion
    return n%10 + sumDigits(n/10);
  }
}
