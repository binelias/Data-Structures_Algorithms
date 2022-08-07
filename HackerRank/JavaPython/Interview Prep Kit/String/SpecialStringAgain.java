// Sample Input 0
// 5
// asasd

// Sample Output 0
// 7 

// Explanation 0
// The special palindromic substrings of s = asasd are {a,s,a,s,d,asa,sas}


// Sample Input 1
// 7
// abcbaba

// Sample Output 1
// 10 

// Explanation 1

// The special palindromic substrings of s=abcbaba are {a,b,c,b,a,b,a,bcb,bab,aba}

// Sample Input 2
// 4
// aaaa

// Sample Output 2
// 10

// Explanation 2
// The special palindromic substrings of s=aaaa are {a,a,a,a,aa,aa,aa,aaa,aaa,aaaa}

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the substrCount function below.
    // for same characters' count: f(n) = f(n-1) + n
    static long substrCount(int n, String s) {
      char prevc = ' ', midc = ' ', currc = ' ';
      int prevn = 1, midn = 1, currn = 0;
      long res = 0;
      for(int i = 0; i < s.length();i++) {
        if(i == 0 || s.charAt(i) != s.charAt(i-1)) {
          prevc = midc;
          prevn = midn;
          midc = currc;
          midn = currn;
          currc = s.charAt(i);
          currn = 1;
        }else currn++;
        res +=currn;
        if(currc == prevc && midn == 1 && currn <= prevn) res++;
      }
      return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}



