
// Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".


// allStar("hello") → "h*e*l*l*o"
// allStar("abc") → "a*b*c"
// allStar("ab") → "a*b"

package CodingBat.recursion;

public class allStar {
  public String allStar(String str) {
    //BaseCase
    if(str.length() <=1) return str;
    //Recursion
    return str.charAt(0) + "*" + allStar(str.substring(1));
  }
}
