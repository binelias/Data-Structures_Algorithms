// Return true if the given string begins with "mix", except the 'm' can be anything, so "pix", "9ix" .. all count.


// mixStart("mix snacks") → true
// mixStart("pix snacks") → true
// mixStart("piz snacks") → false


package CodingBat.Warmup1;

public class mixStart {
  public boolean solution(String str) {
    if(str.length() < 3) return false;
    
    String phrase = str.substring(1,3);
    return phrase.equals("ix") ? true: false;
  }
}
