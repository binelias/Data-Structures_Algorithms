// Sample Input
// 8
// UDDDUDUU

// Sample Output
// 1

package HackerRank.JavaPython.Interview Prep Kit.Warm Up Challenges;

import java.io.*;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
    // Write your code here
      int seaLevel = 0;
      int valley =0;
      for(char paths : path.toCharArray()) {
        if(paths == 'U') seaLevel++;
        else seaLevel--;
    
        if(seaLevel == 0 && paths == 'U') valley++;
      }
      return valley;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

