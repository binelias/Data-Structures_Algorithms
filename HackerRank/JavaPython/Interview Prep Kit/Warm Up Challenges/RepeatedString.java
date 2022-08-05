
// Sample Input 0
// aba
// 10

// Sample Output 0
// 7

// Sample Input 1
// a
// 1000000000000
// Sample Output 1

// 1000000000000

import java.io.*;


class Result {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
    // Write your code here
      return n/s.length()*count(s,'a') + count(s.substring(0,(int) (n%s.length())), 'a');
      
    }
    
    static int count(String s, char ch) {
      return (int) s.chars().filter(c -> c == ch).count();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
