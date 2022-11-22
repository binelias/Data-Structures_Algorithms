// Sample Input
// 2
// 3 9
// 17 24

// Sample Output
// 2
// 0

// Explanation
// Test Case #00: In range [3.9], 4 and 9 are the two square integers.
// Test Case #01: In range [17,24], there are no square integers.

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'squares' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   * 1. INTEGER a
   * 2. INTEGER b
   */

  public static int squares(int a, int b) {
    // Write your code here
    int numSquares = (int) (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);
    return numSquares;

  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q).forEach(qItr -> {
      try {
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int a = Integer.parseInt(firstMultipleInput[0]);

        int b = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.squares(a, b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
