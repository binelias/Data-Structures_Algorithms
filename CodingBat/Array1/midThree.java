
// Given an array of ints of odd length, return a new array length 3 containing the elements from the middle of the array. The array length will be at least 3.


// midThree([1, 2, 3, 4, 5]) → [2, 3, 4]
// midThree([8, 6, 7, 5, 3, 0, 9]) → [7, 5, 3]
// midThree([1, 2, 3]) → [1, 2, 3]

package CodingBat.Array1;

public class midThree {
  public int[] midThree(int[] nums) {
    int middle = nums.length/2;
    return new int[] {nums[middle-1], nums[middle], nums[middle+1]};
  }
}
