// Sample Input
// STDIN           Function
// -----           --------
// 6               arr[] size n = 6
// -4 3 -9 0 4 1   arr = [-4, 3, -9, 0, 4, 1]

// Sample Output
// 0.500000
// 0.333333
// 0.166667

// Explanation
// There are 3 positive numbers, 2 negative numbers, and 1 zero in the array.
// The proportions of occurrence are positive:3/6 = 0.500000 , negative: 2/6 = 0.333333 and zeros: 1/6 = 0.166667.

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
   * Complete the 'plusMinus' function below.
   *
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static void plusMinus(List<Integer> arr, int n) {
    // Write your code here
    double pos = 0;
    double neg = 0;
    double zeroes = 0;

    for (int i : arr) {
      if (i > 0)
        pos++;
      else if (i < 0)
        neg++;
      else
        zeroes++;
    }

    System.out.println(pos / n);
    System.out.println(neg / n);
    System.out.println(zeroes / n);
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    Result.plusMinus(arr, n);

    bufferedReader.close();
  }
}
