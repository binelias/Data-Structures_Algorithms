// Input Format

// The first line contains two space-separated integers,  and , the number of clouds and the jump distance.
// The second line contains  space-separated integers  where . Each cloud is described as follows:

// If 0, then cloud  is a cumulus cloud so 2 steps.
// If 1, then cloud  is a thunderhead o 1 steps.

// Sample Input

// STDIN             Function
// -----             --------
// 8 2               n = 8, k = 2
// 0 0 1 0 0 1 1 0   c = [0, 0, 1, 0, 0, 1, 1, 0]
// Sample Output

// 92
// Explanation

// In the diagram below, red clouds are thunderheads and purple clouds are cumulus clouds:

// game board

// Observe that our thunderheads are the clouds numbered , , and . The character makes the following sequence of moves:

// Move: 0->2, Energy: 100-1-2=97.
// Move: 2->4, Energy: 97-1=96.
// Move: 4->6, Energy: 96-1-2=93.
// Move: 6->0, Energy: 93-1=92.

import java.io.*;
import java.util.*;

public class Solution {

  // Complete the jumpingOnClouds function below.
  static int jumpingOnClouds(int[] c, int k) {
    int e = 100;
    int i = 0;
    int n = c.length;
    do {
      i = (i + k) % n;
      e -= c[i] == 0 ? 1 : 3;
    } while (i != 0);
    return e;

  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nk = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nk[0]);

    int k = Integer.parseInt(nk[1]);

    int[] c = new int[n];

    String[] cItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int cItem = Integer.parseInt(cItems[i]);
      c[i] = cItem;
    }

    int result = jumpingOnClouds(c, k);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
