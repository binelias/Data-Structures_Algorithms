// Larry has been given a permutation of a sequence of natural numbers incrementing from 1 as an array. He must determine whether the array can be sorted using the following operation any number of times:

// Choose any 3 consecutive indices and rotate their elements in such a way that
// ABC -> BCA -> CAB -> ABC.

// Sample Input
// 3
// 3
// 3 1 2
// 4
// 1 3 4 2
// 5
// 1 2 3 5 4

// Sample Output
// YES
// YES
// NO

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
   * Complete the 'larrysArray' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts INTEGER_ARRAY A as parameter.
   */

  public static String larrysArray(List<Integer> A) {
    // Write your code here
    for (int i = 0; i < A.size() - 2; i++) {
      if (A.get(i) != (i + 1)) {
        for (int j = i + 1; j < A.size(); j++) {
          if (A.get(j) == (i + 1)) {
            int diff = j - i;
            int ele = A.get(j);
            A.remove(j);

            if (diff % 2 == 0) {
              A.add(ele - 1, ele);
            } else {
              A.add(ele - 1, ele);
              int temp = A.get(ele);
              int temp1 = A.get(ele + 1);
              A.set(ele + 1, temp);
              A.set(ele, temp1);
            }
            break;
          }
        }
      } else {
        continue;
      }
    }

    if (A.get(A.size() - 1) < A.get(A.size() - 2))
      return "NO";
    else
      return "YES";
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

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String result = Result.larrysArray(A);

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
