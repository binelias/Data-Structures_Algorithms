
// Given a string, if the first or last chars are 'x', return the string without those 'x' chars, and otherwise return the string unchanged.


// withoutX("xHix") → "Hi"
// withoutX("xHi") → "Hi"
// withoutX("Hxix") → "Hxi"

public class WithoutX {
  public String withoutX(String str) {
    int begin = 0; 
    int end = str.length();
    
    if(str.length()<1) return str;
    if(str.charAt(0) == 'x' && str.length() > 0) begin = 1;
    if(str.length()> 1 &&  str.charAt(str.length()-1) == 'x') end--; 
    
    return str.substring(begin, end);
  }
}
