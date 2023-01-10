// Amanda has a string of lowercase letters that she wants to copy to a new string. She can perform the following operations with the given costs. She can perform them any number of times to construct a new string p:

// Append a character to the end of string p at a cost of 1 dollar.
// Choose any substring of p and append it to the end of p at no charge.

// Sample Input
// 2
// abcd
// abab

// Sample Output
// 4
// 2

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'stringConstruction' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  public static int stringConstruction(String s) {
    // Write your code here
    Set<Character> set = new HashSet<>();
    for (char c : s.toCharArray()) {
      set.add(c);
    }
    return set.size();
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q).forEach(qItr -> {
      try {
        String s = bufferedReader.readLine();

        int result = Result.stringConstruction(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
