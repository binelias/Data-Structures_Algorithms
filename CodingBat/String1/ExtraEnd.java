
// Given a string, return a new string made of 3 copies of the last 2 chars of the original string. The string length will be at least 2.


// extraEnd("Hello") → "lololo"
// extraEnd("ab") → "ababab"
// extraEnd("Hi") → "HiHiHi"

public class ExtraEnd {
  public String extraEnd(String str) {
    String res = str.substring(str.length()-2);
    return res + res + res;
  }
}
