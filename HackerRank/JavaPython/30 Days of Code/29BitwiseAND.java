// Sample Input
// STDIN   Function
// -----   --------
// 3       T = 3 //test case
// 5 2     N = 5, K = 2
// 8 5     N = 8, K = 5
// 2 2     N = 8, K = 5

// Sample Output
// 1
// 4
// 0

// Explanation
// The maximum possible value of A&B  that is also < (K =2) is 1, so we print 1 on a new line.
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'bitwiseAnd' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   * 1. INTEGER N
   * 2. INTEGER K
   */

  public static int bitwiseAnd(int N, int K) {
    // Write your code here
    int max = Integer.MIN_VALUE;
    for (int i = 1; i <= N; i++) {
      for (int j = i + 1; j <= N; j++) {
        int temp = i & j;
        if (temp > max && temp < K)
          max = temp;
      }
    }
    return max;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int count = Integer.parseInt(firstMultipleInput[0]);

        int lim = Integer.parseInt(firstMultipleInput[1]);

        int res = Result.bitwiseAnd(count, lim);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
