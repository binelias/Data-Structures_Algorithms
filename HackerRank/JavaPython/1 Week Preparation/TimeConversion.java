// Sample Input
// 07:05:45PM

// Sample Output
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
    String time = LocalTime.parse(s,DateTimeFormatter.ofPattern("hh:mm:ssa")).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
  
    return time;
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

