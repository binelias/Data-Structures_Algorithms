// Sample Input 1
// 10
// 3 4 21 36 10 28 35 5 24 42

// Sample Output 1
// 4 0

// Explanation 1
// The diagram below depicts the number of times Maria broke her best and worst records throughout the season:

// She broke her best record four times (after games , , , and ) and her worst record zero times (no score during the season was lower than the one she earned during her first game), so we print 4 0 as our answer.

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
   * Complete the 'breakingRecords' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY scores as parameter.
   */

  public static List<Integer> breakingRecords(List<Integer> scores) {
    // Write your code here
    int min = scores.get(0);
    int max = scores.get(0);
    int higherScore = 0;
    int lowerScore = 0;
    List<Integer> arr = new ArrayList<>();
    for (int score : scores) {
      if (score > max) {
        max = score;
        higherScore++;
      }
      if (score < min) {
        min = score;
        lowerScore++;
      }
    }
    arr.add(higherScore);
    arr.add(lowerScore);
    return arr;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> result = Result.breakingRecords(scores);

    bufferedWriter.write(
        result.stream()
            .map(Object::toString)
            .collect(joining(" "))
            + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
