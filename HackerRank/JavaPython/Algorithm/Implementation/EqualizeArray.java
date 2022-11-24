// Sample Input

// STDIN       Function
// -----       --------
// 5           arr[] size n = 5
// 3 3 2 1 3   arr = [3, 3, 2, 1, 3]
// Sample Output

// 2   
// Explanation

// Delete arr[2]=2 and arr[3]1 to leave [3,3,3]. This is minimal. The only other options are to delete 4 elements to get an array of either [1] or [2].

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'equalizeArray' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static int equalizeArray(List<Integer> arr) {
    // Write your code here
    int max = 0;
    int curr = 0;
    int listLen = arr.size();
    Set<Integer> distinct = new HashSet<>(arr);
    for (int i : distinct) {
      curr = Collections.frequency(arr, i);
      if (max < curr) {
        max = curr;
      }
    }
    return (listLen - max);
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

    int result = Result.equalizeArray(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
