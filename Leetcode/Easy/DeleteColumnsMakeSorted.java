// You are given an array of n strings strs, all of the same length.

// The strings can be arranged such that there is one on each line, making a grid. For example, strs = ["abc", "bce", "cae"] can be arranged as:

// abc
// bce
// cae
// You want to delete the columns that are not sorted lexicographically. In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted while column 1 ('b', 'c', 'a') is not, so you would delete column 1.

// Return the number of columns that you will delete.

// Example 1:

// Input: strs = ["cba","daf","ghi"]
// Output: 1
// Explanation: The grid looks as follows:
//   cba
//   daf
//   ghi
// Columns 0 and 2 are sorted, but column 1 is not, so you only need to delete 1 column.
// Example 2:

// Input: strs = ["a","b"]
// Output: 0
// Explanation: The grid looks as follows:
//   a
//   b
// Column 0 is the only column and is sorted, so you will not delete any columns.
// Example 3:

// Input: strs = ["zyx","wvu","tsr"]
// Output: 3
// Explanation: The grid looks as follows:
//   zyx
//   wvu
//   tsr
// All 3 columns are not sorted, so you will delete all 3.

// Constraints:

// n == strs.length
// 1 <= n <= 100
// 1 <= strs[i].length <= 1000
// strs[i] consists of lowercase English letters.

// Approach: Matrix Traversing
// Intuition
// We have NNN strings, each of the same length, say KKK, in a list strs. If we make a grid or matrix using these strings with one on each line, we want to find the number of columns in the matrix that are not in lexicographic order.

// To be in lexicographic order, each character in the column should be equal to or greater than the corresponding character in the previous row. Therefore, we will iterate over the columns and for each column, we will iterate over the rows starting from index 1 (not zero, as we will compare the character to the character in the previous row). We will then increment the count of unsorted columns every time we observe a character smaller than the character in the previous row.

// The figure below demonstrates three cases, each with four rows and a single column. The first two columns are sorted as the characters are in lexicographic order. However, the last one is not as the smaller character e comes after g.

// fig

// Algorithm
// Iterate over the columns from 0 to K - 1, for each column col:

// Iterate over the rows row from 1 to N - 1:

// If the character at index col in the string strs[row] is smaller than the character at index col in the string strs[row - 1], then increment the counter variable answer. Also, we can break the inner loop here as we find the current column unsorted.
// Otherwise, we check the next row.
// Return answer.

class Solution {
  public int minDeletionSize(String[] strs) {
    // String length.
    int K = strs[0].length();

    // Variable to store the count of columns to be deleted.
    int answer = 0;
    // Iterate over each index in the string.
    for (int col = 0; col < K; col++) {
      // Iterate over the strings.
      for (int row = 1; row < strs.length; row++) {
        // Characters should be in increasing order,
        // If not, increment the counter.
        if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
          answer++;
          break;
        }
      }
    }

    return answer;
  }
}