// Sample Input

// STDIN       Function
// -----       --------
// 5 3         n = 5, k = 3
// 4 2 6 1 10  arr = [4, 2, 6, 1, 10]
// Sample Output

// 4
// Explanation

// The diagram below depicts Lisa's workbook with  chapters and a maximum of  problems per page. Special problems are outlined in red, and page numbers are in yellow squares.

// bear_workbook.png

// There are  special problems and thus we print the number  on a new line.

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'workbook' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   * 1. INTEGER n
   * 2. INTEGER k
   * 3. INTEGER_ARRAY arr
   */

  public static int workbook(int n, int k, List<Integer> arr) {
    // Write your code here
    int pageNo = 1;
    int specialProblem = 0;
    for (int i = 0; i < arr.size(); i++) {
      for (int j = 1; j <= arr.get(i); j++) {
        if (pageNo == j)
          specialProblem++;

        if ((j % k == 0) || (j == arr.get(i)))
          pageNo++;
      }
    }
    return specialProblem;

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

    int result = Result.workbook(n, k, arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
