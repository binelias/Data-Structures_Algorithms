// pSample Input

// STDIN       Function
// -----       --------
// 10          length of s = 10
// beabeefeab  s = 'beabeefeab'
// Sample Output

// 5
// Explanation

// The characters present in s are a, b, e, and f. This means that t must consist of two of those characters and we must delete two others. Our choices for characters to leave are [a,b], [a,e], [a, f], [b, e], [b, f] and [e, f].

// If we delete e and f, the resulting string is babab. This is a valid  as there are only two distinct characters (a and b), and they are alternating within the string.

// If we delete a and f, the resulting string is bebeeeb. This is not a valid string  because there are consecutive e's present. Removing them would leave consecutive b's, so this fails to produce a valid string t.

// Other cases are solved similarly.

// babab is the longest string we can create.

// Time Complexity:O(n)with just 1 traversal of our String Space Complexity:O(1)There are approximately 26^2 possible combinations of alternating pairs of letters.Notice that this number remains constant and is not dependent on the length of our input String.This fact will help us achieve a linear O(n)runtime.We want to solve this problem with just 1 traversal of our String,so we solve all 26^2 subproblems simultaneously.We use two int[26][26]arrays to keep track of the 26^2 solutions.As we iterate through our String,we update our two int[26][26]arrays as follows:-int[26][26]letter--->This array is used to keep track of which of the alternating characters we saw last.To achieve this,for the current character"ch",we update the corresponding row(26 entries)and column(26 entries)with the(ASCII)value of"ch".-int[26][26]count---->if we find that no solution exists for a pair of characters(which happens when the characters don'talternate),we store-1 in this array.Otherwise,we store he current maximum length of"s"for the pair of characters.Our final answer is the maximum value in our"int[26][26] count"array.

import java.io.*;

class Result {

  /*
   * Complete the 'alternate' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */
  public static final int NUM_LETTERS = 26;

  public static int alternate(String s) {
    // Write your code here
    /* Edge case */
    if (s.length() <= 1) {
      return 0;
    }
    /* Create arrays representing the 26^2 subproblems */
    int[][] pair = new int[NUM_LETTERS][NUM_LETTERS];
    int[][] count = new int[NUM_LETTERS][NUM_LETTERS];

    for (int i = 0; i < s.length(); i++) {
      char letter = s.charAt(i);
      int letterNum = letter - 'a';

      /* Update row */
      for (int col = 0; col < NUM_LETTERS; col++) {
        if (pair[letterNum][col] == letter) {
          count[letterNum][col] = -1;
        }
        if (count[letterNum][col] != -1) {
          pair[letterNum][col] = letter;
          count[letterNum][col]++;
        }
      }

      /* Update column */
      for (int row = 0; row < NUM_LETTERS; row++) {
        if (pair[row][letterNum] == letter) {
          count[row][letterNum] = -1;
        }
        if (count[row][letterNum] != -1) {
          pair[row][letterNum] = letter;
          count[row][letterNum]++;
        }
      }
    }

    /* Find max in "count" array */
    int max = 0;
    for (int row = 0; row < NUM_LETTERS; row++) {
      for (int col = 0; col < NUM_LETTERS; col++) {
        max = Math.max(max, count[row][col]);
      }
    }

    return max;

  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int l = Integer.parseInt(bufferedReader.readLine().trim());

    String s = bufferedReader.readLine();

    int result = Result.alternate(s);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
