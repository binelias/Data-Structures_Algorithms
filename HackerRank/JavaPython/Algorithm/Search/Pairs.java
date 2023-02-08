// Given an array of integers and a target value, determine the number of pairs of array elements that have a difference equal to the target value.

// Sample Input

// STDIN       Function
// -----       --------
// 5 2         arr[] size n = 5, k =2
// 1 5 3 4 2   arr = [1, 5, 3, 4, 2]
// Sample Output

// 3
// Explanation

// There are 3 pairs of integers in the set with a difference of 2: [5,3], [4,2] and [3,1]. .

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
   * Complete the 'pairs' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   * 1. INTEGER k
   * 2. INTEGER_ARRAY arr
   */

  public static int pairs(int k, List<Integer> arr) {
    // Write your code here
    int count = 0;
    Collections.sort(arr);
    for (int i = 0; i < arr.size(); i++) {
      for (int j = i + 1; j < arr.size(); j++) {
        int diff = arr.get(j) - arr.get(i);
        if (diff == k) {
          ++count;
          continue;
        }
        if (diff > k) {
          break;
        }
      }
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

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = Result.pairs(k, arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
