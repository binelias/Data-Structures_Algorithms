// Sample Input

// STDIN       Function
// -----       --------
// 5           arr[] size n =5
// 2 1 3 1 2   arr = [2, 1, 3, 1, 2]
// Sample Output

// 4
// Explanation

// Iteration   Array      Shifts
// 0           2 1 3 1 2
// 1           1 2 3 1 2     1
// 2           1 2 3 1 2     0
// 3           1 1 2 3 2     2
// 4           1 1 2 2 3     1

// Total                     4

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'runningTime' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static int runningTime(List<Integer> arr) {
    // Write your code here
    int shifts = 0;
    // convert arraylist arr to array
    Integer[] array = new Integer[arr.size()];
    arr.toArray(array);

    for (int i = 1; i < array.length; i++) {
      int j = i;
      int value = array[i];
      while (j >= 1 && array[j - 1] > value) {// find where to insert "value"
        array[j] = array[j - 1];// shift elements (1 by 1) to make room for inserting
        j--;
        shifts++;
      }
      array[j] = value;
    }
    return shifts;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = Result.runningTime(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
