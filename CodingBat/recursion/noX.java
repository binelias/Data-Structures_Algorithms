// Given a string, compute recursively a new string where all the 'x' chars have been removed.


// noX("xaxb") → "ab"
// noX("abc") → "abc"
// noX("xx") → ""

package CodingBat.recursion;

public class noX {
  public String noX(String str) {
    //BaseCase
    if(str.length() == 0) return str;
    
    //Recursion
    if(str.charAt(0) == 'x') return noX(str.substring(1));
    return str.charAt(0) + noX(str.substring(1));
  }
  
}
