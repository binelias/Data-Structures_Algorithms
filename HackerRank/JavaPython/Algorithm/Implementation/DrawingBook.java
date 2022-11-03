// Sample Input 0
// 6
// 2

// Sample Output 0
// 1

// Explanation 0
// If the student starts turning from page 1, they only need to turn 1 page:

// _ 1 -> 2 3

// If a student starts turning from page 6, they need to turn 2 pages:

// 6 _ -> 4 5 -> 2 3

// Return the minimum value, 1.

// Sample Input 1
// 5
// 4

// Sample Output 1
// 0

// Explanation 1
// If the student starts turning from page ,1 they need to turn 2 pages:

// _ 1 -> 2 3 -> 4 5

// If they start turning from page 5, they do not need to turn any pages:

// 4 5

// Return the minimum value, 0.

import java.io.*;

class Result {

  /*
   * Complete the 'pageCount' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   * 1. INTEGER n
   * 2. INTEGER p
   */

  public static int pageCount(int n, int p) {
    // Write your code here
    int pagesFromFront = p / 2;
    int pagesFromBack = n / 2 - p / 2;

    return Math.min(pagesFromFront, pagesFromBack);
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    int p = Integer.parseInt(bufferedReader.readLine().trim());

    int result = Result.pageCount(n, p);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
