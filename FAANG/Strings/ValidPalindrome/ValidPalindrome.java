package FAANG.Strings.ValidPalindrome;


public class ValidPalindrome {
  //2 pointers from outside
  public boolean isPalindrome1(String s) {
    s = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
    
    int left = 0; 
    int right = s.length()-1;
    while(left<right) {
        if(s.charAt(left) != s.charAt(right)) return false;
        left++;
        right--;
    }
    return true;
  }

  //2 pointers from center


  // compare against reverse
}
