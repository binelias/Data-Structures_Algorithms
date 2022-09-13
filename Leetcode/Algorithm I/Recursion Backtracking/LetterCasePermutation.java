// Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

// Return a list of all possible strings we could create. Return the output in any order.

// Example 1:
// Input: s = "a1b2"
// Output: ["a1b2","a1B2","A1b2","A1B2"]

// Example 2:
// Input: s = "3z4"
// Output: ["3z4","3Z4"]

class Solution {
  private void backtrack(List<String> ans, int i, char[] S) {
    if (i == S.length)
      ans.add(new String(S));
    else {
      if (Character.isLetter(S[i])) {
        // if letter
        S[i] = Character.toLowerCase(S[i]);
        backtrack(ans, i + 1, S);// LowerCase

        S[i] = Character.toUpperCase(S[i]);
        backtrack(ans, i + 1, S);// UpperCase
      } else
        backtrack(ans, i + 1, S);
    }
  }

  public List<String> letterCasePermutation(String s) {
    List<String> ans = new ArrayList<>();
    backtrack(ans, 0, s.toCharArray());
    return ans;
  }
}
