// Sample Input

// STDIN   Function
// -----   --------
// 5       t = 5
// 10 10   b = 10, w = 10
// 1 1 1   bc = 1, wc = 1, z = 1
// 5 9     b = 5, w = 5
// 2 3 4   bc = 2, wc = 3, z = 4
// 3 6     b = 3, w = 6
// 9 1 1   bc = 9, wc = 1, z = 1
// 7 7     b = 7, w = 7
// 4 2 1   bc = 4, wc = 2, z = 1
// 3 3     b = 3, w = 3
// 1 9 2   bc = 1, wc = 9, z = 2
// Sample Output

// 20
// 37
// 12
// 35
// 12
// Explanation

// Test Case #01:
// Since black gifts cost the same as white, there is no benefit to converting the gifts. Taum will have to buy each gift for 1 unit. The cost of buying all gifts will be: .

// Test Case #02:
// Again, he cannot decrease the cost of black or white gifts by converting colors.  is too high. He will buy gifts at their original prices, so the cost of buying all gifts will be: .

// Test Case #03:
// Since , he will buy  white gifts at their original price of .  of the gifts must be black, and the cost per conversion, . Total cost is .

// Test Case #04:
// Similarly, he will buy  white gifts at their original price, . For black gifts, he will first buy white ones and color them to black, so that their cost will be reduced to . So cost of buying all gifts will be: .

// Test Case #05: He will buy black gifts at their original price, . For white gifts, he will first black gifts worth  unit and color them to white for  units. The cost for white gifts is reduced to  units. The cost of buying all gifts will be: .

import java.io.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'taumBday' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   * 1. INTEGER b
   * 2. INTEGER w
   * 3. INTEGER bc
   * 4. INTEGER wc
   * 5. INTEGER z
   */

  public static long taumBday(int b, int w, int bc, int wc, int z) {
    // Write your code here
    long priceB = Math.min(bc, wc + z); // conversion price
    long priceW = Math.min(wc, bc + z); // conversion price
    return (long) (b * priceB + w * priceW);
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

        int b = Integer.parseInt(firstMultipleInput[0]);

        int w = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int bc = Integer.parseInt(secondMultipleInput[0]);

        int wc = Integer.parseInt(secondMultipleInput[1]);

        int z = Integer.parseInt(secondMultipleInput[2]);

        long result = Result.taumBday(b, w, bc, wc, z);

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
