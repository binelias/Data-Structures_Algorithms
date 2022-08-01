// Example 1:
// Input: strs = ["flower","flow","flight"]
// Output: "fl"

// Example 2:
// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.

package Leetcode.Easy;

public class LongestCommonPrefix {
  public String solution(String[] strs) {
    String pre = strs[0];
    for(int i = 1; i<strs.length; i++) {
        while(!strs[i].startsWith(pre)) {
            pre = pre.substring(0,pre.length()-1);
        }
    }
    return pre;
  }
}
