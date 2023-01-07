// Sample Input

// STDIN   Function
// -----   --------
// 4       q = 4
// abc     query 1 = 'abc'
// abcba
// abcd
// cba
// Sample Output

// 2
// 0
// 4
// 2
// Explanation

// For the first query, abc → abb → aba.
// For the second query, abcba is already a palindromic string.
// For the third query, abcd → abcc → abcb → abca → abba.
// For the fourth query, cba → bba → aba.

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'theLoveLetterMystery' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  public static int theLoveLetterMystery(String s) {
    // Write your code here
    int count = 0;
    for (int i = 0; i < s.length() / 2; i++) {
      count += Math.abs(s.charAt(i) - s.charAt(s.length() - 1 - i));

    }
    return count;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q).forEach(qItr -> {
      try {
        String s = bufferedReader.readLine();

        int result = Result.theLoveLetterMystery(s);

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
