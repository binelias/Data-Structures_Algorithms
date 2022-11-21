// Sample Input 2

// ashley
// ash
// 2
// Sample Output 2

// No
// Explanation 2

// To convert ashley to ash a minimum of  steps are needed. Hence we print No as answer.

import java.io.*;

class Result {

  /*
   * Complete the 'appendAndDelete' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   * 1. STRING s
   * 2. STRING t
   * 3. INTEGER k
   */

  public static String appendAndDelete(String s, String t, int k) {
    // Write your code here
    /* Case 1 */
    if (s.length() + t.length() <= k) {
      return "Yes";
    }

    /* Case 2 */
    int i = 0; // represents index of 1st non-matching character
    for (; i < s.length() && i < t.length(); i++) {
      if (s.charAt(i) != t.charAt(i)) {
        break;
      }
    }
    int minOperations = (s.length() - i) + (t.length() - i);
    return k >= minOperations && (k - minOperations) % 2 == 0 ? "Yes" : "No";

  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    String t = bufferedReader.readLine();

    int k = Integer.parseInt(bufferedReader.readLine().trim());

    String result = Result.appendAndDelete(s, t, k);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
