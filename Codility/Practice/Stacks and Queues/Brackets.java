// A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

// S is empty;
// S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
// S has the form "VW" where V and W are properly nested strings.
// For example, the string "{[()()]}" is properly nested but "([)()]" is not.

// Write a function:

// class Solution { public int solution(String S); }

// that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

// For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

// Write an efficient algorithm for the following assumptions:

// N is an integer within the range [0..200,000];
// string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".


package Codility.Practice.Stacks and Queues;

import java.util.*;

public class Brackets {
	public int solution(String S) {
        // write your code in Java SE 8
        Stack<String> stack = new Stack<>();

        for(int i=0; i<S.length(); i++) {
            String ch = S.substring(i, i+1);
            if(ch.equals("(") || ch.equals("[") || ch.equals("{")) {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) {
                    return 0;
                }
                if(ch.equals(")")) {
                    if(!stack.pop().equals("(")) {
                        return 0;
                    }
                }
                if(ch.equals("]")) {
                    if(!stack.pop().equals("[")) {
                        return 0;
                    }
                }
                if(ch.equals("}")) {
                    if(!stack.pop().equals("{")) {
                        return 0;
                    }
                }
            }
        }
        if(!stack.isEmpty()) {
            return 0;
        }
        return 1;
    }
	
	public static void main(String[] args) {
		System.out.println(new Brackets().solution("{[()()]}"));
		System.out.println(new Brackets().solution("([)()]"));
		System.out.println(new Brackets().solution(""));
		
	}
}

