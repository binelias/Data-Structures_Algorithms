// Example 1:
// Input: s = "()"
// Output: true

// Example 2:
// Input: s = "()[]{}"
// Output: true

// Example 3:
// Input: s = "(]"
// Output: false

class ValidParentheses {
  public boolean isValid(String s) {
    //Base Case
    if(s.length()<2) return false;
    
    Stack<String> stack = new Stack<>();
    
    for(int i = 0; i<s.length(); i++) {
        String ch = s.substring(i, i+1);
        if(ch.equals("(") || ch.equals("[") || ch.equals("{")) {
            stack.push(ch);
        }else {
            if(!stack.isEmpty()) {
                if(ch.equals(")")) {
                    if(!stack.pop().equals("(")) return false;
                }
                if(ch.equals("]")) {
                    if(!stack.pop().equals("[")) return false;
                }
                if(ch.equals("}")) {
                    if(!stack.pop().equals("{")) return false;
                }
            }else  return false;
        }
    }
    return stack.isEmpty();
  }
}
