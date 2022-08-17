// Given a string s of '(' , ')' and lowercase English characters.

// Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

// Formally, a parentheses string is valid if and only if:

// It is the empty string, contains only lowercase characters, or
// It can be written as AB (A concatenated with B), where A and B are valid strings, or
// It can be written as (A), where A is a valid string.

// Example 1:
// Input: s = "lee(t(c)o)de)"
// Output: "lee(t(c)o)de"
// Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

// Example 2:
// Input: s = "a)b(c)d"
// Output: "ab(c)d"

// Example 3:
// Input: s = "))(("
// Output: ""
// Explanation: An empty string is also valid.

package FAANG.Stacks.Minimum RemoveMakeValidParentheses;

public class Minimum RemoveMakeValidParentheses {
  public String minRemoveToMakeValid(String s) {
    char ch[] = s.toCharArray();
    Stack<Integer> stack = new Stack<>();

    for(int i = 0; i < ch.length; i++) {
        if(ch[i] == '(') stack.push(i);
        else if(ch[i] == ')' && !stack.isEmpty()) stack.pop();
        else if(ch[i] == ')') ch[i] = ' ';
    }
    while (!stack.isEmpty()) {
        int curIdx = stack.pop();
        ch[curIdx] = ' ';
    }
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < ch.length; i++){
        if(ch[i] != ' ') sb.append(ch[i]);
    }
    return sb.toString();
  }//T: O(n) ,S: O(n)

}
