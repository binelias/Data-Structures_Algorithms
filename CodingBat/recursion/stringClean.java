
// Given a string, return recursively a "cleaned" string where adjacent chars that are the same have been reduced to a single char. So "yyzzza" yields "yza".


// stringClean("yyzzza") → "yza"
// stringClean("abbbcdd") → "abcd"
// stringClean("Hello") → "Helo"

package CodingBat.recursion;

public class stringClean {
  public String stringClean(String str) {
    //BaseCase
    if(str.length()<2) return str;
    //Recursion
    if(str.charAt(0) == str.charAt(1)) return stringClean(str.substring(1));
    return str.charAt(0) + stringClean(str.substring(1));
  }
}
