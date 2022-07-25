
// Given two arrays of ints sorted in increasing order, outer and inner, return true if all of the numbers in inner appear in outer. The best solution makes only a single "linear" pass of both arrays, taking advantage of the fact that both arrays are already in sorted order.


// linearIn([1, 2, 4, 6], [2, 4]) → true
// linearIn([1, 2, 4, 6], [2, 3, 4]) → false
// linearIn([1, 2, 4, 4, 6], [2, 4]) → true

public class linearIn {
  public boolean linearIn(int[] outer, int[] inner) {
    int i=0;
    int j=0;
    while(i<inner.length && j<outer.length){
      if(inner[i] > outer[j]){
        j++;
      }else if(inner[i] < outer[j]) {
        return false;
      }else {
        i++;
      }
    }
    if(i!=inner.length) return false;
    return true;
  }
}
