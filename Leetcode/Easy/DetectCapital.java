// We define the usage of capitals in a word to be right when one of the following cases holds:

// All letters in this word are capitals, like "USA".
// All letters in this word are not capitals, like "leetcode".
// Only the first letter in this word is capital, like "Google".
// Given a string word, return true if the usage of capitals in it is right.

// Example 1:

// Input: word = "USA"
// Output: true
// Example 2:

// Input: word = "FlaG"
// Output: false

// Constraints:

// 1 <= word.length <= 100
// word consists of lowercase and uppercase English letters.

// Approach: Regex
// Intuition

// Hey, if we want to do pattern matching, why don't we use Regular Expression (Regex)? Regex is a great way to match a given pattern to a string.

// Algorithm

// The pattern of case 1 in regex is [A−Z]∗[A-Z]*[A−Z]∗, where [A−Z][A-Z][A−Z] matches one char from 'A' to 'Z', ∗*∗ represents repeat the pattern before it at least 0 times. Therefore, this pattern represents "All capital".

// The pattern of case 2 in regex is [a−z]∗[a-z]*[a−z]∗, where similarly, [a−z][a-z][a−z] matches one char from 'a' to 'z'. Therefore, this pattern represents "All not capital".

// Similarly, the pattern of case 3 in regex is [A−Z][a−z]∗[A-Z][a-z]*[A−Z][a−z]∗.

// Take these three pattern together, we have [A−Z]∗∣[a−z]∗∣[A−Z][a−z]∗[A-Z]*|[a-z]*|[A-Z][a-z]*[A−Z]∗∣[a−z]∗∣[A−Z][a−z]∗, where "|" represents "or".

// Still, we can combine case 2 and case 3, and we get .[a−z]∗.[a-z]*.[a−z]∗, where "." can matches any char.

// Therefore, the final pattern is [A−Z]∗∣.[a−z]∗[A-Z]*|.[a-z]*[A−Z]∗∣.[a−z]∗.

// However, it is worth pointing out that the speed of regex is highly dependent on its pattern and its implementation, and the time complexity can vary from O(1)O(1)O(1) to O(2n)O(2^n)O(2 
// n
//  ). If you want to control the speed yourself, using Approach 1 would be better.

// Complexity Analysis

// Time complexity: Basically O(n)O(n)O(n), but depends on implementation.

// Space complexity : O(1)O(1)O(1). We only need constant spaces to store our pattern.

class Solution {
  public boolean detectCapitalUse(String word) {
    return word.matches("[A-Z]*|.[a-z]*");
  }
}

// Approach: Character by Character
// Intuition

// Recall (part of) the description of the problem:

// We define the usage of capitals in a word to be right when one of the
// following cases holds:

// All letters in this word are capitals, like "USA".
// All letters in this word are not capitals, like "leetcode".
// Only the first letter in this word is capital, like "Google".
// The problem gives us three patterns, and ask if the given word matches any of
// them. It would be easy to think of checking the cases one by one. In each
// case, we can just use the most simple method to check if word matches the
// pattern -- check the char one by one.

// Algorithm

// We need three bool variables to store if the pattern matches or not. We set
// the variables to be true at the beginning, and when the pattern doesn't
// match, we turn the variables into false. You can also do it otherwise, but
// the code would be a little longer.

// The code is a little long... Don't be afraid! It's fairly easy to understand,
// and we will shorten it later.

// There are a few points you should notice from the code above:

// We use the built-in function isUpperCase (in Java) and isupper (in Python) to
// check whether a char is upper case. You can also use the ASCII to do that.
// Just use something like word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'.

// We use break after we find matching failed because there is no need to check
// whether the further char is valid.

// You can combine the three match variables into one by reusing it after each
// case, but I prefer to separate it into three for better readability.

// OK! Now we have solved this problem. The time complexity is O(n)O(n)O(n)
// (where nnn is word length) because we need to check each char at most three
// times. This time complexity is great, and there is no too much we can do to
// improve it.

// However, we can make the code looks better and shorter, without reducing the
// readability.

// Improvement

// Where to start? The biggest problem of the code above is that there are too
// many cases. What if we can combine them? Notice that the biggest difference
// between case 2 and case 3 is the condition of the first char.

// By combining case 2 and case 3, we get a new pattern: No matter what first
// char is, the rest should be lowercase.

class Solution {
  public boolean detectCapitalUse(String word) {
    int n = word.length();

    boolean match1 = true, match2 = true, match3 = true;

    // case 1: All capital
    for (int i = 0; i < n; i++) {
      if (!Character.isUpperCase(word.charAt(i))) {
        match1 = false;
        break;
      }
    }
    if (match1) {
      return true;
    }

    // case 2: All not capital
    for (int i = 0; i < n; i++) {
      if (!Character.isLowerCase(word.charAt(i))) {
        match2 = false;
        break;
      }
    }
    if (match2) {
      return true;
    }

    // case 3: All not capital except first
    if (!Character.isUpperCase(word.charAt(0))) {
      match3 = false;
    }
    if (match3) {
      for (int i = 1; i < n; i++) {
        if (!Character.isLowerCase(word.charAt(i))) {
          match3 = false;
          break;
        }
      }
    }
    if (match3) {
      return true;
    }

    // if not matching
    return false;
  }
}