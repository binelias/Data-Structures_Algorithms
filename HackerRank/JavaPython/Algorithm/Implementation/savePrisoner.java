// Sample Input 0

// 2
// 5 2 1
// 5 2 2
// Sample Output 0

// 2
// 3
// Explanation 0

// In the first query, there are 5 prisoners and 2 sweets. Distribution starts at seat number 1. Prisoners in seats numbered 1 and 2 get sweets. Warn prisoner 2.

// In the second query, distribution starts at seat 2 so prisoners in seats 2 and 3 get sweets. Warn prisoner 3.

// Sample Input 1

// 2
// 7 19 2
// 3 7 3
// Sample Output 1

// 6
// 3
// Explanation 1

// In the first test case, there are n = 7 prisoners,m = 19  sweets and they are passed out starting at chair s = 2. The candies go all around twice and there are 5 more candies passed to each prisoner from seat 2 to seat 6.

// In the second test case, there are  n = 3 prisoners, 7 candies and they are passed out starting at seat 3. They go around twice, and there is one more to pass out to the prisoner at seat 3.

import java.io.*;
import java.util.stream.*;


class Result {

    /*
     * Complete the 'saveThePrisoner' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. INTEGER s
     */

    public static int saveThePrisoner(int n, int m, int s) {
        // Write your code here
        return (m + s - 2) % n + 1;
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

                int m = Integer.parseInt(firstMultipleInput[1]);

                int s = Integer.parseInt(firstMultipleInput[2]);

                int result = Result.saveThePrisoner(n, m, s);

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
