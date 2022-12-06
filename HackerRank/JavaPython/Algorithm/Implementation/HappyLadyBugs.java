// Sample Input 1

// 5
// 5
// AABBC
// 7
// AABBC_C
// 1
// _
// 10
// DD__FQ_QQF
// 6
// AABCBC
// Sample Output 1

// NO
// YES
// YES
// YES
// NO

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'happyLadybugs' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING b as parameter.
   */

  public static String happyLadybugs(String b) {
    // Write your code here
    int us = 0;
    int[] a = new int[26];

    for (char c : b.toCharArray())
      if (c == '_')
        us++;
      else
        a[c - 'A']++;

    for (int i : a)
      if (i == 1)
        return "NO";

    boolean flag = true;
    for (int i = 0; i < b.length() - 1; i++)
      if (i == 0 && b.charAt(i) != b.charAt(i + 1))
        flag = false;
      else if (b.charAt(i) != b.charAt(i + 1) && b.charAt(i) != b.charAt(i - 1))
        flag = false;

    if (flag)
      return "YES";

    return (us == 0) ? "NO" : "YES";
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int g = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, g).forEach(gItr -> {
      try {
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String b = bufferedReader.readLine();

        String result = Result.happyLadybugs(b);

        bufferedWriter.write(result);
        bufferedWriter.newLine();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
