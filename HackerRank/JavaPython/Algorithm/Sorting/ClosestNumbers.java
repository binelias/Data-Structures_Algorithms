// Sorting is useful as the first step in many different tasks. The most common
// task is to make finding things easier, but there are other uses as well. In
// this case, it will make it easier to determine which pair or pairs of
// elements have the smallest absolute difference between them.

// Sample Input 0

// 10
// -20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854
// Sample Output 0

// -20 30
// Explanation 0
// (30) - (-20) = 50, which is the smallest difference.

// Sample Input 1

// 12
// -20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854
// -520 -470
// Sample Output 1

// -520 -470 -20 30
// Explanation 1
// (-470) - (-520) = 30 - (-20) = 50, which is the smallest difference.

// Sample Input 2

// 4
// 5 4 3 2
// Sample Output 2

// 2 3 3 4 4 5
// Explanation 2
// Here, the minimum difference is 1. Valid pairs are (2, 3), (3, 4), and (4,
// 5).

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'closestNumbers' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static List<Integer> closestNumbers(List<Integer> arr) {
    // Write your code here
    if (arr == null || arr.isEmpty())
      return new ArrayList<>();
    if (arr.size() == 1)
      return arr;

    Collections.sort(arr);
    Map<Integer, List<Integer>> map = new HashMap<>();
    int min = Integer.MAX_VALUE, diff = 0;

    for (int i = 1; i < arr.size(); i++) {
      diff = arr.get(i) - arr.get(i - 1);
      min = Math.min(min, diff);

      if (!map.containsKey(diff))
        map.put(diff, new ArrayList<>());
      map.get(diff).add(arr.get(i - 1));
      map.get(diff).add(arr.get(i));
    }

    return map.get(min);
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> result = Result.closestNumbers(arr);

    bufferedWriter.write(
        result.stream()
            .map(Object::toString)
            .collect(joining(" "))
            + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
