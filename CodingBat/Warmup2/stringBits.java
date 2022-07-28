
// Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".


// stringBits("Hello") → "Hlo"
// stringBits("Hi") → "H"
// stringBits("Heeololeo") → "Hello"

package CodingBat.Warmup2;

public class stringBits {
  public String stringBits(String str) {
    if(str.length()<2) return str;
    String result = "";
    for(int i=0; i<str.length();i+=2){
      result+=str.charAt(i);
    }
    return result;
  }
}
