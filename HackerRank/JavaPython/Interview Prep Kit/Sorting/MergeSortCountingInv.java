// Sample Input
// STDIN       Function
// -----       --------
// 2           d = 2
// 5           arr[] size n = 5 for the first dataset
// 1 1 1 2 2   arr = [1, 1, 1, 2, 2]
// 5           arr[] size n = 5 for the second dataset     
// 2 1 3 1 2   arr = [2, 1, 3, 1, 2]

// Sample Output
// 0  
// 4   

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'countInversions' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static long countInversions(List<Integer> arr) {
    // Write your code here
    return mergeSort(arr, 0, arr.size() - 1);
  }

  public static long mergeSort(List<Integer> arr, int start, int end) {
    if (start >= end) {
      return 0;
    }
    long inversions = 0;
    inversions += mergeSort(arr, start, (end + start) / 2);
    inversions += mergeSort(arr, (end + start) / 2 + 1, end);

    inversions += merge(arr, start, end);
    return inversions;
  }

  public static long merge(List<Integer> arr, int start, int end) {
    List<Integer> merged = new ArrayList<>(end - start + 1);
    long inversionCount = 0;
    int middle = (start + end) / 2;
    int leftIdx = start;
    int rightIdx = middle + 1;
    while (leftIdx <= middle && rightIdx <= end) {
      if (arr.get(leftIdx) > arr.get(rightIdx)) {
        merged.add(arr.get(rightIdx++));
        inversionCount += middle - leftIdx + 1;
      } else {
        merged.add(arr.get(leftIdx++));
      }
    }
    while (leftIdx <= middle) {
      merged.add(arr.get(leftIdx++));
    }
    while (rightIdx <= end) {
      merged.add(arr.get(rightIdx++));
    }
    for (int ii = 0; ii <= end - start; ii++) {
      arr.set(ii + start, merged.get(ii));
    }
    return inversionCount;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result.countInversions(arr);

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
