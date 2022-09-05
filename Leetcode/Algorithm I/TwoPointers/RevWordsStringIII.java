// Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.


// Example 1:
// Input: s = "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"

// Example 2:
// Input: s = "God Ding"
// Output: "doG gniD"

package Leetcode.Algorithm I.TwoPointers;

public class RevWordsStringIII {
  public String reverseWords(String s) {
    //Two Pointers 
    String[] words = s.split(" ");
    StringBuilder ans = new StringBuilder();
    
    for(String word : words) {
        char[] chArray = word.toCharArray();
        int start = 0, end = chArray.length - 1;
        
        while(start < end) {
            char temp = chArray[start];
            chArray[start] = chArray[end];
            chArray[end] = temp;
            start++;
            end--;
        }
        ans.append(chArray);
        ans.append(" ");
    }
    ans.deleteCharAt(ans.length() - 1);
    return ans.toString();
  }//T:O(n), S:O(1)
}
