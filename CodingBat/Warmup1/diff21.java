// Given an int n, return the absolute difference between n and 21, except return double the absolute difference if n is over 21.

// diff21(19) → 2
// diff21(10) → 11
// diff21(21) → 0

package CodingBat.java.Warmup1;

public class diff21 {
  public int solution(int n) {
    if(n>21) {
      return Math.abs(2*(21-n));
    } else {
      return Math.abs(21-n);
    }
  }
  
}
