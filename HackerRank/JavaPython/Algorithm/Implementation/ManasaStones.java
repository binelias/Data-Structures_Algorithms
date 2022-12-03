// Sample Input

// STDIN   Function
// -----   --------
// 2       T = 2 (test cases)
// 3       n = 3 (test case 1)
// 1       a = 1
// 2       b = 2
// 4       n = 4 (test case 2)
// 10      a = 10
// 100     b = 100
// Sample Output

// 2 3 4 
// 30 120 210 300 
// Explanation

// With differences 1 and 2, all possible series for the first test case are given below:

// 0,1,2
// 0,1,3
// 0,2,3
// 0,2,4
// Hence the answer 2 3 4.

// With differences 10 and 100, all possible series for the second test case are the following:

// 0, 10, 20, 30
// 0, 10, 20, 120
// 0, 10, 110, 120
// 0, 10, 110, 210
// 0, 100, 110, 120
// 0, 100, 110, 210
// 0, 100, 200, 210
// 0, 100, 200, 300
// Hence the answer 30 120 210 300.

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result {

  /*
   * Complete the 'stones' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   * 1. INTEGER n
   * 2. INTEGER a
   * 3. INTEGER b
   */

  public static List<Integer> stones(int n, int a, int b) {
    // Write your code here
    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 0; i < n; i++)
      set.add(a * (n - 1 - i) + b * i);
    return new ArrayList<>(set);

  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int T = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, T).forEach(TItr -> {
      try {
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int a = Integer.parseInt(bufferedReader.readLine().trim());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = Result.stones(n, a, b);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
                + "\n");
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
