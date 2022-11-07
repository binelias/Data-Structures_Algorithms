// 

// Algorithm
// Initialize an integer num_copy = num for checking digits.
// Get the remainder of num_copy and 101010.
// If the remainder is 666, record the current digit as the first (highest) digit of 6.
// Divide num_copy by 101010 using integer division.
// If num_copy = 0, go to step 5.
// Otherwise, repeat step 2.
// If we find the first digit of 6, let's say index_first_six, increment num by 3⋅10index_first_six3 \cdot 10^{index\_first\_six}3⋅10 
// index_first_six
//   and return num. Otherwise, just return num.

class Solution {
  public int maximum69Number(int num) {
    // Since we start with the lowest digit, initialize currDigit = 0.
    int numCopy = num;
    int indexSix = -1;
    int currDigit = 0;

    // Check every digit of 'numCopy' from low to high.
    while (numCopy > 0) {
      // If the current digit is '6', record it as the highest digit of 6.
      if (numCopy % 10 == 6)
        indexSix = currDigit;

      // Move on to the next digit.
      numCopy /= 10;
      currDigit++;
    }

    // If we don't find any digit of '6', return the original number,
    // otherwise, increment 'num' by the difference made by the first '6'.
    return indexSix == -1 ? num : num + 3 * (int) Math.pow(10, indexSix);
  }// T:O(n), S:O(1)

}