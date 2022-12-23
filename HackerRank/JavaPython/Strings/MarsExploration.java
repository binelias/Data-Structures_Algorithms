// Sample Input 0

// SOSSPSSQSSOR
// Sample Output 0

// 3
// Explanation 0

// s = SOSSPSSQSSOR, and signal length 12. They sent 4 SOS messages (i.e.: 12/3 = 4).

// Expected signal: SOSSOSSOSSOS
// Recieved signal: SOSSPSSQSSOR
// Difference:          X  X   X
// Sample Input 1

// SOSSOT
// Sample Output 1

// 1
// Explanation 1

// s = SOSSOT, and signal length 6. They sent 2 SOS messages (i.e.: 6/3 = 2).

// Expected Signal: SOSSOS     
// Received Signal: SOSSOT
// Difference:           X
// Sample Input 2

// SOSSOSSOS
// Sample Output 2

// 0
// Explanation 2

// Since no character is altered, return 0.

import java.io.*;

class Result {

  /*
   * Complete the 'marsExploration' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  public static int marsExploration(String s) {
    // Write your code here
    String sos = "SOS";
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != sos.charAt(i % 3)) {
        count++;
      }
    }
    return count;

  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    int result = Result.marsExploration(s);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
