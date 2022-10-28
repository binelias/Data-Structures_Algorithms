// Sample Input 0
// 5
// 1 2 1 3 2
// 3 2

// Sample Output 0
// 2

// Explanation 0
// Lily wants to give Ron  squares summing to . The following two segments meet the criteria:

// Sample Input 1
// 6
// 1 1 1 1 1 1
// 3 2

// Sample Output 1
// 0

// Explanation 1
// Lily only wants to give Ron  consecutive squares of chocolate whose integers sum to . There are no possible pieces satisfying these constraints:

// Thus, we print  as our answer.

// Sample Input 2
// 1
// 4
// 4 1

// Sample Output 2
// 1

// Explanation 2
// Lily only wants to give Ron  square of chocolate with an integer value of . Because the only square of chocolate in the bar satisfies this constraint, we print  as our answer.

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'birthday' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   * 1. INTEGER_ARRAY s
   * 2. INTEGER d
   * 3. INTEGER m
   */

  public static int birthday(List<Integer> s, int d, int m) {
    // Write your code here
    int sum = 0, i, j, count = 0;
    if (s.size() == 1 && s.get(0) == d && m == 1)
      return 1;
    for (i = 0; i < m; i++) {
      sum += s.get(i);
    }
    if (sum == d)
      count++;

    for (i = m; i < s.size(); i++) {
      sum += s.get(i) - s.get(i - m);
      if (sum == d) {
        count++;
      }
    }
    return count;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int d = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    int result = Result.birthday(s, d, m);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
