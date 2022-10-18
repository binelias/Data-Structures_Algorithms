// Input Format
// A single line of five space-separated integers.

// Output Format
// Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers. (The output can be greater than a 32 bit integer.)

// Sample Input
// 1 2 3 4 5

// Sample Output
// 10 14

// Explanation
// The numbers are 1, 2, 3, 4, and 5. Calculate the following sums using four of the five integers:

// Sum everything except 1, the sum is 2+3+4+5 = 14.
// Sum everything except 2, the sum is 13.
// Sum everything except 3, the sum is 12.
// Sum everything except 4, the sum is 11.
// Sum everything except 5, the sum is 10.
// Hints: Beware of integer overflow! Use 64-bit Integer.

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
   * Complete the 'miniMaxSum' function below.
   *
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
    long sum = 0;
    long min = Integer.MAX_VALUE;
    long max = Integer.MIN_VALUE;

    for (int i = 0; i < arr.size(); i++) {
      sum += arr.get(i);
      min = Math.min(min, arr.get(i));
      max = Math.max(max, arr.get(i));
    }

    System.out.println((sum - max) + " " + (sum - min));

  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    Result.miniMaxSum(arr);

    bufferedReader.close();
  }
}
