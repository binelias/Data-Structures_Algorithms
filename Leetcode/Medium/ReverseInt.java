// Example 1:
// Input: x = 123
// Output: 321

// Example 2:
// Input: x = -123
// Output: -321

// Example 3:
// Input: x = 120
// Output: 21

package Data_Structures_Algorithms.Leetcode.Medium;

import java.io.*;

public class ReverseInt {
  public int reverse(int x) {
    boolean neg = (x<0);
    long y = x;
    if(neg) y = -y;
    long str = Long.parseLong( new StringBuilder(""+ y).reverse().toString() );
    if(neg) str = -str;
    if(str>Integer.MAX_VALUE || str<Integer.MIN_VALUE) return 0;
    return (int) str;
  }

  public int reverse(int x) {
    boolean neg = (x<0);
    long y = x;
    if(neg) y = -y;
    String result = String.valueOf(y); 
    int length = result.length();
    String res = "";
    for (int i = length - 1; i >= 0; i--) {
      res += result.charAt(i);
    }
    long str = Long.parseLong(res);
    if(neg) str = -str;
    if(str>Integer.MAX_VALUE || str<Integer.MIN_VALUE) return 0;
    
    return (int) str;
  }
}

