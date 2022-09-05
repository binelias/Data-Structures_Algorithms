// Write a function that reverses a string. The input string is given as an array of characters s.

// You must do this by modifying the input array in-place with O(1) extra memory.


// Example 1:
// Input: s = ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]

// Example 2:
// Input: s = ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]

package Leetcode.Algorithm I.TwoPointers;

public class RevString {
  //Two pointer
  public void reverseString(char[] s) {
    int start = 0, end = s.length - 1;
    while(start < end) {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        start++;
        end--;
        
    }
  }//T: O(n), S:O(1)

  //stack
  public void reverseString(char[] s) {
    Stack<Character> stack = new Stack<>();
    int start = 0, end = s.length - 1;
    for(int i = 0; i < s.length; i++){
        stack.push(s[i]);
    }
    int i = 0;
    while(stack.size() > 0){
        s[i++] = stack.pop();
    }
    
  }
}
