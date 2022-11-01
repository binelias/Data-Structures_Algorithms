// 

import java.io.*;

class Result {

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
        // Write your code here
        int feb = (year >= 1700 && year <= 1917) ? 
        ((year % 4 == 0) ? 29 : 28) : ((year % 400 == 0 || year % 4 == 0 && year % 100 != 0) ? 29 : 28);
        
        int sum = (year == 1918) ? (feb -= 2) : 256 - (31 + feb + 31 + 30 + 31 + 30 + 31 + 31);

        return sum + ".09." + year;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
