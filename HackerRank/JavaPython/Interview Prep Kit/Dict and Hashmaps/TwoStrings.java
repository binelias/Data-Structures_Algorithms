// Sample Input
// 2
// hello
// world
// hi
// world

// Sample Output
// YES
// NO

package HackerRank.JavaPython.Interview Prep Kit.Dict and Hashmaps;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings(String s1, String s2) {
    // Write your code here
      HashSet<Character> set = new HashSet<>();
      for(int i = 0; i<s1.length(); i++) {
        set.add(s1.charAt(i));
      }
      for(int i = 0; i<s2.length(); i++) {
        if(set.contains(s2.charAt(i)))   return "YES";
      }
      return "NO" ;
    }

    public static String twoStrings2(String s1, String s2) {
      // Write your code here
        String ans = "NO";
        if(s2.matches("[a-zA-Z]*[" + s1 + "][a-zA-Z]*")) ans = "YES";
        return ans;
      }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = Result.twoStrings(s1, s2);

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


