// Sample Input
// 6 

// Sample Output
//      #
//     ##
//    ###
//   ####
//  #####
// ######

// Explanation
// The staircase is right-aligned, composed of # symbols and spaces, and has a height and width of n = 6.

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'staircase' function below.
   *
   * The function accepts INTEGER n as parameter.
   */

  public static void staircase(int n) {
    // Write your code here
    for (int spaces = n - 1; spaces >= 0; spaces--) {
      for (int i = spaces; i < n; i++) {
        System.out.print("#");
      }
      for (int i = 0; i < spaces; i++) {
        System.out.print(" ");
      }

      System.out.println();
    }
  }

  public static void staircase(int n) {
    // Write your code here
    int len = n - 1;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (j < len) {
          System.out.print(" ");
        } else {
          System.out.print("#");
        }
      }
      len--;
      System.out.println();
    }
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    Result.staircase(n);

    bufferedReader.close();
  }
}
