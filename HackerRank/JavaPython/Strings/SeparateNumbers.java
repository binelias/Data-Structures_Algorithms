// A numeric string s,is beautiful if it can be split into a sequence of two or more positive integers,a[1,a[2],....,a[n], satisfying the following conditions:

// 1. a[i] - a[i-1] = 1 for any  (i.e., each element in the sequence is  more than the previous element).

// 2.No a[i] contains a leading zero. For example, we can split s =10203 into the sequence {1,02,03}, but it is not beautiful because 02 and 03 have leading zeroes.

// Sample Input 0

// 7
// 1234
// 91011
// 99100
// 101103
// 010203
// 13
// 1
// Sample Output 0

// YES 1
// YES 9
// YES 99
// NO
// NO
// NO
// NO
// Explanation 0

// The first three numbers are beautiful (see the diagram above). The remaining numbers are not beautiful:

// For s=101103, all possible splits violate the first and/or second conditions.
// For s=0120203, it starts with a zero so all possible splits violate the second condition.
// For s=13, the only possible split is , which violates the first condition.
// For s=1, there are no possible splits because  only has one digit.

// Sample Input 1

// 4
// 99910001001
// 7891011
// 9899100
// 999100010001
// Sample Output 1

// YES 999
// YES 7
// YES 98
// NO

import java.io.*;
import java.math.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'separateNumbers' function below.
   *
   * The function accepts STRING s as parameter.
   */

  public static void separateNumbers(String s) {
    // Write your code here

    for (int n = 1; n < s.length() / 2 + 1; n++) {
      // get the substring with first n digits
      String substr = s.substring(0, n);
      // transfer to number
      BigInteger number = new BigInteger(substr);

      int idx = n;
      while (true) {
        // add one to number
        number = number.add(BigInteger.ONE);
        // if we check that (number + 1) is the next number
        if (s.indexOf(number.toString(), idx) == idx) {
          // skip the index
          idx += number.toString().length();
        } else {
          break;
        }
        if (idx == s.length()) {
          // finished traversing whole string
          System.out.println("YES " + substr);
          return;
        }
      }
    }
    System.out.println("NO");

  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q).forEach(qItr -> {
      try {
        String s = bufferedReader.readLine();

        Result.separateNumbers(s);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}
