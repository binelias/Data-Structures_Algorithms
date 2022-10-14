// Sample Input
// 5
// 1000000001 1000000002 1000000003 1000000004 1000000005

// Output
// 5000000015

// Note:
// The range of the 32-bit integer is (-2^31) to (2^31 - 1) or [-214783648,14783648].
// When we add several integer values, the resulting sum might exceed the above range. You might need to use long int C/C++/Java to store such sums.
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
   * Complete the 'aVeryBigSum' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts LONG_INTEGER_ARRAY ar as parameter.
   */

  public static long aVeryBigSum(List<Long> ar, int arCount) {
    // Write your code here
    long sum = 0;
    for (int i = 0; i < arCount; i++) {
      sum += ar.get(i);
    }
    return sum;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int arCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Long> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Long::parseLong)
        .collect(toList());

    long result = Result.aVeryBigSum(ar, arCount);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
