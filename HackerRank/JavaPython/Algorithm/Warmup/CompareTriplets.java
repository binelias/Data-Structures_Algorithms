// Sample Input 1
// 17 28 30
// 99 16 8

// Sample Output 1
// 2 

// Explanation 1
// Comparing the 0th elements, 17<99 so Bob receives a point.
// Comparing the 1st and 2nd elements, 28>16 and 30>8 so Alice receives two points.
// The return array is [2,1].

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
   * Complete the 'compareTriplets' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   * 1. INTEGER_ARRAY a
   * 2. INTEGER_ARRAY b
   */

  public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    int alice = 0;
    int bob = 0;

    for (int i = 0; i < 3; i++) {
      if (a.get(i) > b.get(i)) {
        alice += 1;
      }
      if (a.get(i) < b.get(i)) {
        bob += 1;
      }
    }

    List<Integer> res = new ArrayList<>();
    res.add(alice);
    res.add(bob);

    return res;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> result = Result.compareTriplets(a, b);

    bufferedWriter.write(
        result.stream()
            .map(Object::toString)
            .collect(joining(" "))
            + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
