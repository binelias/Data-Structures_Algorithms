// A pangram is a string that contains every letter of the alphabet. Given a sentence determine whether it is a pangram in the English alphabet. Ignore case. Return either pangram or not pangram as appropriate

// Sample Input

// Sample Input 0

// We promptly judged antique ivory buckles for the next prize

// Sample Output 0

// pangram

// Sample Explanation 0

// All of the letters of the alphabet are present in the string.

// Sample Input 1

// We promptly judged antique ivory buckles for the prize

// Sample Output 1

// not pangram

// Sample Explanation 0

// The string lacks an x.

import java.io.*;
import java.util.*;

class Result {

  /*
   * Complete the 'pangrams' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  public static String pangrams(String s) {
    // Write your code here
    String l = s.toLowerCase();

    HashSet<Character> set = new HashSet<>();
    for (int i = 0; i < l.length(); i++) {
      char ch = l.charAt(i);
      if (Character.isLetter(ch)) {
        set.add(ch);
      }
    }

    return (set.size() == 26 ? "pangram" : "not pangram");
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    String result = Result.pangrams(s);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
