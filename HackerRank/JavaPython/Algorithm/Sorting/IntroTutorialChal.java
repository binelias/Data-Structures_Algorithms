// Sample Input 0

// STDIN           Function
// -----           --------
// 4               V = 4
// 6               arr[] size n = 6 (not passed, see function description parameters)
// 1 4 5 7 9 12    arr = [1, 4, 5, 7, 9, 12]
// Sample Output 0

// 1
// Explanation 0
// V=4. The value 4 is the  2ndelement in the array. Its index is 1 since the array indices start from 0 (see array definition under Input Format).

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'introTutorial' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   * 1. INTEGER V
   * 2. INTEGER_ARRAY arr
   */

  public static int introTutorial(int V, List<Integer> arr) {
    // Write your code here
    int ans = 0;

    for (int i = 0; i < arr.size(); i++) {
      if (arr.get(i) == V) {
        ans = i;
      }
    }
    return ans;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int V = Integer.parseInt(bufferedReader.readLine().trim());

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = Result.introTutorial(V, arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
