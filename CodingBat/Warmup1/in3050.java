
// Given 2 int values, return true if they are both in the range 30..40 inclusive, or they are both in the range 40..50 inclusive.


// in3050(30, 31) → true
// in3050(30, 41) → false
// in3050(40, 50) → true

package CodingBat.Warmup1;

public class in3050 {
  public boolean in3050(int a, int b) {
    boolean aRange1 = a>=30 && a<=40;
    boolean bRange1 = b>=30 && b<=40;
    boolean aRange2 = a>=40 && a<=50;
    boolean bRange2 = b>=40 && b<=50;
    
    return aRange1 && bRange1 || aRange2 && bRange2;
  }
}
