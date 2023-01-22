// Given a string s, partition s such that every 
// substring
// of the partition is a 
// palindrome
// . Return all possible palindrome partitioning of s.

// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]
// Example 2:

// Input: s = "a"
// Output: [["a"]]

// Constraints:

// 1 <= s.length <= 16
// s contains only lowercase English letters.

// Backtracking with Dynamic Programming
// Intuition

// This approach uses a similar backtracking algorithm as discussed in Approach 1. But, the previous approach performs one extra iteration to determine if a given substring is a palindrome or not. Here, we are repeatedly iterating over the same substring multiple times and the result is always the same. There are overlapping subproblems and we could further optimize the approach by using dynamic programming to determine if a string is a palindrome in constant time. Let's understand the algorithm in detail.

// Algorithm

// A given string sss starting at index start\text{start}start and ending at index end\text{end}end is a palindrome if the following conditions are satisfied:

// The characters at start\text{start}start and end\text{end}end indexes are equal.
// The substring starting at index start+1\text{start}+1start+1 and ending at index end−1\text{end}-1end−1 is a palindrome.
// img

// Let NNN be the length of the string. To determine if a substring starting at index start\text{start}start and ending at index end\text{end}end is a palindrome or not, we use a 2 Dimensional array dp\text{dp}dp of size N⋅NN \cdot NN⋅N where,

// dp[start][end]=true\text{dp[start][end]} = \text{true}dp[start][end]=true, if the substring beginning at index start\text{start}start and ending at index end\text{end}end is a palindrome.

// Otherwise, dp[start][end] ==false\text{dp[start][end] }== \text{false}dp[start][end] ==false.

// Also, we must update the dp\text{dp}dp array, if we find that the current string is a palindrome.

class Solution {
  public List<List<String>> partition(String s) {
    int len = s.length();
    boolean[][] dp = new boolean[len][len];
    List<List<String>> result = new ArrayList<>();
    dfs(result, s, 0, new ArrayList<>(), dp);
    return result;
  }

  void dfs(List<List<String>> result, String s, int start, List<String> currentList, boolean[][] dp) {
    if (start >= s.length())
      result.add(new ArrayList<>(currentList));
    for (int end = start; end < s.length(); end++) {
      if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
        dp[start][end] = true;
        currentList.add(s.substring(start, end + 1));
        dfs(result, s, end + 1, currentList, dp);
        currentList.remove(currentList.size() - 1);
      }
    }
  }
}