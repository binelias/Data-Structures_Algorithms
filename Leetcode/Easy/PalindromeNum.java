// Example 1:
// Input: x = 121
// Output: true
// Explanation: 121 reads as 121 from left to right and from right to left.

// Example 2:
// Input: x = -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

// Example 3:
// Input: x = 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
import java.util.Stack;

public class PalindromeNum {
  public boolean isPalindrome(int x) {
    String str = String.valueOf(x);
    //BaseCase
    if(str.length() == 0) return str;
    
    //Recursion
    int len = str.length();
    
    return str.equals(res);
  }

  public boolean isPalindrome2(int x) {
    Stack characterStack = new Stack<>();
    String value=String.valueOf(x);
    for (char ch:value.toCharArray()) {
        characterStack.push(ch);
    }
    StringBuilder builder= new StringBuilder("");
    Iterator iterator= characterStack.iterator();
    while (iterator.hasNext()){
        builder.append(characterStack.pop());
    }
    if(builder.toString().equalsIgnoreCase(value)){
        return true;
    }
    return false;
  }
}
