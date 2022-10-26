// Sample Input
// 2 3
// 2 4
// 16 32 96

// Sample Output
// 3

// Explanation
// 2 and 4 divide evenly into 4, 8, 12 and 16.
// 4, 8 and 16 divide evenly into 16, 32, 96.
// 4, 8 and 16 are the only three numbers for which each element of a is a factor and each is a factor of all elements of b.

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
   * Complete the 'getTotalX' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   * 1. INTEGER_ARRAY a
   * 2. INTEGER_ARRAY b
   */

  public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
    Collections.sort(a);
    Collections.sort(b);

    HashSet<Integer> set = new HashSet<>();
    for (int i = a.get(a.size() - 1); i <= b.get(0); i++) {
      set.add(i);
      for (int j = 0; j < a.size(); j++) {
        if (i % a.get(j) != 0) {
          set.remove(i);
        }
      }
      for (int j = 0; j < b.size(); j++) {
        if (b.get(j) % i != 0 && set.contains(i)) {
          set.remove(i);
        }
      }

    }
    System.out.println(set);
    return set.size();
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int total = Result.getTotalX(arr, brr);

    bufferedWriter.write(String.valueOf(total));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
