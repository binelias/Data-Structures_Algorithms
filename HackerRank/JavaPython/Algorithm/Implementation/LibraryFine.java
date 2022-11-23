// Your local library needs your help! Given the expected and actual return dates for a library book, create a program that calculates the fine (if any). The fee structure is as follows:

// If the book is returned on or before the expected return date, no fine will be charged (i.e.: .
// If the book is returned after the expected return day but still within the same calendar month and year as the expected return date, .
// If the book is returned after the expected return month but still within the same calendar year as the expected return date, the .
// If the book is returned after the calendar year in which it was expected, there is a fixed fine of .

// Sample Input

// 9 6 2015
// 6 6 2015
// Sample Output

// 45
// Explanation

// Given the following dates:
// Returned: 
// Due: 

// Because , we know it is less than a year late.
// Because , we know it's less than a month late.
// Because , we know that it was returned late (but still within the same month and year).

// Per the library's fee structure, we know that our fine will be . We then print the result of  as our output.

import java.io.*;

class Result {

  /*
   * Complete the 'libraryFine' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   * 1. INTEGER d1
   * 2. INTEGER m1
   * 3. INTEGER y1
   * 4. INTEGER d2
   * 5. INTEGER m2
   * 6. INTEGER y2
   */

  public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
    // Write your code here
    if (y1 > y2) {
      return 10000;
    }

    if (y1 == y2 && m1 == m2 && d1 > d2) {
      return Math.abs(d2 - d1) * 15;
    }

    if (y1 == y2 && m1 > m2) {
      return Math.abs(m2 - m1) * 500;
    }

    return 0;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int d1 = Integer.parseInt(firstMultipleInput[0]);

    int m1 = Integer.parseInt(firstMultipleInput[1]);

    int y1 = Integer.parseInt(firstMultipleInput[2]);

    String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int d2 = Integer.parseInt(secondMultipleInput[0]);

    int m2 = Integer.parseInt(secondMultipleInput[1]);

    int y2 = Integer.parseInt(secondMultipleInput[2]);

    int result = Result.libraryFine(d1, m1, y1, d2, m2, y2);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
