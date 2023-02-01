// Sample Input

// STDIN   Function
// -----   --------
// 3       t = 3 (number of queries)
// 2 1     n = 2, k = 1
// 3 0     n = 3, k = 0
// 3 2     n = 3, k = 2
// Sample Output

// 2 1
// 1 2 3
// -1
// Explanation

// Test Case 0:

// perm.png

// Test Case 1:

// perm(1).png

// Test Case 2:
// No absolute permutation exists, so we print -1 on a new line.

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
     * Complete the 'absolutePermutation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     */

    public static List<Integer> absolutePermutation(int n, int k) {
        // Write your code here
         Integer[] result = new Integer[n];
        int idx;
        for (int value = 1; value <= n; value++) {
            idx = value - k;
            if (idx <= n && idx > 0 && result[idx - 1] == null) {
                result[idx - 1] = value;
            } else {
                idx = value + k;
                if (idx <= n && idx > 0 && result[idx - 1] == null) {
                    result[idx - 1] = value;
                } else {
                    result = new Integer[1];
                    result[0] = -1;
                    return Arrays.asList(result);
                }
            }
        }
        return Arrays.asList(result);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> result = Result.absolutePermutation(n, k);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
