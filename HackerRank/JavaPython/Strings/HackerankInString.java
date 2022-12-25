// Sample Input 0

// 2
// hereiamstackerrank
// hackerworld
// Sample Output 0

// YES
// NO
// Explanation 0

// We perform the following  queries:


// The characters of hackerrank are bolded in the string above. Because the string contains all the characters in hackerrank in the same exact order as they appear in hackerrank, we return YES.
//  does not contain the last three characters of hackerrank, so we return NO.
// Sample Input 1

// 2
// hhaacckkekraraannk
// rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt
// Sample Output 1

// YES
// NO

import java.io.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'hackerrankInString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String hackerrankInString(String s) {
        // Write your code here
        String hackerrank = "hackerrank";
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == hackerrank.charAt(index)) {
                index++;
            }
            if (index == hackerrank.length()) {
                return "YES";
            }
        }
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.hackerrankInString(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
