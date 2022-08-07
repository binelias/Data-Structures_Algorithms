// Sample Input
// cde
// abc

// Sample Output
// 4

// Explanation
// Delete the following characters from the strings make them anagrams:
// Remove d and e from cde to get c.
// Remove a and b from abc to get c.
// It takes 4 deletions to make both strings anagrams.

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static int makeAnagram(String a, String b) {
    // Write your code here
      int count = 0, matchCount = 0, initialCount=b.length();
      for(char aChar: a.toCharArray()) {
        if(b.indexOf(aChar) != -1){
          b = b.replaceFirst(""+aChar, "");
          matchCount++;
        }else count++;
      }
      return count + initialCount - matchCount;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = Result.makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}




