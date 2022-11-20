// Sample Input

// 2
// 12
// 1012
// Sample Output

// 2
// 3
// Explanation

// The number 12 is broken into two digits, 1 and 2. When 12 is divided by either of those two digits, the remainder is 0 so they are both divisors.

// The number 1012 is broken into four digits, 1, 0, 1, and 2. 1012  is evenly divisible by its digits 1, 1, and 2, but it is not divisible by 0 as division by zero is undefined.

import java.io.*;
import java.util.stream.*;


class Result {

    /*
     * Complete the 'findDigits' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int findDigits(int n) {
        // Write your code here
        int count = 0;
        int num = n;
        while (num > 0) {
            int digit = num % 10;
            if (digit != 0 && n % digit == 0) {
                count++;
            }
            num /= 10;
        }
        return count;
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

                int result = Result.findDigits(n);

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
