// Sample Input
// 5
// john tom
// john mary
// john tom
// mary anna
// mary anna

// Sample Output
// 1
// 2
// 2
// 3
// 3

// Explanation
// After taking the first input, you have only one pair: (john,tom)
// After taking the second input, you have two pairs: (john, tom) and (john, mary)
// After taking the third input, you still have two unique pairs.
// After taking the fourth input, you have three unique pairs: (john,tom), (john, mary) and (mary, anna)
// After taking the fifth input, you still have three unique pairs.


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    String [] pair_left = new String[t];
    String [] pair_right = new String[t];
    
    for (int i = 0; i < t; i++) {
      pair_left[i] = s.next();
      pair_right[i] = s.next();
    }

    //Write your code here
    HashSet<String> set = new HashSet<>(t);
    for(int i = 0; i < t; i++) {
      set.add(pair_left[i] + " " + pair_right[i]);
      System.out.println(set.size());
    }
  }
}