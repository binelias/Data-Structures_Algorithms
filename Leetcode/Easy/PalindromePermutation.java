// For example, "code" -> False, "aab" -> True, "carerac" -> True.
import java.util.*;

package Leetcode.Easy;

public class Solution {
  public boolean canPermutePalindrome(String s) {
      HashSet<Character> app = new HashSet<Character>();
      for (int i = 0; i < s.length(); i ++) {
          char c = s.charAt(i);
          if (app.contains(c)) {
              app.remove(c);
          }    
          else {
              app.add(c);
          }
      }
      return app.size() <=1;
  }

  public boolean canPermutePalindrome1(String s) {
    // ASCII A:65 Z:90 a:97  z:122
      int[] str= new int[123];  
      for (int ch: s.toCharArray()) {
          str[ch]++;
      }
      int temp = 0;
      for (int i: str) {
          if (i%2==1){
              temp++;
          }
      }
      if (temp>1){
          return false;
      }
      return true;
  }

  public boolean canPermutePalindrome2(String s) {
  // ASCII A:65 Z:90 a:97  z:122
    int[] str= new int[123];  
    for (int i=0; i<s.length(); i++) {
      str[s.charAt(i)]++;
    }
    int count = 0;
    for (int i = 0; i<123; i++) {
      count+=str[i]%2;
    }
    return count <= 1;
  }
}