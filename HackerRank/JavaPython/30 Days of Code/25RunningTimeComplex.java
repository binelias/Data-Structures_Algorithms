// Sample Input
// 3
// 12
// 5
// 7

// Sample Output
// Not prime
// Prime
// Prime

// Explanation
// Test Case 0: n = 12.
// 12 is divisible by numbers other than 1 and itself (i.e.: 2, 3, 46, ), so we print Not prime  on a new line.

// Test Case 1: 5.
// 5 is only divisible 1 and itself, so we print Prime  on a new line.

// Test Case 2: n = 7.
// 7 is only divisible 1 and itself, so we print Prime on a new line.

import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int T = scan.nextInt();
    while (T-- > 0) {
        int n = scan.nextInt();
        System.out.println(isPrime(n) ? "Prime" : "Not prime");
    }
    scan.close();
  }
  private static boolean isPrime(int n) {
      if (n < 2) {
          return false;
      } else if (n == 2) {     // account for even numbers now, so that we can do i+=2 in loop below
          return true;
      } else if (n % 2 == 0) { // account for even numbers now, so that we can do i+=2 in loop below
          return false;
      }
      int sqrt = (int) Math.sqrt(n);
      for (int i = 3; i <= sqrt; i += 2) { // skips even numbers for faster results
          if (n % i == 0) {
              return false;
          }
      }
      return true;
  }
}