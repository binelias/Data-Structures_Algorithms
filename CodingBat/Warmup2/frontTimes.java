
// Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or whatever is there if the string is less than length 3. Return n copies of the front;


// frontTimes("Chocolate", 2) → "ChoCho"
// frontTimes("Chocolate", 3) → "ChoChoCho"
// frontTimes("Abc", 3) → "AbcAbcAbc"

package CodingBat.Warmup2;

public class frontTimes {
  public String frontTimes(String str, int n) {
    String front = "";
    if(str.length()>=3){
      for(int i=0; i<n; i++) {
        front+=str.substring(0,3);
      }
    }else{
      for(int i=0; i<n; i++) {
        front+=str;
      } 
    }
    return front;
  }

  public String frontTimes2(String str, int n) {
    int frontLen = 3;
    if(frontLen>str.length()){
      frontLen = str.length();
    }
    String front = str.substring(0,frontLen);
    String result = "";
    
    for(int i=0; i<n; i++){
      result+=front;
    }
    return result;
  }
}



