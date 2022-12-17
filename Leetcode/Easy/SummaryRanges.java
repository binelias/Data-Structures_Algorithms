// You are given a sorted unique integer array nums.

// A range [a,b] is the set of all integers from a to b (inclusive).

// Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

// Each range [a,b] in the list should be output as:

// "a->b" if a != b
// "a" if a == b

// Example 1:

// Input: nums = [0,1,2,4,5,7]
// Output: ["0->2","4->5","7"]
// Explanation: The ranges are:
// [0,2] --> "0->2"
// [4,5] --> "4->5"
// [7,7] --> "7"
// Example 2:

// Input: nums = [0,2,3,4,6,8,9]
// Output: ["0","2->4","6","8->9"]
// Explanation: The ranges are:
// [0,0] --> "0"
// [2,4] --> "2->4"
// [6,6] --> "6"
// [8,9] --> "8->9"

// With every range that we want to insert, we basically need to know the start and end of a particular range. So we can either maintain two such variables or an array of size 2 with index 0 representing the starting value and index 1 representing the ending value of a range.

// Next, we initialize starting value to be the first value in the array, and the ending value to be same as starting value.

// Logic
// Now, we loop through the entire array and follow these steps:

// If consecutive elements (Elements at index i and i + 1) have a difference of 1, we update end to be the next element (Element at index i + 1).
// Else, we add the current set of start and end values to our solution, and update start and end values, both to the next element in the array (Element at index i + 1).
// Creating Strings

// If both start and end values are same, it indicates that there is only one element in this particular range. So the string that we will need is just "start" OR "end"
// Else, the string would be start + "->" + end

class Solution {
  public List<String> summaryRanges(int[] nums) {
    // Solution list containing all ranges
    List<String> solution = new ArrayList<String>();

    // Edge case condition
    if (nums.length == 0) {
      return solution;
    }

    // currValues array
    // *start* value at index 0
    // *end* value at index 1
    int[] currValues = new int[2];
    currValues[0] = nums[0];
    currValues[1] = nums[0];

    // Iterating through the entire array
    for (int i = 0; i < nums.length - 1; i++) {

      // If consecutive elements differ by only 1.
      // We update the value of *end*
      // Else, we add the current range to our solution list
      // And update *start* and *end* values in *currValues*
      if (nums[i + 1] - nums[i] == 1) {
        currValues[1] = nums[i + 1];
      } else {
        // Creating strings using the aforementioned steps
        StringBuilder currString = new StringBuilder("" + currValues[0]);
        if (currValues[1] != currValues[0]) {
          currString.append("->" + currValues[1]);
        }
        solution.add(currString.toString());
        currValues[0] = nums[i + 1];
        currValues[1] = nums[i + 1];
      }
    }

    // Creating the last string which is left to be inserted
    StringBuilder currString = new StringBuilder("" + currValues[0]);
    if (currValues[1] != currValues[0]) {
      currString.append("->" + currValues[1]);
    }
    solution.add(currString.toString());

    return solution;
  }
}