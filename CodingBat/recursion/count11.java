// Given a string, compute recursively (no loops) the number of "11" substrings in the string. The "11" substrings should not overlap.


// count11("11abc11") → 2
// count11("abc11x11x11") → 3
// count11("111") → 1

package CodingBat.recursion;

public class count11 {
  public int count11(String str) {
    //BaseCase
    if(str.length() < 2) return 0;
    //Recursion
    if(str.substring(0,2).equals("11")) return 1 + count11(str.substring(2));
    return count11(str.substring(1));
  }
}
