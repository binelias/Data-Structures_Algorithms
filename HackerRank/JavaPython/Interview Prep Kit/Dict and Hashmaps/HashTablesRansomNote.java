// Sample Input 0
// 6 4
// give me one grand today night
// give one grand today

// Sample Output 0
// Yes

// Sample Input 1
// 6 5
// two times three is not four
// two times two is four

// Sample Output 1
// No

// Explanation 1
// 'two' only occurs once in the magazine.

// Sample Input 2
// 7 4
// ive got a lovely bunch of coconuts
// ive got some coconuts

// Sample Output 2
// No

// Explanation 2
// Harold's magazine is missing the word some.


package HackerRank.JavaPython.Interview Prep Kit.Dict and Hashmaps;

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
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
    // Write your code here
      Collections.sort(magazine);
      Collections.sort(note);
      
      for(int i = 0; i <note.size(); i++) {
        if(!magazine.remove(note.get(i))) {
          System.out.println("No");
          return;
        }
      }
      System.out.println("Yes");
      
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}

