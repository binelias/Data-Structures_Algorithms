// Sample Input 0

// aaabccddd
// Sample Output 0

// abd
// Explanation 0

// Perform the following sequence of operations to get the final string:

// aaabccddd → abccddd → abddd → abd
// Sample Input 1

// aa
// Sample Output 1

// Empty String
// Explanation 1

// aa → Empty String
// Sample Input 2

// baab
// Sample Output 2

// Empty String
// Explanation 2

// baab → bb → Empty String

//  Time Complexity: O(n)
// Space Complexity: O(n)

// Can alternatively use an ArrayDeque instead of a Stack. Just make sure to iterate
// through it properly since iteration order is opposite that of a Stack.

import java.io.*;
import java.util.*;

class Result {

  /*
   * Complete the 'superReducedString' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  public static String superReducedString(String s) {
    // Write your code here
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      Character ch = s.charAt(i);
      if (!stack.isEmpty() && ch == stack.peek()) {
        stack.pop(); // since String has 2 adjacent equal characters
      } else {
        stack.push(ch);
      }
    }

    // Return final result
    if (stack.isEmpty()) {
      return "Empty String";
    } else {
      StringBuffer sb = new StringBuffer();
      for (char ch : stack) {
        sb.append(ch);
      }
      return sb.toString();
    }

  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    String result = Result.superReducedString(s);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
