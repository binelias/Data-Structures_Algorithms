
// Given 2 arrays of ints, a and b, return true if they have the same first element or they have the same last element. Both arrays will be length 1 or more.


// commonEnd([1, 2, 3], [7, 3]) → true
// commonEnd([1, 2, 3], [7, 3, 2]) → false
// commonEnd([1, 2, 3], [1, 3]) → true

package CodingBat.Array1;

public class commonEnd {
  public boolean commonEnd(int[] a, int[] b) {
    if(a.length>1 && b.length>1) return a[0] == b[0] || a[a.length-1] == b[b.length-1];
    else return a[0] == b[0];
  }
}
