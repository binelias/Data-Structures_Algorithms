// Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.


// countHi("xxhixx") → 1
// countHi("xhixhix") → 2
// countHi("hi") → 1

package CodingBat.recursion;

public class countHi {
  public int countHi(String str) {
    //BaseCase
    if(str.length() < 2) return 0;
    
    //Recursion
    if(str.substring(0,2).equals("hi")) return 1 + countHi(str.substring(2));
    return countHi(str.substring(1));
  }
}
