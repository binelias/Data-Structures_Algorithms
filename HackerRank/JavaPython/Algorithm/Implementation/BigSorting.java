// Sample Input 1

// 8
// 1
// 2
// 100
// 12303479849857341718340192371
// 3084193741082937
// 3084193741082938
// 111
// 200
// Sample Output 1

// 1
// 2
// 100
// 111
// 200
// 3084193741082937
// 3084193741082938
// 12303479849857341718340192371

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'bigSorting' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts STRING_ARRAY unsorted as parameter.
   */

  public static List<String> bigSorting(List<String> unsorted) {
    // Write your code here
    Collections.sort(unsorted, new Comparator<String>() {
      public int compare(String x, String y) {
        if (x.length() == y.length()) {
          return x.compareTo(y);
        } else {
          return x.length() - y.length();
        }
      }
    });
    return unsorted;

  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> unsorted = IntStream.range(0, n).mapToObj(i -> {
      try {
        return bufferedReader.readLine();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    })
        .collect(toList());

    List<String> result = Result.bigSorting(unsorted);

    bufferedWriter.write(
        result.stream()
            .collect(joining("\n"))
            + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
