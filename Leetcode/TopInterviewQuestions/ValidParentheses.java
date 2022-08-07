package Leetcode.TopInterviewQuestions;
import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        //Base Case
        if(s.length()<2) return false;  // for O(1) speed complexity for this case
        
        Stack<String> stack = new Stack<>();
		
        for(int i = 0; i<s.length(); i++) {   //O(n)
            String ch = s.substring(i, i+1); //get each character
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
                }else  return false; //for s starting with "}" or ")" or "]" case
            }
        }
        return stack.isEmpty(); // return false for "((" case
    }

    public boolean isValid2(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character,Character> pairs=new HashMap<>();
        pairs.put(')','(');
        pairs.put(']','[');
        pairs.put('}','{');
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='(')
            {
                st.push(s.charAt(i));
            }
            else{
                if(!st.isEmpty())
                {
                    char c=s.charAt(i);
                    if( st.peek()==pairs.get(c))
                    {
                        st.pop();
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
