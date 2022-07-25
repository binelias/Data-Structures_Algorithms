// Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power, so powerN(3, 2) is 9 (3 squared).


// powerN(3, 1) → 3
// powerN(3, 2) → 9
// powerN(3, 3) → 27

package CodingBat.recursion;

public class powerN {
  public int powerN(int base, int n) {
    //BaseCase
    if(n<=1) return base;
    
    //Recusion
    return base*powerN(base, n -1);
  }
  
}
