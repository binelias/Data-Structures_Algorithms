
// Given a string of even length, return a string made of the middle two chars, so the string "string" yields "ri". The string length will be at least 2.


// middleTwo("string") → "ri"
// middleTwo("code") → "od"
// middleTwo("Practice") → "ct"

public class middleTwo {
  public String middleTwo(String str) {
    if(str.length()<=2) return str;
    return str.substring(((str.length()/2)-1),((str.length()/2)-1)+2);
  }
}
