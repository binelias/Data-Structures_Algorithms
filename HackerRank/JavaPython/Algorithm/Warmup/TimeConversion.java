// Sample Input 0
// 07:05:45PM

// Sample Output 0
// 19:05:45

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Result {

  /*
   * Complete the 'timeConversion' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  public static String timeConversion(String s) {
    // Write your code here
    int hrs = Integer.parseInt(s.substring(0, 2));

    if (s.substring(8, 10).equals("PM") && hrs != 12)
      hrs += 12;
    else if (s.substring(8, 10).equals("AM") && hrs == 12)
      hrs = 0;

    return (String.format("%02d", hrs) + ":" + s.substring(3, 5) + ":" + s.substring(6, 8));
  }

  public static String timeConversion1(String s) {
    return LocalTime.parse(s, DateTimeFormatter.ofPattern("hh:mm:ssa")).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    String result = Result.timeConversion(s);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
