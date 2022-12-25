// You are given an integer array nums of length n, and an integer array queries of length m.

// Return an array answer of length m where answer[i] is the maximum size of a subsequence that you can take from nums such that the sum of its elements is less than or equal to queries[i].

// A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

// Example 1:

// Input: nums = [4,5,2,1], queries = [3,10,21]
// Output: [2,3,4]
// Explanation: We answer the queries as follows:
// - The subsequence [2,1] has a sum less than or equal to 3. It can be proven that 2 is the maximum size of such a subsequence, so answer[0] = 2.
// - The subsequence [4,5,1] has a sum less than or equal to 10. It can be proven that 3 is the maximum size of such a subsequence, so answer[1] = 3.
// - The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be proven that 4 is the maximum size of such a subsequence, so answer[2] = 4.
// Example 2:

// Input: nums = [2,3,4,5], queries = [1]
// Output: [0]
// Explanation: The empty subsequence is the only subsequence that has a sum less than or equal to 1, so answer[0] = 0.

// Sort and Count.
// Intuition
// For each query query, we want the maximize the size of the subsequence, which means we want to collect as many numbers as possible before their sum exceeds the limit query. Another key observation is that the target we look for does not depend on the order of the "subsequence", and it becomes a "set" of element necessarily. In this case, we are allowed to sort since it is order-independent.

// Therefore we should collect numbers from lowest to highest. Sorting nums is therefore necessary for it allows us to traverse over nums and collect numbers from lowest to highest as needed.

// img

// Take the following slides as an example.

// Current

// Algorithm
// Sort nums, and initialize an empty array answer.
// For each query query, we traverse the sorted num and collect numbers from lowest to highest, and record the maximum number of elements we can collect count before their sum exceeds query. Add count to answer.
// Return answer when the iteration stops.

class Solution {
  public int[] answerQueries(int[] nums, int[] queries) {
    // Sort 'nums'
    Arrays.sort(nums);
    int n = nums.length, m = queries.length;
    int answer[] = new int[m];

    // For each query, collect numbers from lowest to highest.
    // If their sum exceeds the limit 'query', move on to the next query.
    for (int i = 0; i < m; ++i) {
      int count = 0;
      int query = queries[i];
      for (int num : nums) {
        if (query >= num) {
          count++;
          query -= num;
        } else
          break;
      }
      answer[i] = count;
    }
    return answer;

  }
}