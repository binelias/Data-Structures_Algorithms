
// 
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

//  1 - Notice there is a special restriction on the range of values in the array: values are between 0 and 100.
//  2 - Since the order of elements in our array does not matter, we can just keep the counts of each number.
//  3 - Create a new 100-element "counts" array to store the counts of each number.
//  4 - In our "counts" array, the adjacent pair with the largest sum is our final solution.
//  5 - This is because the original numbers represented by the 2 adjacent slots in counts[] can be used to create a 
//      maximal solution

// Time complexity: O(n)

class Result {

  /*
   * Complete the 'pickingNumbers' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  public static int pickingNumbers(List<Integer> a) {
    // Write your code here
    // Save counts of each number
    final int MAX_VALUE = 100;

    int[] counts = new int[MAX_VALUE];
    for (int num : a) {
      counts[num]++;
    }

    // Find adjacent pair with largest sum
    int max = 2;
    for (int i = 1; i < 100; i++) {
      int adjacentSum = counts[i] + counts[i - 1];
      max = Math.max(max, adjacentSum);
    }
    return max;

  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = Result.pickingNumbers(a);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
