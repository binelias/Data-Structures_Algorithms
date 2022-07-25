// Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.


// canBalance([1, 1, 1, 2, 1]) → true
// canBalance([2, 1, 1, 2, 1]) → false
// canBalance([10, 10]) → true

public class canBalance {
  int right = 0;
  int left = 0;
  
  for(int i=0; i<nums.length; i++) left+=nums[i];
  for(int i =0;i<=nums.length-2;i++) {
    right += nums[i];
    left -= nums[i];
    
    if(right == left) return true;
  }
  return false;
}
