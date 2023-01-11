// Sample Input
// cde
// abc

// Sample Output
// 4

// Explanation
// Delete the following characters from our two strings to turn them into anagrams:

// Remove d and e from cde to get c.
// Remove a and b from abc to get c.
// characters have to be deleted to make both strings anagrams.

import java.io.*;

class Result {

  /*
   * Complete the 'makingAnagrams' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   * 1. STRING s1
   * 2. STRING s2
   */

  private static final int NUM_LETTERS = 26; // we assume lower-case letters only

  public static int makingAnagrams(String s1, String s2) {
    // Write your code here
    // For each string, create an array of the count of each character
    int[] array1 = createFilledArray(s1);
    int[] array2 = createFilledArray(s2);

    /*
     * Count number of deletions we need to make the Strings anagrams of each other
     */
    int deletions = 0;
    for (int i = 0; i < NUM_LETTERS; i++) {
      deletions += Math.abs(array1[i] - array2[i]);
    }
    return deletions;
  }

  // Creates an array with the count of each character
  private static int[] createFilledArray(String str) {
    int[] array = new int[NUM_LETTERS];
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      array[ch - 'a']++;
    }
    return array;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s1 = bufferedReader.readLine();

    String s2 = bufferedReader.readLine();

    int result = Result.makingAnagrams(s1, s2);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
