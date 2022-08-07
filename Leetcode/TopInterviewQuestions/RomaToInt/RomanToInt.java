package Leetcode.TopInterviewQuestions.RomaToInt;
class Solution {
  public int romanToInt(String s) {
    Map<Character,Integer> numerals = new HashMap<>();
    
    numerals.put('I',1);
    numerals.put('V',5);
    numerals.put('X',10);
    numerals.put('L',50);
    numerals.put('C',100);
    numerals.put('D',500);
    numerals.put('M',1000);
    int n = 0;
    int i = 0;
    char[] st = s.toCharArray();
    while(i<st.length){
      if(i+1 < st.length && numerals.get(st[i]) < numerals.get(st[i+1])){
        n+=numerals.get(st[i+1])-numerals.get(st[i]);
        i+=2;
      }
      else{
        n+=numerals.get(st[i]);
        i++;
      }    
    }
    return n;
  }
}