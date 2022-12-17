// Input Format

// The first line contains the lower integer limit p.
// The second line contains the upper integer limit q.

// Note: Your range should be inclusive of the limits.

// Constraints
// 0<p<q<100000

// Sample Input

// STDIN   Function
// -----   --------
// 1       p = 1
// 100     q = 100
// Sample Output

// 1 9 45 55 99

// Explanation

// 1, 9, 45, 55, and 99 are the modified Kaprekar Numbers in the given range.

import java.io.*;

class Result {

  /*
   * Complete the 'kaprekarNumbers' function below.
   *
   * The function accepts following parameters:
   * 1. INTEGER p
   * 2. INTEGER q
   */

  public static void kaprekarNumbers(int p, int q) {
    // Write your code here
    int count = 0;
    for (int i = p; i <= q; i++) {

      long sqrt = (long) i * i;

      if (i == 1) {
        System.out.print(1 + " ");
        count++;
      }

      String str = String.valueOf(sqrt);
      if (str.length() > 1) {
        String s1 = str.substring(0, str.length() / 2);
        String s2 = str.substring(str.length() / 2, str.length());

        if (Integer.parseInt(s1) + Integer.parseInt(s2) == i) {

          System.out.print(i + " ");
          count++;
        }
      }
    }

    if (count == 0) {
      System.out.println("INVALID RANGE");
    }
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int p = Integer.parseInt(bufferedReader.readLine().trim());

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    Result.kaprekarNumbers(p, q);

    bufferedReader.close();
  }
}
