
// Given a string and a non-empty substring sub, compute recursively if at least n copies of sub appear in the string somewhere, possibly with overlapping. N will be non-negative.


// strCopies("catcowcat", "cat", 2) → true
// strCopies("catcowcat", "cow", 2) → false
// strCopies("catcowcat", "cow", 1) → true


package CodingBat.recursion;

public class strCopies {
  public boolean strCopies(String str, String sub, int n) {
    //BaseCase
    if(n == 0) return true;
    if(str.length() < sub.length()) return false;
    //Recursion
    if(str.substring(0,sub.length()).equals(sub)) return strCopies(str.substring(1),sub, n-1);
    return strCopies(str.substring(1), sub, n);
  }
}
