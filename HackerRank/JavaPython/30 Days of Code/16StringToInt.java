// Sample Input 0
// 3

// Sample Output 0
// 3

// Sample Input 1
// za

// Sample Output 1
// Bad String

package HackerRank.JavaPython.30 Days of Code;

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String S = bufferedReader.readLine();
        try {
          int num = Integer.parseInt(S);
          System.out.println(num);
        } catch(NumberFormatException e) {
          System.out.println("Bad String");
        }
        bufferedReader.close();
    }
}

