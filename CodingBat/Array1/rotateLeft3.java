
// Given an array of ints length 3, return an array with the elements "rotated left" so {1, 2, 3} yields {2, 3, 1}.


// rotateLeft3([1, 2, 3]) → [2, 3, 1]
// rotateLeft3([5, 11, 9]) → [11, 9, 5]
// rotateLeft3([7, 0, 0]) → [0, 0, 7]

package CodingBat.Array1;

public class rotateLeft3 {
  public int[] rotateLeft3(int[] nums) {
    int[] left = new int[nums.length];
    for(int i=0; i<nums.length-1; i++) {
      left[i] = nums[i+1];
    }
    left[nums.length-1] = nums[0];
    
    return left;
  }
}
