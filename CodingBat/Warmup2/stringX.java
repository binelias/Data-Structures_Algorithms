
// Given a string, return a version where all the "x" have been removed. Except an "x" at the very start or end should not be removed.


// stringX("xxHxix") → "xHix"
// stringX("abxxxcd") → "abcd"
// stringX("xabxxxcdx") → "xabcdx


package CodingBat.Warmup2;

public class stringX {
  public String stringX(String str) {
    String result = "";
    for (int i=0; i<str.length(); i++) {
      // Only append the char if it is not the "x" case
      if (!(i > 0 && i < (str.length()-1) && str.substring(i, i+1).equals("x"))) {
        result = result + str.substring(i, i+1); // Could use str.charAt(i) here
      }
    }
    return result;
  }
}
