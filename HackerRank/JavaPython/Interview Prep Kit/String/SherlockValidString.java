// Sample Input 0
// aabbcd

// Sample Output 0
// NO

// Sample Input 1
// aabbccddeefghi

// Sample Output 1
// NO

// Sample Input 2
// abcdefghhgfedecba

// Sample Output 2
// YES

// Explanation 2
// All characters occur twice except for  which occurs  times. We can delete one instance of  to have a valid string.

import java.io.*;

class Result {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
    // Write your code here
      int[] alphabets = new int[26];
      
      for(int ch: s.toCharArray()) {
        alphabets[ch-'a']++;
      }
      
      int freq = alphabets[0];
      int count = 0;
      for(int i = 1; i < alphabets.length; i++) {
        if(alphabets[i]-freq != 0 && alphabets[i] !=0) count++;
      }
      return count>1 ? "NO" : "YES"; 
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

