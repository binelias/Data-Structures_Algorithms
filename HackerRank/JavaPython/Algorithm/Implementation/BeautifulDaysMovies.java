// Sample Input

// 20 23 6
// Sample Output

// 2
// Explanation

// Lily may go to the movies on days , , , and . We perform the following calculations to determine which days are beautiful:

// Day  is beautiful because the following evaluates to a whole number: 
// Day  is not beautiful because the following doesn't evaluate to a whole number: 
// Day  is beautiful because the following evaluates to a whole number: 
// Day  is not beautiful because the following doesn't evaluate to a whole number: 
// Only two days,  and , in this interval are beautiful. Thus, we print  as our answer.

import java.io.*;

class Result {

  /*
   * Complete the 'beautifulDays' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   * 1. INTEGER i
   * 2. INTEGER j
   * 3. INTEGER k
   */

  public static int beautifulDays(int i, int j, int k) {
    // Write your code here
    int count = 0;
    for (int num = i; num <= j; num++) {
      if (Math.abs(num - reverse(num)) % k == 0) {
        count++;
      }
    }
    return count;
  }

  private static int reverse(int num) {
    StringBuilder sb = new StringBuilder();
    sb.append(num);
    sb.reverse();
    return Integer.parseInt(sb.toString());
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int i = Integer.parseInt(firstMultipleInput[0]);

    int j = Integer.parseInt(firstMultipleInput[1]);

    int k = Integer.parseInt(firstMultipleInput[2]);

    int result = Result.beautifulDays(i, j, k);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
