// Sample Input 1

// STDIN   Function
// -----   --------
// 2       arr[] size n = 2
// 4 2     arr = [4, 2]
// Sample Output 1

// yes  
// swap 1 2
// Explanation 1

// You can either swap(1, 2) or reverse(1, 2). You prefer swap.

// Sample Input 2

// 3
// 3 1 2
// Sample Output 2

// no
// Explanation 2

// It is impossible to sort by one single operation.

// Sample Input 3

// 6
// 1 5 4 3 2 6
// Sample Output 3

// yes
// reverse 2 5
// Explanation 3

// You can reverse the sub-array d[2...5] = "5 4 3 2", then the array becomes sorted.

// do not make the problem too complex..

// here is the simple java solution. simple steps; just the array and store it as separate array. compare both arrays and get differenceCount, first and last difference Indexes. if difference is 0, yes if difference is 2, yes, swap first last else check the numbers between first and last were in decending order or not. if not print no. if yes print reverse first last

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'almostSorted' function below.
   *
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static void almostSorted(List<Integer> arr) {
    // Write your code here
    List<Integer> sorted = arr.stream().sorted().collect(Collectors.toList());
    int first = -1, last = -1;
    int diff = 0;
    for (int i = 0; i < sorted.size(); i++)
      if (sorted.get(i) != arr.get(i)) {
        if (first == -1)
          first = i;
        else
          last = i;
        diff++;
      }
    if (diff == 0)
      System.out.println("yes");
    else if (diff == 2)
      System.out.println("yes\nswap " + (first + 1) + " " + (last + 1));
    else {
      for (int i = first; i < last; i++) {
        if (arr.get(i) < arr.get(i + 1)) {
          System.out.println("no");
          return;
        }
      }
      System.out.println("yes\nreverse " + (first + 1) + " " + (last + 1));
    }
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    Result.almostSorted(arr);

    bufferedReader.close();
  }
}
