// Sample Input

// STDIN   Function
// -----   --------
// 3       t = 3 (test cases)
// 10 2 5  n = 10, c = 2, m = 5 (first test case)
// 12 4 4  n = 12, c = 4, m = 4 (second test case)
// 6 2 2   n = 6,  c = 2, m = 2 (third test case)
// Sample Output

// 6
// 3
// 5
// Explanation

// Bobby makes the following  trips to the store:

// He spends  on  chocolates at  apiece. He then eats them and exchanges all  wrappers to get  more. He eats  chocolates.
// He spends his  on  chocolates at  apiece. He has  wrappers, but needs  to trade for his next chocolate. He eats  chocolates.
// He spends  on  chocolates at  apiece. He then exchanges  of the  wrappers for  additional piece. Next, he uses his third leftover chocolate wrapper from his initial purchase with the wrapper from his trade-in to do a second trade-in for  more piece. At this point he has  wrapper left, which is not enough to perform another trade-in. He eats  chocolates.

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'chocolateFeast' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   * 1. INTEGER n
   * 2. INTEGER c
   * 3. INTEGER m
   */

  public static int chocolateFeast(int n, int c, int m) {
    // Write your code here
    // n - cash, c - cost, m - wrapper
    int total = n / c;
    int wrapper = total;
    while (wrapper > m || wrapper == m) {
      total += wrapper / m;
      wrapper = (wrapper / m) + (wrapper % m);

    }
    return total;
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

        int n = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int m = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.chocolateFeast(n, c, m);

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
