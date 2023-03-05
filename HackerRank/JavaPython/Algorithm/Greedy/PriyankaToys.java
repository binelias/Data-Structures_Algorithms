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
   * Complete the 'toys' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY w as parameter.
   */

  public static int toys(List<Integer> w) {
    // Write your code here
    Collections.sort(w);

    int limit = w.get(0) + 4;
    int containers = 1;

    for (int i = 0; i < w.size(); i++) {
      int item = w.get(i);

      if (!(item <= limit)) {
        containers++;
        limit = item + 4;
      }
    }

    return containers;

  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> w = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = Result.toys(w);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
