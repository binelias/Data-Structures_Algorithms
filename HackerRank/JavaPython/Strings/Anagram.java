// Sample Input

// 6
// aaabbb
// ab
// abc
// mnop
// xyyx
// xaxbbbxx
// Sample Output

// 3
// 1
// -1
// 2
// 0
// 1
// Explanation

// Test Case #01: We split s into two strings S1='aaa' and S2='bbb'. We have to replace all three characters from the first string with 'b' to make the strings anagrams.

// Test Case #02: You have to replace 'a' with 'b', which will generate "bb".

// Test Case #03: It is not possible for two strings of unequal length to be anagrams of one another.

// Test Case #04: We have to replace both the characters of first string ("mn") to make it an anagram of the other one.

// Test Case #05: S1 and S2 are already anagrams of one another.

// Test Case #06: Here S1 = "xaxb" and S2 = "bbxx". You must replace 'a' from S1 with 'b' so that S1 = "xbxb".

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'anagram' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  public static int anagram(String s) {
    // Write your code here
    if (s.length() % 2 != 0)
      return -1;
    char[] ch = s.toCharArray();
    int n = s.length();
    int count = 0;
    int[] hash = new int[26];
    for (int i = 0; i < n; i++)
      hash[ch[i] - 'a'] += i < n / 2 ? 1 : -1;
    for (int x : hash)
      if (x > 0)
        count += x;
    return count;
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

        int result = Result.anagram(s);

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
