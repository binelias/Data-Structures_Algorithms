// Sample Input 0

// STDIN   Function
// -----   --------
// 5 2     n = 5, c[] size m = 2
// 0 4     c = [0, 4]
// Sample Output 0

// 2
// Explanation 0

// This sample corresponds to following graphic:

// hreasy(5).png

// The distance to the nearest space station for each city is listed below:

//  has distance , as it contains a space station.
//  has distance  to the space station in .
//  has distance  to the space stations in  and .
//  has distance  to the space station in .
//  has distance , as it contains a space station.
// We then take .

// Sample Input 1

// 6 6
// 0 1 2 4 3 5
// Sample Output 1

// 0
// Explanation 1

// In this sample,  so every city has space station and we print  as our answer.

import java.io.*;
import java.util.*;

public class Solution {

  // Complete the flatlandSpaceStations function below.
  static int flatlandSpaceStations(int n, int[] c) {
    if (n == c.length) {
      return 0;
    }

    int longest = 0;

    for (int i = 0; i < n; i++) {
      int shortest = Math.abs(i - c[0]);

      for (int j = 0; j < c.length; j++) {
        if (shortest > (Math.abs(i - c[j]))) {
          shortest = Math.abs(i - c[j]);
        }
      }

      if (shortest > longest) {
        longest = shortest;
      }
    }

    return longest;

  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nm = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nm[0]);

    int m = Integer.parseInt(nm[1]);

    int[] c = new int[m];

    String[] cItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < m; i++) {
      int cItem = Integer.parseInt(cItems[i]);
      c[i] = cItem;
    }

    int result = flatlandSpaceStations(n, c);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
