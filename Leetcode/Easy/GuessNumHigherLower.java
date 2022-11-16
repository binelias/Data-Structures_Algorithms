// We are playing the Guess Game. The game is as follows:

// I pick a number from 1 to n. You have to guess which number I picked.

// Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

// You call a pre-defined API int guess(int num), which returns three possible results:

// -1: Your guess is higher than the number I picked (i.e. num > pick).
// 1: Your guess is lower than the number I picked (i.e. num < pick).
// 0: your guess is equal to the number I picked (i.e. num == pick).
// Return the number that I picked.

// Example 1:

// Input: n = 10, pick = 6
// Output: 6
// Example 2:

// Input: n = 1, pick = 1
// Output: 1
// Example 3:

// Input: n = 2, pick = 1
// Output: 1

// Constraints:

// 1 <= n <= 231 - 1
// 1 <= pick <= n

// Approach 2: Using Binary Search
// Algorithm

// We can apply Binary Search to find the given number. We start with the mid number. We pass that number to the guessguessguess function. If it returns a -1, it implies that the guessed number is larger than the required one. Thus, we use Binary Search for numbers lower than itself. Similarly, if it returns a 1, we use Binary Search for numbers higher than itself.

/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is higher than the picked number
 *         1 if num is lower than the picked number
 *         otherwise return 0
 *         int guess(int num);
 */

public class Solution extends GuessGame {
  public int guessNumber(int n) {
    int low = 1;
    int high = n;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int res = guess(mid);
      if (res == 0)
        return mid;
      else if (res < 0)
        high = mid - 1;
      else
        low = mid + 1;
    }
    return -1;
  }// T:O(log2n), S:O(1)
}