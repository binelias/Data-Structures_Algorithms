// Sample Input 0

// STDIN       Function
// -----       --------
// 5           B[] size N = 5
// 2 3 4 5 6   B = [2, 3, 4, 5, 6]   
// Sample Output 0

// 4
// Explanation 0

// The initial distribution is (2,3,4,5,6). The requirements can be met as follows:

// Give 1 loaf of bread each to the second and third people so that the distribution becomes (2,4,5,5,6).
// Give 1 loaf of bread each to the third and fourth people so that the distribution becomes (2,4,6,6,6).
// Each of the N subjects has an even number of loaves after 4 loaves were distributed.

// Sample Input 1

// 2
// 1 2
// Sample Output 1

// NO
// Explanation 1

// The initial distribution is (1,2). As there are only 2 people in the line, any time you give one person a loaf you must always give the other person a loaf. Because the first person has an odd number of loaves and the second person has an even number of loaves, no amount of distributed loaves will ever result in both subjects having an even number of loaves.

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'fairRations' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts INTEGER_ARRAY B as parameter.
   */

  public static String fairRations(List<Integer> B) {
    // Write your code here
    int breadGiven = 0;
    for (int i = 0; i < B.size() - 1; i++) {
      if (B.get(i) % 2 != 0) {
        B.set(i, B.get(i) + 1); // give bread to current person
        B.set(i + 1, B.get(i + 1) + 1); // give bread to next person
        breadGiven += 2;
      }
    }

    if (B.get(B.size() - 1) % 2 != 0) {
      return "NO"; // Array has odd parity. No solution exists
    } else {
      return Integer.toString(breadGiven);
    }

  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int N = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    String result = Result.fairRations(B);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
