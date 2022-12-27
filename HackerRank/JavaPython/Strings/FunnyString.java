// In this challenge, you will determine whether a string is funny or not. To
// determine whether a string is funny, create a copy of the string in reverse
// e.g. . Iterating through each string, compare the absolute difference in the
// ascii values of the characters at positions 0 and 1, 1 and 2 and so on to the
// end. If the list of absolute differences is the same for both strings, they
// are funny.

// Determine whether a give string is funny. If it is, return Funny, otherwise
// return Not Funny.

// Sample Input

// STDIN Function
// ----- --------
// 2 q = 2
// acxz s = 'acxz'
// bcxz s = 'bcxz'
// Sample Output

// Funny
// Not Funny
// Explanation

// Let be the reverse of .

// Test Case 0:

// ,
// Corresponding ASCII values of characters of the strings:
// and
// For both the strings the adjacent difference list is [2, 21, 2].

// Test Case 1:

// ,
// Corresponding ASCII values of characters of the strings:
// and
// The difference list for string is [1, 21, 2] and for string is [2, 21, 1].

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'funnyString' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  public static String funnyString(String s) {
    // Write your code here
    for (int i = 0; i < s.length() - 1; i++) {
      if (Math.abs(s.charAt(i) - s.charAt(i + 1)) != Math
          .abs(s.charAt(s.length() - 1 - i) - s.charAt(s.length() - 2 - i))) {
        return "Not Funny";
      }

    }
    return "Funny";
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

        String result = Result.funnyString(s);

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
