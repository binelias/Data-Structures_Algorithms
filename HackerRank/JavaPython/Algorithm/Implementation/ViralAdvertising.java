// 

import java.io.*;

class Result {

  /*
   * Complete the 'viralAdvertising' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER n as parameter.
   */

  public static int viralAdvertising(int n) {
    // Write your code here
    int people = 2;
    int count = 2;
    for (int i = 2; i <= n; i++) {
      people = (people * 3) / 2;
      count += people;
    }
    return count;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    int result = Result.viralAdvertising(n);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
