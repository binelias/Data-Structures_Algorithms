// Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.


// countX("xxhixx") → 4
// countX("xhixhix") → 3
// countX("hi") → 0

package CodingBat.recursion;

public class countX {
  public int countX(String str) {
    //BaseCase
    if(str.length() == 0) return 0;
    
    //Recursion
    if(str.charAt(0) == 'x') return 1 + countX(str.substring(1));
    return countX(str.substring(1));
  }
}
