// Sample Input
// HARRY
// SALLY

// Sample Output
// 2

// Explanation
// The longest string that can be formed by deleting zero or more characters from HARRY and SALLY is AY, whose length is 2.

// Sample Input 1
// AA
// BB

// Sample Output 1
// 0

// Explanation 1
// AA and BB have no characters in common and hence the output is 0.

// Sample Input 3
// ABCDEF
// FBDAMN

// Sample Output 3
// 2

// Explanation 3
// BD is the longest child of the given strings.

import java.io.*;

class Result {

    /*
     * Complete the 'commonChild' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int commonChild(String s1, String s2) {
    // Write your code here
      int[][] twoD = new int[s1.length()+1][s2.length()+1];
      
      for(int i = 0; i < s1.length(); i++) {
        for(int j = 0; j < s2.length(); j++) {
          if(s1.charAt(i) == s2.charAt(j)) {
            twoD[i+1][j+1] = twoD[i][j] +1;
          }else {
            twoD[i+1][j+1] = Math.max(twoD[i+1][j], twoD[i][j+1]);
          }
        }
      }
      return twoD[s1.length()][s2.length()];
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result.commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

