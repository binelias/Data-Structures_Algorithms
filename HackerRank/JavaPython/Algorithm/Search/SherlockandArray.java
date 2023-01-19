// Watson gives Sherlock an array of integers. His challenge is to find an element of the array such that the sum of all elements to the left is equal to the sum of all elements to the right.

// Sample Input 1

// 3
// 5
// 1 1 4 1 1
// 4
// 2 0 0 0
// 4
// 0 0 2 0 
// Sample Output 1

// YES
// YES
// YES
// Explanation 1

// In the first test case,arr[2]=4  is between two subarrays summing to 2.
// In the second case,arr[0]=2  is between two subarrays summing to 0.
// In the third case,arr[2]=2  is between two subarrays summing to 0.

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'balancedSums' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static String balancedSums(List<Integer> arr) {
    // Write your code here
    int n = arr.size();
    int sumFor[] = new int[n];
    int sumBack[] = new int[n];
    sumFor[0] = arr.get(0);
    sumBack[n - 1] = arr.get(n - 1);
    for (int i = 1; i < n; i++) {
      sumFor[i] = arr.get(i) + sumFor[i - 1];
    }
    for (int i = n - 2; i >= 0; i--) {
      sumBack[i] = arr.get(i) + sumBack[i + 1];
    }
    for (int i = 0; i < n; i++) {
      if (sumFor[i] == sumBack[i]) {
        return "YES";
      }
    }

    return "NO";

  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int T = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, T).forEach(TItr -> {
      try {
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String result = Result.balancedSums(arr);

        bufferedWriter.write(result);
        bufferedWriter.newLine();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
