// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// Example 1:
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]

// Example 2:
// Input: n = 1
// Output: ["()"]

// Constraints:
// 1 <= n <= 8

class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList();
    if (n == 0) {
      ans.add("");
    } else {
      for (int c = 0; c < n; ++c)
        for (String left : generateParenthesis(c))
          for (String right : generateParenthesis(n - 1 - c))
            ans.add("(" + left + ")" + right);
    }
    return ans;
  }
}