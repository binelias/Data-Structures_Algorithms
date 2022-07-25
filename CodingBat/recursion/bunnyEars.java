// We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).

// bunnyEars(0) → 0
// bunnyEars(1) → 2
// bunnyEars(2) → 4

package CodingBat.recursion;

public class bunnyEars {
  public int bunnyEars(int bunnies) {
    //Base case
    if(bunnies == 0) return 0;
    
    //recursion
    return bunnyEars(bunnies-1)+2;
  }
}
