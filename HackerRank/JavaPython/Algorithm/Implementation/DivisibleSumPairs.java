// Sample Input
// STDIN           Function
// -----           --------
// 6 3             n = 6, k = 3
// 1 3 2 6 1 2     ar = [1, 3, 2, 6, 1, 2]

// Sample Output
// 5

// Explanation
// Here are the 5 valid pairs when divisible by k = 3:
//   (0,2) -> 1 + 2 = 3
//   (0,5) -> 1 + 2 = 3
//   (1,3) -> 3 + 6 = 9
//   (2,4) -> 2 + 1 = 3
//   (4,5) -> 1 + 2 = 3

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
   * Complete the 'divisibleSumPairs' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   * 1. INTEGER n
   * 2. INTEGER k
   * 3. INTEGER_ARRAY ar
   */

  public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
    // Write your code here
    int[] bucket = new int[k];
    int count = 0;
    for (int value : ar) {
      int modValue = value % k;
      count += bucket[(k - modValue) % k]; // adds # of elements in complement bucket
      bucket[modValue]++;// saves in bucket
    }
    return count;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = Result.divisibleSumPairs(n, k, ar);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
