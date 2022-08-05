
// Given a string of any length, return a new string where the last 2 chars, if present, are swapped, so "coding" yields "codign".


// lastTwo("coding") → "codign"
// lastTwo("cat") → "cta"
// lastTwo("ab") → "ba"

public class LastTwo {
  public String lastTwo(String str) {
    //CornerCase
    if(str.length()<2) return str;
    
    return str.substring(0,str.length()-2) + str.substring(str.length()-1) + 
      str.charAt(str.length()-2);
  }
}
