// Sample Input

// 4
// Sample Output

// 6
// Explanation

// Time t = 4 marks the beginning of the second cycle. It is double the number displayed at the beginning of the first cycle: 2 x 3 = 6. This is shown in the diagram in the problem statement.

import java.io.*;

class Result {

  /*
   * Complete the 'strangeCounter' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts LONG_INTEGER t as parameter.
   */

  public static long strangeCounter(long t) {
    // Write your code here
    long startValue = 3;
    long startTime = 1;
    while (startTime + startValue <= t) {
      startTime = startTime + startValue;
      startValue *= 2;
      if (t == startTime)
        return startValue;
    }
    return startValue - (t - startTime);

  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    long t = Long.parseLong(bufferedReader.readLine().trim());

    long result = Result.strangeCounter(t);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
