
// Given a string, compute recursively a new string where all the lowercase 'x' chars have been moved to the end of the string.


// endX("xxre") → "rexx"
// endX("xxhixx") → "hixxxx"
// endX("xhixhix") → "hihixxx"

package CodingBat.recursion;

public class endX {
  public String endX(String str) {
    //BaseCase
    if(str.length() <= 1) return str;
    //Recursion
    if(str.charAt(0) == 'x') return endX(str.substring(1)) +'x';
    return str.charAt(0) + endX(str.substring(1));
  }
}
