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


public class PalindromeNum {
  public boolean isPalindrome1(int x) {
      String str = String.valueOf(x);
      StringBuilder sb = new StringBuilder(str);
      return str.equals(sb.reverse().toString());
  }
  
  public boolean isPalindrome2(int x) {
    String res = "";
    String str = String.valueOf(x);
    int len = str.length();
    for(int i = len-1; i>=0; i--) {
        res+=str.charAt(i);
    }
    return str.equals(res);
  }
}