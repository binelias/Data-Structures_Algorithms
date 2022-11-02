// Sample Input 0
// 4 1
// 3 10 2 9
// 12

// Sample Output 0
// 5

// Explanation 0
// Anna didn't eat item bill[1] = 10, but she shared the rest of the items with Brian. The total cost of the shared items is 3+2+9 = 14 and, split in half, the cost per person is b(actual) =7. Brian charged her b(charged) =12 for her portion of the bill. We print the amount Anna was overcharged, 12-7= 5, on a new line.

// Sample Input 1
// 4 1
// 3 10 2 9
// 7

// Sample Output 1
// Bon Appetit

// Explanation 1
// Anna didn't eat item 10, but she shared the rest of the items with Brian. The total cost of the shared items is 3+2+9 = 14  and, split in half, the cost per person is 7. Because 7 = 7, we print Bon Appetit on a new line.

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
   * Complete the 'bonAppetit' function below.
   *
   * The function accepts following parameters:
   * 1. INTEGER_ARRAY bill
   * 2. INTEGER k
   * 3. INTEGER b
   */

  public static void bonAppetit(List<Integer> bill, int k, int b) {
    // Write your code here
    int sum = 0;
    for (int i = 0; i < bill.size(); i++) {
      if (i != k)
        sum += bill.get(i);
    }
    sum = sum / 2;
    if (sum == b)
      System.out.print("Bon Appetit");
    else
      System.out.print(b - sum);
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int b = Integer.parseInt(bufferedReader.readLine().trim());

    Result.bonAppetit(bill, k, b);

    bufferedReader.close();
  }
}
