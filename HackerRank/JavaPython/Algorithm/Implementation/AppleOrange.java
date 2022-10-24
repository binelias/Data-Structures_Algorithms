// Input Format
// The first line contains two space-separated integers denoting the respective values of s and t.
// The second line contains two space-separated integers denoting the respective values of a and b.
// The third line contains two space-separated integers denoting the respective values of m and n.
// The fourth line contains m space-separated integers denoting the respective distances that each apple falls from point a.
// The fifth line contains n space-separated integers denoting the respective distances that each orange falls from point b.

// Output Format
// Print two integers on two different lines:

// The first integer: the number of apples that fall on Sam's house.
// The second integer: the number of oranges that fall on Sam's house.

// Sample Input 0
// 7 11
// 5 15
// 3 2
// -2 2 1
// 5 -6

// Sample Output 0
// 1
// 1

// Explanation 0
// The first apple falls at position 5 - 2 = 3.
// The second apple falls at position 5 + 2 = 7.
// The third apple falls at position 5 + 1 = 6.
// The first orange falls at position 15 + 5 = 20.
// The second orange falls at position 15 - 6 = 9.
// Only one fruit (the second apple) falls within the region between 7 and 11, so we print 1 as our first line of output.
// Only the second orange falls within the region between 7 and 11, so we print 1 as our second line of output.

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
   * Complete the 'countApplesAndOranges' function below.
   *
   * The function accepts following parameters:
   * 1. INTEGER s
   * 2. INTEGER t
   * 3. INTEGER a
   * 4. INTEGER b
   * 5. INTEGER_ARRAY apples
   * 6. INTEGER_ARRAY oranges
   */

  public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
    // Write your code here
    int applesOnHouse = 0;
    for (int i = 0; i < apples.size(); i++) {
      int applePosition = a + apples.get(i);
      if (applePosition >= s && applePosition <= t) {
        applesOnHouse++;
      }
    }
    System.out.println(applesOnHouse);

    /* Calculate # of oranges that fall on house */
    int orangesOnHouse = 0;
    for (int i = 0; i < oranges.size(); i++) {
      int orangePosition = b + oranges.get(i);
      if (orangePosition >= s && orangePosition <= t) {
        orangesOnHouse++;
      }
    }
    System.out.println(orangesOnHouse);
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int s = Integer.parseInt(firstMultipleInput[0]);

    int t = Integer.parseInt(firstMultipleInput[1]);

    String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int a = Integer.parseInt(secondMultipleInput[0]);

    int b = Integer.parseInt(secondMultipleInput[1]);

    String[] thirdMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int m = Integer.parseInt(thirdMultipleInput[0]);

    int n = Integer.parseInt(thirdMultipleInput[1]);

    List<Integer> apples = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> oranges = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    Result.countApplesAndOranges(s, t, a, b, apples, oranges);

    bufferedReader.close();
  }
}
