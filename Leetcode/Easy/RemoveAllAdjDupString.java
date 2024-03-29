// 

// For Loop

class Solution {
  public String removeDuplicates(String s) {
    StringBuilder sb = new StringBuilder(s);
    int len = sb.length();
    for (int i = 0; i < sb.length() - 1; i++) {
      char c1 = sb.charAt(i);
      char c2 = sb.charAt(i + 1);
      if (c1 == c2) {
        sb.delete(i, i + 2);
        i = i == 0 ? i - 1 : i - 2;
      }
    }
    return sb.toString();
  }
}

// Stack

class Solution {
  public String removeDuplicates(String s) {
    Stack<Character> st = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (st.isEmpty()) {
        st.push(c);
      } else if (st.peek() == c) {
        st.pop();
      } else {
        st.push(c);
      }
    }
    String ans = new String("");
    while (!st.isEmpty()) {
      ans = st.pop() + ans;
    }
    return ans;
  }
}