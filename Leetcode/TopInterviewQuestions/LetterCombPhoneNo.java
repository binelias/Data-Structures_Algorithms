// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// Example 1:
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

// Example 2:
// Input: digits = ""
// Output: []

// Example 3:
// Input: digits = "2"
// Output: ["a","b","c"]

// Constraints:
// 0 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9']

// Approach
// First, I find the number of combinations which is equal to: N = [number of letters in digit] * [number of letters in digit] * ... * [number of letters in last digit].
// Then I just looped over all buttons in a given sequence and found the combination. After that I added it to the set. I repeated this until the number of elements in the set reaches the number of precalculated combinations (N).

class Solution {
  char[][] letters = new char[][] {
      { 'a', 'b', 'c' },
      { 'd', 'e', 'f' },
      { 'g', 'h', 'i' },
      { 'j', 'k', 'l' },
      { 'm', 'n', 'o' },
      { 'p', 'q', 'r', 's' },
      { 't', 'u', 'v' },
      { 'w', 'x', 'y', 'z' }
  };

  // hashset
  public List<String> letterCombinations(String digits) {
    // corner case
    if (digits.length() == 0)
      return new ArrayList<>();

    Set<String> set = new HashSet<>();
    int numCombinations = 1;

    for (int i = 0; i < digits.length(); i++) {
      int len = letters[digits.charAt(i) - '0' - 2].length;
      numCombinations *= len;
    }

    StringBuilder sb = new StringBuilder();
    Random random = new Random();

    while (set.size() < numCombinations) {
      for (int i = 0; i < digits.length(); i++) {
        char[] temp = letters[digits.charAt(i) - '0' - 2];
        int idx = random.nextInt(temp.length);
        sb.append(temp[idx]);
      }
      set.add(sb.toString());
      sb.setLength(0);
    }
    return new ArrayList<>(set);
  }
}

// Approach
// Here, I use backtracking. I just find all the combinations by looping thru
// them.

class Solution {
  char[][] buttons = new char[][] {
      { 'a', 'b', 'c' },
      { 'd', 'e', 'f' },
      { 'g', 'h', 'i' },
      { 'j', 'k', 'l' },
      { 'm', 'n', 'o' },
      { 'p', 'q', 'r', 's' },
      { 't', 'u', 'v' },
      { 'w', 'x', 'y', 'z' }
  };
  List<String> res;

  // backtracking
  public List<String> letterCombinations(String digits) {
    // corner case
    if (digits.length() == 0)
      return new ArrayList<>();

    res = new ArrayList<>();
    traverse(1, buttons[digits.charAt(0) - '0' - 2], digits, new StringBuilder());
    return res;
  }

  private void traverse(int idx, char[] button, String digits, StringBuilder sb) {
    if (sb.length() >= digits.length()) {
      res.add(sb.toString());
      return;
    }
    for (int i = 0; i < button.length; i++) {
      sb.append(button[i]);
      if (idx >= digits.length()) {
        traverse(idx + 1, button, digits, sb);
      } else {
        traverse(idx + 1, buttons[digits.charAt(idx) - '0' - 2], digits, sb);
      }
      sb.setLength(sb.length() - 1);
    }
  }
}