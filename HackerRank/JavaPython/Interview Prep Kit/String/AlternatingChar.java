// Sample Input
// 5
// AAAA
// BBBBB
// ABABABAB
// BABABA
// AAABBB

// Sample Output
// 3
// 4
// 0
// 0
// 4

// Explanation
// The characters marked red are the ones that can be deleted so that the string does not have matching adjacent characters.

import java.io.*;
import java.util.stream.*;


class Result {

    /*
     * Complete the 'alternatingCharacters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternatingCharacters(String s) {
    // Write your code here
      int count = 0;
      char temp = s.charAt(0);
      for( int i = 1; i < s.length(); i++) {
        if(temp == s.charAt(i)) count ++;
        else if( temp != s.charAt(i)) {
          temp = s.charAt(i);
        }
      }
      return count;
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

                int result = Result.alternatingCharacters(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

